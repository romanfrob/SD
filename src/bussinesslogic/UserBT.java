package bussinesslogic;

import java.sql.SQLException;
import java.util.List;

import dao.UserDAO;
import datamodel.User;

public class UserBT {
	
	UserDAO user = new UserDAO();
	
	public void insertUser(String username, String password, String userrole) throws SQLException{
		user.insertUser(username, password, userrole);
	}
	
	public void deleteUser(String username) throws SQLException{
		user.deleteUser(username);
	}
	
	public void updateUser(String username, String password, String userrole) throws SQLException{
		user.updateUser(username, password, userrole);
	}
	
	public List<User> getAllUsers() throws Exception{
		return user.getAllUsers();		
	}
	
	public List<User> getAllEmpUsers() throws Exception{
		return user.getAllEmpUsers();		
	}
	
	public List<User> searchUsers(String username) throws Exception{
		return user.searchUsers(username);
	}
}
