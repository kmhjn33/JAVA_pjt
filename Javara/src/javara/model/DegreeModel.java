package javara.model;

import java.sql.*;
import java.util.ArrayList;

public class DegreeModel implements InterfaceCommonModel{

	private Connection con;
	
	@Override
	public void connectDB() {
		// TODO Auto-generated method stub
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(jdbc_url, db_id, db_pwd);
			System.out.println("학위 데이타베이스에 연결되었습니다.");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("학위 데이타베이스에 연결실패되었습니다.");
		}
	}
	
	
	@Override
	public void modify(Object obj) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void regist(Object obj) {
		// TODO Auto-generated method stub		
	}
	
	@Override
	public ArrayList search() {
		// TODO Auto-generated method stub
		return null;
	}
		
	public DegreeModel() {
		// TODO Auto-generated constructor stub
		connectDB();
	}
}
