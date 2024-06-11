package com.orderapp.orderapp.repository;

import com.orderapp.orderapp.entity.Order;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends R2dbcRepository<Order,Integer> {
}
