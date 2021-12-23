package javara.model.rec;

public class Professor {

	private int profno;
	private int majno;
	private String profname;
	private String proftel;
	private String profoffice;
	private String majname;
	
	public Professor() {
		// TODO Auto-generated constructor stub
	}
	
	public Professor(int profno, int majno, String profname, String proftel, String profoffice, String majname) {
		// TODO Auto-generated constructor stub
		this.profno = profno;
		this.majno = majno;
		this.profname = profname;
		this.proftel = proftel;
		this.profoffice = profoffice;		
		this.majname = majname;
	}

	public int getProfno() {
		return profno;
	}

	public void setProfno(int profno) {
		this.profno = profno;
	}

	public int getMajno() {
		return majno;
	}

	public void setMajno(int majno) {
		this.majno = majno;
	}

	public String getProfname() {
		return profname;
	}

	public void setProfname(String profname) {
		this.profname = profname;
	}

	public String getProftel() {
		return proftel;
	}

	public void setProftel(String proftel) {
		this.proftel = proftel;
	}

	public String getProfoffice() {
		return profoffice;
	}

	public void setProfoffice(String profoffice) {
		this.profoffice = profoffice;
	}
	
	public String getMajname() {
		return majname;
	}

	public void setMajname(String majname) {
		this.majname = majname;
	}
}
