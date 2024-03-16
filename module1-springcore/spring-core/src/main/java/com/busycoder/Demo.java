package com.busycoder;

import org.springframework.core.annotation.Order;

//we go with the abstraction
//
interface Vehicle{
    public void move();
}
class Car implements Vehicle{
    @Override
    public void move(){
        System.out.println("moving in a car");
    }
}
class Bike implements Vehicle{
    @Override
    public void move(){
        System.out.println("moving in on a bike");
    }
}
// whenever we are changing the vehical we have to chagne the person code

//bad code==> SOLID design pattern
//
class Person{
    private Vehicle vehicle;

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void travel(String personName){
        System.out.println("person "+ personName+" ");
        vehicle.move();
    }
}
public class Demo {

    public static void main(String[] args) {
        Vehicle vehicle=new Bike();
        Person person=new Person();
        person.setVehicle(vehicle);

        person.travel("rama");

    }
}




