package com.orderapp.handler;

import com.orderapp.dto.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;

@Service
public class OrderHandler {

    public Mono<ServerResponse> getAll(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(Flux.fromArray(getOrders()), Order.class);
    }

    public Mono<ServerResponse> getOneById(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(Flux.just(new Order(20L, 300.00)), Order.class);
    }

    private Order[] getOrders() {
        return new Order[]{
                new Order(20L, 300.00),
                new Order(70L, 900.00),
                new Order(10L, 380.00),
                new Order(23L, 300.00),
                new Order(29L, 370.00),
                new Order(28L, 304.00),
                new Order(280L, 340.00),
                new Order(209L, 390.00),
                new Order(24L, 301.00),
                new Order(280L, 800.00),
                new Order(230L, 320.00)
        };
    }
}
