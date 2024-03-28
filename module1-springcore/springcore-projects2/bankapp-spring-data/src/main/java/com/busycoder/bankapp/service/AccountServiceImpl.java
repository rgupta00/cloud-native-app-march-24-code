package com.busycoder.bankapp.service;

import com.busycoder.bankapp.entities.Account;
import com.busycoder.bankapp.exceptions.BankAccountNotFoundException;
import com.busycoder.bankapp.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepo accountRepo;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public List<Account> getAll() {
        return accountRepo.findAll();
    }

    @Override
    public Account getById(int id) {
      return accountRepo.findById(id).orElseThrow(()->new BankAccountNotFoundException("bank account with id "+id +" is not found"));
    }

    @Override
    public void transfer(int fromId, int toId, double amount) {
        Account fromAcc=getById(fromId);//load both the acc in memory
        Account toAcc=getById(toId);
        fromAcc.setAmount(fromAcc.getAmount()-amount);
        toAcc.setAmount(toAcc.getAmount()+amount);
        accountRepo.save(fromAcc);
//        if(1==1)
//            throw  new RuntimeException("some jdbc prob");
        accountRepo.save(toAcc);
    }

    @Override
    public void deposit(int fromId, double amount) {
        Account acc=getById(fromId);
        acc.setAmount(acc.getAmount()+amount);
        accountRepo.save(acc);
    }

    @Override
    public void withdraw(int fromId, double amount) {
        Account acc=getById(fromId);
        acc.setAmount(acc.getAmount()-amount);
        accountRepo.save(acc);
    }
}
