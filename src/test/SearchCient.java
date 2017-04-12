package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.ClientDAO;


public class SearchCient {

	@Test
	public void test() throws Exception {
		ClientDAO dao = new ClientDAO();
		System.out.println(dao.searchClient("Roman"));


	}
}