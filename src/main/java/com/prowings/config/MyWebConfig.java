package com.prowings.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.prowings")
@EnableWebMvc
public class MyWebConfig {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/myfirstspringmvcrestapi"); // Update with your DB name
		dataSource.setUsername("prowingsuser"); // Update with your DB username
		dataSource.setPassword("prowingsuser"); // Update with your DB password
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		// 1. Datasource
		sessionFactory.setDataSource(dataSource());
		// 2. Hibernate Properties
		sessionFactory.setHibernateProperties(hibernateProperties());
		// 3. Mapping Details
		sessionFactory.setPackagesToScan("com.prowings.entity");

		return sessionFactory;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect"); // Use MySQL8 dialect
		properties.put("hibernate.hbm2ddl.auto", "update"); // Create or update DB schema
		properties.put("hibernate.show_sql", "true"); // Logs SQL to console
		properties.put("hibernate.format_sql", "true"); // Pretty prints the SQL
		return properties;
	}


}
