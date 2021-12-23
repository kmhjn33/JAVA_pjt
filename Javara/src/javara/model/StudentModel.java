package javara.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javara.model.rec.Student;

public class StudentModel implements DBConnetor{

	private Connection con;
	
	public StudentModel() {
		// TODO Auto-generated constructor stub
		connectDB();
	}
	
	public void connectDB() {
		// TODO Auto-generated method stub
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(JDBC_URL,DB_ID,DB_PW);
			System.out.println("학생 데이타베이스에 연결되었습니다.");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("학생 데이타베이스에 연결실패되었습니다.");
		}	
	}

	public void modify(Object obj) {
		// TODO Auto-generated method stub
		Student stu = (Student) obj;
		
		try {
			String sql = "UPDATE student_info SET stu_name=?, stu_tel=?, stu_addr=? where stu_no=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, stu.getStuname());
			ps.setString(2, stu.getStutel());
			ps.setString(3, stu.getStuaddr());
			ps.setInt(4, stu.getStuno());
			
			ps.execute();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	public ArrayList searchStu(int sel, String text) throws Exception{
		
		String[]  selCol = {"s.stu_no = " + text, "s.stu_name = '" + text +"'"};
		
		String sql = "SELECT s.stu_no, s.stu_name, s.stu_tel, s.stu_addr, m.maj_name, d.dgr_name, p.prof_name "
				+ "FROM student_info s, major_info m, professor_info p, degree d "
				+ "where s.maj_no=m.maj_no and p.prof_no=s.prof_no and d.dgr_no=s.dgr_no "
				+"and "+ selCol[sel];

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList list = new ArrayList();
		
    	while (rs.next()) {
    		ArrayList temp = new ArrayList();
    		
    		temp.add(rs.getInt("stu_no"));
    		temp.add(rs.getString("stu_name"));
    		temp.add(rs.getString("stu_tel"));
    		temp.add(rs.getString("stu_addr"));
    		temp.add(rs.getString("maj_name"));
    		temp.add(rs.getString("dgr_name"));
    		temp.add(rs.getString("prof_name"));
    		
    		list.add(temp);
    	}
        
        rs.close();
        stmt.close();
        
		return list;	
	}
	
	public void stuDelete(int stuno) throws Exception{
		String sql = "delete student_info where stu_no=" + stuno;
		Statement st = con.createStatement();
		
		st.executeUpdate(sql);
		st.close();
	}

	public Student selectBySt( int sNo ) throws Exception{
		Student stu = new Student();
		String sql = "SELECT s.stu_no, s.stu_name, s.stu_tel, s.stu_addr, m.maj_name FROM student_info s, major_info m "
				+"where s.maj_no=m.maj_no and stu_no=" + sNo;
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()) {
			stu.setStuno(rs.getInt("STU_NO"));
			stu.setStuname(rs.getString("STU_NAME"));
			stu.setStutel(rs.getString("STU_TEL"));
			stu.setStuaddr(rs.getString("STU_ADDR"));
			stu.setMajname(rs.getString("MAJ_NAME"));
		}
		rs.close();
		stmt.close();
		
		return stu;
	}
	
}
	
