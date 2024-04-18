package com.productapp;

import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
//@ComponentScan(basePackages = {"com.productapp"})
public class Productapp01Application implements CommandLineRunner {

	@Autowired
	private RedisTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(Productapp01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(template!=null){
			System.out.println("template is configured");
		}
	}
}
