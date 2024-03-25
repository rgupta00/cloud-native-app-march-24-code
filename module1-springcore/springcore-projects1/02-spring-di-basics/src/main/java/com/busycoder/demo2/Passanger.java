package com.busycoder.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//A passanger is traveling using a car
//A passanger is traveling using a Bike
//A passanger is traveling using a ...
//SOLID: srp ocp lsp isp dip(DIP)
/*
high level modules should not depend on
 low level modules; both should depend on abstractions.
 */
/*
        DI: high level module should not create the object of low level module
        or Passanger should not create the object of vehicle
        rather then vehicle should be injected to the passanger

        pull vs push
 */

@Component(value = "p") //<bean id="p" class="com.busycoder.demo1.Passanger"
public class Passanger {

    @Autowired
    private Vehicle vehicle; // autowire="byType">

    public Passanger(){
        System.out.println("Passanger ctr is called");
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void travel(){
        vehicle.move();
    }
}