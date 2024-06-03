package com.orderapp.orderapp.handlers;

import com.orderapp.orderapp.entity.Order;
import com.orderapp.orderapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class OrderHandler {

    @Autowired
    private OrderService orderService;

    public Mono<ServerResponse> getAllOrders(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(orderService.getAll(), Order.class);
    }
}








