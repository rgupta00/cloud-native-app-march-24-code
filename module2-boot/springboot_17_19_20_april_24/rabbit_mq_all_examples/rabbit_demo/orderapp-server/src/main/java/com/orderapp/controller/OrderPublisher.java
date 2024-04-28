package com.orderapp.controller;

import com.orderapp.config.MessageConfig;
import com.orderapp.dto.Order;
import com.orderapp.dto.OrderStatusInfo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.core.AbstractDestinationResolvingMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class OrderPublisher {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public OrderPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("order/{restName}")
    public String bookProductOrder(@RequestBody Order order, @PathVariable String restName){
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatusInfo orderStatusInfo=OrderStatusInfo.builder()
                .order(order).orderStatus("PENDING").localDateTime(LocalDateTime.now()).build();

        rabbitTemplate.convertAndSend(MessageConfig.ORDERAPP_EXCHANGE, MessageConfig.ORDERAPP_ROUTINGKEY,orderStatusInfo );

        return "order is booked";
    }
}
