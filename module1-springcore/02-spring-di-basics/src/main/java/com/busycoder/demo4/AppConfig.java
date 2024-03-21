package com.busycoder.demo4;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"com.busycoder.demo4"})
public class AppConfig {
    @Bean(name = "p")
    public Passanger passanger(Vehicle vehicle){
        Passanger passanger=new Passanger();
        passanger.setVehicle(vehicle);
        return  passanger;
    }
   // @Primary
    @Profile("test")
    @Bean(name = "car")
    public Vehicle car(){
        return new Car();
    }
    @Profile("dev")
    @Bean(name = "bike")
    public Vehicle bike(){
        return new Bike();
    }
}
