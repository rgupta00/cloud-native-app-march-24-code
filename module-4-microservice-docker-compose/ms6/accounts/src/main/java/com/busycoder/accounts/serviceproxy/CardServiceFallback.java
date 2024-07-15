package com.busycoder.accounts.serviceproxy;

import com.busycoder.accounts.dto.CardDto;
import org.springframework.stereotype.Component;

@Component
public class CardServiceFallback implements CardServiceProxy{
    @Override
    public CardDto findByMobileNumber(String mobile) {
        return new CardDto();
    }
}
