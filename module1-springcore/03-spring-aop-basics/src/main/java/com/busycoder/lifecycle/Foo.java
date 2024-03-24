package com.busycoder.lifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Component(value = "foo")
public class Foo {

    @Value(value = "raja")
    private String name;

    public Foo() {
        System.out.println("ctr is called");
    }
    @PostConstruct
    public void myInit(){
        System.out.println("myInit in annotation");
    }

    @PreDestroy
    public void myDestroy(){
        System.out.println("myDestroy in annotation");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setname is called");
        this.name = name;
    }

}
