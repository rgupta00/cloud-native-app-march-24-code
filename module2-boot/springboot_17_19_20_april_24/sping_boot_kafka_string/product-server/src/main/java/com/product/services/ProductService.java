package com.product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ProductService {

    //no need to config this bean urself for k, v as string
    private KafkaTemplate<String, String> template;

    @Autowired
    public ProductService(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    public void processProduct(String message){
        CompletableFuture<SendResult<String, String>> future =
                template.send("my_topic2_sb", message);

        future.whenComplete(((result, ex) -> {
            if(ex==null){
                System.out.println(result.getRecordMetadata().hasOffset());//:)
            }else {
                System.out.println(ex.getMessage());
            }
        }));
    }


}
