package com.busycoder.productapp.productapp.controller;

import com.busycoder.productapp.productapp.dto.DbConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private Logger logger= LoggerFactory.getLogger(HelloController.class);

//    @Autowired
//    private Environment environment;
//
//    @Value("${my.key: value is not found}")
//    private String myKey;
//
//    @Value("${my.key2: value is not found}")
//    private String myKey2;
//
//    @GetMapping(path = "hello")
//    public String hello(){
//        System.out.println(environment.getProperty("my.key"));
//        System.out.println(environment.getProperty("JAVA_HOME"));
//        return  "hello: "+ myKey+ ": "+ myKey2;
//    }

    @Autowired
    private DbConfig dbConfig;

    @GetMapping(path = "hello2")
    public String hello2(){
        logger.info("logging is stated in hello2 method ");
        return dbConfig.getUrl();
    }
}
