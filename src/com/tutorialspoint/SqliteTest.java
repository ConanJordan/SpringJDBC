package com.tutorialspoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqliteTest {

	public static void main(String[] args) {
		String SQL = "select id, name, age from Tearcher";
		
		Connection conn = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		try {
			conn = createConnection();
			
			System.out.println(conn);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static Connection createConnection () throws ClassNotFoundException, SQLException {
		
		Class.forName("org.sqlite.JDBC");
		
		Connection connection = DriverManager.getConnection(
				"jdbc:sqlite:/d:/database/sqlite/netwisdom.db");
		
		return connection;
	}

}
