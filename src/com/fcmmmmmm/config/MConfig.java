package com.fcmmmmmm.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages="com.fcmmmmmm")
public class MConfig {
	private final String URL="jdbc:mysql://localhost:3306/jdbctest";
	private final String NAME="root";
	private final String PASSWORD="";
	
	
	@Bean
	public DataSource datasouce() {
		BasicDataSource bSource=new BasicDataSource();
		bSource.setDriverClassName("com.mysql.jdbc.Driver");
		bSource.setUrl(URL);
		bSource.setUsername(NAME);
		bSource.setPassword(PASSWORD);
		bSource.setInitialSize(5);
		bSource.setMaxActive(10);
		return bSource;	
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource datasouce) {
		return new JdbcTemplate(datasouce);
	}
}
