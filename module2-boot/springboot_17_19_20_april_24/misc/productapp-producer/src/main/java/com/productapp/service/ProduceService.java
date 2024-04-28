package com.productapp.service;

import com.productapp.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
public class ProduceService {
	@Autowired
	private KafkaTemplate<String, String>kafkaTemplate;
	public void produce(String message) {
		System.out.println("message is send....");
		CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("my_topic2", message);
		future.whenComplete((result, ex) -> {
			if(ex==null){
				System.out.println("send message with offset: "+result.getRecordMetadata().offset());
			}else{
				System.out.println("unable to send message: "+ ex.getMessage());
			}
		});
	}
}