package com.productapp.dao;

import java.util.List;

public interface ProductDao {
    public Product addProduct(Product product);
    public List<Object> getAll();
    public Product getById(int id);
    public Product deleteProduct(int id);
    public Product updateProduct(int id, Product product);
}
