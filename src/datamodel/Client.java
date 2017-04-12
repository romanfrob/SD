package datamodel;

public class Client {
	private int idclient;
	private String first_name;
	private String last_name;
	private String CNP;
	private String address;
	
	public Client(int idclient, String first_name, String last_name, String CNP, String address) {
		this.idclient = idclient;
		this.first_name = first_name;
		this.last_name = last_name;
		this.CNP = CNP;
		this.address = address;
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String CNP) {
		this.CNP = CNP;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return String
				.format("Client [idclient=%s, first_name=%s, last_name=%s, CNP=%s, address=%s]",
						idclient, first_name, last_name, CNP, address);
	}
	
	
}
