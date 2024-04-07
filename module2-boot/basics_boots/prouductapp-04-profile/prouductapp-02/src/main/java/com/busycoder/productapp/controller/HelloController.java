package com.busycoder.productapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //i want to create a rest api
public class HelloController {
    //Requestparam vs pathvariable
    @GetMapping(path = "hello")
    public String hello() {
        return "hello champs! ";
    }
}












