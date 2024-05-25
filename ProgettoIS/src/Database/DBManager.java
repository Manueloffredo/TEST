package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBManager {
	
	private static Connection conn = null;
	private static String urlConn = " ";
	private static String usernameConn = " ";
	private static String passwordConn = " ";
	
	private DBManager() {}
	
	public static Connection getConnection() throws SQLException {
			
			if(conn == null || conn.isClosed()) {
				try {
					conn = DriverManager.getConnection(urlConn, usernameConn, passwordConn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return conn;
		
	}
	
	
	public static void closeConnection() throws SQLException {
		
			if(conn != null) { 
				conn.close();
			}
	}

}
