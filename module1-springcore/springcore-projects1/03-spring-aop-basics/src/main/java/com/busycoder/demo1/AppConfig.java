package com.busycoder.demo1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//  <aop:aspectj-autoproxy/>
@Configuration
@ComponentScan(basePackages = {"com.busycoder.demo1"})
@EnableAspectJAutoProxy
public class AppConfig {
}
