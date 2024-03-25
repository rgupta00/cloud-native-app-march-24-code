package com.busycoder.bankapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.busycoder.bankapp"})
@EnableAspectJAutoProxy
public class AppConfig {
}
