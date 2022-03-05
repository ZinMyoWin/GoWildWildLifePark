package com.crud;
import com.content.*;
import com.dbconnector.*;
import java.sql.*;
import java.util.ArrayList;
public class AnimalContentManager {
	public  int insert(Animal c) throws ClassNotFoundException, SQLException {
		int result=-1;
		DBManager dbM=new DBManager();
		Connection con=dbM.getConnection();
		String sql="INSERT INTO `gowildwildlife`.`animals`\r\n"
				+ "(`name`,\r\n"
				+ "`gender`,\r\n"
				+ "`year`,\r\n"
				+ "`speciesid`,\r\n"
				+ "`dietid`,\r\n"
				+ "`enclosuresid`,\r\n"
				+ "`keepersid`)\r\n"
				+ "VALUES\r\n"
				+ "(?,?,?,?,?,?,?);";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,c.getName());
		pstmt.setString(2, c.getGender());
		pstmt.setInt(3, c.getYear());
		pstmt.setInt(4, c.getSpeciesId());
		pstmt.setInt(5, c.getDietId());
		pstmt.setInt(6, c.getEnclosureId());
		pstmt.setInt(7, c.getKeeperId());
		result=pstmt.executeUpdate();
		con.close();
		return result;
		
	}
	public ArrayList<Animal> selectAllAnimalsByKeeperName() throws ClassNotFoundException, SQLException{
		ArrayList<Animal> AnimalList = new ArrayList<Animal>();
		Animal animal;
		//1. get connection
		DBManager dbMgr = new DBManager();
		Connection conn = dbMgr.getConnection();
		//2. prepare statement
		String sql ="select animals.animal_id, animals.name, animals.gender, animals.year, "
				+ "keepers.keepers_id, keepers.name "
				+ "from animals left join keepers on animals.keepersid=keepers.keepers_id ;";
		PreparedStatement pstmt =conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		//populate the array list from the record of the table_html
		while (rs.next()) {
			 animal = new Animal(rs.getInt("animal_id"),
					rs.getString("name"),
					rs.getString("gender"),
					rs.getInt("year"),
					rs.getInt("keepers_id"),
					rs.getString("name"));
			AnimalList.add(animal);//add entity object into collection
		}
		conn.close();
		return AnimalList;
	}
	public ArrayList<Animal> selectTotalAnimalCount() throws ClassNotFoundException, SQLException{
		ArrayList<Animal> AnimalList = new ArrayList<Animal>();
		Animal animal;
		//1. get connection
		DBManager dbMgr = new DBManager();
		Connection conn = dbMgr.getConnection();
		//2. prepare statement
		String sql ="select keepers.name, count(animals.animal_id) as totalanimal"
				+ " from animals left join keepers on animals.keepersid=keepers.keepers_id "
				+ "group by keepers_id ;";
		PreparedStatement pstmt =conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		//populate the array list from the record of the table_html
		while (rs.next()) {
			 animal = new Animal(rs.getString("name"),
					rs.getInt("totalanimal"));
			AnimalList.add(animal);//add entity object into collection
		}
		conn.close();
		return AnimalList;
	}

}
