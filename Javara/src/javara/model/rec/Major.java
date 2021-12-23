package javara.model.rec;

public class Major {

	int majno;
	String majname;
	String majtel;
	String majoffice;

	public Major() {
		// TODO Auto-generated constructor stub
	}	
	
	public Major(int majno, String majname, String majtel, String majoffice) {
		// TODO Auto-generated constructor stub
		this.majno = majno;
		this.majname = majname;
		this.majtel = majtel;
		this.majoffice= majoffice;
	}	
	
	public int getMajno() {
		return majno;
	}
	
	public void setMajno(int majno) {
		this.majno = majno;
	}
	
	public String getMajname() {
		return majname;
	}
	
	public void setMajname(String majname) {
		this.majname = majname;
	}
	
	public String getMajtel() {
		return majtel;
	}
	
	public void setMajtel(String majtel) {
		this.majtel = majtel;
	}
	
	public String getMajoffice() {
		return majoffice;
	}
	
	public void setMajoffice(String majoffice) {
		this.majoffice = majoffice;
	}
	
}
