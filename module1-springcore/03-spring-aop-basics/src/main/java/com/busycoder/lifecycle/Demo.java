package com.busycoder.lifecycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Demo {
    public static void main(String[] args) {

//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-life.xml");
//        ctx.registerShutdownHook();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfing.class);
         ctx.registerShutdownHook();
        Foo foo=ctx.getBean("foo", Foo.class);
        System.out.println(foo.getName());

    }
}
