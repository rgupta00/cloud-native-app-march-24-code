package com.orderapp.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OrderStatusInfo {
    private Order order;
    private String orderStatus;
    private LocalDateTime localDateTime;
}
