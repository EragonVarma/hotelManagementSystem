package idb.hms.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = "root";
		String pass = "root";
		
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/rafi?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connection to database: " + jdbcUrl);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			Statement stmt = myConn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM rafi.user");
			while(rs.next()) {
				System.out.println(rs.getString("FIRST_NAME"));
			}
			out.println("SUCCESS !!!");
			myConn.close();
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}






