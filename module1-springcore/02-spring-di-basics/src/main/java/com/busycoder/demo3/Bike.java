package com.busycoder.demo3;

import org.springframework.stereotype.Component;

//<bean id="v2" class="com.busycoder.demo1.Bike"/>
@Component(value = "v2")
public class Bike implements Vehicle {
    public void move(){
        System.out.println("moving in a bike");
    }
}