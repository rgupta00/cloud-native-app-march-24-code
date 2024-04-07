package com.busycoder.productapp.service;

import com.busycoder.productapp.dao.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();
    public Product getById(int id);
    public Product addProduct(Product product);
    public Product updateProduct(int id, Product product);
    public Product deleteProduct(int id);
}
