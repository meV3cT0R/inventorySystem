package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	public static Connection getDbConn() {
		try {
			
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorySystem","root","");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
