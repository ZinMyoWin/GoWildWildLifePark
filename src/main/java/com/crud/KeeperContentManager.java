package com.crud;
import com.content.*;
import com.dbconnector.*;
import java.sql.*;
import java.util.ArrayList;
public class KeeperContentManager {
	public int insert(Keeper c) throws ClassNotFoundException, SQLException{
		int result = -1;
		DBManager dbM = new DBManager();
		Connection con = dbM.getConnection();
		String sql="INSERT INTO `gowildwildlife`.`keepers`\r\n"
				+ "(`name`,\r\n"
				+ "`date_of_birth`,\r\n"
				+ "`email`,\r\n"
				+ "`phone`,\r\n"
				+ "`rank`)\r\n"
				+ "VALUES\r\n"
				+ "(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, c.getKeeperName());
		pstmt.setString(2, c.getKeeperDate());
		pstmt.setString(3, c.getKeeperEmail());
		pstmt.setString(4, c.getKeeperPhone());
		pstmt.setString(5, c.getKeeperPhone());
		result = pstmt.executeUpdate();
		con.close();
		return result;
	}
	public ArrayList<Keeper> selectAll() throws ClassNotFoundException, SQLException{
		ArrayList<Keeper> KeeperList = new ArrayList<Keeper>();
		Keeper keeper;
		//1. get connection
		DBManager dbMgr = new DBManager();
		Connection conn = dbMgr.getConnection();
		//2. prepare statement
		String sql ="SELECT `keepers`.`keepers_id`,\r\n"
				+ "    `keepers`.`name`,\r\n"
				+ "    `keepers`.`date_of_birth`,\r\n"
				+ "    `keepers`.`email`,\r\n"
				+ "    `keepers`.`phone`,\r\n"
				+ "    `keepers`.`rank`\r\n"
				+ "FROM `gowildwildlife`.`keepers`";
		PreparedStatement pstmt =conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		//populate the array list from the record of the table_html
		while (rs.next()) {
			 keeper = new Keeper(rs.getInt("keepers_id"),
					rs.getString("name"),
					rs.getString("date_of_birth"),
					rs.getString("email"),
					rs.getString("phone"),
					rs.getString("rank"));
			KeeperList.add(keeper);//add entity object into collection
		}
		conn.close();
		return KeeperList;
	}
	public Keeper getById(int id) throws ClassNotFoundException, SQLException {
		Keeper content =null;
		DBManager dbMgr=new DBManager();
	Connection conn=dbMgr.getConnection();
	String sql ="SELECT `keepers`.`keepers_id`,\r\n"
			+ "    `keepers`.`name`,\r\n"
			+ "    `keepers`.`date_of_birth`,\r\n"
			+ "    `keepers`.`email`,\r\n"
			+ "    `keepers`.`phone`,\r\n"
			+ "    `keepers`.`rank`\r\n"
			+ "FROM `gowildwildlife`.`keepers` where `keepers`.`keepers_id`=?";
	PreparedStatement pstmt =conn.prepareStatement(sql);
	pstmt.setInt(1, id);
	ResultSet rs = pstmt.executeQuery();
	//populate the array list from the record of the table_html
	while (rs.next()) {
		 content = new Keeper(rs.getInt("keepers_id"),
				rs.getString("name"),
				rs.getString("date_of_birth"),
				rs.getString("email"),
				rs.getString("phone"),
				rs.getString("rank"));
	}
	conn.close();
	return content;
	}
	public int update(Keeper k) throws ClassNotFoundException, SQLException{
		
		int result=-1;
		
		//1. get connection
		DBManager dbMgr=new DBManager();
		Connection conn=dbMgr.getConnection();
		
		//2.prepare statement
		
		String sql = "UPDATE `gowildwildlife`.`keepers`\r\n"
				+ "SET\r\n"
				+ "`name` = ?,\r\n"
				+ "`date_of_birth` = ?,\r\n"
				+ "`email` = ?,\r\n"
				+ "`phone` = ?,\r\n"
				+ "`rank` = ?\r\n"
				+ "WHERE `keepers_id` = ?";

		


		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		// first and second parameters inserted 1. course name and course text
		
		pstmt.setInt(6, k.getKeeperId());
		pstmt.setString(1, k.getKeeperName());
		pstmt.setString(2, k.getKeeperDate());
		pstmt.setString(3, k.getKeeperEmail());
		pstmt.setString(4, k.getKeeperPhone());
		pstmt.setString(5, k.getKeeperRank());
		
		
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
	    sql = "DELETE FROM `gowildwildlife`.`keepers`\r\n"
	    		+ "WHERE `keepers_id` = ?";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    //First parameter is the course id of the course entity
	    pstmt.setInt(1, id);

	    rowsDeleted = pstmt.executeUpdate();
	    return rowsDeleted;
	}
}
