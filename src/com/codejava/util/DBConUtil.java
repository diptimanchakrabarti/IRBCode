package com.codejava.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

@Service 
public class DBConUtil {
    //static reference to itself
	public DataSource getdataSource() throws SQLException{
		
	SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
	dataSource.setDriver(new com.mysql.jdbc.Driver());
	dataSource.setUrl("jdbc:mysql://bluemix-sandbox-dal-9-portal.4.dblayer.com:21405/irbdb");
    dataSource.setUsername("admin");
    dataSource.setPassword("BXBELAOXDOTKBZOE");
	return dataSource;
	}
    //private constructor
    
}
