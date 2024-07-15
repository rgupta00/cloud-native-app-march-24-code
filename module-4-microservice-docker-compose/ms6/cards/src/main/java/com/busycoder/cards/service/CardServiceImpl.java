package com.busycoder.cards.service;

import com.busycoder.cards.dto.CardDto;
import com.busycoder.cards.entities.Card;
import com.busycoder.cards.repo.CardRepo;
import com.busycoder.cards.uti.DtoConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CardServiceImpl implements CardService{
    @Autowired
    private CardRepo cardRepo;

    private static  Logger logger = LoggerFactory.getLogger(CardServiceImpl.class);

    @Override
    public CardDto findByMobileNumber(String mobile) {
        logger.info("findByMobileNumber is called for CardService");
        Card card= cardRepo.findByMobile(mobile);
        return DtoConverter.entityToDto(card);
    }
}
