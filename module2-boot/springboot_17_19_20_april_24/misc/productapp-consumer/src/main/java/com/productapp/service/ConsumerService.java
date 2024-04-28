package com.productapp.service;

import com.productapp.dto.Product;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
	@KafkaListener(topics = "my_topic2", groupId = "my_topic_group_id")
	public void consume(String message) {
		System.out.println(message);
	}
}
