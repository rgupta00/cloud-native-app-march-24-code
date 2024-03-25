package com.busycoder.bankapp.dao;

import com.busycoder.bankapp.dto.Account;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.*;

@Repository
public class AccountDaoImplMap implements AccountDao{

    private Map<Integer, Account> map=new HashMap<>();
    public AccountDaoImplMap(){
        map.put(1, new Account(1,"raj",1000));
        map.put(2, new Account(2,"ekta",1000));
    }
    @Override
    public List<Account> getAll() {
        System.out.println("using hashmap");
        return new ArrayList<>(map.values());
    }

    @Override
    public Optional<Account> getById(int id) {
        Account account= map.get(id);
        return Optional.ofNullable(account);
    }

    @Override
    public void updateAccount(Account account) {
        map.put(account.getId(), account);
    }

    @Override
    public void addAccount(Account account) {

    }

    @Override
    public void deleteAccount(int id) {

    }
}
