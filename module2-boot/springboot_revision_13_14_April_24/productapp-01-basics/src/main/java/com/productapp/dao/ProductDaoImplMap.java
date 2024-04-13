package com.productapp.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
//@Primary
@Repository
//@Qualifier(value = "productDaoImplMap")
public class ProductDaoImplMap implements ProductDao{
    @Override
    public Product addProduct(Product product) {
        System.out.println("product is added using hashmap");
        return product;
    }
}
