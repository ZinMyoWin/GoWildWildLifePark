package com.crud;
import com.content.*;
import com.dbconnector.*;
import java.sql.*;
import java.util.ArrayList;
public class DietContentManager {
	public int  insert(Diet c) throws ClassNotFoundException, SQLException{
		int result = -1;
		DBManager dbM = new DBManager();
		Connection con = dbM.getConnection();
		String sql="INSERT INTO `gowildwildlife`.`diet`\r\n"
				+ "(`diet_type`,\r\n"
				+ "`no_of_feeds`)\r\n"
				+ "VALUES\r\n"
				+ "(?,?);";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, c.getDietType());
		pstmt.setInt(2, c.getNoOfFeed());
		result = pstmt.executeUpdate();
		con.close();
		return result;
	}
	public ArrayList<Diet> selectAll() throws ClassNotFoundException, SQLException{
		ArrayList<Diet> dietList = new ArrayList<Diet>();
		Diet diet;
		//1. get connection
		DBManager dbMgr = new DBManager();
		Connection conn = dbMgr.getConnection();
		//2. prepare statement
		String sql ="SELECT `diet`.`diet_id`,\r\n"
				+ "    `diet`.`diet_type`,\r\n"
				+ "    `diet`.`no_of_feeds`\r\n"
				+ "FROM `gowildwildlife`.`diet`";
		PreparedStatement pstmt =conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		//populate the array list from the record of the table_html
		while (rs.next()) {
			 diet = new Diet(rs.getInt("diet_id"),
					rs.getString("diet_type"),
					rs.getInt("no_of_feeds"));
			dietList.add(diet);//add entity object into collection
		}
		conn.close();
		return dietList;
	}

}
