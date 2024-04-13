package com.productapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
//@Primary

@Repository
//@Qualifier(value = "productDaoImplJdbc")
@Primary
public class ProductDaoImplJdbc implements ProductDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDaoImplJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Product addProduct(Product product) {
        System.out.println("product is added using jdbc");
        jdbcTemplate.update("insert into products(name, price) values(?,?)", new Object[]{product.getName(), product.getPrice()});
        return product;
    }

}
