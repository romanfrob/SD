package dao;

import java.sql.*;

public class Database {
	
	 static String url = "jdbc:mysql://localhost:3306/a1";
	 static String user = "root";
	 static String password = "deliric1";
	 
	 public Database(){		 
	 }
	 
	 
	 public static Connection getConnection(){
		 try{
			 Connection conn = DriverManager.getConnection(url, user, password);
			 return conn;
		 }catch (Exception e){
			 e.printStackTrace();
		 }
		return null;
		 
	}

}
