package com.productapp.controller;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.productapp.repo.Product;
import com.productapp.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api")
public class ProductRestController {

    private final ProductService productService;
    private final Environment environment;
    //get all
    @GetMapping(path = "products")
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    //http://localhost:8090/productapp/api/productssorted/price
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "productssorted/{sortField}")
    public List<Product> getAllSorted(@PathVariable String sortField){
        return productService.getAllSortedBy(sortField);
    }

    //http://localhost:8090/productapp/api/productspagination?offset=3&pageSize=10
    //int offset, int pageSize
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "productspagination")
    public Page<Product> getAllPagination(@RequestParam(name = "offset") int offset, @RequestParam(name = "pageSize") int pageSize ){
        Page<Product> productPages= productService.getPages(offset, pageSize);
        return productPages;
    }


    //get by id
    @GetMapping(path = "products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getById(@PathVariable int id){
        return productService.getById(id);
    }

    //update
    @PutMapping(path = "products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@PathVariable int id, @RequestBody  Product product){
        return productService.updateProduct(id, product);
    }
    //delete
    @DeleteMapping(path = "products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id){
         productService.deleteProduct(id);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    //add
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "products")
    public String addProduct( @RequestBody  Product product){
         productService.addProduct(product);
         return environment.getProperty("app.added_successfully");
    }
}
