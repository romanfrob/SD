package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.UserDAO;

public class SearchUser {

	@Test
	public void test() throws Exception {
		UserDAO dao = new UserDAO();
		System.out.println(dao.searchUsers("romana"));
	}

}
