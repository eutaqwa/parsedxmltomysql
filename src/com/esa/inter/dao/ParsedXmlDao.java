package com.esa.inter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.esa.inter.model.RecordModel;


public class ParsedXmlDao {
	public static void saveRecord(RecordModel save) throws ClassNotFoundException, SQLException{
		String driver = "com.mysql.jdbc.Driver";
		String dburl = "jdbc:mysql://127.0.0.1:3306/recordsfamily";
		String username = "root";
		String password = "cityofevil";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(dburl, username, password);
		String insertquery = "INSERT INTO records (idrecords, name, phone, email, city, parentrecords) "+ "SELECT * FROM (SELECT ?, ?, ?, ?, ?, ?) AS tmp "+
		"WHERE NOT EXISTS (SELECT name FROM records " + "WHERE name = ?) LIMIT 1 ";
		PreparedStatement ps = conn.prepareStatement(insertquery);
		ps.setInt(1, save.getRecordsid());
		ps.setString(2, save.getName());
		ps.setString(3, save.getPhone());
		ps.setString(4, save.getEmail());
		ps.setString(5, save.getCity());
		ps.setString(6, save.getParent());
		ps.setString(7, save.getName());
		ps.execute();
		ps.close();
	}

}
