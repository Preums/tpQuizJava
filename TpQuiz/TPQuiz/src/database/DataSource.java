package database;


import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
	public Connection dataSourceConnexion() {

		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/tp_quiz";
			String username = "Preums";
			String password = "password";
			Class.forName(driver);
			Connection con=(Connection) DriverManager.getConnection(url, username, password);
			
			return con;
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return null;
	}
}
