package idb.hms.test;

import java.sql.*;

public class TestDB {

	public static void main(String[] args) {
		
		try {
			String query = "INSERT INTO user VALUES ('1','Rafi','Ahmed','rafi','123') ";
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rafi?useSSL=false","root", "root");
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("OK!"
					+ "");
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}





