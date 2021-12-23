package javara.model;

import java.awt.List;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sound.sampled.Line;
import javax.swing.JOptionPane;

import javara.model.rec.Coop;


public class CoopModel implements InterfaceCommonModel, DBConnetor {

	private Connection conn;
	private String name;
	private Object tablecoop;
	
	public CoopModel () {
		connectDB();
	}

	@Override
	public void connectDB() {
		try {

			Class.forName(DRIVER);
			conn=DriverManager.getConnection(JDBC_URL,DB_ID,DB_PW);
			System.out.println("협력기관 데이타 베이스에 연결되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("협력기관 데이타 베이스에 연결 실패");
		}
	}
		//--------------------------------------------
		// 협력 기관 정보 ( * )
		//--------------------------------------------	
		

		@Override
		public void modify(Object obj) {
			// TODO Auto-generated method stub
			try {
				
				int numOfAffected;
					Coop c = new Coop();
					String sql = "UPDATE SUBJECT_INFO SET CO_NO = ?,"
							+ " CO_NAME = ?,"
							+ " CO_TEL = ?";
					PreparedStatement st = conn.prepareStatement(sql);
					
					st.setInt(1, c.getco_no());
					st.setString(2, c.getCo_name());
					st.setString(3, c.getCo_tel());
					numOfAffected = st.executeUpdate();
					
					st.close();
				
			if(numOfAffected == 0) {
				throw new Exception(this.getClass().getName() + "데이터 수정 실패 : ");
			}else {
				throw new Exception(this.getClass().getName() + "데이터 수정 성공 : " + numOfAffected);
			}
			
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(this.getClass().getName() + "데이터 수정 실패 : " + e.getMessage());
			}
			
			//--------------------------------------------
			// 과제 정보 추가 ( * )
			//--------------------------------------------
			
			
		}

		@Override
		public void regist(Object obj) {
			// TODO Auto-generated method stub
			
			try {
			
				Coop c = new Coop();
				c = (Coop)obj;
				String sql= "INSERT INTO COOP(CO_NO, CO_NAME, CO_TEL, CO_DETAIL) VALUES (COOP_SQ.NEXTVAL, ?,?,?)";
				
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, c.getCo_name());
				st.setString(2, c.getCo_tel());
				st.setString(3, c.getCo_detail());
				st.executeUpdate();
				

					st.close();
			}catch (Exception e) {
				System.out.println("regist 오류 " + e.getMessage());
				// TODO: handle exception
			}
		
			//--------------------------------------------
			// 과제 정보 검색 ( * )
			//--------------------------------------------
		
		}

		@Override
		public ArrayList search() {
			// TODO Auto-generated method stub
			ArrayList list = new ArrayList();
			return list;
		}
		
		public ArrayList searchCoop(String sh, int sx) {
			// TODO Auto-generated method stub
			String[] sel = {"co_name", "co_tel"};
			ArrayList list = new ArrayList();
			
			String sql = "select * from Coop where " + sel[sx] + " like '%" + sh + "%'";
			
			try {
				Statement ps = conn.createStatement();
				ResultSet rs = ps.executeQuery(sql);

				while (rs.next()) {
					ArrayList cop = new ArrayList();
					cop.add(rs.getInt("CO_No"));
					cop.add(rs.getString("CO_Name"));
					cop.add(rs.getString("CO_Tel"));
					cop.add(rs.getString("CO_DETAIL"));

					list.add(cop);
				}

				rs.close();
				ps.close();
			} catch (Exception e) {
				System.out.println("검색 오류 " + e.getMessage());
			}

			return list;
		}
		
		
		
		public ArrayList searchAll() {
			// TODO Auto-generated method stub
			
			String sql = "select * from Coop";
			ArrayList list = new ArrayList();
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					ArrayList cop = new ArrayList();
					cop.add(rs.getString("CO_No"));
					cop.add(rs.getString("CO_Name"));
					cop.add(rs.getString("CO_Tel"));
					cop.add(rs.getString("CO_detail"));

					list.add(cop);
				}

				rs.close();
				stmt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}

			return list;
		}
		
		
		
		//과제협력기관 관련 표 표현
		public ArrayList searchAll1() {
			// TODO Auto-generated method stub
			
			String sql = "select * from coopinfo";
			ArrayList list = new ArrayList();
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					ArrayList cop = new ArrayList();
					cop.add(rs.getString("CI_NO"));
					cop.add(rs.getString("SI_NO"));
					cop.add(rs.getString("CO_NO"));
					cop.add(rs.getString("CI_SDATE"));
					cop.add(rs.getString("C_EDATE"));
					list.add(cop);
				}

				rs.close();
				stmt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}

			return list;
		}
		
		
		//과제정보 검색
		
//		public void jfsi(String ti) {
//
//			try {
//
//				String sql = "select si_no from subject_info = where si_title = ? ";
//				
//				System.out.println("실행 성공" + sql);
//				Statement stmt = conn.createStatement();
//				ResultSet rs = stmt.executeQuery(sql);
//				rs.close();
//				stmt.close();
//
//
//				
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				System.out.println("실행 실패!!!!!");
//			}
//			
//
//		}
//		
		
		public ArrayList searchByTitle(String title) {
			// TODO Auto-generated method stub
			ArrayList list = new ArrayList();
			
			try {
				String sql = "select si_no, si_title from subject_info where instr(si_title,?)>0";
						
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, title);
				
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					ArrayList subject_info = new ArrayList();					
					subject_info.add(rs.getInt("si_no"));
					subject_info.add(rs.getString("si_title"));
					//subject_info.add(rs.getString("si_title"));
					list.add(subject_info);
				}
				
				System.out.println(this.getClass().getName().toString() + ":" + list.size() + " 건의 자료가 검색되었습니다.");

				rs.close();
				ps.close();
				

				
			
			}catch(Exception e) {
				System.out.println(this.getClass().getName().toString() + " 데이타 조회 실패 : " + e.getMessage());
			}
			return list;

		}
		
		
		
//		
//		public ArrayList searchallsitest() {
//			// TODO Auto-generated method stub
//			ArrayList list = new ArrayList();
//			
//			try {
//				String sql = "select * from subject_info";
//						
//				Statement stmt = conn.createStatement();
//				ps.setString(1, title);
//				
//				
//				ResultSet rs = ps.executeQuery();
//				while(rs.next()) {
//					ArrayList subject_info = new ArrayList();					
//					subject_info.add(rs.getInt("si_no"));
//					subject_info.add(rs.getString("si_title"));
//					//subject_info.add(rs.getString("si_title"));
//					list.add(subject_info);
//				}
//				
//				System.out.println(this.getClass().getName().toString() + ":" + list.size() + " 건의 자료가 검색되었습니다.");
//
//				rs.close();
//				ps.close();
//				
//
//				
//			
//			}catch(Exception e) {
//				System.out.println(this.getClass().getName().toString() + " 데이타 조회 실패 : " + e.getMessage());
//			}
//			return list;
//
//		}
		
		
		
		public ArrayList searchallsi() {
			// TODO Auto-generated method stub
			
			String sql = "select si_no, si_title from subject_info";
			ArrayList list = new ArrayList();
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					ArrayList cop = new ArrayList();
					cop.add(rs.getInt("SI_NO"));
					cop.add(rs.getString("SI_TITLE"));
					
					list.add(cop);
				}

				rs.close();
				stmt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}

			return list;
		}
		
		
		
		
		
		
		

		public void jfTel(int Tl, String Te) {

			try {

				String sql = "update Coop set CO_TEl=? where CO_NO=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				System.out.println("실행 성공" + sql);

				ps.setInt(2, Tl);
				ps.setString(1, Te);
				ps.executeUpdate();

				ps.close();

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("실행 실패!!!!!");
			}

		}

		
		
		public void jfDel(int f) {

			try {

				String sql = "Delete from Coop where CO_NO=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				System.out.println("실행이 되었습니다" + sql);

				ps.setInt(1, f);
				ps.executeUpdate();

				ps.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("실행 실패!!!!!");
			}
		}
		
		public void name() {
			
			
			
		}
		
		
		
		
		
		
//		public void ArrayList (Object obj) {
//			ArrayList data = new ArrayList();
//			Coop c = new Coop();
//			c = (Coop)obj;
//			String sql= "UPDATE Coop SET NAME= ?, PRICE = ? WHERE CODE =?";
//			Connection con = null;

//			try {
//			
//					
//				ArrayList con = new ArrayList();
//				con.add(rs.getString("CO_No"));
//				con.add(rs.getString("CO_Name"));
//				con.add(rs.getString("CO_Tel"));
//				con.add(rs.getString("CO_detail"));
//
//				list.add(con);
//			
//				
//				textName.setText(name);
//				
//				textTel.setText(tel);
//				
//				textDetail.setText(detail);
//				
//				String name = textName.getText(name);
//				String tel = textTel.getText(tel);
//				String detail = textDetail.getText();
//				
//				
//			
//				
//				
//				
//			}catch (Exception e1) {
//				// TODO: handle exception
//				JOptionPane.showMessageDialog(null, "협력기관 정보 검색 실패" + e1.getMessage());
//			
//				
//				
//			}
			
//		}
}

