package com.busycoder.bankapp.service;

import com.busycoder.bankapp.dao.AccountDao;
import com.busycoder.bankapp.dao.AccountDaoImplMap;
import com.busycoder.bankapp.dto.Account;
import com.busycoder.bankapp.exceptions.AEx;
import com.busycoder.bankapp.exceptions.BankAccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//Around advice aop
@Transactional(isolation = Isolation.REPEATABLE_READ, readOnly = true,
        timeout = 1000)
@Service
public class AccountServiceImpl implements AccountService{

    private AccountDao accountDao;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> getAll() {
        return accountDao.getAll();
    }

    @Override
    public Account getById(int id) {
      return accountDao.getById(id).orElseThrow(()->new BankAccountNotFoundException("bank account with id "+id +" is not found"));
    }
    @Transactional(rollbackFor = {AEx.class}, noRollbackFor = {NullPointerException.class})
    @Override
    public void transfer(int fromId, int toId, double amount)throws AEx {
        Account fromAcc=getById(fromId);//load both the acc in memory
        Account toAcc=getById(toId);
        fromAcc.setAmount(fromAcc.getAmount()-amount);
        toAcc.setAmount(toAcc.getAmount()+amount);
        accountDao.updateAccount(fromAcc);
        if(1==1)
            throw  new NullPointerException();
        accountDao.updateAccount(toAcc);
    }

    @Transactional
    @Override
    public void deposit(int fromId, double amount) {
        Account acc=getById(fromId);
        acc.setAmount(acc.getAmount()+amount);
        accountDao.updateAccount(acc);
    }
    @Transactional
    @Override
    public void withdraw(int fromId, double amount) {
        Account acc=getById(fromId);
        acc.setAmount(acc.getAmount()-amount);
        accountDao.updateAccount(acc);
    }
}
