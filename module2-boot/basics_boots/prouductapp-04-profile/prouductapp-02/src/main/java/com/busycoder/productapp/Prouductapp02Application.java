package com.busycoder.productapp;

import com.busycoder.productapp.repo.Product;
import com.busycoder.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class Prouductapp02Application{

	public static void main(String[] args) {
		SpringApplication.run(Prouductapp02Application.class, args);
	}


}
