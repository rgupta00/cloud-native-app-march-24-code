package com.orderapp.orderapp;

import com.orderapp.orderapp.entity.Order;
import com.orderapp.orderapp.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableR2dbcRepositories
@SpringBootApplication
public class Orderapp2Application implements CommandLineRunner {

	@Autowired
	private OrderRepo orderRepo;

	public static void main(String[] args) {
		SpringApplication.run(Orderapp2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("--------------------------------------------");
		orderRepo.save(new Order(3L,9800.00));
	}
}
