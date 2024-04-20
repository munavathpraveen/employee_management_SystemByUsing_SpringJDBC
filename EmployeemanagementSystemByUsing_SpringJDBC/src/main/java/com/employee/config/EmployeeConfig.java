package com.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan("com.employee")
public class EmployeeConfig {
	@Bean
	public JdbcTemplate jdbcTemplateBean()
	{
		JdbcTemplate jdbcTemplate=new JdbcTemplate(driverManagerDataSourceBean());
		return jdbcTemplate;
	}
	
	@Bean
	public DriverManagerDataSource driverManagerDataSourceBean()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/teca53");
		dataSource.setUsername("root");
		dataSource.setPassword("12345");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
	}
}
