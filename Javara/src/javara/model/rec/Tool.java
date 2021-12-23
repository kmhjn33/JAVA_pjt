package javara.model.rec;

import java.sql.Date;

public class Tool {
	
	
	private int t_no;		//기자재번호
	private int cate_no = 0;	//분류번호(FK)
	private String t_name = null;	//기자재명
	private Date t_buy_date = null;	//구입일자
	private Date t_limit_date = null;	//사용기한
	private Date t_reg_date = null;	//등록일
	private int stor_no = 0;	//보관소 번호(FK)
	private Date t_final_ck = null;	//최종 점검일자
	private String t_note = null;	//비고
	
	
	
	public Tool(int t_no) {
		
	}
	

	
	public Tool(String t_name) {
		
	}
	
	
	
	
	public Tool(int cate_no2, String t_name2, int stor_no2, String t_note2, int t_no2) {
		// TODO Auto-generated constructor stub
	}
	
	
	public Tool(int t_no, int cate_no, String t_name, Date t_buy_date,
			Date t_limit_date, Date t_reg_date, int stor_no, Date t_ck_date, String t_note) {
		
		
		// TODO Auto-generated constructor stub
		
		this.t_no= t_no;
		this.cate_no = cate_no;
		this.t_name = t_name;
		this.t_buy_date = t_buy_date;
		this.t_limit_date = t_limit_date;
		this.t_reg_date = t_reg_date;
		this.stor_no = stor_no;
		this.t_final_ck = t_ck_date;
		this.t_note = t_note;
		
		
	}
	
	
	
	public Tool() {
		// TODO Auto-generated constructor stub
	}



	public int getT_no() {
		return t_no;
	}
	public void setT_no(int t_no) {
		this.t_no = t_no;
	}
	public int getCate_no() {
		return cate_no;
	}
	public void setCate_no(int cate_no) {
		this.cate_no = cate_no;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public Date getT_buy_date() {
		return t_buy_date;
	}
	public void setT_buy_date(Date t_buy_date) {
		this.t_buy_date = t_buy_date;
	}
	public Date getT_limit_date() {
		return t_limit_date;
	}
	public void setT_limit_date(Date t_limit_date) {
		this.t_limit_date = t_limit_date;
	}
	public Date getT_reg_date() {
		return t_reg_date;
	}
	public void setT_reg_date(Date t_reg_date) {
		this.t_reg_date = t_reg_date;
	}
	public int getStor_no() {
		return stor_no;
	}
	public void setStor_no(int stor_no) {
		this.stor_no = stor_no;
	}
	public Date getT_final_ck() {
		return t_final_ck;
	}
	public void setT_final_ck(Date t_ck_date) {
		this.t_final_ck = t_ck_date;
	}
	public String getT_note() {
		return t_note;
	}
	public void setT_note(String t_note) {
		this.t_note = t_note;
	}

	
	
	
	
	

}
