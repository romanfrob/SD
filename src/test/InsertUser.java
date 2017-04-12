package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import dao.UserDAO;

public class InsertUser {

	@Test
	public void test() throws SQLException {
		UserDAO user = new UserDAO();
		
		user.insertUser("testuser", "testpassword", "E");
		
	}

}
