package com.productclient;

import com.productclient.service.ProductServiceProxy2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@EnableFeignClients("com.productclient.service")
@SpringBootApplication
public class ProductclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductclientApplication.class, args);
	}

	//define resttemplate
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
//	@Bean
//	public WebClient webClient(){
//		return WebClient.builder().build();
//	}

	@Bean
	public WebClient webClient(){
		return WebClient.builder().baseUrl("http://localhost:8080").build();
	}

	//here u are not dep on framework to provide proxy impl
	@Bean
	public ProductServiceProxy2 productServiceProxy2(){
		HttpServiceProxyFactory httpServiceProxyFactory=
				HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient())).build();
		return httpServiceProxyFactory.createClient(ProductServiceProxy2.class);
	}
}
