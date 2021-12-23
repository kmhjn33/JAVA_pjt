package javara.model.rec;

import java.sql.Date;

public class coopinfo {

	private int ci_no = 0; // 과제 협력 기관 번호
	private int si_no = 0; // 과제번호(FK)
	private int co_no = 0; // 협력 기관 정보 번호(FK)
	private Date ci_sdate = null; // 시작일
	private Date c_edate = null; // 종료일

	public coopinfo(int ci_no, int si_no, int co_no, Date ci_sdate, Date c_edate) {
		this.ci_no = ci_no;
		this.si_no = si_no;
		this.co_no = co_no;
		this.ci_sdate = ci_sdate;
		this.c_edate = c_edate;
	}

	public coopinfo() {

	}
	

	public int getCi_no() {
		return ci_no;
	}

	public void setCi_no(int ci_no) {
		this.ci_no = ci_no;
	}

	public int getSi_no() {
		return si_no;
	}

	public void setSi_no(int si_no) {
		this.si_no = si_no;
	}

	public int getCo_no() {
		return co_no;
	}

	public void setCo_no(int co_no) {
		this.co_no = co_no;
	}

	public Date getCi_sdate() {
		return ci_sdate;
	}

	public void setCi_sdate(Date ci_sdate) {
		this.ci_sdate = ci_sdate;
	}

	public Date getC_edate() {
		return c_edate;
	}

	public void setC_edate(Date c_edate) {
		this.c_edate = c_edate;
	}

}
