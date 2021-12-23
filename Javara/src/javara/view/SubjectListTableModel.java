package javara.view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class SubjectListTableModel extends AbstractTableModel {

	public ArrayList  list = new ArrayList();
	public String[] columnNames;
	

	public SubjectListTableModel(String[] columnNames, ArrayList list) {
		// TODO Auto-generated constructor stub
		this.columnNames=columnNames;
		this.list=list;
	}
	public SubjectListTableModel(String[] columnNames, int rowcount) {
		// TODO Auto-generated constructor stub
		this.columnNames=columnNames;
		
	}
	
	
	
	public ArrayList getList() {
		return this.list;
	}
	
	public void setList(ArrayList list) {
		this.list=list;
	}
	
	
	public SubjectListTableModel() {
		// TODO Auto-generated constructor stub
	}
	//=============================================================
	// 1. 기본적인 TabelModel  만들기
	// 아래 세 함수는 TabelModel 인터페이스의 추상함수인데
	// AbstractTabelModel에서 구현되지 않았기에...
	// 반드시 사용자 구현 필수!!!!
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		//return list[rowIndex][columnIndex];
		ArrayList temp = (ArrayList)list.get( rowIndex );
        return temp.get( columnIndex ); 
	}
	
	//===============================================================
	// 2. 지정된 컬럼명으로 변환하기
	//
	//			기본적으로 A, B, C, D 라는 이름으로 컬럼명이 지정된다
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames[column];
		//return super.getColumnName(column);
	}	
}
