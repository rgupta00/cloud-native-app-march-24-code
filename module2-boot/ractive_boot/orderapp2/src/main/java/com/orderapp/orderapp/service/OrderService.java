package com.orderapp.orderapp.service;

import com.orderapp.orderapp.entity.Order;
import com.orderapp.orderapp.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;


    public Flux<Order> getAll(){
        return orderRepo.findAll();
    }

    public Mono<Order> getOneById(long id){
        return orderRepo.findById(id);
    }
    public Mono<Order> saveOrder(Order order){
        return orderRepo.save(order);
    }
    public Mono<Void> deleteOrder(long id){
        return orderRepo.deleteById(id);
    }


}
