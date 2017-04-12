package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import dao.ClientDAO;

public class UpdateClient {

	@Test
	public void test() throws SQLException {
		ClientDAO client = new ClientDAO();
		
		client.updateClient("first name update", "last name update", "1234567890123", "adresa update");
	}

}


