package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import dao.ReportDAO;

public class InsertReport {

	@Test
	public void test() throws SQLException {
		ReportDAO report = new ReportDAO();
		
		report.insertReport(2, "Deleted something");
		//report.insertReport(2, "Made an account transaction");
		
	}
}
