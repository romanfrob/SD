package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import datamodel.Report;

public class ReportDAO {
	Database db = new Database();	
	Connection con = Database.getConnection();
	
	public void insertReport(int iduser, String operation) throws SQLException{
		PreparedStatement stmt = con.prepareStatement("insert into report (iduser, operation) values ( ? , ? )");
			
		stmt.setInt(1, iduser);
		stmt.setString(2, operation);
		
		stmt.executeUpdate();
		
	}
	
	
	private Report convertRowToReport(ResultSet myRs) throws SQLException {
		
		int idreport = myRs.getInt("idreport");
		int iduser  = myRs.getInt("iduser");
		String operation = myRs.getString("operation");
		
		Report tempReport = new Report(idreport, iduser, operation);
		
		return tempReport;
	}
	
	public List<Report> getAllReports() throws Exception{
		
		List<Report> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from report");
			
			while(rs.next()){
				Report tempReport = convertRowToReport(rs);
				list.add(tempReport);
			}
			
			return list;
		}
		finally{
			close(stmt,rs);
		}		
	}
	
	public List<Report> searchReportsByUser(int iduser) throws Exception {
		List<Report> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {

			myStmt = con.prepareStatement("select * from report where iduser like ?");
			
			myStmt.setInt(1, iduser);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Report tempReport = convertRowToReport(myRs);
				list.add(tempReport);
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
