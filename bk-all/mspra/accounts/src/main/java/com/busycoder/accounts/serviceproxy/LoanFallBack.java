package com.busycoder.accounts.serviceproxy;

import com.busycoder.accounts.dto.LoanDto;
import org.springframework.stereotype.Component;

@Component
public class LoanFallBack implements LoanServiceProxy{
    @Override
    public LoanDto getByMobile(String mobile) {
        return new LoanDto();
    }
}