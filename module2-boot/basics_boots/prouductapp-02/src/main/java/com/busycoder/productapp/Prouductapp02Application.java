package com.busycoder.productapp;

import com.busycoder.productapp.repo.Product;
import com.busycoder.productapp.service.ProductService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "productapp API", version = "2.0" , description = "BusyCoder API"))
public class Prouductapp02Application implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(Prouductapp02Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//productService.addProduct(new Product("laptop", BigDecimal.valueOf(12000)));
	//	productService.addProduct(new Product("laptop coolpad", BigDecimal.valueOf(1200)));

	}
}
