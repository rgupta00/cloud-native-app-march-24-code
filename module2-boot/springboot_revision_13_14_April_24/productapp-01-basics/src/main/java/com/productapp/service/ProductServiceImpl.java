package com.productapp.service;

import com.productapp.dao.Product;
import com.productapp.dao.ProductDao;
import com.productapp.dao.ProductDaoImplJdbc;
import com.productapp.dao.ProductDaoImplMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
//SL=BL+ ccc
// fun req+ non functinal req (aop)
@Service
public class ProductServiceImpl implements ProductService{

    private ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product addProduct(Product product) {
        return productDao.addProduct(product);
    }
}

//@Qualifier(value = "productDaoImplJdbc")

//field: avoid

//setter: optional dep
//ctr injection: mandatory dep