package com.productapp.service;

import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    public Product addProduct(Product product);
    public List<Product> getAll();

    public List<Product> getAllSortedBy(String sortField);

    public Page<Product> getPages(int offset, int pageSize);

    public Page<Product> getPagesAndSorting(int offset, int pageSize, String sortField);

    public Product getById(int id);
    public Product deleteProduct(int id);
    public Product updateProduct(int id, Product product);
    //how to remove cache periodically?
    public void evictAll();
}
