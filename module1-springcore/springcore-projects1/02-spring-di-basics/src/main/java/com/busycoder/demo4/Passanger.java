package com.busycoder.demo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Passanger {

    private Vehicle vehicle;

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