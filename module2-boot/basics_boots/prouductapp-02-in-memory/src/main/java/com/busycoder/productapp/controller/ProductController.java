package com.busycoder.productapp.controller;

import com.busycoder.productapp.dao.Product;
import com.busycoder.productapp.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products= productService.findAll();
        if(1==1)
            throw new NullPointerException("some big issue");
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    //get by id
    @GetMapping(path = "products/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id){
        return ResponseEntity.ok(productService.getById(id));
    }
    //add product
    @PostMapping(path = "products")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product){
        Product productAdded= productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productAdded);
    }
    //update

    //delete

}














