package com.product.service;

import com.product.dto.Product;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @KafkaListener(topics = "my_topic2_sb", groupId = "my_topic_group_id")
    public void consumeProduct(Product product){
        System.out.println("----------------"+ product);
    }
}
