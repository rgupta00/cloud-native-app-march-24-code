package com.busycoder.accounts.servies;

import com.busycoder.accounts.dto.AccountDto;
import com.busycoder.accounts.dto.AccountInfoDto;
import com.busycoder.accounts.entities.Account;
import com.busycoder.accounts.repo.AccountRepo;
import com.busycoder.accounts.serviceproxy.CardServiceProxy;
import com.busycoder.accounts.serviceproxy.LoanServiceProxy;
import com.busycoder.accounts.util.DtoConvertor;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{

    private static Logger logger= LoggerFactory.getLogger(AccountServiceImpl.class);
    private final AccountRepo accountRepo;
    private final CardServiceProxy cardServiceProxy;
    private final LoanServiceProxy loanServiceProxy;

    @Override
    public List<AccountDto> getAll() {
        return accountRepo.findAll().stream()
                .map(DtoConvertor::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto getByMobile(String mobile) {
        return DtoConvertor.entityToDto(accountRepo.findByMobile(mobile));
    }

    @Override
    public AccountInfoDto getAccountDetails(String mobile) {
        logger.info("getAccountDetails method of AccountServiceImpl is called");
        AccountInfoDto accountInfoDto=new AccountInfoDto();
        accountInfoDto.setAccountDto(getByMobile(mobile));
        accountInfoDto.setCardDto(cardServiceProxy.findByMobileNumber(mobile));
        accountInfoDto.setLoanDto(loanServiceProxy.getByMobile(mobile));
        logger.info("getAccountDetails method of AccountServiceImpl is finished");
        return accountInfoDto;
    }

    @Override
    public String addAccount(AccountDto accountDto) {
        Account account=DtoConvertor.dtoToEntity(accountDto);
        accountRepo.save(account);
        accountDto.setAccId(account.getAccId());
        return "account is added successfully";
    }
}
