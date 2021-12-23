package javara.model.rec;

public class Student {

	private int stuno;
	private String stuname;
	private String stutel;
	private String stuaddr;
	private int majno;
	private int drgno;
	private int profno;
	private String majname;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int stuno, String stuname, String stutel, String stuaddr, int majno, int drgno, int profno, String majname) {
		// TODO Auto-generated constructor stub
		this.stuno = stuno;
		this.stuname = stuname;
		this.stutel = stutel;
		this.stuaddr = stuaddr;
		this.majno = majno;
		this.drgno = drgno;
		this.profno = profno;
		this.majname = majname;
	}
	
	public int getStuno() {
		return stuno;
	}
	
	public void setStuno(int stuno) {
		this.stuno = stuno;
	}
	
	public String getStuname() {
		return stuname;
	}
	
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	
	public String getStutel() {
		return stutel;
	}
	
	public void setStutel(String stutel) {
		this.stutel = stutel;
	}
	
	public String getStuaddr() {
		return stuaddr;
	}
	
	public void setStuaddr(String stuaddr) {
		this.stuaddr = stuaddr;
	}
	
	public int getMajno() {
		return majno;
	}
	
	public void setMajno(int majno) {
		this.majno = majno;
	}
	
	public int getDrgno() {
		return drgno;
	}
	
	public void setDrgno(int drgno) {
		this.drgno = drgno;
	}
	
	public int getProfno() {
		return profno;
	}
	
	public void setProfno(int profno) {
		this.profno = profno;
	}
	
	public String getMajname() {
		return majname;
	}

	public void setMajname(String majname) {
		this.majname = majname;
	}
	
}
