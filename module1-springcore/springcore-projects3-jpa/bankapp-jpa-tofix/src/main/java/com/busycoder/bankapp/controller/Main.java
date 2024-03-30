package com.busycoder.bankapp.controller;

import com.busycoder.bankapp.config.AppConfig;
import com.busycoder.bankapp.entities.Account;
import com.busycoder.bankapp.exceptions.AEx;
import com.busycoder.bankapp.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args)throws AEx {

        ApplicationContext ctx=
                new AnnotationConfigApplicationContext(AppConfig.class);

        AccountService accountService=ctx.getBean("accountServiceImpl",
                AccountService.class);

//        Account account=new Account("foo",7000.00);
//        Account account2=new Account("bar",7000.00);
//        accountService.addAccount(account);
//        accountService.addAccount(account2);
        System.out.println("------------------------");
      List<Account> accounts=accountService.getAll();

      accounts.forEach(acc-> System.out.println(acc));
//        System.out.println("-------------------------------");
      //  accountService.transfer(1,2,10);
//        accounts=accountService.getAll();
//        accounts.forEach(acc-> System.out.println(acc));

    }
}
