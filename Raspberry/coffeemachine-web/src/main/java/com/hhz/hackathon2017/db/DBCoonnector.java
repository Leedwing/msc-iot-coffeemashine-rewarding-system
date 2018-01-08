package com.hhz.hackathon2017.db;
/**
 * Web Controller
 * @author Lee Edwing Nguepedja Tchwangnwou
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCoonnector {
	
	private static Connection conn;
	private static boolean hashdata = false;
	
	public String addUser() throws SQLException, ClassNotFoundException {
		if(conn==null) {
			getConnection();
		}
		Statement state = conn.createStatement();
		ResultSet rs = state.executeQuery("INSERT INTO user(id, firstname, lastname, cookingCount) values(1, 'fdfdf','fdfdf',23)");
		
		 while ( rs.next() ) {
	         int id = rs.getInt("id");
	         String  name = rs.getString("name");
	         int age  = rs.getInt("age");
	         String  address = rs.getString("address");
	         float salary = rs.getFloat("salary");
	         
	         System.out.println( "ID = " + id );
	         System.out.println( "NAME = " + name );
	         System.out.println( "AGE = " + age );
	         System.out.println( "ADDRESS = " + address );
	         System.out.println( "SALARY = " + salary );
		 }
		return "";
	}
	
	private void getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite://home/pi/iot/sqlDatenbank/coffeeDB.db");
	}
	
	
	
	
	
//	private Connection connect() {
//		String url = "jdbc:sqlite://home/pi/iot/sqlDatenbank/coffeeDB.db";
//		Connection conn = null;
//		
//		try {
//			conn = DriverManager.getConnection(url);
//		} catch (SQLException e) {
//			System.out.println("keine verbindung " + e.getMessage());
//		}
//		
//		return conn;
//	}

	
//	public void selectTest() {
//		connect();	
//		String sql = "INSERT INTO user(id, firstname, lastname, cookingCount) values(1, 'fdfdf','fdfdf',23)";
//		
//		try {
//			connect();
//			System.out.println("#######VERBINDUNG HERGESTELLT###########");
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(sql);
//			
//			while(rs.next()) {
//				System.out.println(rs.getInt("id")+ "\t" + 
//								rs.getString("firstname")+ "\t" + 
//								rs.getString("lastname"));
//			}
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		
//	}
//}
	
}
