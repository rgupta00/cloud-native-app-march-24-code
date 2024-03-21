package com.busycoder.demo3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
    <context:component-scan base-package="com.busycoder.demo2"/>
    <context:annotation-config/>
 */
@Configuration
@ComponentScan(basePackages = {"com.busycoder.demo3"})
public class AppConfig {
}
