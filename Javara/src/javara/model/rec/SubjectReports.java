package javara.model.rec;


import java.util.Date;

public class SubjectReports {
	
	private int sr_no;							// �������� ������ȣ
	private String sr_report_date;                 // ��������
	private int sr_participant;                  // �����ο�
	private String sr_title;                     // ���� Ÿ��Ʋ
	private String sr_experimen_date;              // ��������
	private String sr_laboflocate;               // �������
	private String sr_purpose;                   // �������
	private int sr_repetitions;                  // ���� �ݺ� Ƚ��
	private String sr_simulationmethod;          // ���� ���
	private String sr_experimentalprocedure;     // ���� ����
	private String sr_simulationresult;          // ������
	private String sr_note;                      // ��Ÿ�߰�����
	private int sd_no;                           // �����д� ���� ��ȣ
	public SubjectReports() {
		// TODO Auto-generated constructor stub
		sr_no=0;
	}
	
	
	public SubjectReports(int sr_no,String sr_report_date,int sr_participant,String sr_title,String sr_experimen_date
			,String sr_laboflocate,String sr_purpose,int sr_repetitions,String sr_simulationmethod,String sr_experimentalprocedure
			,String sr_simulationresult,String sr_note,int sd_no) {
		// TODO Auto-generated constructor stub
	}
	public int getSr_no() {
		return sr_no;
	}
	public void setSr_no(int sr_no) {
		this.sr_no = sr_no;
	}
	public String getSr_report_date() {
		return sr_report_date;
	}
	public void setSr_report_date(String sr_report_date) {
		this.sr_report_date = sr_report_date;
	}
	public int getSr_participant() {
		return sr_participant;
	}
	public void setSr_participant(int sr_participant) {
		this.sr_participant = sr_participant;
	}
	public String getSr_title() {
		return sr_title;
	}
	public void setSr_title(String sr_title) {
		this.sr_title = sr_title;
	}
	public String getSr_experimen_date() {
		return sr_experimen_date;
	}
	public void setSr_experimen_date(String sr_experimen_date) {
		this.sr_experimen_date = sr_experimen_date;
	}
	public String getSr_laboflocate() {
		return sr_laboflocate;
	}
	public void setSr_laboflocate(String sr_laboflocate) {
		this.sr_laboflocate = sr_laboflocate;
	}
	public String getSr_purpose() {
		return sr_purpose;
	}
	public void setSr_purpose(String sr_purpose) {
		this.sr_purpose = sr_purpose;
	}
	public int getSr_repetitions() {
		return sr_repetitions;
	}
	public void setSr_repetitions(int sr_repetitions) {
		this.sr_repetitions = sr_repetitions;
	}
	public String getSr_simulationmethod() {
		return sr_simulationmethod;
	}
	public void setSr_simulationmethod(String sr_simulationmethod) {
		this.sr_simulationmethod = sr_simulationmethod;
	}
	public String getSr_experimentalprocedure() {
		return sr_experimentalprocedure;
	}
	public void setSr_experimentalprocedure(String sr_experimentalprocedure) {
		this.sr_experimentalprocedure = sr_experimentalprocedure;
	}
	public String getSr_simulationresult() {
		return sr_simulationresult;
	}
	public void setSr_simulationresult(String sr_simulationresult) {
		this.sr_simulationresult = sr_simulationresult;
	}
	public String getSr_note() {
		return sr_note;
	}
	public void setSr_note(String sr_note) {
		this.sr_note = sr_note;
	}
	public int getSd_no() {
		return sd_no;
	}
	public void setSd_no(int sd_no) {
		this.sd_no = sd_no;
	}


}
