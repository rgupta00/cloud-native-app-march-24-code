package com.busycoder.demo1;

//we go with the abstraction
//
// whenever we are changing the vehical we have to chagne the person code

//bad code==> SOLID design pattern
//
public class Demo {
    public static void main(String[] args) {
        Vehicle vehicle=new Bike();
        Person person=new Person();
        person.setVehicle(vehicle);

        person.travel("rama");


    }
}




