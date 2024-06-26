package com.busycoder.productapp;

import com.busycoder.productapp.dto.ProductDto;
import com.busycoder.productapp.entities.Product;
import com.busycoder.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class Prouductapp02Application implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(Prouductapp02Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productService.addProduct(new ProductDto("laptop", BigDecimal.valueOf(12000)));
		productService.addProduct(new ProductDto("laptop coolpad", BigDecimal.valueOf(1200)));

	}
}
