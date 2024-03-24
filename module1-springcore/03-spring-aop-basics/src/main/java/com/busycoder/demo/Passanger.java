package com.busycoder.demo;

public class Passanger {

    private Vehicle vehicle;

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public void travel(){
        vehicle.move();
    }
}