package javara.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import javara.model.rec.SubjectInfo;
import javara.model.rec.Coop;
import javara.model.rec.coopinfo;

public class coopinfoModel implements InterfaceCommonModel, DBConnetor {

	

		private Connection con;

		@Override
		public void connectDB() {
			// TODO Auto-generated method stub
			try {
				Class.forName(DRIVER);
				con=DriverManager.getConnection(JDBC_URL,DB_ID,DB_PW);
				System.out.println("과제제출보고서 데이타베이스에 연결되었습니다.");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("과제제출보고서 데이타베이스에 연결 실패했습니다.");
			}
		}
		
		public coopinfoModel() {
			// TODO Auto-generated constructor stub
			
			connectDB();
			
		}
		
		
		// -------------------------------
		// 과제 제출 보고서 정보 ( * )
		// -------------------------------

		@Override
		public void modify(Object obj) {
			// TODO Auto-generated method stub
			try {

				int numOfAffected;
				coopinfo cm = new coopinfo();
				cm = (coopinfo) obj;
				String sql = "UPDATE SUBJECT_INFO SET SI_NO = ?," + " CO_NO = ?," + " CI_SDATE = ?," + " C_EDATE = ? "
						+ " WHERE CI_NO = ?";
				PreparedStatement st = con.prepareStatement(sql);

				st.setInt(1, cm.getSi_no());
				st.setInt(2, cm.getCo_no());
				st.setDate(3, (Date) cm.getC_edate());
				st.setDate(4, (Date) cm.getCi_sdate());
				st.setInt(5, cm.getCi_no());
				numOfAffected = st.executeUpdate();

				st.close();

				if (numOfAffected == 0) {
					throw new Exception(this.getClass().getName() + "데이터 수정 실패");
				} else {
					throw new Exception(this.getClass().getName() + "데이터 수정 성공 : " + numOfAffected);
				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(this.getClass().getName() + "데이터 수정 실패 : " + e.getMessage());
			}
		}

		// -------------------------------------
		// 협력 기관 고유 추가
		// -------------------------------------

		@Override
		public void regist(Object obj) {
			// TODO Auto-generated method stub
			try {
				int numOfAffected;

					coopinfo ci = new coopinfo();
					ci = (coopinfo) obj;
					String sql = "INSERT INTO SUBJECT_INFO(CI_NO, SI_NO, CO_NO, CI_SDATE,C_EDATE) VALUES(?,?,?,?,?)";
	
					PreparedStatement st = con.prepareStatement(sql);
					st.setInt(1, ci.getCi_no());
					st.setInt(2, ci.getSi_no());
					st.setInt(3, ci.getCo_no());
					st.setDate(4, (Date) ci.getCi_sdate());
					st.setDate(5, (Date) ci.getC_edate());
					numOfAffected = st.executeUpdate();
				if (numOfAffected == 0) {
					throw new Exception(this.getClass().getName() + "데이타 추가 실패 : ");
				} else {
					System.out.println(this.getClass().getName() + "데이타 추가 성공 : " + numOfAffected);
				}
				st.close();
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		// -------------------------------
		// 과제 제출 보고서 검색( * )
		// -------------------------------

		public ArrayList<SubjectInfo> search1(String name) {

			String sql = "select * from Coporation where co_no = ?";
			ArrayList list = new ArrayList();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, name);
				ResultSet rs = ps.executeQuery();
				coopinfo ci = null;
				while (rs.next()) {
					ci = new coopinfo();
					ci.setCi_no(ci.getCi_no());
					ci.setSi_no(ci.getSi_no());
					ci.setCo_no(ci.getCo_no());
					ci.setCi_sdate(ci.getCi_sdate());
					ci.setC_edate(ci.getC_edate());
					list.add(ci);
				}

				rs.close();
				ps.close();
			} catch (Exception e) {
				// TODO: handle exception
			}

			return list;
		}



		public ArrayList<SubjectInfo> search(String name) {

			String sql = "select * from Coporation where co_no = ?";
			ArrayList list = new ArrayList();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, name);
				ResultSet rs = ps.executeQuery();
				coopinfo ci = null;
				while (rs.next()) {
					ci = new coopinfo();
					ci.setCi_no(ci.getCi_no());
					ci.setSi_no(ci.getSi_no());
					ci.setCo_no(ci.getCo_no());
					ci.setCi_sdate(ci.getCi_sdate());
					ci.setC_edate(ci.getC_edate());
					list.add(ci);
				}

				rs.close();
				ps.close();
			} catch (Exception e) {
				// TODO: handle exception
			}

			return list;
		}

		@Override
		public ArrayList search() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		
		
		
		
		
	
	
	
	
	
	
	public void registcm(int sino1, int cono1, String csd1,
			String ced1) {
		// TODO Auto-generated method stub
			
		try {
			
			int numOfAffected;
	
			String sql="insert into coopinfo(ci_no, si_no, co_no, ci_sdate, c_edate) values(coopinfo_sq.nextval,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			System.out.println("삽입 쿼리 실행 : " + sql);
			
			//ps.setInt(1,t_no2);
			ps.setInt(1,sino1);
			ps.setInt(2, cono1);
			ps.setString(3, csd1);
			ps.setString(4, ced1);
			
			
			numOfAffected = ps.executeUpdate();
			ps.close();
			
			
			if(numOfAffected == 0) {
			throw new Exception(this.getClass().getName() + " 데이타 추가 실패 : ");
			}else {
				System.out.println(this.getClass().getName() + " 데이타 추가 성공 : " + numOfAffected);
			}
			
			
			}catch(Exception e) {
				System.out.println(this.getClass().getName() + " 데이터 추가 실패 : " + e.getMessage());
			}
			
			
			
	}
	
	public void coopInfoModelDel(int f) {

		try {

			String sql = "Delete from coopinfo where CI_NO=?";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("실행이 되었습니다" + sql);

			ps.setInt(1, f);
			ps.executeUpdate();

			ps.close();
			
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println("실행 실패!!!!!");
		}
	}
	
	
	
	
	

}
