package com.busycoder.accounts.serviceproxy;

import com.busycoder.accounts.dto.CardDto;
import org.springframework.stereotype.Component;

@Component
public class CardFallBack implements CardServiceProxy{
    @Override
    public CardDto findByMobileNumber(String mobile) {
        return new CardDto();
    }
}