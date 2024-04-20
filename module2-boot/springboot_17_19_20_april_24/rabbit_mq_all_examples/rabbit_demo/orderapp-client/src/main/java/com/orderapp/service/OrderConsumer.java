package com.orderapp.service;

import com.orderapp.config.MessageConfig;
import com.orderapp.dto.OrderStatusInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class OrderConsumer {
    private Logger logger= LoggerFactory.getLogger(OrderConsumer.class);

    @RabbitListener(queues = MessageConfig.ORDERAPP_QUEUE)
    public void processOrder(OrderStatusInfo orderStatusInfo){
        logger.info("order is recived: {}", orderStatusInfo);
    }
}
