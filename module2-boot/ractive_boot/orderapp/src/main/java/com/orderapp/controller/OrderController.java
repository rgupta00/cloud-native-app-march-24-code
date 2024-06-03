//package com.orderapp.controller;
//
//import com.orderapp.dto.Order;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.time.Duration;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
////
////@RestController
////@RequestMapping(path = "api/orders")
//public class OrderController {
//
//    @GetMapping(path = "getall2", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<Order> getAllNews(){
//        Flux<Order> orderFlux=Flux.fromArray(getOrders())
//                .delayElements(Duration.ofSeconds(1)).log();
//        return orderFlux;
//    }
//    @GetMapping(path = "getallone", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Mono<Order> getOne(){
//        return Mono.just(new Order(20L, 300.00));
//    }
//
//    @GetMapping(path = "getall1", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public List<Order> getAllTraditional(){
//        List<Order> orderList= Arrays.asList(getOrders());
//        orderList=orderList.stream()
//                .peek(order -> {
//                    try{
//                        System.out.println(order.getId());
//                        Thread.sleep(1000);
//                    }catch (Exception e){}
//                }).collect(Collectors.toList());
//        return orderList;
//    }
//
//
//
//
//
//    private Order[] getOrders() {
//        return new Order[]{
//                new Order(20L, 300.00),
//                new Order(70L, 900.00),
//                new Order(10L, 380.00),
//                new Order(23L, 300.00),
//                new Order(29L, 370.00),
//                new Order(28L, 304.00),
//                new Order(280L, 340.00),
//                new Order(209L, 390.00),
//                new Order(24L, 301.00),
//                new Order(280L, 800.00),
//                new Order(230L, 320.00)
//        };
//    }
//}
