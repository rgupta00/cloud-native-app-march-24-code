package com.productapp.service;

import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product product);
    public List<Product> getAll();
    public Product getById(int id);
    public Product deleteProduct(int id);
    public Product updateProduct(int id, Product product);
    //how to remove cache periodically?
    public void evictAll();
}
