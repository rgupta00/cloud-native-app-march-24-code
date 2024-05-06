package com.bankapp;

import com.bankapp.entites.UserEntity;
import com.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BankappsecApplication {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BankappsecApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){

		return (String... args) ->{
		//String username, String password, String email, List<String> roles
//			userService.addUserEntity(new UserEntity("raj","raj123","raj@gmail.com",
//					List.of("ROLE_ADMIN","ROLE_MGR","ROLE_CLERK")));
//			userService.addUserEntity(new UserEntity("ekta","ekta123","ekta@gmail.com",
//					List.of("ROLE_MGR","ROLE_CLERK")));
//			userService.addUserEntity(new UserEntity("gun","gun123","gun@gmail.com", List.of("ROLE_CLERK")));
		};
	}

}
