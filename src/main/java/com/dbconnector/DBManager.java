package com.dbconnector;
import java.sql.*;
public class DBManager {
	public Connection getConnection()throws ClassNotFoundException, SQLException {
		Connection connection=null;
		//step1(teeth)riverManager class to acquire JDBC connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		// step2(teeth)B connection URL with Server , Port, DB Name, SSl connection type and
		String dbUrl="jdbc:mysql://localhost:3306/gowildwildlife?useSSL=true&serverTimezone=UTC";
	String dbUser="root";
	String dbPass="Admin1234";
	connection=DriverManager.getConnection(dbUrl,dbUser,dbPass);
	return connection;
	}
}