package com.busycoder.bankapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

//class is going to bootstrap spring framework
@Configuration //hey spring this is a config class
@ComponentScan(basePackages = "com.busycoder.bankapp")
@EnableAspectJAutoProxy
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class AppConfig {

    //datasouce: aka connection pool that help me to get the jdbc conn
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driver}")
    private String driverName;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

   // @Scope("singleton")
    @Bean
    public DataSource getDataSource(){
        //assignment: try to replace it with some conn pooling *
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setUrl(url);
        ds.setPassword(password);
        ds.setUsername(username);
        ds.setDriverClassName(driverName);
        return ds;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return  new JdbcTemplate(dataSource);
    }
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
