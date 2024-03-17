package com.busycoder.demo1;

public class Person{
    private Vehicle vehicle;

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void travel(String personName){
        System.out.println("person "+ personName+" ");
        vehicle.move();
    }
}