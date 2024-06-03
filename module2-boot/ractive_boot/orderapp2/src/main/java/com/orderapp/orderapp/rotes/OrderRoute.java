package com.orderapp.orderapp.rotes;

import com.orderapp.orderapp.handlers.OrderHandler;
import com.orderapp.orderapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;

@Component
public class OrderRoute {

    @Autowired
    private OrderHandler orderHandler;

    @Bean
    public RouterFunction<ServerResponse> orderRouter(){
        return RouterFunctions.route(RequestPredicates.GET("/api/orders/getall"),
                orderHandler::getAllOrders);
    }

}
