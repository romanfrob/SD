package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import datamodel.Account;

public class AccountDAO {
	Database db = new Database();	
	Connection con = Database.getConnection();
    private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public void insertAccount(int idclient, Double amount) throws SQLException{
		PreparedStatement stmt = con.prepareStatement("insert into account (idclient, amount, creation_date) values ( ? , ? , ? )");
		
	    Date date = new Date();
		String creation_date = sdf.format(date);
		
		stmt.setInt(1, idclient);
		stmt.setDouble(2, amount);
		stmt.setString(3, creation_date);
		
		stmt.executeUpdate();
		
	}
	
	public void deleteAccount(int idaccount) throws SQLException{
		PreparedStatement stmt = con.prepareStatement("delete from account where idaccount=?");
		
		stmt.setInt(1, idaccount);
		
		stmt.executeUpdate();
		
	}
	
	public void updateAccount(int idaccount, Double amount) throws SQLException{
		PreparedStatement stmt = con.prepareStatement("update account set amount=? where idaccount=?");
		
		stmt.setDouble(1, amount);
		stmt.setInt(2, idaccount);
		
		stmt.executeUpdate();
	}
	
	private Account convertRowToAccount(ResultSet myRs) throws SQLException {
		
		int idaccount = myRs.getInt("idaccount");
		int idclient  = myRs.getInt("idclient");
		Double amount = myRs.getDouble("amount");
		Date creation_date = myRs.getDate("creation_date");
		
		Account tempAccount = new Account(idaccount, idclient, amount, creation_date);
		
		return tempAccount;
	}
	
	public List<Account> getAllAccounts() throws Exception{
		
		List<Account> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from account");
			
			while(rs.next()){
				Account tempAccount = convertRowToAccount(rs);
				list.add(tempAccount);
			}
			
			return list;
		}
		finally{
			close(stmt,rs);
		}		
	}
	
	public List<Account> searchAccountsByClient(int idclient) throws Exception {
		List<Account> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {

			myStmt = con.prepareStatement("select * from account where idclient = ?");
			
			myStmt.setInt(1, idclient);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Account tempAccount = convertRowToAccount(myRs);
				list.add(tempAccount);
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
