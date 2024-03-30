package com.busycoder.bankapp.dao;

import com.busycoder.bankapp.entities.Account;

import java.util.List;
import java.util.Optional;

public interface AccountDao {
    public List<Account> getAll();
    public Optional<Account> getById(int id);
    public void updateAccount(Account account);
    public void addAccount(Account account);
    public void deleteAccount(int id);
}
