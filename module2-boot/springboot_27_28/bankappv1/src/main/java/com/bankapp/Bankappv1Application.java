package com.bankapp;

import com.bankapp.entities.Account;
import com.bankapp.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class Bankappv1Application {

	@Autowired
	private AccountRepo accountRepo;

	public static void main(String[] args) {
		SpringApplication.run(Bankappv1Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return (args)-> {
			//String name, BigDecimal balance, String email, String phone
//			accountRepo.save(new Account("raj", BigDecimal.valueOf(1000), "raj@gmail.com","6546565676"));
//			accountRepo.save(new Account("ekta", BigDecimal.valueOf(1000), "ekta@gmail.com","6546560076"));

		};
	}
}
