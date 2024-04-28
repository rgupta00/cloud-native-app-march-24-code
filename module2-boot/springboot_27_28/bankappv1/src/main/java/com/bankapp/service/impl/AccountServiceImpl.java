package com.bankapp.service.impl;

import com.bankapp.dto.AccountContactDetailDto;
import com.bankapp.entities.Account;
import com.bankapp.entities.TxHistory;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountRepo;
import com.bankapp.service.AccountService;
import com.bankapp.service.TxHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@Service
@Transactional(readOnly = true,timeout = 5000, isolation = Isolation.DEFAULT)
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;
    private final TxHistoryService txHistoryService;

    @Override
    public List<Account> getAll() {
        return accountRepo.findAll();
    }

    @Override
    public Account getById(int id) {
        return accountRepo.findById(id).orElseThrow(()->new BankAccountNotFoundException("account with id "+id +" is not found"));
    }

    @Transactional
    @Override
    public Account updateAccountContactDetails(int id, AccountContactDetailDto accountContactDetailDto) {
        Account accountToUpdateDetails=getById(id);
        accountToUpdateDetails.setPhone(accountContactDetailDto.getPhone());
        accountToUpdateDetails.setEmail(accountContactDetailDto.getEmail());

        accountRepo.save(accountToUpdateDetails);
        return accountToUpdateDetails;
    }
    @Transactional
    @Override
    public Account addAccount(Account account) {
        accountRepo.save(account);
        return null;
    }
    @Transactional
    @Override
    public Account deleteAccount(int id) {
        Account accountToDelete=getById(id);
        accountRepo.delete(accountToDelete);
        return accountToDelete;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void transfer(int fromAccId, int toAccId, BigDecimal amount) {
            Account fromAcc=getById(fromAccId);
            Account toAcc=getById(toAccId);

            fromAcc.setBalance(fromAcc.getBalance().subtract(amount));
            toAcc.setBalance(toAcc.getBalance().add(amount));
        //int acc1, int acc2, String txType, String clerkName, LocalDateTime localDateTime
           txHistoryService.addTxHistory(new TxHistory(fromAccId, toAccId, "TF","foo", LocalDateTime.now()));
            accountRepo.save(fromAcc);
            if(1==1)
                throw new RuntimeException("some db error");
            accountRepo.save(toAcc);


    }
    @Transactional
    @Override
    public void withdraw(int accId, BigDecimal amount) {
        Account account=getById(accId);
        account.setBalance(account.getBalance().subtract(amount));
        accountRepo.save(account);
    }
    @Transactional
    @Override
    public void deposit(int accId, BigDecimal amount) {
        Account account=getById(accId);
        account.setBalance(account.getBalance().add(amount));
        accountRepo.save(account);
    }
}
