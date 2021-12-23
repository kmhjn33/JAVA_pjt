package javara.model.rec;

public class Coop {

	private int co_no = 0; 				// 협력 기관 정보 변호
	private String co_name = null;		// 협력 기관 이름
	private String co_tel = null; 		// 전화번호
	private String co_detail = null;
	
	public  Coop(int co_no, String co_name, String co_tel, String co_detail) {
		this.co_no = co_no;
		this.co_name = co_name;
		this.co_tel = co_tel;
		this.co_detail =co_detail;
		
	}
	public  Coop() {
		
	}
	
	public String getCo_detail() {
		return co_detail;
	}
	public void setCo_detail(String co_detail) {
		this.co_detail = co_detail;
	}
	public int getco_no() {
		return co_no;

	}

	public void setCo_no(int co_no) {
		this.co_no = co_no;
	}

	public String getCo_name() {
		return co_name;
	}

	public void setCo_name(String co_name) {
		this.co_name = co_name;
	}

	public String getCo_tel() {
		return co_tel;
	}

	public void setCo_tel(String co_tel) {
		this.co_tel = co_tel;
	}

}

