package com.productclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@EnableFeignClients("com.productclient.service")
@SpringBootApplication
public class ProductclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductclientApplication.class, args);
	}

	//1 using resttemplate
//	@Bean
//	public RestTemplate template(){
//		return new RestTemplate();
//	}
}
