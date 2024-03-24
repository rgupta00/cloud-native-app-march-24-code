package com.busycoder.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {

        ApplicationContext ctx=
                new ClassPathXmlApplicationContext("beans-di.xml");
        Passanger passanger=ctx.getBean("p", Passanger.class);
        passanger.travel();

        Passanger passanger2=ctx.getBean("p", Passanger.class);
        System.out.println(passanger.hashCode());
        System.out.println(passanger2.hashCode());

    }
}




