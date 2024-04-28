package com.bankapp.service;
import com.bankapp.dto.AccountContactDetailDto;
import com.bankapp.entities.Account;

import java.math.BigDecimal;
import java.util.*;
public interface AccountService {
    public List<Account> getAll();
    public Account getById(int id);
    public Account updateAccountContactDetails(int id, AccountContactDetailDto accountContactDetailDto);
    public Account addAccount(Account account);
    public Account deleteAccount(int id);

    public void transfer(int fromAccId, int toAccId, BigDecimal amount);
    public void withdraw(int accId, BigDecimal amount);
    public void deposit(int accId, BigDecimal amount);

}
