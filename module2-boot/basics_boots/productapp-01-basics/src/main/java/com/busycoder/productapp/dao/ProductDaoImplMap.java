package com.busycoder.productapp.dao;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImplMap implements ProductDao{

    private Map<Integer,Product> map=new HashMap<>();

    private int counter;
    public ProductDaoImplMap(){
        map.put(1, new Product(1,"laptop", BigDecimal.valueOf(500000)));
        map.put(2, new Product(2,"laptop cover", BigDecimal.valueOf(1000)));
        counter=2;

    }
    @Override
    public List<Product> getAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Product getById(int id) {
        return map.get(id);
    }

    @Override
    public Product addProduct(Product product) {
        product.setId(++counter);
        map.put(counter, product);
        return product;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(int id) {
        return null;
    }
}
