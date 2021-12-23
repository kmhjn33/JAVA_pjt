package javara.model;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import javara.model.rec.SubjectInfo;

public class SubjectInfoModel implements InterfaceCommonModel, DBConnetor {

	private Connection  con;
	
	
	public SubjectInfoModel() {
		// TODO Auto-generated constructor stub
		try {
			connectDB();
			System.out.println("DB 연결완료 : " + this.getClass().getName());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("DB 연결실패 : " + this.getClass().getName());
			
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
			System.out.println("데이타베이스 연결 초기화 실패 : " + this.getClass().getName());
		}
		
	}
	//--------------------------------------------
	// 과제 정보 수정 ( * )
	//--------------------------------------------
	@Override
	public void modify(Object obj) {
		// TODO Auto-generated method stub
		try {
			
			
				int numOfAffected;
				SubjectInfo sj = new SubjectInfo();
				sj=(SubjectInfo)obj;
		
				String sql="UPDATE SUBJECT_INFO SET SI_TITLE=?,"
						+ " SI_GOAL_SUBJCT=?,"
						+ " SI_PUBLISHING_DATE=?,"
						+ " SI_END_DATE=?,"
						+ " SI_BUDGET=?,"
						+ " MAJ_NO=?,"
						+ " PROF_NO=?,"
						+ " SI_DETAIL=?,"
						+ " SI_PAY=?"
						+ " WHERE SI_NO=?";
				PreparedStatement st=con.prepareStatement(sql);
				
				st.setString(1, sj.getSi_title());
				st.setString(2, sj.getSi_goal_subject());
				st.setString(3, sj.getSi_publishing_date().toString());
				st.setString(4, sj.getSi_end_date().toString());
				st.setDouble(5, sj.getSi_budget());
				st.setInt(6, sj.getMaj_no());
				st.setInt(7, sj.getProf_no());
				st.setString(8, sj.getSi_detail());
				st.setDouble(9, sj.getSi_pay());
				st.setInt(10,sj.getSi_no() );
				
				numOfAffected=st.executeUpdate();
				
				st.close();
				
				if(numOfAffected == 0) {
					throw new Exception(this.getClass().getName() + " 데이터 수정 실패 : ");
				}else {
					throw new Exception(this.getClass().getName() + " 데이터 수정 성공 : " + numOfAffected);
				}
				
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(this.getClass().getName() + " 데이터 수정 실패 : " + e.getMessage());
			}
		
	}
	
	//--------------------------------------------
	// 과제 정보 추가 ( * )
	//--------------------------------------------
	@Override
	public void regist(Object obj) {
		// TODO Auto-generated method stub
		try {
			
			//int numOfAffected;
			
			SubjectInfo sj = new SubjectInfo();
		
			sj=(SubjectInfo)obj;

			String sql="INSERT INTO SUBJECT_INFO(SI_NO, SI_TITLE,SI_GOAL_SUBJCT,SI_PUBLISHING_DATE"
					+ ",SI_END_DATE,SI_BUDGET,MAJ_NO,PROF_NO,SI_DETAIL,SI_PAY) VALUES(Subject_info_SQ.nextval,?,?,?,?,?,?,?,?,?)";
						
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, sj.getSi_title());
			st.setString(2, sj.getSi_goal_subject());
			st.setString(3, sj.getSi_publishing_date());
			st.setString(4, sj.getSi_end_date());
			st.setDouble(5, sj.getSi_budget());
			st.setInt(6, sj.getMaj_no());
			st.setInt(7, sj.getProf_no());
			st.setString(8, sj.getSi_detail());
			st.setDouble(9, sj.getSi_pay());
			
			st.executeQuery();
			
//			if(numOfAffected == 0) {
//				throw new Exception(this.getClass().getName() + " 데이타 추가 실패 : ");
//			}else {
//				System.out.println(this.getClass().getName() + " 데이타 추가 성공 : " + numOfAffected);
//			}
			st.close();
			System.out.println(this.getClass().getName() + " 데이타 추가 성공 : ");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.getClass().getName() + " 데이타 추가 실패 : " + e.getMessage());
		}
		
	}
	
	//--------------------------------------------
	// 과제 정보 검색 ( * )
	//--------------------------------------------
	@Override
	public ArrayList search() {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		try {
			String sql="SELECT SI_NO,SI_TITLE,SI_GOAL_SUBJCT,SI_PUBLISHING_DATE,SI_END_DATE,SI_BUDGET,MAJ_NO"
					+ ",(SELECT MAJ_NAME FROM MAJOR_INFO M WHERE M.MAJ_NO=S.MAJ_NO) MAJ_NAME"
					+ ",PROF_NO"
					+ ",(SELECT PROF_NAME FROM PROFESSOR_INFO P WHERE P.PROF_NO=S.PROF_NO) PROF_NAME"
					+ ",SI_DETAIL,SI_PAY FROM SUBJECT_INFO S ";
			System.out.println(sql);
//			PreparedStatement ps =con.prepareStatement(sql);
//			ResultSet rs=ps.executeQuery();
			
			
			ResultSet rs;
			Statement st=con.createStatement();
			rs=st.executeQuery(sql);
			
			
			
			//SubjectInfo sj;
			
			while(rs.next()) {
				
				ArrayList temp= new ArrayList();
				temp.add(rs.getInt("SI_NO"));
				System.out.println(rs.getInt("SI_NO"));
				temp.add(rs.getString("SI_TITLE"));
//				temp.add(rs.getString("SI_GOAL_SUBJCT"));
				temp.add(rs.getDate("SI_PUBLISHING_DATE"));
				temp.add(rs.getDate("SI_END_DATE"));
				temp.add(rs.getDouble("SI_BUDGET"));
//				temp.add(rs.getInt("MAJ_NO"));
				temp.add(rs.getString("MAJ_NAME"));
//				temp.add(rs.getInt("PROF_NO"));
				temp.add(rs.getString("PROF_NAME"));
//				temp.add(rs.getString("SI_DETAIL"));
//				temp.add(rs.getDouble("SI_PAY"));
				list.add(temp);
				
//				sj=new SubjectInfo();
//				sj.setSi_no(rs.getInt("SI_NO"));
//				sj.setSi_title(rs.getString("SI_TITLE"));
//				sj.setSi_goal_subject(rs.getString("SI_GOAL_SUBJCT"));
//				sj.setSi_publishing_date(rs.getDate("SI_PUBLISHING_DATE"));
//				sj.setSi_end_date(rs.getDate("SI_END_DATE"));
//				sj.setSi_budget(rs.getDouble("SI_BUDGET"));
//				sj.setMaj_no(rs.getInt("MAJ_NO"));
//				sj.setMaj_name(rs.getString("MAJ_NAME"));
//				sj.setProf_no(rs.getInt("PROF_NO"));
//				sj.setProf_name(rs.getString("PROF_NAME"));
//				sj.setSI_DETAIL(rs.getString("SI_DETAIL"));
//				sj.setSi_pay(rs.getDouble("SI_PAY"));
//				list.add(sj);
			}
			
			System.out.println(this.getClass().getName().toString() + ":" + list.size() + " 건의 자료가 검색되었습니다.");
			rs.close();
			//ps.close();

		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.getClass().getName().toString() + " 데이타 조회 실패 : " + e.getMessage());
		}
		return list;
	
	}
	
			//--------------------------------------------
			// 과제 정보 검색 ( 과제 제목 )
			//--------------------------------------------
			public SubjectInfo searchbySI_No(int si_no) {
				
				SubjectInfo sj=new SubjectInfo();
				try {
					
					String sql="SELECT SI_NO,SI_TITLE,SI_GOAL_SUBJCT,SI_PUBLISHING_DATE,SI_END_DATE,SI_BUDGET,MAJ_NO"
							+ ",(SELECT MAJ_NAME FROM MAJOR_INFO M WHERE M.MAJ_NO=S.MAJ_NO) MAJ_NAME"
							+ ",PROF_NO"
							+ ",(SELECT PROF_NAME FROM PROFESSOR_INFO P WHERE P.PROF_NO=S.PROF_NO) PROF_NAME"
							+ ",SI_DETAIL,SI_PAY FROM SUBJECT_INFO S "
							+ " Where SI_NO=?";
					PreparedStatement ps =con.prepareStatement(sql);
					ps.setInt(1, si_no);
					ResultSet rs=ps.executeQuery();
					
					
					
					while(rs.next()) {
						sj.setSi_no(rs.getInt("SI_NO"));
						sj.setSi_title(rs.getString("SI_TITLE"));
						sj.setSi_goal_subject(rs.getString("SI_GOAL_SUBJCT"));
						sj.setSi_publishing_date(rs.getString("SI_PUBLISHING_DATE"));
						sj.setSi_end_date(rs.getString("SI_END_DATE"));
						sj.setSi_budget(rs.getDouble("SI_BUDGET"));
						sj.setMaj_no(rs.getInt("MAJ_NO"));
						sj.setMaj_name(rs.getString("MAJ_NAME"));
						sj.setProf_no(rs.getInt("PROF_NO"));
						sj.setProf_name(rs.getString("PROF_NAME"));
						sj.setSi_detail(rs.getString("SI_DETAIL"));
						sj.setSi_pay(rs.getDouble("SI_PAY"));
					}
					
					// System.out.println(this.getClass().getName().toString() + ":" + list.size() + " 건의 자료가 검색되었습니다.");
					rs.close();
					ps.close();
					
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println(this.getClass().getName().toString() + " 데이타 조회 실패 : " + e.getMessage());
				}
				return sj;
		}
		//--------------------------------------------
		// 과제 정보 검색 ( 과제 제목 )
		//--------------------------------------------
		public ArrayList<SubjectInfo> search(String title) {
			
			ArrayList<SubjectInfo> list = new ArrayList<SubjectInfo>();
			try {
				
				String sql="SELECT SI_NO,SI_TITLE,SI_GOAL_SUBJCT,SI_PUBLISHING_DATE,SI_END_DATE,SI_BUDGET,MAJ_NO"
						+ ",(SELECT MAJ_NAME FROM MAJOR_INFO M WHERE M.MAJ_NO=S.MAJ_NO) MAJ_NAME"
						+ ",PROF_NO"
						+ ",(SELECT PROF_NAME FROM PROFESSOR_INFO P WHERE P.PROF_NO=S.PROF_NO) PROF_NAME"
						+ ",SI_DETAIL,SI_PAY FROM SUBJECT_INFO S "
						+ " Where SI_TITLE LIKE %?%";
				PreparedStatement ps =con.prepareStatement(sql);
				ps.setString(1, title);
				ResultSet rs=ps.executeQuery();
				
				SubjectInfo sj;
				
				while(rs.next()) {
					sj=new SubjectInfo();
					sj.setSi_no(rs.getInt("SI_NO"));
					sj.setSi_title(rs.getString("SI_TITLE"));
					sj.setSi_goal_subject(rs.getString("SI_GOAL_SUBJCT"));
					sj.setSi_publishing_date(rs.getString("SI_PUBLISHING_DATE"));
					sj.setSi_end_date(rs.getString("SI_END_DATE"));
					sj.setSi_budget(rs.getDouble("SI_BUDGET"));
					sj.setMaj_no(rs.getInt("MAJ_NO"));
					sj.setMaj_name(rs.getString("MAJ_NAME"));
					sj.setProf_no(rs.getInt("PROF_NO"));
					sj.setProf_name(rs.getString("PROF_NAME"));
					sj.setSi_detail(rs.getString("SI_DETAIL"));
					sj.setSi_pay(rs.getDouble("SI_PAY"));
					list.add(sj);
				}
				
				System.out.println(this.getClass().getName().toString() + ":" + list.size() + " 건의 자료가 검색되었습니다.");
				rs.close();
				ps.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(this.getClass().getName().toString() + " 데이타 조회 실패 : " + e.getMessage());
			}
			return list;
	}
	
		//--------------------------------------------
		// 과제 정보 검색 ( 게시일 / 종료일 )
		//--------------------------------------------
		public ArrayList<SubjectInfo> search(Date sdate,Date edate) {
			
			ArrayList<SubjectInfo> list = new ArrayList<SubjectInfo>();
			try {				
				String sql="SELECT SI_NO,SI_TITLE,SI_GOAL_SUBJCT,SI_PUBLISHING_DATE,SI_END_DATE,SI_BUDGET,MAJ_NO"
						+ ",(SELECT MAJ_NAME FROM MAJOR_INFO M WHERE M.MAJ_NO=S.MAJ_NO) MAJ_NAME"
						+ ",PROF_NO"
						+ ",(SELECT PROF_NAME FROM PROFESSOR_INFO P WHERE P.PROF_NO=S.PROF_NO) PROF_NAME"
						+ ",SI_DETAIL,SI_PAY FROM SUBJECT_INFO S "
						+ " WHERE SI_PUBLISHING_DATE BETWEEN ? AND ? OR SI_END_DATE BETWEEN ? AND ? ";
				PreparedStatement ps =con.prepareStatement(sql);
				ps.setDate(1, (Date)sdate);
				ps.setDate(2, (Date)edate);
				ps.setDate(3, (Date)sdate);
				ps.setDate(4, (Date)edate);
				ResultSet rs=ps.executeQuery();
				
				SubjectInfo sj;
				
				while(rs.next()) {
					sj=new SubjectInfo();
					sj.setSi_no(rs.getInt("SI_NO"));
					sj.setSi_title(rs.getString("SI_TITLE"));
					sj.setSi_goal_subject(rs.getString("SI_GOAL_SUBJCT"));
					sj.setSi_publishing_date(rs.getString("SI_PUBLISHING_DATE"));
					sj.setSi_end_date(rs.getString("SI_END_DATE"));
					sj.setSi_budget(rs.getDouble("SI_BUDGET"));
					sj.setMaj_no(rs.getInt("MAJ_NO"));
					sj.setMaj_name(rs.getString("MAJ_NAME"));
					sj.setProf_no(rs.getInt("PROF_NO"));
					sj.setProf_name(rs.getString("PROF_NAME"));
					sj.setSi_detail(rs.getString("SI_DETAIL"));
					sj.setSi_pay(rs.getDouble("SI_PAY"));
					list.add(sj);
				}
				
				System.out.println(this.getClass().getName().toString() + ":" + list.size() + " 건의 자료가 검색되었습니다.");
				rs.close();
				ps.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(this.getClass().getName().toString() + " 데이타 조회 실패 : " + e.getMessage());
			}
			return list;
	}

	
		//--------------------------------------------
		// 과제 정보 검색 ( 학과별 )
		//--------------------------------------------
		public ArrayList<SubjectInfo> search(int majno) {
			
			ArrayList<SubjectInfo> list = new ArrayList<SubjectInfo>();
			try {
				String sql="SELECT SI_NO,SI_TITLE,SI_GOAL_SUBJCT,SI_PUBLISHING_DATE,SI_END_DATE,SI_BUDGET,MAJ_NO"
						+ ",(SELECT MAJ_NAME FROM MAJOR_INFO M WHERE M.MAJ_NO=S.MAJ_NO) MAJ_NAME"
						+ ",PROF_NO"
						+ ",(SELECT PROF_NAME FROM PROFESSOR_INFO P WHERE P.PROF_NO=S.PROF_NO) PROF_NAME"
						+ ",SI_DETAIL,SI_PAY FROM SUBJECT_INFO S "
						+ " WHERE MAJ_NO=? ";
				PreparedStatement ps =con.prepareStatement(sql);
				ps.setInt(1, majno);
				ResultSet rs=ps.executeQuery();
				
				SubjectInfo sj;
				
				while(rs.next()) {
					sj=new SubjectInfo();
					sj.setSi_no(rs.getInt("SI_NO"));
					sj.setSi_title(rs.getString("SI_TITLE"));
					sj.setSi_goal_subject(rs.getString("SI_GOAL_SUBJCT"));
					sj.setSi_publishing_date(rs.getString("SI_PUBLISHING_DATE"));
					sj.setSi_end_date(rs.getString("SI_END_DATE"));
					sj.setSi_budget(rs.getDouble("SI_BUDGET"));
					sj.setMaj_no(rs.getInt("MAJ_NO"));
					sj.setMaj_name(rs.getString("MAJ_NAME"));
					sj.setProf_no(rs.getInt("PROF_NO"));
					sj.setProf_name(rs.getString("PROF_NAME"));
					sj.setSi_detail(rs.getString("SI_DETAIL"));
					sj.setSi_pay(rs.getDouble("SI_PAY"));
					list.add(sj);
				}
				
				System.out.println(this.getClass().getName().toString() + ":" + list.size() + " 건의 자료가 검색되었습니다.");
				rs.close();
				ps.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(this.getClass().getName().toString() + " 데이타 조회 실패 : " + e.getMessage());
			}
			return list;
	}	
	
		//--------------------------------------------
		// 과제 정보 검색 ( 참여 학생 )
		//--------------------------------------------
		public ArrayList<SubjectInfo> searchbyStuNo(int stuno) {
			
			ArrayList<SubjectInfo> list = new ArrayList<SubjectInfo>();
			try {
				String sql="SELECT SI_NO,SI_TITLE,SI_GOAL_SUBJCT,SI_PUBLISHING_DATE,SI_END_DATE,SI_BUDGET,MAJ_NO"
						+ ",(SELECT MAJ_NAME FROM MAJOR_INFO M WHERE M.MAJ_NO=S.MAJ_NO) MAJ_NAME"
						+ ",PROF_NO"
						+ ",(SELECT PROF_NAME FROM PROFESSOR_INFO P WHERE P.PROF_NO=S.PROF_NO) PROF_NAME"
						+ ",SI_DETAIL,SI_PAY FROM SUBJECT_INFO S "
						+ " WHERE SI_NO IN (SELECT SI_NO FROM SUBJECTPARTICIPANT WHERE STU_NO=?) ";
				PreparedStatement ps =con.prepareStatement(sql);
				ps.setInt(1, stuno);
				ResultSet rs=ps.executeQuery();
				
				SubjectInfo sj;
				
				while(rs.next()) {
					sj=new SubjectInfo();
					sj.setSi_no(rs.getInt("SI_NO"));
					sj.setSi_title(rs.getString("SI_TITLE"));
					sj.setSi_goal_subject(rs.getString("SI_GOAL_SUBJCT"));
					sj.setSi_publishing_date(rs.getString("SI_PUBLISHING_DATE"));
					sj.setSi_end_date(rs.getString("SI_END_DATE"));
					sj.setSi_budget(rs.getDouble("SI_BUDGET"));
					sj.setMaj_no(rs.getInt("MAJ_NO"));
					sj.setMaj_name(rs.getString("MAJ_NAME"));
					sj.setProf_no(rs.getInt("PROF_NO"));
					sj.setProf_name(rs.getString("PROF_NAME"));
					sj.setSi_detail(rs.getString("SI_DETAIL"));
					sj.setSi_pay(rs.getDouble("SI_PAY"));
					list.add(sj);
				}
				
				System.out.println(this.getClass().getName().toString() + ":" + list.size() + " 건의 자료가 검색되었습니다.");
				rs.close();
				ps.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(this.getClass().getName().toString() + " 데이타 조회 실패 : " + e.getMessage());
			}
			return list;
	}	
		

		
		
		
		//--------------------------------------------
		// 과제 정보 검색 ( 교수 )
		//--------------------------------------------
		public ArrayList<SubjectInfo> searchByProf_no(int prof_no) {
			
			ArrayList<SubjectInfo> list = new ArrayList<SubjectInfo>();
			try {
				String sql="SELECT SI_NO,SI_TITLE,SI_GOAL_SUBJCT,SI_PUBLISHING_DATE,SI_END_DATE,SI_BUDGET,MAJ_NO"
						+ ",(SELECT MAJ_NAME FROM MAJOR_INFO M WHERE M.MAJ_NO=S.MAJ_NO) MAJ_NAME"
						+ ",PROF_NO"
						+ ",(SELECT PROF_NAME FROM PROFESSOR_INFO P WHERE P.PROF_NO=S.PROF_NO) PROF_NAME"
						+ ",SI_DETAIL,SI_PAY FROM SUBJECT_INFO S "
						+ " WHERE PROF_NO=? ";
				PreparedStatement ps =con.prepareStatement(sql);
				ps.setInt(1, prof_no);
				ResultSet rs=ps.executeQuery();
				
				SubjectInfo sj;
				
				while(rs.next()) {
					sj=new SubjectInfo();
					sj.setSi_no(rs.getInt("SI_NO"));
					sj.setSi_title(rs.getString("SI_TITLE"));
					sj.setSi_goal_subject(rs.getString("SI_GOAL_SUBJCT"));
					sj.setSi_publishing_date(rs.getString("SI_PUBLISHING_DATE"));
					sj.setSi_end_date(rs.getString("SI_END_DATE"));
					sj.setSi_budget(rs.getDouble("SI_BUDGET"));
					sj.setMaj_no(rs.getInt("MAJ_NO"));
					sj.setMaj_name(rs.getString("MAJ_NAME"));
					sj.setProf_no(rs.getInt("PROF_NO"));
					sj.setProf_name(rs.getString("PROF_NAME"));
					sj.setSi_detail(rs.getString("SI_DETAIL"));
					sj.setSi_pay(rs.getDouble("SI_PAY"));
					list.add(sj);
				}
				
				System.out.println(this.getClass().getName().toString() + ":" + list.size() + " 건의 자료가 검색되었습니다.");
				rs.close();
				ps.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(this.getClass().getName().toString() + " 데이타 조회 실패 : " + e.getMessage());
			}
			return list;
	}	
		//--------------------------------------------
		// 과제 별 참여 학생정보 조회
		//--------------------------------------------
		public ArrayList searchStudentBySubJectNo(int Subject_no) {
			
			ArrayList list = new ArrayList();
			try {
				String sql="SELECT SI_NO,STU_NO,(SELECT STU_NAME FROM STUDENT_INFO T WHERE T.STU_NO=S.STU_NO) STU_NAME FROM SUBJECTPARTICIPANT S WHERE S.SI_NO=?";
				PreparedStatement ps =con.prepareStatement(sql);
				ps.setInt(1, Subject_no);
				ResultSet rs=ps.executeQuery();
						
				while(rs.next()) {
					ArrayList stu = new ArrayList();
					
					stu.add(rs.getInt("SI_NO"));
					stu.add(rs.getString("STU_NO"));
					stu.add(rs.getString("STU_NAME"));
					
					list.add(stu);
				}
				
				System.out.println(this.getClass().getName().toString() + ":" + list.size() + " 건의 자료가 검색되었습니다.");
				rs.close();
				ps.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(this.getClass().getName().toString() + " 데이타 조회 실패 : " + e.getMessage());
			}
			return list;
	}	
		
		//--------------------------------------------
		// 과제 별 참여 학생추가
		//--------------------------------------------
		public void registStudentBySubJectNo(int subject_no,int student_no) {
		
			int count;
			try {
				
				
				String sql="INSERT INTO SUBJECTPARTICIPANT(SP_NO,SI_NO,STU_NO,SP_JOIN_DATE)"
						+" VALUES(SUBJECTPARTICIPANT_SQ.NEXTVAL,?,?,sysdate) ";
				PreparedStatement ps =con.prepareStatement(sql);
				ps.setInt(1, subject_no);
				ps.setInt(2, student_no);
				count=ps.executeUpdate();
				ps.close();
				
				System.out.println(this.getClass().getName().toString() + ":" + count + " 건의 자료가 등록되었습니다.");
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(this.getClass().getName().toString() + " 데이타 등록 실패 : " + e.getMessage());
			}
	}	
		
		//--------------------------------------------
		// 과제 별 참여 학생 중단
		//--------------------------------------------
		public void removeStudentBySubJectNo(int subject_no,int student_no) {
		
			int count;
			try {
				
				
				String sql="delete SUBJECTPARTICIPANT where si_no=? and stu_no=?";
				PreparedStatement ps =con.prepareStatement(sql);
				ps.setInt(1, subject_no);
				ps.setInt(2, student_no);
				count=ps.executeUpdate();
				ps.close();
				
				System.out.println(this.getClass().getName().toString() + ":" + count + " 건의 자료가 삭제되었습니다.");
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(this.getClass().getName().toString() + " 데이타 삭제 실패 : " + e.getMessage());
			}
	}	
		
		//--------------------------------------------
		// 학생정보 조회
		//--------------------------------------------
		public ArrayList searchStudentByname(String stu_name) {
			
			ArrayList list = new ArrayList();
			try {
				
				String sql="SELECT STU_NO,STU_NAME FROM STUDENT_INFO ";
				if (stu_name != "") {
					sql=sql +  " WHERE STU_NAME LIKE '%" + stu_name + "%'";
				}
				PreparedStatement ps =con.prepareStatement(sql);
				//ps.setString(1, stu_name);
				ResultSet rs=ps.executeQuery();
						
				while(rs.next()) {
					ArrayList stu = new ArrayList();
					
//					stu.add(rs.getInt("SI_NO"));
					stu.add(rs.getString("STU_NO"));
					stu.add(rs.getString("STU_NAME"));
					list.add(stu);
				}
				
				System.out.println(this.getClass().getName().toString() + ":" + list.size() + " 건의 자료가 검색되었습니다.");
				rs.close();
				ps.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(this.getClass().getName().toString() + " 데이타 조회 실패 : " + e.getMessage());
			}
			return list;
	}	
		//--------------------------------------------
		// 학과별 교수 정보 가져오기 ( ListBox 용도)
		// 인수 : 학과 정보 INT
		//--------------------------------------------
		public ArrayList SelectProfessor_info(int maj_no) {
			ArrayList list= new ArrayList();
//			String data[]=null;
			try {
				
				String sql="SELECT PROF_NO,PROF_NAME FROM PROFESSOR_INFO";
				if (maj_no > 0) {
					sql=sql + "Where maj_no=" + maj_no;
				}
				System.out.println(sql);
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
//				data = new String[rs.getRow()];
				while (rs.next()){
//					int i=0;
					ArrayList tmp=new ArrayList();
					int prof_no=rs.getInt("PROF_NO");
					String prof_name=rs.getString("PROF_NAME");
					String prof_info=prof_no + "-" + prof_name;
//					data[i]=prof_info;
//					i++;
					tmp.add( prof_info);

					list.add(tmp);
					
				}
				rs.close();
				ps.close();
				//System.out.println(this.getClass().getName().toString() + ":" + list.size() + " 건의 자료가 검색되었습니다.");
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(this.getClass().getName().toString() + " 데이타 조회 실패 : " + e.getMessage());
			}
//			return data;
			return list;
		}
		//--------------------------------------------
		// 학과 정보 가져오기 ( ListBox 용도)
		// 인수 : None
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
//					tmp.add(maj_no + "-" + maj);
					tmp.add(maj_info);
					
					list.add(tmp);
				}
				rs.close();
				ps.close();
				//System.out.println(this.getClass().getName().toString() + ":" + list.size() + " 건의 자료가 검색되었습니다.");
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(this.getClass().getName().toString() + " 데이타 조회 실패 : " + e.getMessage());
			}
			return list;
		}
		
		
		
}
