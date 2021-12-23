package javara.model;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javara.model.rec.Professor;


public class ProfessorModel implements DBConnetor{
	
	private Connection con;
	
	public ProfessorModel() {
		// TODO Auto-generated constructor stub
		connectDB();
	}

	public void connectDB() {
		// TODO Auto-generated method stub
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(JDBC_URL,DB_ID,DB_PW);
			System.out.println("교수 데이타베이스에 연결되었습니다.");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("교수 데이타베이스에 연결실패되었습니다.");
		}
	}
	
	public void modify(Object obj) {
		// TODO Auto-generated method stub	
		Professor prof = (Professor) obj;
		
		try {
			String sql = "UPDATE professor_info SET prof_name=?, prof_tel=?, prof_office=? where prof_no=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, prof.getProfname());
			ps.setString(2, prof.getProftel());
			ps.setString(3, prof.getProfoffice());
			ps.setInt(4, prof.getProfno());
			ps.execute();
			ps.close();
		}catch (Exception e) {
			// TODO: handle exception
		}	
	}
	
	public ArrayList searchProf(int sel, String text) throws Exception{
		
		String[]  selCol = {"m.maj_name like '%" + text +"%'", "p.prof_name = '" + text +"'"};
		
		String sql = "SELECT p.prof_no, p.prof_name, p.prof_tel, p.prof_office, m.maj_name FROM professor_info p, major_info m "
				+"where p.maj_no=m.maj_no "	
				+"and "+ selCol[sel];
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery(sql);
	
		ArrayList list = new ArrayList();

		while (rs.next()) {
    	ArrayList temp = new ArrayList();
    	
        temp.add(rs.getInt("prof_no"));
        temp.add(rs.getString("prof_name"));
        temp.add(rs.getString("prof_tel"));
        temp.add(rs.getString("prof_office"));
        temp.add(rs.getString("maj_name"));
        
        list.add(temp);	

		}
		rs.close();
		ps.close();	
        
		return list;
	}
	
	public Professor selectByPf( int pNo ) throws Exception{
		Professor prof = new Professor();
		String sql = "SELECT p.prof_no, p.prof_name, p.prof_tel, p.prof_office, m.maj_name FROM professor_info p, major_info m "
				+"where p.maj_no=m.maj_no and prof_no=" + pNo;
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			prof.setProfno(rs.getInt("PROF_NO"));
			prof.setProfname(rs.getString("PROF_NAME"));
			prof.setProftel(rs.getString("PROF_TEL"));
			prof.setProfoffice(rs.getString("PROF_OFFICE"));	
			prof.setMajname(rs.getString("MAJ_NAME"));
		}
		rs.close();
		stmt.close();
		
		return prof;
	}
	
}
