package com.productapp.web;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.productapp.config.AppConfig;
import com.productapp.entity.Product;
import com.productapp.service.ProductService;
import com.productapp.service.ProductServiceImpl;

public class Main {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		ProductService productService=ctx.getBean("productService", ProductService.class);
		
		//----------------------printing all products-------------------
		List<Product> list= productService.getAll();
	     list.forEach(p-> System.out.println(p));
		
		
		//---------------------get a particular product-------------------
//		System.out.println("---------------------get a particular product-------------------");
//		Product product=productService.getById(7);
//		System.out.println(product);
		
//		System.out.println("---------------------add product----------------");
//		Product product=new Product("sketch pen", 300);
//		product=productService.addProduct(product);
//		System.out.println(product);
//		
//		//System.out.println("---------------------update product----------------");
//		productService.updateProduct(9	, 400);
		
	}

}
