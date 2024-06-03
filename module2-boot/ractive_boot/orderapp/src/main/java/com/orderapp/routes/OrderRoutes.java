package com.orderapp.routes;

import com.orderapp.handler.OrderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;
//Same as controlller
@Component
public class OrderRoutes {

    @Autowired
    private OrderHandler orderHandler;

    @Bean
    public RouterFunction<ServerResponse> orderRoute(){
        return RouterFunctions
                .route(RequestPredicates.GET("api/orders/getall"), orderHandler::getAll)
                .andRoute(RequestPredicates.GET("api/orders/getall"), orderHandler::getOneById);
    }
}
