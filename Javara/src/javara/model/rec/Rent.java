package javara.model.rec;

public class Rent {

	private int rentNo;
	private String rentDate;
	private String returnSchedule;
	private String returnFlag;
	private String returnDate;
	private int tNo;
	private int stuNo;
	
	public Rent(int rentNo, String rentDate, String returnSchedule, String returnFlag, String returnDate, int tNo, int stuNo) {
		this.rentNo = rentNo;
		this.rentDate = rentDate;
		this.returnSchedule = returnSchedule;
		this.returnFlag = returnFlag;
		this.returnDate = returnDate;
		this.tNo = tNo;
		this.stuNo = stuNo;
	}
	
	public Rent(int tNo, String returnSchedule, int stuNo) {
		this(-1, "sysdate", returnSchedule, "N", null, tNo, stuNo);

	}
			
	public Rent() {
		
	}
	
	public int getRentNo() {
		return rentNo;
	}

	public void setRentNo(int rentNo) {
		this.rentNo = rentNo;
	}

	public String getRentDate() {
		return rentDate;
	}

	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}

	public String getReturnSchedule() {
		return returnSchedule;
	}

	public void setReturnSchedule(String returnSchedule) {
		this.returnSchedule = returnSchedule;
	}

	public String getReturnFlag() {
		return returnFlag;
	}

	public void setReturnFlag(String returnFlag) {
		this.returnFlag = returnFlag;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public int gettNo() {
		return tNo;
	}

	public void settNo(int tNo) {
		this.tNo = tNo;
	}

	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	
}
