package com.productapp.service;

import com.productapp.dao.Product;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product product);
    public List<Object> getAll();
    public Product getById(int id);
    public Product deleteProduct(int id);
    public Product updateProduct(int id, Product product);
    //how to remove cache periodically?
    public void evictAll();
}
