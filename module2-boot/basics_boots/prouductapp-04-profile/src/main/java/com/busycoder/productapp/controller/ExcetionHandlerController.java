package com.busycoder.productapp.controller;

import com.busycoder.productapp.dto.ErrorInfo;
import com.busycoder.productapp.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice //aop @ControllerAdvice+ @ResponseBody
public class ExcetionHandlerController {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorInfo> handle404(ProductNotFoundException ex){
        ErrorInfo errorInfo=ErrorInfo.builder()
                .errorMessage(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.toString())
                .toContact("rgupta.mtech@gmail.com")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
    }
    //catch all
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorInfo> handle500(Exception ex){
//        //log4j to log the actual cause of ex in a log file
//
//        ErrorInfo errorInfo=ErrorInfo.builder()
//                .errorMessage("pls try after some time")
//                .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
//                .toContact("rgupta.mtech@gmail.com")
//                .timestamp(LocalDateTime.now())
//                .build();
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfo);
//    }
    //MethodArgumentNotValidException

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorInfo> handle400(MethodArgumentNotValidException ex){
        //log4j to log the actual cause of ex in a log file

        String errorMessage = ex.getBindingResult().getAllErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.joining(" ,"));

        ErrorInfo errorInfo=ErrorInfo.builder()
                .errorMessage(errorMessage)
                .status(HttpStatus.BAD_REQUEST.toString())
                .toContact("rgupta.mtech@gmail.com")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
    }

}
