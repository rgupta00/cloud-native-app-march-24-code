package com.bankapp;

import com.bankapp.entities.Account;
import com.bankapp.entities.Loan;
import com.bankapp.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

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
			Loan loan1=Loan.builder().loanNumber(UUID.randomUUID().toString())
					.amount(BigDecimal.valueOf(2000)).issueDate(LocalDate.now()).type("EDU").build();
			Loan loan2=Loan.builder().loanNumber(UUID.randomUUID().toString())
					.amount(BigDecimal.valueOf(3000)).issueDate(LocalDate.now()).type("BOOKS").build();
			Account account1=new Account("raj", BigDecimal.valueOf(1000), "raj@gmail.com","6546565676");
			account1.setLoan(loan1);
			Account account2=new Account("ekta", BigDecimal.valueOf(1000), "ekta@gmail.com","6546560076");
			account2.setLoan(loan2);

			//String name, BigDecimal balance, String email, String phone
			accountRepo.save(account1);
			accountRepo.save(account2);

		};
	}
}
