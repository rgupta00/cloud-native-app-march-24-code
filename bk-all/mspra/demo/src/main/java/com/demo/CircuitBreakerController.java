package com.demo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger= LoggerFactory.getLogger(CircuitBreakerController.class);
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("simple-api")
    @CircuitBreaker(name = "default", fallbackMethod = "hardCodedResponse")
    public String simpleApi(){
        logger.info("sample api call recived");
        String data=restTemplate.getForObject("http://localhost:8080/hello", String.class);
        return "simple api";
    }
    public String hardCodedResponse(){
        return "hardCodedResponse";
    }
}
