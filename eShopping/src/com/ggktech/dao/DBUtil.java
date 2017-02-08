package com.ggktech.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan(basePackages="com.ggktech.dao")
public class DBUtil {
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dm=new DriverManagerDataSource();
		dm.setUrl("jdbc:sqlserver://ggku3ser2;databaseName=eShopping");
		dm.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dm.setUsername("sa");
		dm.setPassword("Welcome@1234");
		return dm;
	}
	

}
