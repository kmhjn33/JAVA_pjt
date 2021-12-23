package javara.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import javara.model.rec.SubjectDivision;
import javara.model.rec.SubjectInfo;
import javara.model.rec.SubjectReports;

public class SubjectReportsModel implements InterfaceCommonModel, DBConnetor  {
	
	private Connection con;
	
	//--------------------------------------------------
	// ������
	//--------------------------------------------------
	public SubjectReportsModel() {
		// TODO Auto-generated constructor stub
		try {
			connectDB();
			System.out.println("DB ����Ϸ� : " + this.getClass().getName());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("DB ������� : " + this.getClass().getName());
			
		}
	}
		
	@Override
	public void connectDB() {
		// TODO Auto-generated method stub
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(JDBC_URL,DB_ID,DB_PW);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println( this.getClass().getName() + "-DB ���� ���� ���� : " + e.getMessage());
		}
		
	}
	//--------------------------------------------
	// ���� ������ ���� ���� ( * )
	//--------------------------------------------
	@Override
	public void modify(Object obj) {
		// TODO Auto-generated method stub
		try {
			int numOfAffected;
			SubjectReports sr = new SubjectReports();
			sr=(SubjectReports)obj;
			String sql="UPDATE SUBJECTREPORTS SET SD_NO=?"
					+ ", SR_REPORT_DATE=?"
					+ ", SR_PARTICIPANT=?"
					+ ", SR_TITLE=?"
					+ ", SR_EXPERIMEN_DATE=?"
					+ ", SR_LABOFLOCATE=?"
					+ ", SR_PURPOSE=?"
					+ ", SR_REPETITIONS=?"
					+ ", SR_SIMULATIONMETHOD=?"
					+ ", SR_EXPERIMENTALPROCEDURE=?"
					+ ", SR_SIMULATIONRESULT=?"
					+ ", SR_NOTE=?"
					+ " WHERE SR_NO=? " ;
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, sr.getSd_no());
			st.setString(2, sr.getSr_report_date());
			st.setInt(3, sr.getSr_participant());
			st.setString(4, sr.getSr_title());
			st.setString(5, sr.getSr_experimen_date());
			st.setString(6, sr.getSr_laboflocate());
			st.setString(7, sr.getSr_purpose());
			st.setInt(8, sr.getSr_repetitions());
			st.setString(9, sr.getSr_simulationmethod());
			st.setString(10,sr.getSr_experimentalprocedure() );
			st.setString(11,sr.getSr_simulationresult() );
			st.setString(12,sr.getSr_note() );
			st.setInt(13,sr.getSr_no() );
			numOfAffected=st.executeUpdate();
			
			st.close();
			
			if(numOfAffected == 0) {
				throw new Exception(this.getClass().getName() + " ������ ���� ���� : ");
			}else {
				throw new Exception(this.getClass().getName() + " ������ ���� ���� : " + numOfAffected);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.getClass().getName() + " ������ ���� ���� : " + e.getMessage());
		}
	}
	//--------------------------------------------
	// ���� ������ ���� �߰� ( * )
	//--------------------------------------------
	@Override
	public void regist(Object obj) {
		// TODO Auto-generated method stub
		try {
			int numOfAffected;
			
			SubjectReports sr = new SubjectReports();
			sr=(SubjectReports)obj;
			String sql="INSERT INTO SUBJECTREPORTS(SR_NO,SR_REPORT_DATE,SR_PARTICIPANT,SR_TITLE,SR_EXPERIMEN_DATE"
					+ ",SR_LABOFLOCATE,SR_PURPOSE,SR_REPETITIONS, SR_SIMULATIONMETHOD, SR_EXPERIMENTALPROCEDURE"
					+ ",SR_SIMULATIONRESULT,SR_NOTE,SD_NO) VALUES (SUBJECTREPORTS_sq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			//st.setInt(1, sr.getSd_no());
			st.setString(1, sr.getSr_report_date());
			st.setInt(2, sr.getSr_participant());
			st.setString(3, sr.getSr_title());
			st.setString(4, sr.getSr_experimen_date());
			st.setString(5, sr.getSr_laboflocate());
			st.setString(6, sr.getSr_purpose());
			st.setInt(7, sr.getSr_repetitions());
			st.setString(8, sr.getSr_simulationmethod());
			st.setString(9,sr.getSr_experimentalprocedure() );
			st.setString(10,sr.getSr_simulationresult() );
			st.setString(11,sr.getSr_note() );
			st.setInt(12,sr.getSd_no() );
			numOfAffected= st.executeUpdate();
			if(numOfAffected == 0) {
				throw new Exception(this.getClass().getName() + " ����Ÿ �߰� ���� : ");
			}else {
				System.out.println(this.getClass().getName() + " ����Ÿ �߰� ���� : " + numOfAffected);
			}
			st.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.getClass().getName() + " ����Ÿ �߰� ���� : " + e.getMessage());
		}
	}
	
	//--------------------------------------------
	// ���� ���� �д� ���� �߰� ( * )
	//--------------------------------------------
	public void registDivision(SubjectDivision obj) {
		// TODO Auto-generated method stub
		try {
			int numOfAffected;
			String sql="INSERT INTO subjectDivision(SD_NO,SD_TITLE,SD_DETAIL_INFO,SD_CONFIRM_MANAGER,SI_NO,STU_NO)  VALUES (" 
					+ "subjectDivision_sq.NEXTVAL ,?,?,?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			
			st.setString(1, obj.getSd_title());
			st.setString(2, obj.getSd_detail_info());
			st.setString(3, obj.getSd_Confirm_Manager());
			st.setInt(4,obj.getSi_no());
			st.setInt(5,obj.getStu_no());
			numOfAffected= st.executeUpdate();
			if(numOfAffected == 0) {
				throw new Exception(this.getClass().getName() + " ����Ÿ �߰� ���� : ");
			}else {
				System.out.println(this.getClass().getName() + " ����Ÿ �߰� ���� : " + numOfAffected);
			}
			st.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.getClass().getName() + " ����Ÿ �߰� ���� : " + e.getMessage());
		}
	}
	
	//--------------------------------------------
	// ���� ���� �д� ���� �����̵� ( * )
	//--------------------------------------------
	public void modifyDivision(SubjectDivision obj) {
		// TODO Auto-generated method stub
		try {
			int numOfAffected;
			String sql="UPDATE SUBJECTDIVISION SET SD_TITLE=?, SD_DETAIL_INFO=?, SD_CONFIRM_MANAGER=?, SI_NO=?, STU_NO=? " 
					+ " WHERE SD_NO=?";
			PreparedStatement st=con.prepareStatement(sql);
			
			st.setString(1, obj.getSd_title());
			st.setString(2, obj.getSd_detail_info());
			st.setString(3, obj.getSd_Confirm_Manager());
			st.setInt(4,obj.getSi_no());
			st.setInt(5,obj.getStu_no());
			st.setInt(6,obj.getSd_no());
			numOfAffected= st.executeUpdate();
			if(numOfAffected == 0) {
				throw new Exception(this.getClass().getName() + " ����Ÿ ���� ���� : ");
			}else {
				System.out.println(this.getClass().getName() + " ����Ÿ ���� ���� : " + numOfAffected);
			}
			st.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.getClass().getName() + " ����Ÿ ���� ���� : " + e.getMessage());
		}
	}
	
	//--------------------------------------------
	// ���� ������ ���� ��ȸ ( * )
	//--------------------------------------------
	@Override
	public ArrayList<SubjectReports> search() {
		// TODO Auto-generated method stub
		ArrayList<SubjectReports> list=new ArrayList<SubjectReports>();
		try {
			String sql="select SR_NO,SR_REPORT_DATE,SR_PARTICIPANT,SR_TITLE,SR_EXPERIMEN_DATE"
					+ ",SR_LABOFLOCATE,SR_PURPOSE,SR_REPETITIONS, SR_SIMULATIONMETHOD, SR_EXPERIMENTALPROCEDURE"
					+ ",SR_SIMULATIONRESULT,SR_NOTE,SD_NO FROM SUBJECTREPORTS";
			PreparedStatement ps =con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			SubjectReports sr;
			while(rs.next()) {
				sr = new SubjectReports();
				sr.setSr_no(rs.getInt("SR_NO"));
				sr.setSr_report_date(rs.getString("SR_REPORT_DATE"));
			 	sr.setSr_participant(rs.getInt("SR_PARTICIPANT"));
				sr.setSr_title( rs.getString("SR_TITLE"));
				sr.setSr_experimen_date(rs.getString("SR_EXPERIMEN_DATE"));
				sr.setSr_laboflocate(rs.getString("SR_LABOFLOCATE"));
				sr.setSr_purpose(rs.getString("SR_PURPOSE"));
				sr.setSr_repetitions(rs.getInt("SR_REPETITIONS"));
				sr.setSr_simulationmethod(rs.getString("SR_SIMULATIONMETHOD"));
			    sr.setSr_experimentalprocedure(rs.getString("SR_EXPERIMENTALPROCEDURE" ));
			    sr.setSr_simulationresult(rs.getString("SR_SIMULATIONRESULT"));
				sr.setSr_note(rs.getString("SR_NOTE"));
				sr.setSd_no(rs.getInt("SD_NO"));
				
			}
			System.out.println(this.getClass().getName().toString() + ":" + list.size() + " ���� �ڷᰡ �˻��Ǿ����ϴ�.");
			rs.close();
			ps.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.getClass().getName().toString() + " ����Ÿ ��ȸ ���� : " + e.getMessage());
		}
		return list;
	}
	//--------------------------------------------
	// ���� ���� �д� ���� ��ȸ ( * )
	//--------------------------------------------
	public SubjectDivision searchDivisionInfo(int si_no, int stu_no) {
		// TODO Auto-generated method stub
		SubjectDivision sr = new SubjectDivision();
		try {
			String sql="select SD_NO, SD_TITLE, SD_DETAIL_INFO, SD_CONFIRM_MANAGER, SI_NO, STU_NO FROM SUBJECTDIVISION "
					+ " Where SI_NO=? AND STU_NO=?";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setInt(1, si_no);
			ps.setInt(2, stu_no);			
			ResultSet rs=ps.executeQuery();
			sr.setSd_no(0);
			while(rs.next()) {
				sr = new SubjectDivision();
				sr.setSd_no(rs.getInt("SD_NO"));
				sr.setSd_title(rs.getString("SD_TITLE"));
				sr.setSd_detail_info(rs.getString("SD_DETAIL_INFO"));
				sr.setSd_Confirm_Manager(rs.getString("SD_CONFIRM_MANAGER"));
				sr.setSi_no(rs.getInt("SI_NO"));
				sr.setStu_no(rs.getInt("STU_NO"));
			}

			rs.close();
			ps.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.getClass().getName().toString() + " ����Ÿ ��ȸ ���� : " + e.getMessage());
		}
		return sr;
	}
	//--------------------------------------------
	// ���� ������ ���� ��ȸ ( [��������].����������ȣ )
	//--------------------------------------------
	public SubjectReports search(int sino) {
		// TODO Auto-generated method stub
		SubjectReports sr = new SubjectReports();
		try {
			String sql="select SR_NO,SR_REPORT_DATE,SR_PARTICIPANT,SR_TITLE,SR_EXPERIMEN_DATE"
					+ ",SR_LABOFLOCATE,SR_PURPOSE,SR_REPETITIONS, SR_SIMULATIONMETHOD, SR_EXPERIMENTALPROCEDURE"
					+ ",SR_SIMULATIONRESULT,SR_NOTE,SD_NO FROM SUBJECTREPORTS WHERE SR_NO=?";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setInt(1, sino);
			
			ResultSet rs=ps.executeQuery();
		
			while(rs.next()) {
				sr = new SubjectReports();
				sr.setSr_no(rs.getInt("SR_NO"));
				sr.setSr_report_date(rs.getString("SR_REPORT_DATE"));
			 	sr.setSr_participant(rs.getInt("SR_PARTICIPANT"));
				sr.setSr_title( rs.getString("SR_TITLE"));
				sr.setSr_experimen_date(rs.getString("SR_EXPERIMEN_DATE"));
				sr.setSr_laboflocate(rs.getString("SR_LABOFLOCATE"));
				sr.setSr_purpose(rs.getString("SR_PURPOSE"));
				sr.setSr_repetitions(rs.getInt("SR_REPETITIONS"));
				sr.setSr_simulationmethod(rs.getString("SR_SIMULATIONMETHOD"));
			    sr.setSr_experimentalprocedure(rs.getString("SR_EXPERIMENTALPROCEDURE" ));
			    sr.setSr_simulationresult(rs.getString("SR_SIMULATIONRESULT"));
				sr.setSr_note(rs.getString("SR_NOTE"));
				sr.setSd_no(rs.getInt("SD_NO"));
			}
			rs.close();
			ps.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.getClass().getName().toString() + " ����Ÿ ��ȸ ���� : " + e.getMessage());
		}
		return sr;
	}
	

	//--------------------------------------------
	// ���� ������ ���� ��ȸ ( [�����д�]������ȣ )
	//--------------------------------------------
	public ArrayList<SubjectReports> searchBySD_No(int sdno) {
		// TODO Auto-generated method stub
		ArrayList<SubjectReports> list=new ArrayList<SubjectReports>();
		try {
			String sql="select SR_NO,SR_REPORT_DATE,SR_PARTICIPANT,SR_TITLE,SR_EXPERIMEN_DATE"
					+ ",SR_LABOFLOCATE,SR_PURPOSE,SR_REPETITIONS, SR_SIMULATIONMETHOD, SR_EXPERIMENTALPROCEDURE"
					+ ",SR_SIMULATIONRESULT,SR_NOTE,SD_NO FROM SUBJECTREPORTS WHERE SD_NO=?";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setInt(1, sdno);
			
			ResultSet rs=ps.executeQuery();
			SubjectReports sr;
			while(rs.next()) {
				sr = new SubjectReports();
				sr.setSr_no(rs.getInt("SR_NO"));
				sr.setSr_report_date(rs.getString("SR_REPORT_DATE"));
			 	sr.setSr_participant(rs.getInt("SR_PARTICIPANT"));
				sr.setSr_title( rs.getString("SR_TITLE"));
				sr.setSr_experimen_date(rs.getString("SR_EXPERIMEN_DATE"));
				sr.setSr_laboflocate(rs.getString("SR_LABOFLOCATE"));
				sr.setSr_purpose(rs.getString("SR_PURPOSE"));
				sr.setSr_repetitions(rs.getInt("SR_REPETITIONS"));
				sr.setSr_simulationmethod(rs.getString("SR_SIMULATIONMETHOD"));
			    sr.setSr_experimentalprocedure(rs.getString("SR_EXPERIMENTALPROCEDURE" ));
			    sr.setSr_simulationresult(rs.getString("SR_SIMULATIONRESULT"));
				sr.setSr_note(rs.getString("SR_NOTE"));
				sr.setSd_no(rs.getInt("SD_NO"));
				
				list.add(sr);
			}
			System.out.println(this.getClass().getName().toString() + ":" + list.size() + " ���� �ڷᰡ �˻��Ǿ����ϴ�.");
			rs.close();
			ps.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.getClass().getName().toString() + " ����Ÿ ��ȸ ���� : " + e.getMessage());
		}
		return list;
	}
	
	//--------------------------------------------
	// ���� ������ ���� ��ȸ ( �������� )
	//--------------------------------------------
	public ArrayList<SubjectReports> search(Date sr_report_date) {
		// TODO Auto-generated method stub
		ArrayList<SubjectReports> list=new ArrayList<SubjectReports>();
		try {
			String sql="select SR_NO,SR_REPORT_DATE,SR_PARTICIPANT,SR_TITLE,SR_EXPERIMEN_DATE"
					+ ",SR_LABOFLOCATE,SR_PURPOSE,SR_REPETITIONS, SR_SIMULATIONMETHOD, SR_EXPERIMENTALPROCEDURE"
					+ ",SR_SIMULATIONRESULT,SR_NOTE,SD_NO FROM SUBJECTREPORTS WHERE SR_REPORT_DATE=?";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setDate(1, (java.sql.Date)sr_report_date);
			
			ResultSet rs=ps.executeQuery();
			SubjectReports sr;
			while(rs.next()) {
				sr = new SubjectReports();
				sr.setSr_no(rs.getInt("SR_NO"));
				sr.setSr_report_date(rs.getString("SR_REPORT_DATE"));
			 	sr.setSr_participant(rs.getInt("SR_PARTICIPANT"));
				sr.setSr_title( rs.getString("SR_TITLE"));
				sr.setSr_experimen_date(rs.getString("SR_EXPERIMEN_DATE"));
				sr.setSr_laboflocate(rs.getString("SR_LABOFLOCATE"));
				sr.setSr_purpose(rs.getString("SR_PURPOSE"));
				sr.setSr_repetitions(rs.getInt("SR_REPETITIONS"));
				sr.setSr_simulationmethod(rs.getString("SR_SIMULATIONMETHOD"));
			    sr.setSr_experimentalprocedure(rs.getString("SR_EXPERIMENTALPROCEDURE" ));
			    sr.setSr_simulationresult(rs.getString("SR_SIMULATIONRESULT"));
				sr.setSr_note(rs.getString("SR_NOTE"));
				sr.setSd_no(rs.getInt("SD_NO"));
				
				list.add(sr);
			}
			System.out.println(this.getClass().getName().toString() + ":" + list.size() + " ���� �ڷᰡ �˻��Ǿ����ϴ�.");
			rs.close();
			ps.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.getClass().getName().toString() + " ����Ÿ ��ȸ ���� : " + e.getMessage());
		}
		return list;
	}
	
	//�޺��ڽ��� �а����� ��������
	//--------------------------------------------
	// �а� ���� �������� ( ListBox �뵵)
	// �μ� : None
	//--------------------------------------------
	public ArrayList SelectMajorInfo() {
		ArrayList list=new ArrayList();
		try {
			String sql="SELECT MAJ_NO,MAJ_NAME FROM MAJOR_INFO";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()){
				ArrayList tmp = new ArrayList(); 
				int maj_no=rs.getInt("MAJ_NO");
				String maj=rs.getString("MAJ_NAME");
				String maj_info=maj_no + "-" + maj;
//				tmp.add(maj_no + "-" + maj);
				tmp.add(maj_info);
				
				list.add(tmp);
			}
			rs.close();
			ps.close();
			//System.out.println(this.getClass().getName().toString() + ":" + list.size() + " ���� �ڷᰡ �˻��Ǿ����ϴ�.");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.getClass().getName().toString() + " ����Ÿ ��ȸ ���� : " + e.getMessage());
		}
		return list;
	}
	
	//--------------------------------------------
	// �������� ��� ��������
	//--------------------------------------------
	public ArrayList searchSubjectInfobyMajorNo(int major_no) {
		
		ArrayList list = new ArrayList();
		try {
			String sql="SELECT SI_NO,SI_TITLE FROM SUBJECT_INFO";
			if(major_no > 0) {
				sql=sql + " Where maj_no=" + major_no;
			}
			
			System.out.println(sql);
			PreparedStatement ps =con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
					
			while(rs.next()) {
				ArrayList item = new ArrayList();
				
				int si_no=rs.getInt("SI_NO");
				String si_title=rs.getString("SI_TITLE");
				String itemString=si_no + "-" + si_title;
				item.add(itemString);
				list.add(item);
			}
			
			System.out.println(this.getClass().getName().toString() + ":" + list.size() + " ���� �ڷᰡ �˻��Ǿ����ϴ�.");
			rs.close();
			ps.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.getClass().getName().toString() + " ����Ÿ ��ȸ ���� : " + e.getMessage());
		}
		return list;
	}
	//--------------------------------------------
	// �������� ������ ��� ��������
	//--------------------------------------------
	public ArrayList searchStudentInfobySubjectNo(int subject_no) {
		
		ArrayList list = new ArrayList();
		try {
			String sql="SELECT S.STU_NO,(SELECT STU_NAME FROM STUDENT_INFO T WHERE T.STU_NO=S.STU_NO) STU_NAME FROM SUBJECTPARTICIPANT S WHERE SI_NO=?";
			
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setInt(1, subject_no);
			ResultSet rs=ps.executeQuery();
					
			while(rs.next()) {
				ArrayList item = new ArrayList();
				
				int stu_no=rs.getInt("STU_NO");
				String stu_name=rs.getString("STU_NAME");
				String itemString=stu_no + "-" + stu_name;
				item.add(itemString);
				list.add(item);
			}
			
			System.out.println(this.getClass().getName().toString() + ":" + list.size() + " ���� �ڷᰡ �˻��Ǿ����ϴ�.");
			rs.close();
			ps.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.getClass().getName().toString() + " ����Ÿ ��ȸ ���� : " + e.getMessage());
		}
		return list;
	}
	//--------------------------------------------
	// ���� ������ ���� ��ȸ Table��
	//--------------------------------------------
	public ArrayList searchSubjectReportBySD_No(int sdno) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		try {
			String sql="select SR_NO,SR_REPORT_DATE,SR_TITLE,SR_EXPERIMEN_DATE,SR_LABOFLOCATE"
					+ " FROM SUBJECTREPORTS WHERE SD_NO=? ORDER BY SR_REPORT_DATE";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setInt(1, sdno);
			ResultSet rs=ps.executeQuery();
			ArrayList temp;
			while(rs.next()) {
				temp = new ArrayList();
				temp.add(rs.getInt("SR_NO"));
				temp.add(rs.getString("SR_REPORT_DATE"));
				temp.add( rs.getString("SR_TITLE"));
				temp.add(rs.getString("SR_EXPERIMEN_DATE"));
				temp.add(rs.getString("SR_LABOFLOCATE"));
				list.add(temp);
			}
			System.out.println(this.getClass().getName().toString() + ":" + list.size() + " ���� �ڷᰡ �˻��Ǿ����ϴ�.");
			rs.close();
			ps.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.getClass().getName().toString() + " ����Ÿ ��ȸ ���� : " + e.getMessage());
		}
		return list;
	}
}
