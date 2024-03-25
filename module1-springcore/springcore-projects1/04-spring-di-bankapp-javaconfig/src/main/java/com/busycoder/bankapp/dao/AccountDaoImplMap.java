package com.busycoder.bankapp.dao;

import com.busycoder.bankapp.dto.Account;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Primary
@Repository
public class AccountDaoImplMap implements AccountDao{

    private Map<Integer, Account> accounts=new HashMap<>();

    public AccountDaoImplMap() {
        accounts.put(1, new Account(1, "raj", 1000.00));
        accounts.put(2, new Account(2, "ekta", 1000.00));
    }
    @Override
    public List<Account> getAll() {
        System.out.println("getAll using using HashMap...");
        return new ArrayList<>(accounts.values());
    }

    @Override
    public Account getById(int id) {
        return accounts.get(id);
    }

    @Override
    public void updateAccount(Account account) {
        accounts.put(account.getId(), account);
    }
}
