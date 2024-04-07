package com.busycoder.productapp.config;

import com.busycoder.productapp.dao.ProductDao;
import com.busycoder.productapp.dao.ProductDaoImplJdbc;
import com.busycoder.productapp.dao.ProductDaoImplMongoDb;
import jdk.jshell.EvalException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"com.busycoder.productapp"})
@PropertySource(value = "classpath:application.yaml")
public class AppConfig {
    @Value("${dao.mysql.enable}")
    private final String value;

    @Bean
    @ConditionalOnProperty(name = "dao.mysql.enable",havingValue= value)
    public ProductDao getProductDaoJdbc(){
        return new ProductDaoImplJdbc();
    }
    @Bean
    @ConditionalOnMissingBean(ProductDaoImplJdbc.class)
    public ProductDao productDaoMongodb(){
        return new ProductDaoImplMongoDb();
    }



}
