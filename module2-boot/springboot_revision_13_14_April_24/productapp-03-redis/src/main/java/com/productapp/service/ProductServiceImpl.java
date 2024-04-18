package com.productapp.service;

import com.productapp.dao.ProductDao;
import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.dao.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

//SL=BL+ ccc
// fun req+ non functinal req (aop)
@Service
public class ProductServiceImpl implements ProductService{

    private ProductDao productDao;
    private Logger logger= LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @CachePut(value = "products", key = "#result.id")
    @Override
    public Product addProduct(Product product) {
        return productDao.addProduct(product);
    }
    @Cacheable(value = "products")
    @Override
    public List<Object> getAll() {
        logger.info("database is hit get all is called............");
        return productDao.getAll();
    }
    //Spring EL (Expression language)
    @Cacheable(value = "products", key = "#id")
    @Override
    public Product getById(int id) {
        return productDao.getById(id);
    }
    @CacheEvict(value = "products", key = "#id")
    @Override
    public Product deleteProduct(int id) {
       return null;
    }
    @CachePut(value = "products", key = "#id")
    @Override
    public Product updateProduct(int id, Product product) {
        return null;
    }

    //5 sec
    @CacheEvict(value = "products",allEntries = true)
    @Override
    public void evictAll() {}
}

//@Qualifier(value = "productDaoImplJdbc")

//field: avoid

//setter: optional dep
//ctr injection: mandatory dep