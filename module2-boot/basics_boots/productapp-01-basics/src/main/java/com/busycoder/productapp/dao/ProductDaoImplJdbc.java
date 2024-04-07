package com.busycoder.productapp.dao;

import org.springframework.stereotype.Repository;

public class ProductDaoImplJdbc implements ProductDao{

    @Override
    public Product addProduct(Product product) {
        System.out.println("product is added using jdbc");
        return product;
    }

}
