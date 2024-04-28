package com.product.controller;

import com.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "producer/{message}")
    public String processProduct(@PathVariable String message){
        for(int i=0;i<5000;i++){
            productService.processProduct(message+" "+i);
        }
        return "message is processed";
    }
}
