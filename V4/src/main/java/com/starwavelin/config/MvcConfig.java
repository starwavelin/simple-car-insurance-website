package com.starwavelin.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.starwavelin.dao.CustomerDAO;
import com.starwavelin.dao.VehicleDAO;
import com.starwavelin.dao.impl.CustomerDAOImpl;
import com.starwavelin.dao.impl.VehicleDAOImpl;

@Configuration
@ComponentScan(basePackages = "com.starwavelin")
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/insurance");
		dataSource.setUsername(IConstant.DB_USER);	// USE_YOUR_OWN_DB_USER
		dataSource.setPassword(IConstant.DB_PWD); // USE_YOUR_OWN_DB_USER_PASSWORD 
		return dataSource;
	}
	
	@Bean
	public CustomerDAO getCustomerDAO() {
		return new CustomerDAOImpl(getDataSource());
	}
	
	/*
	 * If forgetting to add Bean for VehicleDAO, 
	 * I will encounter bug
	 * "Error creating bean with name 'vehicleController': Injection of autowired dependencies failed; "
	 *  
	 * */
	@Bean 
	public VehicleDAO getVehicleDAO() {
		return new VehicleDAOImpl(getDataSource());
	}
}
