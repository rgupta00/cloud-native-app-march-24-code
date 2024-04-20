package com.orderapp.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Order {
    private String orderId;
    private String name;
    private int qty;
    private double price;
}
