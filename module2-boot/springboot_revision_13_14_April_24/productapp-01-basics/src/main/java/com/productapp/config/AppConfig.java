package com.productapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

//hey spring boot i want to configure ds mysql
@Configuration
@ComponentScan(basePackages = {"com.productapp.config"})
@EnableTransactionManagement
public class AppConfig {

    @Autowired
    private DbProp dbProp;

    @Bean
    public DataSource getDataSource(){
        //assignment: try to replace it with some conn pooling *
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setUrl(dbProp.getUrl());
        ds.setPassword(dbProp.getPassword());
        ds.setUsername(dbProp.getUsername());
        ds.setDriverClassName(dbProp.getDriverClassName());
        return ds;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return  new JdbcTemplate(dataSource);
    }

}
