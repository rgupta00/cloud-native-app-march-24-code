package com.product.services;

import com.product.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ProductService {

    //no need to config this bean urself for k, v as string
    private KafkaTemplate<String, Product> template;

    @Autowired
    public ProductService(KafkaTemplate<String, Product> template) {
        this.template = template;
    }

    public void processProduct(Product product){
        CompletableFuture<SendResult<String, Product>> future =
                template.send("my_topic2_sb2", product);

        future.whenComplete(((result, ex) -> {
            if(ex==null){
                System.out.println(result.getRecordMetadata().offset());//:)
            }else {
                System.out.println(ex.getMessage());
            }
        }));
    }


}
