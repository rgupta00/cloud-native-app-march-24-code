package com.product.controller;

import com.product.dto.Product;
import com.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "producer")
    public String processProduct(@RequestBody Product product){
        for(int i=0;i<5000;i++){
            productService.processProduct(product);
        }
        return "message is processed";
    }
}
