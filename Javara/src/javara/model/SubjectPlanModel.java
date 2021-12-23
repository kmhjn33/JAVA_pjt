package javara.model;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javara.model.rec.SubjectPlan;
import javara.model.rec.SubjectReports;

public class SubjectPlanModel implements InterfaceCommonModel, DBConnetor {
	
	private Connection con;

	
	public SubjectPlanModel() {
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
			System.out.println( this.getClass().getName() + "DB 연결 생성 실패 : " + e.getMessage());
		}
	}
		
	@Override
	public void modify(Object obj) {
		// TODO Auto-generated method stub
		try {
			int numOfAffected;
			SubjectPlan sp = new SubjectPlan();
			sp=(SubjectPlan)obj;
			String sql="UPDATE SUBJECT_PLAN SET SP_ACCOUNT=?"
					+ ", SP_ACC_DETAIL=?"
					+ ", SP_ITEM=?"
					+ ", SP_AMOUNT=?"
					+ ", PURPOSEOFUSE=?"
					+ " WHERE SP_NO=? " ;
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, sp.getSp_Account());
			st.setString(2, sp.getSp_Acc_Detail());
			st.setString(3, sp.getSp_Acc_Item());
			st.setDouble(4, sp.getSp_Amount());
			st.setString(5,sp.getPurposeofUse());
			st.setInt(6, sp.getSp_No());
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

	
	public void delete(int plan_no) {
		// TODO Auto-generated method stub
		try {
			int numOfAffected;
			SubjectPlan sp = new SubjectPlan();
			
			String sql="delete SUBJECT_PLAN WHERE SP_NO=? " ;
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, plan_no);
			numOfAffected=st.executeUpdate();
			
			st.close();
			
			if(numOfAffected == 0) {
				throw new Exception(this.getClass().getName() + " 데이터 삭제 실패 : ");
			}else {
				throw new Exception(this.getClass().getName() + " 데이터 삭제 성공 : " + numOfAffected);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.getClass().getName() + " 데이터 삭제 실패 : " + e.getMessage());
		}
	}
	@Override
	public void regist(Object obj) {
		// TODO Auto-generated method stub
		try {
			int numOfAffected;
			
			SubjectPlan sp = new SubjectPlan();
			sp=(SubjectPlan)obj;

			String sql="INSERT INTO SUBJECT_PLAN( SP_NO,SP_ACCOUNT,SP_ACC_DETAIL,SP_ITEM,SP_AMOUNT,PURPOSEOFUSE,SI_NO)"
					+ " VALUES (SUBJECT_PLAN_SQ.NEXTVAL,?,?,?,?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			
			st.setString(1, sp.getSp_Account());
			st.setString(2, sp.getSp_Acc_Detail());
			st.setString(3, sp.getSp_Acc_Item());
			st.setDouble(4, sp.getSp_Amount());
			st.setString(5,sp.getPurposeofUse());
			st.setInt(6, sp.getSi_No());
			
			numOfAffected=st.executeUpdate();
			
//			sp.setSp_No(rs.getInt("SP_NO"));
//			sp.setSp_Account(rs.getString("SP_ACCOUNT"));
//			sp.setSp_Acc_Detail(rs.getString("SP_ACC_DETAIL"));
//			sp.setSp_Acc_Item(rs.getString("SP_ITEM"));
//			sp.setSp_Amount(rs.getDouble("SP_AMOUNT"));
//			sp.setPurposeofUse(rs.getString("PURPOSEOFUSE"));
//			sp.setSi_No(rs.getInt("SI_NO"));
			
			if(numOfAffected == 0) {
				throw new Exception(this.getClass().getName() + " 데이타 추가 실패 : ");
			}else {
				System.out.println(this.getClass().getName() + " 데이타 추가 성공 : " + numOfAffected);
			}
			st.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.getClass().getName() + " 데이타 추가 실패 : " + e.getMessage());
		}
	}
	@Override
	public ArrayList search() {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		try {
			String sql="SELECT SP_NO,SP_ACCOUNT,SP_ACC_DETAIL,SP_ITEM,SP_AMOUNT,PURPOSEOFUSE,SI_NO"
					+ " FROM SUBJECT_PLAN";
			PreparedStatement ps =con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			SubjectPlan sp;
			while(rs.next()) {
				sp = new SubjectPlan();
				sp.setSp_No(rs.getInt("SP_NO"));
				sp.setSp_Account(rs.getString("SP_ACCOUNT"));
				sp.setSp_Acc_Detail(rs.getString("SP_ACC_DETAIL"));
				sp.setSp_Acc_Item(rs.getString("SP_ITEM"));
				sp.setSp_Amount(rs.getDouble("SP_AMOUNT"));
				sp.setPurposeofUse(rs.getString("PURPOSEOFUSE"));
				sp.setSi_No(rs.getInt("SI_NO"));
				list.add(sp);
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
	// 예산 상세 정보 가져오기
	//--------------------------------------------
	public SubjectPlan searchbyPlanNo(int plan_no) {
		// TODO Auto-generated method stub
		SubjectPlan sp = new SubjectPlan();
		try {
			String sql="SELECT SP_NO,SP_ACCOUNT,SP_ACC_DETAIL,SP_ITEM,SP_AMOUNT,PURPOSEOFUSE,SI_NO"
					+ " FROM SUBJECT_PLAN Where SP_NO=?";
					
			PreparedStatement ps =con.prepareStatement(sql );
			ps.setInt(1, plan_no);
			ResultSet rs=ps.executeQuery();
			System.out.println(sql + plan_no);
			while(rs.next()) {
				sp.setSp_No(rs.getInt("SP_NO"));
				sp.setSp_Account(rs.getString("SP_ACCOUNT"));
				sp.setSp_Acc_Detail(rs.getString("SP_ACC_DETAIL"));
				sp.setSp_Acc_Item(rs.getString("SP_ITEM"));
				sp.setSp_Amount(rs.getDouble("SP_AMOUNT"));
				sp.setPurposeofUse(rs.getString("PURPOSEOFUSE"));
				sp.setSi_No(rs.getInt("SI_NO"));
			}
			
			rs.close();
			ps.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.getClass().getName().toString() + " 데이타 조회 실패 : " + e.getMessage());
		}
		return sp;
	}
	//--------------------------------------------
	// 과제정보 별 예산 목록 리스트 가져오기
	//--------------------------------------------
	public ArrayList search(int subject_no) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		try {
			String sql="SELECT SP_NO,SP_ACCOUNT,SP_ACC_DETAIL,SP_ITEM,SP_AMOUNT,PURPOSEOFUSE,SI_NO"
					+ " FROM SUBJECT_PLAN";
			if(subject_no >0) {
				sql=sql + " Where SI_NO=" + subject_no;
			}			
			
			PreparedStatement ps =con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				ArrayList sp = new ArrayList();
				sp.add(rs.getInt("SP_NO"));
				sp.add(rs.getString("SP_ACCOUNT"));
				sp.add(rs.getString("SP_ACC_DETAIL"));
				sp.add(rs.getString("SP_ITEM"));
				sp.add(rs.getDouble("SP_AMOUNT"));
				sp.add(rs.getString("PURPOSEOFUSE"));
				sp.add(rs.getInt("SI_NO"));
				list.add(sp);
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
	// 과제정보 목록 가져오기
	//--------------------------------------------
	public ArrayList searchSubjectInfobyMajorNo(int major_no) {
		
		ArrayList list = new ArrayList();
		try {
			String sql="SELECT SI_NO,SI_TITLE FROM SUBJECT_INFO";
			if(major_no >0) {
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
				list.add(itemString);
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
//				tmp.add(maj_no + "-" + maj);
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
