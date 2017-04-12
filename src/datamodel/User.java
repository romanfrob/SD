package datamodel;

public class User {
	private int iduser;
	private String username;
	private String password;
	private String userrole;
	
	public User(int iduser, String username, String password, String userrole) {
		this.iduser = iduser;
		this.username = username;
		this.password = password;
		this.userrole = userrole;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	
	@Override
	public String toString() {
		return String
				.format("User [id=%s, username=%s, password=%s, userrole=%s]",
						iduser, username, password, userrole);
	}
	
}
