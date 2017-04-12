package datamodel;

import java.util.Date;

public class Account {
	private int idaccount;
	private int idclient;
	private double amount;
	private Date creation_date;
	
	public Account(int idaccount, int idclient, double amount, Date creation_date) {
		this.idaccount = idaccount;
		this.idclient = idclient;
		this.amount = amount;
		this.creation_date = creation_date;
	}

	public int getIdaccount() {
		return idaccount;
	}

	public void setIdaccount(int idaccount) {
		this.idaccount = idaccount;
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	
	
	
	
}
