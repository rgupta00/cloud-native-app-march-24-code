package com.busycoder.bankapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

//Spring jdbc 
@Configuration
@ComponentScan(basePackages = {"com.busycoder.bankapp"})
@EnableTransactionManagement
@Import(DbConfig.class)
@EnableJpaRepositories(basePackages = "com.busycoder.bankapp.repo",
entityManagerFactoryRef = "emf1", transactionManagerRef = "tx1")
public class AppConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean emf1(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean factoryBean=new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setPackagesToScan(new String[] {"com.busycoder.bankapp.entities"});
		
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
		factoryBean.setJpaProperties(jpaProperites());
		return factoryBean;
	}
	
	private Properties jpaProperites() {
		Properties properties=new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
		
		return properties;
	}

	@Bean
	public JpaTransactionManager tx1(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}








