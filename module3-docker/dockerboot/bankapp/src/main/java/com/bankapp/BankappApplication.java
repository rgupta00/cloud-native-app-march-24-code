package com.bankapp;

import com.bankapp.entities.UserEntity;
import com.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BankappApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.addUserEntity
				(new UserEntity("raj","raj","raj@gmail.com", List.of("ROLE_ADMIN","ROLE_MGR","ROLE_CLERK")));
		userService.addUserEntity
				(new UserEntity("ekta","ekta","ekta@gmail.com", List.of("ROLE_MGR","ROLE_CLERK")));
		userService.addUserEntity
				(new UserEntity("gun","gun","gun@gmail.com", List.of("ROLE_CLERK")));

	}
}
