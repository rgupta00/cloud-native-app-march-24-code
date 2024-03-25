package com.busycoder.bankapp.dao;

import com.busycoder.bankapp.dto.Account;

import java.util.List;

public interface AccountDao {
    public List<Account> getAll();
    public Account getById(int id);
    public void updateAccount(Account account);
}
