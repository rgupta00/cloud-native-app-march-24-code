package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.entity.Product;
import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.repo.ProductRepo;
@Service(value = "productService")
@Transactional
public class ProductServiceImpl implements ProductService {

	
	private ProductRepo productRepo;

	
	@Autowired
	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	@Override
	public List<Product> getAll()  {
		return productRepo.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		// validation
		productRepo.save(product);
		return product;
	}

	@Override
	public Product getById(int productId) {
		Product product = productRepo.findById(productId)
				.orElseThrow(()->new ProductNotFoundException("product with id " + productId + " is not found"));
		return product;
	}

	@Override
	public void deleteProduct(int productId) {
		Product productToDelete= getById(productId);
		productRepo.delete(productToDelete);
	}

	@Override
	public void updateProduct(int productId, double productPrice) {
		Product productToUpate= getById(productId);
		productToUpate.setPrice(productPrice);
		productRepo.save(productToUpate);
	}

}
