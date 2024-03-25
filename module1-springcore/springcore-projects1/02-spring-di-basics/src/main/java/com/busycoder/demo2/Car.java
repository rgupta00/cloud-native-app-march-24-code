package com.busycoder.demo2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// <bean id="v1" class="com.busycoder.demo1.Car" primary="true"/>
@Component(value = "v1")
@Primary
public class Car implements Vehicle {
    public void move(){
        System.out.println("moving in a car");
    }
}