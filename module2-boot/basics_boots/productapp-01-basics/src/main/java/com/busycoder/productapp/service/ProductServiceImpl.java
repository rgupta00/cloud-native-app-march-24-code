package com.busycoder.productapp.service;

import com.busycoder.productapp.dao.Product;
import com.busycoder.productapp.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "ps")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    public Product addProduct(Product product) {
        return productDao.addProduct(product);
    }
}
