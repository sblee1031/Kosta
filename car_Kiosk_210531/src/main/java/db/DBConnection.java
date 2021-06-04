package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static void initConnection() {
		try {
			Class.forName("org.sqlite.JDBC"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:./db/carKiosk.db");
			System.out.println("DB Connection Success!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}