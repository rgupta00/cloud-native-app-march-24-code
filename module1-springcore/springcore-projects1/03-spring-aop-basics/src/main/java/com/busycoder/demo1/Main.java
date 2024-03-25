package com.busycoder.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

//        ApplicationContext ctx=
//                new ClassPathXmlApplicationContext("beans-aop.xml");

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Magician magician=ctx.getBean("m", Magician.class);
       // System.out.println(magician.getClass());
        String data= magician.doMagic();
        System.out.println(data);

    }
}
