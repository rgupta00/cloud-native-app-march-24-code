package com.busycoder.accounts.serviceproxy;

import com.busycoder.accounts.dto.LoanDto;
import org.springframework.stereotype.Component;

@Component
public class LoanServiceFallback implements LoanServiceProxy{
    @Override
    public LoanDto getByMobile(String mobile) {
        //cache
        return new LoanDto();
    }
}
