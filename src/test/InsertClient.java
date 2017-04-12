package test;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.Test;
import dao.ClientDAO;

public class InsertClient {

	@Test
	public void test() throws SQLException {
		ClientDAO client = new ClientDAO();
		
		client.insertClient("first name test" , "last name test", "1234567890123", "Adresa random");
		
	}

}
