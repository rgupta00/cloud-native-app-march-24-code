package com.busycoder.productapp.controller;

import com.busycoder.productapp.Productapp01BasicsApplication;
import com.busycoder.productapp.dao.Product;
import com.busycoder.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(path = "api")
@RestController//?@Controller+ @ResponseBody
public class ProductRestController {

    private ProductService productService;

    //ResponseEntity: bag = data + status code

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    //get all the products
//    @GetMapping(path = "products")
//    public List<Product> getAll(){
//        return productService.getAll();
//    }
    @GetMapping(path = "products")
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products= productService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    //get by id
    //http://localhost:8090/productapp/api/products/2
    //@RequestParam vs PathVaraible
    @GetMapping(path = "products/{id}")
    public ResponseEntity<Product> getById(@PathVariable(name = "id") int id){
        Product product= productService.getById(id);
        return ResponseEntity.ok(product);
    }
    //add the product
    //java -->json @ResponseBody
    //json --> java object @RequestBody
    @PostMapping(path = "products")
    public ResponseEntity<Product> addProduct(@RequestBody  Product product){
        Product addedProduct= productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedProduct);
    }

    //delete

    //update

}
