package com.bankapp.controller;

import com.bankapp.dto.AccountContactDetailDto;
import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "operation")
public class AccountOperationController {

    private final AccountService accountService;

    @GetMapping(path = "accounts")
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping(path = "accounts/{id}")
    public Account getById( @PathVariable(name="id") int id) {
        return accountService.getById(id);
    }
//    @GetMapping(path = "accounts/{id}/loans/{lid}")
//    public Account getAccountWithLoan( @PathVariable(name="id") int id) {
//        return accountService.getById(id);
//    }
    //add
    @PostMapping(path = "account")
    public Account addAccount(Account account){
        return accountService.addAccount(account);
    }

    //delete
    @DeleteMapping(path = "accounts/{id}")
    public void deleteAccount( @PathVariable(name="id") int id) {
         accountService.deleteAccount(id);
    }

    //update contact details
    @PostMapping(path = "updateaccountdetails/{id}")
    public Account updateAccountContactDetails(@PathVariable  int id,  @RequestBody AccountContactDetailDto accountContactDetailDto){
        return accountService.updateAccountContactDetails(id, accountContactDetailDto);
    }
}


