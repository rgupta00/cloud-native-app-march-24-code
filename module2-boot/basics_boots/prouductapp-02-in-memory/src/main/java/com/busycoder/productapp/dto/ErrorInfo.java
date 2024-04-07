package com.busycoder.productapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
    "timestamp": "2024-04-06T15:22:57.713+00:00",
    "status": 404,
    "error": "Not Found",
    "toContact": "rgupta.mech@gmail.com"
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorInfo {
    private String errorMessage;
    private String status;
    private LocalDateTime timestamp;
    private String toContact;
}
