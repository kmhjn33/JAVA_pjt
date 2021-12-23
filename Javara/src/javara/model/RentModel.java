package javara.model;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javara.model.rec.Rent;

public class RentModel implements InterfaceCommonModel, DBConnetor {
	
	private Connection  con;
	
	public RentModel() {
		try {
			connectDB();
			System.out.println("Rent DB ���� ����");
		} catch (Exception e) {
			System.out.println("Rent DB ���� ����");
		}
	}

	@Override
	public void connectDB() {
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(JDBC_URL,DB_ID,DB_PW);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	//----------------�뿩------------------------
	@Override
	public void regist(Object obj) {

		try {
			Rent rent = (Rent)obj;
			
			String sql = "insert into rent(rent_no, rent_date, return_schedule, return_flag, return_date, t_no, stu_no) " + 
						 "values (rent_sq.nextval , sysdate, ?, 'N', null, ?, ?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, rent.getReturnSchedule());
			ps.setInt(2, rent.gettNo());
			ps.setInt(3, rent.getStuNo());
			
			ps.executeUpdate();
			
			ps.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "�뿩�� �� �����ϴ�.");
			System.out.println("model" + e.getMessage());
		}
		
	}
	
	//---------------- �뿩 ���� ���� Ȯ��--------------------
	public boolean isRentPossible(int tNo) {	
		boolean result = false;
		
		try {
			String sql = "select rent_no from rent where return_flag = 'N' and t_no = " + tNo;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				rs.close();
				stmt.close();
				result = false;
			} else {
				rs.close();
				stmt.close();
				result = true;
			}
		} catch (Exception e) {
			System.out.println("�뿩 ���� ���� Ȯ�� ���� (model) " + e.getMessage());
		}
		
		return result;
	}
	
	
	//---------------�ݳ�------------------------------
	@Override
	public void modify(Object obj) {
		
		try {
			Rent rent = (Rent)obj;
			
			String sql = "update rent set return_Flag = 'Y', return_date = sysdate where rent_no = ?"; 
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, rent.getRentNo());
			ps.execute();
			
			ps.close();
		} catch (Exception e) {
			System.out.println("�ݳ� ó�� ����(model) " + e.getMessage());
		}
	}
	
	
	//-----------��ü �뿩 ���� ��ȸ---------------
	@Override
	public ArrayList search() {
		
		ArrayList list = new ArrayList();
		
		try { 
			String sql = "select r.rent_no, r.rent_date, r.return_schedule, r.return_flag, r.return_date, t.t_no, t.t_name, s.stu_no, s.stu_name from "
						 + "rent r, student_info s, tool t where r.t_no = t.t_no and r.stu_no = s.stu_no "
						 + "order by r.rent_no desc";
	
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	
	
	        while (rs.next()) {
	        	ArrayList temp = new ArrayList();
	        	temp.add(rs.getString("rent_no"));			// �뿩 ��ȣ
	        	temp.add(rs.getString("rent_date"));		// �뿩��
	        	temp.add(rs.getString("t_no"));				// ������ ��ȣ
	        	temp.add(rs.getString("t_name")); 			// ������ �̸�
	        	temp.add(rs.getString("stu_no"));			// �й�
	        	temp.add(rs.getString("stu_name"));			// �л� �̸�
	        	temp.add(rs.getString("return_schedule"));	// �ݳ� ������
	        	temp.add(rs.getString("return_flag"));		// �ݳ� ����
	        	temp.add(rs.getString("return_date"));		// �ݳ���
	        	list.add(temp);
	        }
	        rs.close();
	        stmt.close();
	
		} catch (Exception e) {
			System.out.println("search method" + e.getMessage());
		}

		return list;
		
	}
	
	//------------�뿩 ��ȣ�� ��ȸ (�ݳ� ��� �߰���)--------------
	public Object searchRentNo(int rNo) {
		String sql = "select r.rent_no, t.t_name, r.rent_date, r.return_schedule " +
					 "from rent r, tool t where r.t_no = t.t_no and r.rent_no = " + rNo + 
					 " and r.return_flag = 'N'";
		ArrayList list = new ArrayList();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
	        	list.add(rs.getString("rent_no"));			// �뿩 ��ȣ
	        	list.add(rs.getString("t_name")); 			// ������ �̸�
	        	list.add(rs.getString("rent_date"));		// �뿩��
	        	list.add(rs.getString("return_schedule"));	// �ݳ� ������
	        	
				rs.close();
				stmt.close();
	        	
				return (Object)list;
			}
			
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("�뿩 ��ȣ ��ȸ ����" + e.getMessage());
		}
		
		return null;
	}
	
		
	//------------�׸� �˻�------------------
		public ArrayList searchByCol(int cmbSel, String searchT) {
			String[] selCol = {"r.rent_no = " + searchT, 
								"t.t_no = " + searchT, 
								"t.t_name like '%" + searchT + "%'", 
								"s.stu_no = " + searchT, 
								"s.stu_name like '%" + searchT +"%'"};
			ArrayList list = new ArrayList();
			
			String sql = "select r.rent_no, r.rent_date, r.return_schedule, r.return_flag, r.return_date, t.t_no, t.t_name, s.stu_no, s.stu_name "
					+ "from rent r, student_info s, tool t "
					+ "where r.t_no = t.t_no and r.stu_no = s.stu_no "
					+ "and " + selCol[cmbSel]
					+ " order by r.rent_no desc";
			
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
		        	ArrayList temp = new ArrayList();
		        	temp.add(rs.getString("rent_no"));			// �뿩 ��ȣ
		        	temp.add(rs.getString("rent_date"));		// �뿩��
		        	temp.add(rs.getString("t_no"));				// ������ ��ȣ
		        	temp.add(rs.getString("t_name")); 			// ������ �̸�
		        	temp.add(rs.getString("stu_no"));			// �й�
		        	temp.add(rs.getString("stu_name"));			// �л� �̸�
		        	temp.add(rs.getString("return_schedule"));	// �ݳ� ������
		        	temp.add(rs.getString("return_flag"));		// �ݳ� ����
		        	temp.add(rs.getString("return_date"));		// �ݳ���
		        	list.add(temp);
				}
				
				rs.close();
				stmt.close();
			} catch (Exception e) {
				System.out.println("�׸� �˻� ���� :" + e.getMessage());
			}

			return list;
			
		}
	
	//------------��¥�� �˻�------------------
	public ArrayList searchByDate(int cmbSel, String dateSel) {
		String[] selCol = {"rent_date", "return_schedule", "return_date"};
		ArrayList list = new ArrayList();
		
		String sql = "select r.rent_no, r.rent_date, r.return_schedule, r.return_flag, r.return_date, t.t_no, t.t_name, s.stu_no, s.stu_name "
				+ "from rent r, student_info s, tool t "
				+ "where r.t_no = t.t_no and r.stu_no = s.stu_no "
				+ "and to_char(" + selCol[cmbSel] + ", 'yy/MM/dd') = '" + dateSel 
				+ "' order by r.rent_no desc";
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
	        	ArrayList temp = new ArrayList();
	        	temp.add(rs.getString("rent_no"));			// �뿩 ��ȣ
	        	temp.add(rs.getString("rent_date"));		// �뿩��
	        	temp.add(rs.getString("t_no"));				// ������ ��ȣ
	        	temp.add(rs.getString("t_name")); 			// ������ �̸�
	        	temp.add(rs.getString("stu_no"));			// �й�
	        	temp.add(rs.getString("stu_name"));			// �л� �̸�
	        	temp.add(rs.getString("return_schedule"));	// �ݳ� ������
	        	temp.add(rs.getString("return_flag"));		// �ݳ� ����
	        	temp.add(rs.getString("return_date"));		// �ݳ���
	        	list.add(temp);
			}
			
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println("��¥�� �˻� ���� :" + e.getMessage());
		}

		return list;
		
	}
	
	
	//#################################################

	public ArrayList toolSearch() {		// ������ ����Ʈ�� ���� ������ ������ ����
		ArrayList list = new ArrayList();
		
		try {
			String sql = "select t_no, t_name from tool where t_limit_date > sysdate order by t_no";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				ArrayList temp = new ArrayList();
				temp.add(rs.getInt("t_no"));
				temp.add(rs.getString("t_name"));
				list.add(temp);
			}
			rs.close();
			stmt.close();
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
		
	
	public ArrayList searchToolByName(String tName) {	// ������ ������ ������ ã�� (����Ʈ��)

		ArrayList list = new ArrayList();
		String sql = "select t_no, t_name from tool where t_name like '%" + tName + "%' and t_limit_date > sysdate order by t_no";
				
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				ArrayList temp = new ArrayList();
				temp.add(rs.getString("t_no"));
				temp.add(rs.getString("t_name"));
				list.add(temp);
			}
			
			rs.close();
			stmt.close();
			
		} catch (Exception e) {
			System.out.println("tool name �˻� ����" + e.getMessage());
		}
		
		return list;
	}
	
	
	public String searchToolByNo(int tNo) {	// ������ ��ȣ�� ������ �̸� ��ȯ

		String name = " (������ ���� ����) ";
		String sql = "select t_name from tool where t_no = " + tNo;
				
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				name = rs.getString("t_name");
			}
			
			rs.close();
			stmt.close();
			
		} catch (Exception e) {
			System.out.println("tool no �˻� ����" + e.getMessage());
		}
		
		return name;
	}	
		
	//#################################################

}
