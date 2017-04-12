package bussinesslogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ReportDAO;
import datamodel.Report;


public class ReportBT {
	
	ReportDAO report = new ReportDAO();
	
	public void insertReport(int iduser, String operation) throws SQLException{
		report.insertReport(iduser, operation);
	}
	
	public void generateReport(int iduser) throws Exception{
		List<Report> list = new ArrayList<>();
		list = report.searchReportsByUser(iduser);
		
		try{
		    PrintWriter writer = new PrintWriter("report.txt", "UTF-8");
		    
		    for(int i=0; i < list.size(); i++){
		    	int temp = i + 1;
		    	writer.println("Operation nr " + temp + ": " + list.get(i));
		    }		    
		    
		    writer.close();
		} catch (IOException e) {
		   System.out.println(e);
		}
		
	}

}
