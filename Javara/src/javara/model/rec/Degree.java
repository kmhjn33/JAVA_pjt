package javara.model.rec;

public class Degree {
	
	int drgno;
	String drgname;
	
	public Degree() {
		// TODO Auto-generated constructor stub
	}
	
	public Degree(int drgno, String drgname) {
		// TODO Auto-generated constructor stub
		this.drgno = drgno;
		this.drgname = drgname;
	}
	
	public int getDrgno() {
		return drgno;
	}
	
	public void setDrgno(int drgno) {
		this.drgno = drgno;
	}
	
	public String getDrgname() {
		return drgname;
	}
	
	public void setDrgname(String drgname) {
		this.drgname = drgname;
	}

}
