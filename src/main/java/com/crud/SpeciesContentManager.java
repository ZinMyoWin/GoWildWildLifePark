package com.crud;
import com.content.*;
import com.dbconnector.*;
import java.sql.*;
public class SpeciesContentManager {
	public int insert(Species c) throws ClassNotFoundException, SQLException{
		int result = -1;
		DBManager dbM = new DBManager();
		Connection con = dbM.getConnection();
		String sql="INSERT INTO `gowildwildlife`.`species`\r\n"
				+ "(`speciestype`,\r\n"
				+ "`speciesgroup`,\r\n"
				+ "`lifestyle`,\r\n"
				+ "`conservation_status`)\r\n"
				+ "VALUES\r\n"
				+ "(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, c.getsType());
		pstmt.setString(2, c.getsGroup());
		pstmt.setString(3, c.getLifeStyle());
		pstmt.setString(4, c.getStatus());
		result = pstmt.executeUpdate();
		con.close();
		return result;
		
	}
}
