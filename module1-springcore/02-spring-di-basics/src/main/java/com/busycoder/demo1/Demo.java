package com.busycoder.demo1;

//we go with the abstraction
//
// whenever we are changing the vehical we have to chagne the person code

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//bad code==> SOLID design pattern
//
//A passanger is traveling using a car
public class Demo {
    public static void main(String[] args) {
        //rather then manual DI somebody should for me
        //who is that : spring framework can do it for me

        //DI: XML, annotation , java config
//
//        Vehicle vehicle=new Bike();
//       Passanger passanger=new Passanger();
//       passanger.setVehicle(vehicle); //me assigning the object ie manual di
//       passanger.travel();

        ApplicationContext ctx=
                new ClassPathXmlApplicationContext("beans.xml");
        Passanger passanger=ctx.getBean("p", Passanger.class);
//        Passanger passanger2=ctx.getBean("p", Passanger.class);
//
        passanger.travel();
//
//        //is bean is sigleton by default ?
//
        //System.out.println(passanger.hashCode());
//        System.out.println(passanger2.hashCode());

    }
}




