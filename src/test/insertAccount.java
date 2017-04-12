package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import dao.AccountDAO;

public class insertAccount {

	@Test
	public void test() throws SQLException {
		AccountDAO account = new AccountDAO();
		
		account.insertAccount(1, 200.3);
		
	}
}
