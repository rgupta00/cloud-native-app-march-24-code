package com.busycoder.productapp.service;

import com.busycoder.productapp.repo.Product;
import com.busycoder.productapp.exceptions.ProductNotFoundException;
import com.busycoder.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service //SL=BL+CCC
public class ProductServiceImpl implements ProductService{

    private ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products= productRepo.findAll();
        return products;
    }

    @Override
    public Product getById(int id) {
        Product product=productRepo.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("product with id "+ id +" is not found"));
        return product;
    }

    @Override
    public Product addProduct(Product product) {
        productRepo.save(product);
        return product;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product productToUpdate= getById(id);
        productToUpdate.setPrice(product.getPrice());
         productRepo.save(productToUpdate);
         return productToUpdate;
    }

    @Override
    public Product deleteProduct(int id) {
        Product productToDelete= getById(id);
         productRepo.delete(productToDelete);
         return productToDelete;
    }
}
