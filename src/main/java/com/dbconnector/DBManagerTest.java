package com.dbconnector;
import java.sql.*;
public class DBManagerTest {
	public static void main(String[] args){
		DBManager dbM = new DBManager();
		try {
			dbM.getConnection();
			System.out.print("Connection Successfully");
		}
		catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
	}

}
