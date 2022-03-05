package com.crud;
import com.content.*;
import com.dbconnector.*;
import java.sql.*;
import java.util.*;
public class EnclosureContentManager {
	public int insert(Enclosure c) throws ClassNotFoundException, SQLException{
		int result = -1;
		DBManager dbM = new DBManager();
		Connection con = dbM.getConnection();
		String sql="INSERT INTO `gowildwildlife`.`enclosures`\r\n"
				+ "(`type`,\r\n"
				+ "`location`)\r\n"
				+ "VALUES\r\n"
				+ "(?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, c.getType());
		pstmt.setString(2, c.getLocation());
		result = pstmt.executeUpdate();
		con.close();
		return result;
	}
	public ArrayList<Enclosure> selectAll() throws ClassNotFoundException, SQLException{
		ArrayList<Enclosure> enclosure = new ArrayList<Enclosure>();
		Enclosure e;
		//1. get connection
		DBManager dbMgr = new DBManager();
		Connection conn = dbMgr.getConnection();
		//2. prepare statement
		String sql ="SELECT `enclosures`.`enclosures_id`,\r\n"
				+ "    `enclosures`.`type`,\r\n"
				+ "    `enclosures`.`location`\r\n"
				+ "FROM `gowildwildlife`.`enclosures`;";
		PreparedStatement pstmt =conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		//populate the array list from the record of the table_html
		while (rs.next()) {
			 e = new Enclosure(rs.getInt("enclosures_id"),
					rs.getString("type"),
					rs.getString("location"));
			enclosure.add(e);//add entity object into collection
		}
		conn.close();
		return enclosure;
	}
	public Enclosure getById(int id) throws ClassNotFoundException, SQLException {
		Enclosure content =null;
		DBManager dbMgr=new DBManager();
	Connection conn=dbMgr.getConnection();
	String sql ="SELECT `enclosures`.`enclosures_id`,\r\n"
			+ "    `enclosures`.`type`,\r\n"
			+ "    `enclosures`.`location`\r\n"
			+ "FROM `gowildwildlife`.`enclosures` where `enclosures`.`enclosures_id`=?";
	PreparedStatement pstmt =conn.prepareStatement(sql);
	pstmt.setInt(1, id);
	ResultSet rs = pstmt.executeQuery();
	//populate the array list from the record of the table_html
	while (rs.next()) {
		 content = new Enclosure(rs.getInt("enclosures_id"),
				rs.getString("type"),
				rs.getString("location"));
	}
	conn.close();
	return content;
	}
	public int update(Enclosure e) throws ClassNotFoundException, SQLException{
		
		int result=-1;
		
		//1. get connection
		DBManager dbMgr=new DBManager();
		Connection conn=dbMgr.getConnection();
		
		//2.prepare statement
		
		String sql = "UPDATE `gowildwildlife`.`enclosures`\r\n"
				+ "SET\r\n"
				+ "`type` = ?,\r\n"
				+ "`location` = ?\r\n"
				+ "WHERE `enclosures_ID` = ?";


		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		// first and second parameters inserted 1. course name and course text
		
		pstmt.setInt(3, e.getEnclosureid());
		pstmt.setString(1, e.getType());
		pstmt.setString(2, e.getLocation());
		
		
		
		//3.execute statement
		
		result = pstmt.executeUpdate();
		
		return result;
	}
	public int delete (int id) throws SQLException, ClassNotFoundException {
	    int rowsDeleted = -1;
	    String sql ;
		//1. get Connection
		DBManager dbMgr = new DBManager();
		Connection conn = dbMgr.getConnection();
		
		//2. prepare the statement 
	    sql = "DELETE FROM `gowildwildlife`.`enclosures`\r\n"
	    		+ "WHERE `enclosures_ID` = ?";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    //First parameter is the course id of the course entity
	    pstmt.setInt(1, id);

	    rowsDeleted = pstmt.executeUpdate();
	    return rowsDeleted;
	}
}
