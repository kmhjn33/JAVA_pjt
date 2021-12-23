package javara.model.rec;



import java.util.ArrayList;
import java.util.Date;

public class SubjectInfo {
	
	private int si_no; 						//������ȣ
	private String si_title;				//����Ÿ��Ʋ
	private String si_goal_subject;			//������ǥ
	private String si_detail;				//������
	private String si_publishing_date;		//���� �Խ���
	private String si_end_date; 				//������
	private Double si_budget;				//�����
	private int maj_no;						//�а� ��ȣ
	private String maj_name;				//�а���
	
	private int prof_no;					//��米�� PROF_NO;
	private String prof_name;				//��米�� �̸�
	
	
	public SubjectInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public SubjectInfo(int si_no,String si_title,String si_goal_subject,String si_detail,String si_publishing_date
			,String si_end_date,Double si_budget,int maj_no,int prof_no,Double si_pay) {
		this.si_no=si_no;
		this.si_title=si_title;
		this.si_goal_subject=si_goal_subject;
		this.si_detail=si_detail;
		this.si_publishing_date=si_publishing_date;
		this.si_end_date=si_end_date;
		this.si_budget=si_budget;
		this.maj_no=maj_no;
		this.prof_no=prof_no;
		this.si_pay=si_pay;
	}
	
	public String getSi_detail() {
		return si_detail;
	}

	public void setSi_detail(String si_detail) {
		this.si_detail = si_detail;
	}

	public String getMaj_name() {
		return maj_name;
	}

	public void setMaj_name(String maj_name) {
		this.maj_name = maj_name;
	}

	public String getProf_name() {
		return prof_name;
	}

	public void setProf_name(String prof_name) {
		this.prof_name = prof_name;
	}
	private Double si_pay;					//����
	


	public int getSi_no() {
		return si_no;
	}
	public void setSi_no(int si_no) {
		this.si_no = si_no;
	}
	public String getSi_title() {
		return si_title;
	}
	public void setSi_title(String si_title) {
		this.si_title = si_title;
	}
	public String getSi_goal_subject() {
		return si_goal_subject;
	}
	public void setSi_goal_subject(String si_goal_subject) {
		this.si_goal_subject = si_goal_subject;
	}
//	public String getSI_DETAIL() {
//		return this.si_detail;
//	}
//	public void setSI_DETAIL(String sI_DETAIL) {
//		this.si_detail = sI_DETAIL;
//	}
	public String getSi_publishing_date() {
		return si_publishing_date;
	}
	public void setSi_publishing_date(String si_publishing_date) {
		this.si_publishing_date = si_publishing_date;
	}
	public String getSi_end_date() {
		return si_end_date;
	}
	public void setSi_end_date(String si_end_date) {
		this.si_end_date = si_end_date;
	}
	public Double getSi_budget() {
		return si_budget;
	}
	public void setSi_budget(Double si_budget) {
		this.si_budget = si_budget;
	}
	public int getMaj_no() {
		return maj_no;
	}
	public void setMaj_no(int maj_no) {
		this.maj_no = maj_no;
	}
	public int getProf_no() {
		return prof_no;
	}
	public void setProf_no(int prof_no) {
		this.prof_no = prof_no;
	}
	public Double getSi_pay() {
		return si_pay;
	}
	public void setSi_pay(Double si_pay) {
		this.si_pay = si_pay;
	}

	
	

}

	