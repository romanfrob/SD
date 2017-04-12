package bussinesslogic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dao.AccountDAO;
import dao.ClientDAO;
import datamodel.Account;
import datamodel.Client;
import datamodel.User;

public class ClientLogicBT {
	ClientDAO clientdao = new ClientDAO();
	AccountDAO accountdao = new AccountDAO();
	
	public void insertClient(String first_name, String last_name, String CNP, String Address) throws SQLException{
		clientdao.insertClient(first_name, last_name, CNP, Address);
	}
	
	public void deleteClient(String CNP) throws SQLException{
		clientdao.deleteClient(CNP);
	}
	
	public void updateClient(String first_name, String last_name, String CNP, String Address) throws SQLException{
		clientdao.updateClient(first_name, last_name, CNP, Address);
	}
	
	public List<Client> getAllClients() throws Exception{
		return clientdao.getAllClients();
	}
	
	public List<Client> searchClient(String last_name) throws Exception {
		return clientdao.searchClient(last_name);
	}
	
	public void insertAccount(int idclient, Double amount) throws SQLException{
		accountdao.insertAccount(idclient, amount);
	}
	
	public void deleteAccount(int idaccount) throws SQLException{
		accountdao.deleteAccount(idaccount);
	}
	
	public void updateAccount(int idaccount, Double amount) throws SQLException{
		accountdao.updateAccount(idaccount, amount);
	}
	
	public List<Account> getAllAccounts() throws Exception{
		return accountdao.getAllAccounts();
	}
	
	public List<Account> searchAccountsByClient(int idclient) throws Exception {
		return accountdao.searchAccountsByClient(idclient);
	}
	
	public void Transfer(int idclientfrom, int idclientto, double amount) throws Exception{
		List<Account> list = new ArrayList<>();
		List<Account> list2 = new ArrayList<>();
		
		double sum = 0;
		int count = 0;
		Vector<Integer> accountids = new Vector<>();
		double tempamount = 0;
		
		list = accountdao.searchAccountsByClient(idclientfrom);
		
		if(list.isEmpty()){
			System.out.println("This client has no account available");
		}
		else{
			for(int i = 0; i <list.size(); i++){
				Account account = list.get(i);
				accountids.add(account.getIdaccount());
				sum += account.getAmount();
				if(sum < amount){
					count++;
					tempamount = amount - sum;
				}								
			}
			
			if(sum < amount){
				System.out.println("The amount is too large!");
			}
			else{
				int j;
				for( j = 0; j < count; j++){
					updateAccount(accountids.get(j), 0.0);
				}
				updateAccount(accountids.get(j+1), tempamount);	
				
				list2 = accountdao.searchAccountsByClient(idclientto);
				if(list2.isEmpty()){
					insertAccount(idclientto, amount);
				} 
				else{
					Account account = list2.get(0);
					updateAccount(account.getIdaccount(), amount + account.getAmount());
				}
			}
		}
		

	
		
	}
	
	
}
