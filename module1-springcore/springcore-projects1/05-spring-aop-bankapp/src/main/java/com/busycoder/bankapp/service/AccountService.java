package com.busycoder.bankapp.service;

import com.busycoder.bankapp.dto.Account;

import java.util.List;

public interface AccountService {
    public List<Account> getAll();
    public Account getById(int id);
    public void transfer(int fromId, int toId, double amount);
    public void deposit(int fromId, double amount);
    public void withdraw(int fromId, double amount);
}
