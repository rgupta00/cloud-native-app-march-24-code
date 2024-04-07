package com.busycoder.productapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //i want to create a rest api
public class HelloController {
    //Requestparam vs pathvariable
    @GetMapping(path="hello/{name}/{city}")
    public String hello(@PathVariable(name = "name") String uname,
                        @PathVariable(name = "city") String city){
        return "hello champs! "+ uname+": " + city;
    }
    //bye?name=raja&city=delhi @Requestparam
    @GetMapping(path = "bye")
    public  String hello2(@RequestParam(name = "name")String name,@RequestParam(name = "city")String city ){
        return "using Requestparam "+ name+" "+ city;
    }

}












