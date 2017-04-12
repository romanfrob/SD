package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import bussinesslogic.ReportBT;


public class GenerateReportFile {

	@Test
	public void test() throws Exception {
		ReportBT report = new ReportBT();
		
		report.generateReport(2);
	}

}
