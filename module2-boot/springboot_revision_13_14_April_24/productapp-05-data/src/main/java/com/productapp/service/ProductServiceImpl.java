package com.productapp.service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

//SL=BL+ ccc
// fun req+ non functinal req (aop)
@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepo productRepo;
    private Logger logger= LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @CachePut(value = "products", key = "#result.id")
    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    //http://localhost:8090/productapp/api/products
    @Cacheable(value = "products")
    @Override
    public List<Product> getAll() {
        logger.info("database is hit get all is called............");
        return productRepo.findAll();
    }

    //http://localhost:8090/productapp/api/products
    @Override
    public List<Product> getAllSortedBy(String sortField) {
//        return productRepo.findAll(Sort.by(sortField));
        return productRepo.findAll(Sort.by(Sort.Direction.DESC,  sortField));
    }

    @Override
    public Page<Product> getPages(int offset, int pageSize) {
        return productRepo.findAll(PageRequest.of(offset, pageSize));
    }

    @Override
    public Page<Product> getPagesAndSorting(int offset, int pageSize, String sortField) {
        return productRepo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(sortField)));
    }

    //Spring EL (Expression language)
    @Cacheable(value = "products", key = "#id")
    @Override
    public Product getById(int id) {
        return productRepo
                .findById(id)
                .orElseThrow(()-> new ProductNotFoundException("product with id "+id +" is not found"));
    }
    @CacheEvict(value = "products", key = "#id")
    @Override
    public Product deleteProduct(int id) {
        Product productToDelete= getById(id);
        productRepo.delete(productToDelete);
        return productToDelete;
    }
    @CachePut(value = "products", key = "#id")
    @Override
    public Product updateProduct(int id, Product product) {
        Product productToUpdate= getById(id);
        productToUpdate.setPrice(product.getPrice());
        productRepo.save(productToUpdate);
        return productToUpdate;
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