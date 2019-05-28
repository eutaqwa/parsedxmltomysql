package com.esa.inter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.esa.inter.model.FamilyModel;


public class FamilyBranchedDao {
	public static void saveFamily(FamilyModel saves)throws ClassNotFoundException, SQLException{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/recordsfamily";
		String username = "root";
		String password = "cityofevil";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		String insertquery = "INSERT INTO family(parent, child) " + "SELECT * FROM (SELECT ?,?) As tmp "
		+"WHERE NOT EXISTS(SELECT parent FROM family WHERE parent = ?) LIMIT 1 " 
				;
		PreparedStatement ps = conn.prepareStatement(insertquery);
		ps.setString(1, saves.getParent());
		ps.setString(2, saves.getChild());
		ps.setString(3, saves.getParent());
		ps.execute();
		ps.close();
		
	}
}
