package com.productapp;

import com.productapp.config.DbProp;
import com.productapp.dao.Product;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.math.BigDecimal;
@EnableAspectJAutoProxy
@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		JdbcTemplateAutoConfiguration.class
})
@EnableConfigurationProperties({DbProp.class})
//@ComponentScan(basePackages = {"com.productapp"})
public class Productapp01Application implements CommandLineRunner {

	@Autowired
	private ProductService productService;

//	@Autowired
//	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Productapp01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productService.addProduct(new Product("laptop", BigDecimal.valueOf(120000)));
//		if(jdbcTemplate!=null){
//			System.out.println("jdbcTemplate is confired...");
//		}else{
//			System.out.println("not confi");
//		}
	}
}
