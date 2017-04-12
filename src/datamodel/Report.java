package datamodel;

public class Report {
	private int idreport;
	private int iduser;
	private String operation;	
	
	public Report(int idreport, int iduser, String operation) {
		this.idreport = idreport;
		this.iduser = iduser;
		this.operation = operation;
	}
	
	public int getIdreport() {
		return idreport;
	}
	public void setIdreport(int idreport) {
		this.idreport = idreport;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	@Override
	public String toString() {
		return String
				.format("Report [idreport=%s, iduser=%s, operation=%s]",
						idreport, iduser, operation);
	}
}
