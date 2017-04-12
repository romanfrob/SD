package dao;

import datamodel.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	
	Database db = new Database();	
	Connection con = Database.getConnection();
	
	public void insertUser(String username, String password, String userrole) throws SQLException{
		PreparedStatement stmt = con.prepareStatement("insert into user (username, pw, userrole) values ( ? , ? , ? )");
		
		stmt.setString(1, username);
		stmt.setString(2, password);
		stmt.setString(3, userrole);
		
		stmt.executeUpdate();
		
	}
	
	public void deleteUser(String username) throws SQLException{
		PreparedStatement stmt = con.prepareStatement("delete from user where username=?");
		
		stmt.setString(1, username);
		
		stmt.executeUpdate();
		
	}
	
	public void updateUser(String username, String password, String userrole) throws SQLException{
		PreparedStatement stmt = con.prepareStatement("update user set pw=?, userrole=? where username=?");
		
		stmt.setString(1, password);
		stmt.setString(2, userrole);
		stmt.setString(3, username);
		
		stmt.executeUpdate();
	}
	
	private User convertRowToUser(ResultSet myRs) throws SQLException {
		
		int id = myRs.getInt("iduser");
		String username = myRs.getString("username");
		String password = myRs.getString("pw");
		String userrole = myRs.getString("userrole");
		
		User tempEmployee = new User(id, username, password, userrole);
		
		return tempEmployee;
	}
	
	public List<User> getAllUsers() throws Exception{
		
		List<User> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from user");
			
			while(rs.next()){
				User tempUser = convertRowToUser(rs);
				list.add(tempUser);
			}
			
			return list;
		}
		finally{
			close(stmt,rs);
		}		
	}
	
	public List<User> getAllEmpUsers() throws Exception{
		
		List<User> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from user where userrole = 'E'");
			
			while(rs.next()){
				User tempUser = convertRowToUser(rs);
				list.add(tempUser);
			}
			
			return list;
		}
		finally{
			close(stmt,rs);
		}		
	}
	
	public List<User> searchUsers(String username) throws Exception {
		List<User> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			username += "%";
			myStmt = con.prepareStatement("select * from user where username like ?");
			
			myStmt.setString(1, username);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				User tempUser = convertRowToUser(myRs);
				list.add(tempUser);
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}
	
}
