
package javara.model;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JTextField;

import javara.model.rec.Tool;
import javara.view.ToolView;

public class ToolModel implements InterfaceCommonModel, DBConnetor {
	
	private Connection con;
	
	public ToolModel() {
		try {
			connectDB();
			System.out.println("Tool DB ���� ����");
		} catch (Exception e) {
			System.out.println("Tool DB ���� ����");
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

	
	//--------------------------------------------
	// ������ ���� �߰� ( * )
	//--------------------------------------------
	
	//���� �޼ҵ�� �̿����� ���� ����
	@Override
	public void regist(Object obj) {
		// TODO Auto-generated method stub
		try {
			
			int numOfAffected;
			
			int t_no = ((Tool) obj).getT_no();
			int cate_no=((Tool) obj).getCate_no();
			String t_name=((Tool) obj).getT_name();
			Date t_buy_date=((Tool) obj).getT_buy_date();
			Date t_limit_date=((Tool) obj).getT_limit_date();
			Date t_reg_date=((Tool) obj).getT_reg_date();
			int stor_no=((Tool) obj).getStor_no();
			Date t_final_ck=((Tool) obj).getT_final_ck();
			String t_note=((Tool) obj).getT_note();
			String sql = "insert into tool(t_no, cate_no, t_name, t_buy_date, t_limit_date, t_reg_date, stor_no, t_final_ck, t_note) values(tool_sq.nextval,?,?,?,?,?,?,?,?)";
			
			//t_no�� ������ , �������̸�.nextval�� �س���.
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1,t_no);
			ps.setInt(2,cate_no);
			ps.setString(3, t_name);
			ps.setDate(4, t_buy_date);
			ps.setDate(5, t_limit_date);
			ps.setDate(6, t_reg_date );
			ps.setInt(7, stor_no);
			ps.setDate(8, t_final_ck);
			ps.setString(9, t_note);
			
			numOfAffected = ps.executeUpdate();
			
			if(numOfAffected == 0) {
			throw new Exception(this.getClass().getName() + " ����Ÿ �߰� ���� : ");
			}else {
			System.out.println(this.getClass().getName() + " ����Ÿ �߰� ���� : " + numOfAffected);
			}
			
			ps.close();
		
		}catch (Exception e) {
			
			System.out.println(this.getClass().getName() + " ����Ÿ �߰� ���� : " + e.getMessage());
		}
		
	}
	
	//1.ī�װ� ��ȣ ���� ��� ����.
		public void insertCN(int TNum, int CN) {
			// TODO Auto-generated method stub
			
			try {
			
					int numOfAffected;
			
					String sql="insert into tool(t_no, cate_no) values(tool_sq.nextval,?)";
					PreparedStatement ps=con.prepareStatement(sql);
					System.out.println("ī�װ� ���� ���� : " + sql);
					
					ps.setInt(1, CN);
					ps.setInt(2, TNum);
					
					numOfAffected = ps.executeUpdate();
					ps.close();
					
					
					if(numOfAffected == 0) {
					throw new Exception(this.getClass().getName() + " ����Ÿ �߰� ���� : ");
					}else {
					System.out.println(this.getClass().getName() + " ����Ÿ �߰� ���� : " + numOfAffected);
					}
					
					
			}catch(Exception e) {
				System.out.println(this.getClass().getName() + " ������ ���� ���� : " + e.getMessage());
			}
			
		}
	
	//----------------------------------------
	//��ü ����
	//------------------------------------	
		
	public void regist(int cate_no2, String t_name2, String t_buy_date2, String t_limit_date2,
			String t_reg_date2, int stor_no2, String t_final_ck2, String t_note2) {
		// TODO Auto-generated method stub
			
		try {
			
			int numOfAffected;
	
			String sql="insert into tool(t_no, cate_no, t_name, t_buy_date, t_limit_date, t_reg_date, stor_no, t_final_ck, t_note) values(tool_sq.nextval,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			System.out.println("���� ���� ���� : " + sql);
			
			//ps.setInt(1,t_no2);
			ps.setInt(1,cate_no2);
			ps.setString(2, t_name2);
			ps.setString(3, t_buy_date2);
			ps.setString(4, t_limit_date2);
			ps.setString(5, t_reg_date2);
			ps.setInt(6, stor_no2);
			ps.setString(7, t_final_ck2);
			ps.setString(8, t_note2);
			
			numOfAffected = ps.executeUpdate();
			ps.close();
			
			
			if(numOfAffected == 0) {
			throw new Exception(this.getClass().getName() + " ����Ÿ �߰� ���� : ");
			}else {
				System.out.println(this.getClass().getName() + " ����Ÿ �߰� ���� : " + numOfAffected);
			}
			
			
			}catch(Exception e) {
				System.out.println(this.getClass().getName() + " ������ ���� ���� : " + e.getMessage());
			}
			
			
			
	}	
	
	
	
	//--------------------------------------------
	// ������ ���� ���� ( int,string�κе� )
	//--------------------------------------------
	
	//1.ī�װ� ��ȣ ����
	public void modifyCN(int TNum, int CN) {
		// TODO Auto-generated method stub
		
		try {
		
				int numOfAffected;
		
				String sql="update tool set cate_no=? where t_no=?"; 
				PreparedStatement ps=con.prepareStatement(sql);
				System.out.println("ī�װ� ���� ���� : " + sql);
				
				ps.setInt(1, CN);
				ps.setInt(2, TNum);
				
				numOfAffected = ps.executeUpdate();
				ps.close();
				
				
				if(numOfAffected == 0) {
				throw new Exception(this.getClass().getName() + " ����Ÿ �߰� ���� : ");
				}else {
				System.out.println(this.getClass().getName() + " ����Ÿ �߰� ���� : " + numOfAffected);
				}
				
				
		}catch(Exception e) {
			System.out.println(this.getClass().getName() + " ������ ���� ���� : " + e.getMessage());
		}
		
	}
	
	
	
	
	
	
	//2.������� ����
	public void modifyTN(int TNum, String TN) {
		// TODO Auto-generated method stub
		
		try {
		
				int numOfAffected;
		
				String sql="update tool set t_name=? where t_no=?"; 
				PreparedStatement ps=con.prepareStatement(sql);
				System.out.println("������� ���� ���� : " + sql);
				
				ps.setString(1, TN);
				ps.setInt(2, TNum);
				
				numOfAffected = ps.executeUpdate();
				ps.close();
				
				
				if(numOfAffected == 0) {
				throw new Exception(this.getClass().getName() + " ����Ÿ �߰� ���� : ");
				}else {
				System.out.println(this.getClass().getName() + " ����Ÿ �߰� ���� : " + numOfAffected);
				}
				
				
		}catch(Exception e) {
			System.out.println(this.getClass().getName() + " ������ ���� ���� : " + e.getMessage());
		}
		
	}
	
	//3.������ ��ȣ ����
	public void modifySN(int TNum, int SN) {
		// TODO Auto-generated method stub
		
		try {
		
				int numOfAffected;
		
				String sql="update tool set stor_no=? where t_no=?"; 
				PreparedStatement ps=con.prepareStatement(sql);
				System.out.println("ī�װ� ���� ���� : " + sql);
				
				ps.setInt(1, SN);
				ps.setInt(2, TNum);
				
				numOfAffected = ps.executeUpdate();
				ps.close();
				
				
				if(numOfAffected == 0) {
				throw new Exception(this.getClass().getName() + " ����Ÿ �߰� ���� : ");
				}else {
				System.out.println(this.getClass().getName() + " ����Ÿ �߰� ���� : " + numOfAffected);
				}
				
				
				
				
				
				
		}catch(Exception e) {
			System.out.println(this.getClass().getName() + " ������ ���� ���� : " + e.getMessage());
		}
		
	}
	
	
	//4.������ ���� �������� ����
	public void modifyTFC(int TNum, String TFC) {
		// TODO Auto-generated method stub
		
		try {
		
				int numOfAffected;
		
				String sql="update tool set t_final_ck=? where t_no=?"; 
				PreparedStatement ps=con.prepareStatement(sql);
				System.out.println("������� ���� ���� : " + sql);
				
				
				ps.setString(1, TFC);
				ps.setInt(2, TNum);
				
				
				numOfAffected = ps.executeUpdate();
				ps.close();
				
				
				if(numOfAffected == 0) {
				throw new Exception(this.getClass().getName() + " ����Ÿ �߰� ���� : ");
				}else {
				System.out.println(this.getClass().getName() + " ����Ÿ �߰� ���� : " + numOfAffected);
				}
				
				
				
		}catch(Exception e) {
			System.out.println(this.getClass().getName() + " ������ ���� ���� : " + e.getMessage());
		}
		
	}
	
	
	//5.��� ����
	public void modifyTNT(int TNum, String TNT) {
		// TODO Auto-generated method stub
		
		try {
		
				int numOfAffected;
		
				String sql="update tool set t_note=? where t_no=?"; 
				PreparedStatement ps=con.prepareStatement(sql);
				System.out.println("������� ���� ���� : " + sql);
				
				
				ps.setString(1, TNT);
				ps.setInt(2, TNum);
				
				
				numOfAffected = ps.executeUpdate();
				ps.close();
				
				
				if(numOfAffected == 0) {
				throw new Exception(this.getClass().getName() + " ����Ÿ �߰� ���� : ");
				}else {
				System.out.println(this.getClass().getName() + " ����Ÿ �߰� ���� : " + numOfAffected);
				}
				
				
		}catch(Exception e) {
			System.out.println(this.getClass().getName() + " ������ ���� ���� : " + e.getMessage());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//���� �޼ҵ�� ���� ��������
	@Override
	public void modify(Object obj) {
		// TODO Auto-generated method stub

		try {
			
			int numOfAffected;
			
			Tool t_no = null;
			int t_noCN = t_no.getT_no();
			Tool cate_no = null;
			int cate_noCN=cate_no.getCate_no();
			Tool t_name = null;
			String t_nameCN=t_name.getT_name();
			Tool stor_no = null;
			//Date t_buy_date=((Tool) obj).getT_buy_date();
			//Date t_limit_date=((Tool) obj).getT_limit_date();
			//Date t_reg_date=((Tool) obj).getT_reg_date();
			int stor_noCN=stor_no.getStor_no();
			Tool t_note = null;
			//Date t_final_ck=((Tool) obj).getT_final_ck();
			String t_noteCN=t_note.getT_note();

		
		
			String sql="update tool set cate_no=?, t_name=?, stor_no = ?, t_note =?  where t_no=?";
		
			PreparedStatement ps = con.prepareStatement(sql);
			
			System.out.println(" ���� ���� �Ϸ� : " + sql);
		
			
			ps.setInt(1,cate_noCN);
			ps.setString(2, t_nameCN);
			//ps.setDate(4, t_buy_date);
			//ps.setDate(5, t_limit_date);
			//ps.setDate(6, t_reg_date );
			ps.setInt(3, stor_noCN);
			//ps.setDate(8, t_final_ck);
			ps.setString(4, t_noteCN);
			ps.setInt(5,t_noCN);
			
			
			numOfAffected = ps.executeUpdate();
			ps.close();
			
			
			if(numOfAffected == 0) {
			throw new Exception(this.getClass().getName() + " ����Ÿ �߰� ���� : ");
			}else {
			System.out.println(this.getClass().getName() + " ����Ÿ �߰� ���� : " + numOfAffected);
			}
			

		
		}catch(Exception e) {
			System.out.println(this.getClass().getName() + " ������ ���� ���� : " + e.getMessage());
		}
		
	}
	
	
//	public Tool selectByTNo (int TNum) {
//		Tool tl = new Tool();
//		try {
//			
//			String sql = "select * from videotab where videonum = "+ TNum;
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery(sql);
//			while(rs.next()) {
//				tl.setT_no(rs.getInt("t_no"));
//				tl.setCate_no(rs.getInt("cate_no"));
//				tl.setT_name(rs.getString("t_name"));
//				tl.setT_buy_date(rs.getDate("t_buy_date"));
//				tl.setT_limit_date(rs.getDate("t_limit_date"));
//				tl.setT_reg_date(rs.getDate("t_reg_date"));
//				tl.setStor_no(rs.getInt("stor_no"));
//				tl.setT_final_ck(rs.getDate("t_final_ck"));
//				tl.setT_note(rs.getString("t_note"));
//				
//			}
//			rs.close();
//			stmt.close();
//			
//			
//		}catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(this.getClass().getName().toString() + " ����Ÿ ��ȸ ���� : " + e.getMessage());
//			
//		}
//		return tl;
//		
//		
//		
//		
//		
//		
//	}
	
	//---------------------
	//���� �޼ҵ� �۵� �ȉ�.
	//--------------------
	
	public Tool tl = new Tool();
	
	public Tool selectByTNo (int TNum) throws Exception{


		String sql = "select * from videotab where videonum = "+ TNum;
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			tl.setT_no(rs.getInt("t_no"));
			tl.setCate_no(rs.getInt("cate_no"));
			tl.setT_name(rs.getString("t_name"));
			tl.setT_buy_date(rs.getDate("t_buy_date"));
			tl.setT_limit_date(rs.getDate("t_limit_date"));
			tl.setT_reg_date(rs.getDate("t_reg_date"));
			tl.setStor_no(rs.getInt("stor_no"));
			tl.setT_final_ck(rs.getDate("t_final_ck"));
			tl.setT_note(rs.getString("t_note"));
				
		}
		rs.close();
		stmt.close();

		return tl;
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	//--------------------------------------------
	// ������ ���� �˻� ( * )
	//--------------------------------------------

	@Override
	public ArrayList search() {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		
		try {
			String sql = "select t_no, cate_no, t_name, t_buy_date, t_limit_date, t_reg_date, stor_no, t_final_ck, t_note from tool";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ArrayList tool = new ArrayList();					
				tool.add(rs.getInt("t_no"));
				tool.add(rs.getInt("cate_no"));
				tool.add(rs.getString("t_name"));
				tool.add(rs.getDate("t_buy_date"));
				tool.add(rs.getDate("t_limit_date"));
				tool.add(rs.getDate("t_reg_date"));
				tool.add(rs.getInt("stor_no"));
				tool.add(rs.getDate("t_final_ck"));
				tool.add(rs.getString("t_note"));
				list.add(tool);
			}
			
			System.out.println(this.getClass().getName().toString() + ":" + list.size() + " ���� �ڷᰡ �˻��Ǿ����ϴ�.");

			rs.close();
			ps.close();
			

			
		
		}catch(Exception e) {
			System.out.println(this.getClass().getName().toString() + " ����Ÿ ��ȸ ���� : " + e.getMessage());
		}
		return list;

	}
	
	//--------------------------------------------
	// ������ ���� �˻� ( ������ ��ȣ )
	//--------------------------------------------
	
	public ArrayList searchByTNo(int t_no) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		
		
		try {
			String sql = "select t_no, cate_no, t_name, t_buy_date, t_limit_date, t_reg_date, stor_no, t_final_ck, t_note from tool where t_no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, t_no);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ArrayList tool = new ArrayList();					
				tool.add(rs.getInt("t_no"));
				tool.add(rs.getInt("cate_no"));
				tool.add(rs.getString("t_name"));
				tool.add(rs.getDate("t_buy_date"));
				tool.add(rs.getDate("t_limit_date"));
				tool.add(rs.getDate("t_reg_date"));
				tool.add(rs.getInt("stor_no"));
				tool.add(rs.getDate("t_final_ck"));
				tool.add(rs.getString("t_note"));
				list.add(tool);
			}
			
			System.out.println(this.getClass().getName().toString() + ":" + list.size() + " ���� �ڷᰡ �˻��Ǿ����ϴ�.");

			rs.close();
			ps.close();
			

			
		
		}catch(Exception e) {
			System.out.println(this.getClass().getName().toString() + " ����Ÿ ��ȸ ���� : " + e.getMessage());
		}
		return list;

	}	
	
	
	//--------------------------------------------
	// ������ ���� �˻� ( �з���ȣ )
	//--------------------------------------------
	public ArrayList searchByCateNo(int cate_no) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		
		
		try {
			String sql = "select t_no, cate_no, t_name, t_buy_date, t_limit_date, t_reg_date, stor_no, t_final_ck, t_note from tool where cate_no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cate_no);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ArrayList tool = new ArrayList();					
				tool.add(rs.getInt("t_no"));
				tool.add(rs.getInt("cate_no"));
				tool.add(rs.getString("t_name"));
				tool.add(rs.getDate("t_buy_date"));
				tool.add(rs.getDate("t_limit_date"));
				tool.add(rs.getDate("t_reg_date"));
				tool.add(rs.getInt("stor_no"));
				tool.add(rs.getDate("t_final_ck"));
				tool.add(rs.getString("t_note"));
				list.add(tool);
			}
			
			System.out.println(this.getClass().getName().toString() + ":" + list.size() + " ���� �ڷᰡ �˻��Ǿ����ϴ�.");

			rs.close();
			ps.close();
			

			
		
		}catch(Exception e) {
			System.out.println(this.getClass().getName().toString() + " ����Ÿ ��ȸ ���� : " + e.getMessage());
		}
		return list;

	}	
	

	//--------------------------------------------
	// ������ ���� �˻� ( ������� )
	//--------------------------------------------
	public ArrayList searchByTName(String t_name) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		
		try {
			String sql = "select t_no, cate_no, t_name, t_buy_date, t_limit_date, t_reg_date, stor_no, t_final_ck, t_note from tool where t_name = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t_name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ArrayList tool = new ArrayList();					
				tool.add(rs.getInt("t_no"));
				tool.add(rs.getInt("cate_no"));
				tool.add(rs.getString("t_name"));
				tool.add(rs.getDate("t_buy_date"));
				tool.add(rs.getDate("t_limit_date"));
				tool.add(rs.getDate("t_reg_date"));
				tool.add(rs.getInt("stor_no"));
				tool.add(rs.getDate("t_final_ck"));
				tool.add(rs.getString("t_note"));
				list.add(tool);
			}
			
			System.out.println(this.getClass().getName().toString() + ":" + list.size() + " ���� �ڷᰡ �˻��Ǿ����ϴ�.");

			rs.close();
			ps.close();
			

			
		
		}catch(Exception e) {
			System.out.println(this.getClass().getName().toString() + " ����Ÿ ��ȸ ���� : " + e.getMessage());
		}
		return list;

	}
	
	
	//�������, �������ڴ� ���� ����.
	//--------------------------------------------
	// ������ ���� �˻� ( ������ )
	//--------------------------------------------
	public ArrayList searchByTLimitDate(Date t_limit_date) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		
		
		try {
			String sql = "select t_no, cate_no, t_name, t_buy_date, t_limit_date, t_reg_date, stor_no, t_final_ck, t_note from tool where t_limit_date > ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDate(1, t_limit_date);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ArrayList tool = new ArrayList();					
				tool.add(rs.getInt("t_no"));
				tool.add(rs.getInt("cate_no"));
				tool.add(rs.getString("t_name"));
				tool.add(rs.getDate("t_buy_date"));
				tool.add(rs.getDate("t_limit_date"));
				tool.add(rs.getDate("t_reg_date"));
				tool.add(rs.getInt("stor_no"));
				tool.add(rs.getDate("t_final_ck"));
				tool.add(rs.getString("t_note"));
				list.add(tool);
			}
			
			System.out.println(this.getClass().getName().toString() + ":" + list.size() + " ���� �ڷᰡ �˻��Ǿ����ϴ�.");

			rs.close();
			ps.close();
			

			
		
		}catch(Exception e) {
			System.out.println(this.getClass().getName().toString() + " ����Ÿ ��ȸ ���� : " + e.getMessage());
		}
		return list;

	}
	
	
	
	//--------------------------------------------
	// ������ ���� �˻� ( ������ ��ȣ )
	//--------------------------------------------
	
	public ArrayList searchByStorNo(int stor_no) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		
		
		try {
			String sql = "select t_no, cate_no, t_name, t_buy_date, t_limit_date, t_reg_date, stor_no, t_final_ck, t_note from tool where stor_no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, stor_no);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ArrayList tool = new ArrayList();					
				tool.add(rs.getInt("t_no"));
				tool.add(rs.getInt("cate_no"));
				tool.add(rs.getString("t_name"));
				tool.add(rs.getDate("t_buy_date"));
				tool.add(rs.getDate("t_limit_date"));
				tool.add(rs.getDate("t_reg_date"));
				tool.add(rs.getInt("stor_no"));
				tool.add(rs.getDate("t_final_ck"));
				tool.add(rs.getString("t_note"));
				list.add(tool);
			}
			
			System.out.println(this.getClass().getName().toString() + ":" + list.size() + " ���� �ڷᰡ �˻��Ǿ����ϴ�.");

			rs.close();
			ps.close();
			

			
		
		}catch(Exception e) {
			System.out.println(this.getClass().getName().toString() + " ����Ÿ ��ȸ ���� : " + e.getMessage());
		}
		return list;

	}	
	
	//--------------------------------------------
	// ������ ���� �˻� ( ���� �������� )
	//--------------------------------------------
	
	
	
	public ArrayList searchByTFinalCk(Date t_final_ck) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		
		
		try {
			String sql = "select t_no, cate_no, t_name, t_buy_date, t_limit_date, t_reg_date, stor_no, t_final_ck, t_note from tool where t_final_ck > ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDate(1, t_final_ck);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ArrayList tool = new ArrayList();					
				tool.add(rs.getInt("t_no"));
				tool.add(rs.getInt("cate_no"));
				tool.add(rs.getString("t_name"));
				tool.add(rs.getDate("t_buy_date"));
				tool.add(rs.getDate("t_limit_date"));
				tool.add(rs.getDate("t_reg_date"));
				tool.add(rs.getInt("stor_no"));
				tool.add(rs.getDate("t_final_ck"));
				tool.add(rs.getString("t_note"));
				list.add(tool);
			}
			
			System.out.println(this.getClass().getName().toString() + ":" + list.size() + " ���� �ڷᰡ �˻��Ǿ����ϴ�.");

			rs.close();
			ps.close();
			

			
		
		}catch(Exception e) {
			System.out.println(this.getClass().getName().toString() + " ����Ÿ ��ȸ ���� : " + e.getMessage());
		}
		return list;

	}
	
	
	
	
//	public ArrayList<Tool> searchByTFinalCk(Date t_final_ck) {
//		// TODO Auto-generated method stub
//		ArrayList<Tool> list = new ArrayList<Tool>();
//		
//		try {
//			String sql = "select * from tool where t_final_ck = ?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setDate(1, (Date)t_final_ck);
//			ResultSet rs = ps.executeQuery();
//			
//			Tool tool = new Tool();
//			
//			while(rs.next()) {
//				tool.setT_no(rs.getInt("t_no"));
//				tool.setCate_no(rs.getInt("cate_no"));
//				tool.setT_name(rs.getString("t_name"));
//				tool.setT_buy_date(rs.getDate("t_buy_date"));
//				tool.setT_limit_date(rs.getDate("t_limit_date"));
//				tool.setT_reg_date(rs.getDate("t_reg_date"));
//				tool.setStor_no(rs.getInt("stor_no"));
//				tool.setT_final_ck(rs.getDate("t_final_ck"));
//				tool.setT_note(rs.getString("t_note"));
//				list.add(tool);
//			}
//			
//			System.out.println(this.getClass().getName().toString() + ":" + list.size() + " ���� �ڷᰡ �˻��Ǿ����ϴ�.");
//			
//			rs.close();
//			ps.close();
//		
//		}catch(Exception e) {
//			System.out.println(this.getClass().getName().toString() + " ����Ÿ ��ȸ ���� : " + e.getMessage());
//		}
//		return list;
//	}
	
	//--------------------------------------------
	// ������ ���� �˻� ( ��� )
	//--------------------------------------------
	public ArrayList searchByTNote(String t_note) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		
		try {
			String sql = "select t_no, cate_no, t_name, t_buy_date, t_limit_date, t_reg_date, stor_no, t_final_ck, t_note from tool where instr(t_note,?)>0";
					
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t_note);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ArrayList tool = new ArrayList();					
				tool.add(rs.getInt("t_no"));
				tool.add(rs.getInt("cate_no"));
				tool.add(rs.getString("t_name"));
				tool.add(rs.getDate("t_buy_date"));
				tool.add(rs.getDate("t_limit_date"));
				tool.add(rs.getDate("t_reg_date"));
				tool.add(rs.getInt("stor_no"));
				tool.add(rs.getDate("t_final_ck"));
				tool.add(rs.getString("t_note"));
				list.add(tool);
			}
			
			System.out.println(this.getClass().getName().toString() + ":" + list.size() + " ���� �ڷᰡ �˻��Ǿ����ϴ�.");

			rs.close();
			ps.close();
			

			
		
		}catch(Exception e) {
			System.out.println(this.getClass().getName().toString() + " ����Ÿ ��ȸ ���� : " + e.getMessage());
		}
		return list;

	}


	
	
}
