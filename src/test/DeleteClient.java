package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import dao.ClientDAO;

public class DeleteClient {

	@Test
	public void test() throws SQLException {
		ClientDAO client = new ClientDAO();
		
		client.deleteClient("1234567890123");
	}

}
