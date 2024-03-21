package com.busycoder.demo4;

//we go with the abstraction
//
// whenever we are changing the vehical we have to chagne the person code

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//bad code==> SOLID design pattern
//
//A passanger is traveling using a car
public class Demo {
    public static void main(String[] args) {

//        ApplicationContext ctx=
//                new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext ctx=
                new AnnotationConfigApplicationContext(AppConfig.class);
        Passanger passanger=ctx.getBean("p", Passanger.class);

        passanger.travel();
        
    }
}




