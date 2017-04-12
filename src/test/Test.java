package test;


import java.sql.*;

import dao.UserDAO;

public class Test {
	
	 static String url = "jdbc:mysql://localhost:3306/a1";
	 static String user = "root";
	 static String password = "deliric1";

	public static void main(String[] args) throws SQLException {
		try{
			Connection con = DriverManager.getConnection(url,user,password);
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("Select * from user");
			
			while(rs.next()){
				System.out.println(rs.getString("username"));
			}
			
		} catch(Exception e)
		{
			System.out.println(e);
		}
		
		UserDAO user = new UserDAO();
		
		user.insertUser("testuser", "testpassword", "E");

	}

}
