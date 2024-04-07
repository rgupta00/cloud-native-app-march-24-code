package com.busycoder.productapp.dao;

import org.springframework.stereotype.Repository;

public class ProductDaoImplMongoDb implements ProductDao{
    @Override
    public Product addProduct(Product product) {
        System.out.println("product is added using mongodb");
        return product;
    }
}
