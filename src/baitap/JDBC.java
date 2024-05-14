package baitap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;


public class JDBC {
	public static Connection connect(){
		Connection c = null;
		String url = "jdbc:mysql://127.0.0.1/test" ;
		String username = "root";
		String password = "";
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			c = DriverManager.getConnection(url, username, password);
			System.out.println("connected!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
		
	}
	public static void disconnect(Connection c) {
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		connect();
	}
}
