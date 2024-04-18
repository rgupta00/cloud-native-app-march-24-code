package com.productapp;

import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
//@EnableCaching
@EnableScheduling
//@ComponentScan(basePackages = {"com.productapp"})
public class Productapp01Application implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepo productRepo;


	public static void main(String[] args) {
		SpringApplication.run(Productapp01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//i want to add 200 rec
//		List<Product> products= IntStream.rangeClosed(1,200)
//				.mapToObj(i-> new Product("product "+i, BigDecimal.valueOf(new Random().nextDouble(400))))
//				.toList();
//		productRepo.saveAll(products);
//
//		List<Product> products1=productRepo.findAll();
//		products1.forEach(p-> System.out.println(p));
	}
}
