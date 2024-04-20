package com.busycoder.productapp.service;

import com.busycoder.productapp.dto.ProductDto;
import com.busycoder.productapp.entities.Product;

import java.util.List;
//SL= BL + ccc
public interface ProductService {
	public List<ProductDto> findAll();
	public ProductDto getById(int id);
	public ProductDto addProduct(ProductDto product);
	public ProductDto updateProduct(int id, ProductDto product);
	public ProductDto deleteProduct(int id);
	
}