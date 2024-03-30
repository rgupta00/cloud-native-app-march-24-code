package com.busycoder.demo1;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//Aspect =advice +pointcut
@Component
@Aspect //Aspect =advice + pointcut
public class AudienceAspect {

//    @Pointcut("execution(public String doMagic())")
//    public  void define(){}// dummy method
//
//    @Before("define()")
//    public void clapping(String info){
//        System.out.println("wow wounderful magic "+ info);
//    }

//    @Pointcut("execution(public String doMagic())")
//    public  void define(){}// dummy method

    @Before("execution(public String doMagic())")
    public void clapping(String info){
        System.out.println("wow wounderful magic "+ info);
    }

//    @AfterThrowing(pointcut = "execution(public String doMagic())", throwing = "ex")
//    public void clapping(Exception ex){
//        System.out.println("Sorry "+ ex.getMessage());
//    }
    //@After @Before @AfterReturing

//    @AfterReturning(pointcut = "execution(public String doMagic())", returning = "info")
//    public void clapping(String info){
//        System.out.println("wow wounderful magic "+ info);
//    }
}
//    @Pointcut("execution(public void doMagic())")
//    public void applyClapping(){}
