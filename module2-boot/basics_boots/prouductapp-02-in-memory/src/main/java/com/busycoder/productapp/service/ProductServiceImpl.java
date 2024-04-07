package com.busycoder.productapp.service;

import com.busycoder.productapp.dao.Product;
import com.busycoder.productapp.dao.ProductDao;
import com.busycoder.productapp.dao.ProductDaoImplMap;
import com.busycoder.productapp.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service //SL=BL+CCC
public class ProductServiceImpl implements ProductService{

    private ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products= productDao.getAll();
        return products;
    }

    @Override
    public Product getById(int id) {
        Product product=productDao.getById(id);
        if(product==null)
            throw new ProductNotFoundException("product with id "+ id +" is not found");
        return product;
    }

    @Override
    public Product addProduct(Product product) {
        Product productAdded=productDao.addProduct(product);
        return productAdded;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        return productDao.updateProduct(id, product);
    }

    @Override
    public Product deleteProduct(int id) {
        return productDao.deleteProduct(id);
    }
}
