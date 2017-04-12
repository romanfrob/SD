package dao;

import datamodel.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
	
	Database db = new Database();	
	Connection con = Database.getConnection();
	
	public void insertClient(String first_name, String last_name, String CNP, String Address) throws SQLException{
		
		PreparedStatement stmt = con.prepareStatement("insert into client (first_name, last_name, CNP, Address) values ( ? , ? , ?, ? )");
		
		stmt.setString(1, first_name);
		stmt.setString(2, last_name);
		stmt.setString(3, CNP);
		stmt.setString(4, Address);
		
		stmt.executeUpdate();
		
	}
	
	public void deleteClient(String CNP) throws SQLException{
		PreparedStatement stmt = con.prepareStatement("delete from client where CNP=?");
		
		stmt.setString(1, CNP);
		
		stmt.executeUpdate();
		
	}
	
	public void updateClient(String first_name, String last_name, String CNP, String Address) throws SQLException{
		PreparedStatement stmt = con.prepareStatement("update client set first_name=?, last_name=?, Address=? where CNP=?");
		
		stmt.setString(1, first_name);
		stmt.setString(2, last_name);
		stmt.setString(3, Address);
		stmt.setString(4, CNP);
		
		stmt.executeUpdate();
	}
	
	private Client convertRowToClient(ResultSet myRs) throws SQLException {
		
		int id = myRs.getInt("idclient");
		String first_name = myRs.getString("first_name");
		String last_name = myRs.getString("last_name");
		String CNP = myRs.getString("CNP");
		String Address= myRs.getString("Address");
		
		Client tempClient = new Client(id, first_name, last_name, CNP, Address);		
		return tempClient;
	}
	
	public List<Client> getAllClients() throws Exception{
		
		List<Client> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from client");
			
			while(rs.next()){
				Client tempClient = convertRowToClient(rs);
				list.add(tempClient);
			}
			
			return list;
		}
		finally{
			close(stmt,rs);
		}		
	}
	
	public List<Client> searchClient(String last_name) throws Exception {
		List<Client> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			last_name += "%";
			myStmt = con.prepareStatement("select * from client where last_name like ?");
			
			myStmt.setString(1, last_name);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Client tempClient = convertRowToClient(myRs);
				list.add(tempClient);
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
