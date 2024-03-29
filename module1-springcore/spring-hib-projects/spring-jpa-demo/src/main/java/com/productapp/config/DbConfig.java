package com.productapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@PropertySource("classpath:db.properties")
public class DbConfig {

	@Autowired
	private Environment environment;

	@Bean
	public DriverManagerDataSource getDriverManagerDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setUsername(environment.getProperty("jdbc.username"));
		ds.setPassword(environment.getProperty("jdbc.password"));
		ds.setDriverClassName(environment.getProperty("jdbc.drivername"));
		ds.setUrl(environment.getProperty("jdbc.url"));
		
		return ds;
	}
	
}
