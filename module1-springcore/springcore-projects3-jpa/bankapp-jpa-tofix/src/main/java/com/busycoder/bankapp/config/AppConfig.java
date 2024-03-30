package com.busycoder.bankapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

//class is going to bootstrap spring framework
@Configuration //hey spring this is a config class
@ComponentScan(basePackages = "com.busycoder.bankapp")
@EnableAspectJAutoProxy
@EnableTransactionManagement
@Import(DbConfig.class)
public class AppConfig {

    //datasouce: aka connection pool that help me to get the jdbc conn



    public Properties properties(){
        Properties properties=new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.show_sql", "true");
      //  properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        return properties;
    }

    @Bean
    public PlatformTransactionManager tx1(LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean){
        EntityManagerFactory emf=localContainerEntityManagerFactoryBean.getObject();

        return new JpaTransactionManager(emf);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean emf1(DataSource dataSource){
        LocalContainerEntityManagerFactoryBean lcemfb
                =new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(dataSource);
        lcemfb.setPackagesToScan(new String[]{"com.busycoder.bankapp.entities"});
        lcemfb.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties properties=new Properties();
        properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.show-sql","true");

        lcemfb.setJpaProperties(properties);

        return lcemfb;
    }


}
