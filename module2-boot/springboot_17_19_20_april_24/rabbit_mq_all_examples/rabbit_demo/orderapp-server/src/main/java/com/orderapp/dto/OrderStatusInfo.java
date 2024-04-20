package com.orderapp.dto;

import lombok.*;

import java.time.LocalDateTime;
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderStatusInfo {
    private Order order;
    private String orderStatus;
    private LocalDateTime localDateTime;
}
