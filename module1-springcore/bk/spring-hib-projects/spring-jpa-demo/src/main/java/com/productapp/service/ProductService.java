package com.productapp.service;

import java.sql.SQLException;
import java.util.*;

import com.productapp.entity.Product;

public interface ProductService {

	public List<Product> getAll();

	public Product addProduct(Product product);

	public Product getById(int productId);

	public void deleteProduct(int productId);

	public void updateProduct(int productId, double productPrice);

}
