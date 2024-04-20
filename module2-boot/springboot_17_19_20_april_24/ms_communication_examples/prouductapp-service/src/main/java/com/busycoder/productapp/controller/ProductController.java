package com.busycoder.productapp.controller;

import com.busycoder.productapp.dto.ProductDto;
import com.busycoder.productapp.entities.Product;
import com.busycoder.productapp.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//@Controller+ @ResponseBody(it trigger parser to convert java to json object)
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    //----get all products
    //ResponseEnitty= data + http status code
    @GetMapping(path = "products")
    public ResponseEntity<List<ProductDto>> getAll(){
        List<ProductDto> products= productService.findAll();
//        if(1==1)
//            throw new NullPointerException("some big issue");
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    //get by id
    @GetMapping(path = "products/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable int id){
        return ResponseEntity.ok(productService.getById(id));
    }
    //add product
    @PostMapping(path = "products")
    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(productDto));
    }
    //update
    @PutMapping(path = "products/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable int id,  @RequestBody ProductDto productDto){
        return ResponseEntity.ok().body(productService.updateProduct(id, productDto));
    }
    //delete
    @DeleteMapping(path = "products/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        ProductDto productDtoDeleted= productService.deleteProduct(id);
        //log4j
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}














