package com.busycoder.eurekserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekserverApplication.class, args);
	}

}
