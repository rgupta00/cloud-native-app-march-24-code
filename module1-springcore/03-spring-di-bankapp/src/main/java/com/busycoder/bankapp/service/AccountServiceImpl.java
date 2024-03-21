package com.busycoder.bankapp.service;

import com.busycoder.bankapp.dao.AccountDao;
import com.busycoder.bankapp.dao.AccountDaoImplMap;
import com.busycoder.bankapp.dto.Account;
import com.busycoder.bankapp.exceptions.BankAccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//SL=BL + CCC
@Service(value = "accountService")
public class AccountServiceImpl implements AccountService{
    //field /setter/ctr
    private AccountDao accountDao;
    //in new version of spring if u have only once ctr
    //writing autowire on ctr is not mandatory
   // @Autowired
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    @Override
    public List<Account> getAll() {
        return accountDao.getAll();
    }

    @Override
    public Account getById(int id) {
        Account account=accountDao.getById(id);
        if(account==null)
            throw new BankAccountNotFoundException("bank account not found with id "+ id);

        return account;
    }

    @Override
    public void transfer(int fromId, int toId, double amount) {
           //load both the acc in momory
        Account fromAcc=getById(fromId);
        Account toAcc=getById(toId);
        fromAcc.setAmount(fromAcc.getAmount()-amount);
        toAcc.setAmount(toAcc.getAmount()+amount);
        accountDao.updateAccount(fromAcc);
        accountDao.updateAccount(toAcc);
    }

    @Override
    public void deposit(int fromId, double amount) {
        Account acc=getById(fromId);
        acc.setAmount(acc.getAmount()+amount);
    }

    @Override
    public void withdraw(int fromId, double amount) {
        Account acc=getById(fromId);
        acc.setAmount(acc.getAmount()-amount);
    }
}
