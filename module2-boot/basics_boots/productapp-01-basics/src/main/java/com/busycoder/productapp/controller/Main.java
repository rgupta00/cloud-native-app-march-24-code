package com.busycoder.productapp.controller;

import com.busycoder.productapp.config.AppConfig;
import com.busycoder.productapp.dao.Product;
import com.busycoder.productapp.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService=applicationContext.getBean("ps", ProductService.class);
        productService.addProduct(new Product());
    }
}
