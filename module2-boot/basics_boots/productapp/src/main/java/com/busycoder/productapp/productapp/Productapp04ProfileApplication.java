package com.busycoder.productapp.productapp;

import com.busycoder.productapp.productapp.dto.DbConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({DbConfig.class})
@SpringBootApplication
public class Productapp04ProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(Productapp04ProfileApplication.class, args);
	}

}
