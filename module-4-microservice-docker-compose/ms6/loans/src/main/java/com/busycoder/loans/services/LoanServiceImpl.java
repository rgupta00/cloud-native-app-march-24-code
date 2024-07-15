package com.busycoder.loans.services;

import com.busycoder.loans.dto.LoanDto;
import com.busycoder.loans.entities.Loan;
import com.busycoder.loans.repositories.LoanRepo;
import com.busycoder.loans.util.DtoConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService{
    @Autowired
    private LoanRepo loanRepo;


    private static Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);

    @Override
    public LoanDto findByMobile(String mobile) {
        logger.info("findByMobile is called for LoanService");
        return DtoConverter.entityToDto(loanRepo.findByMobile(mobile));
    }
}
