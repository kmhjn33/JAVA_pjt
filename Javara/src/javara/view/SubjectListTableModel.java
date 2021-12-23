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
	// 1. �⺻���� TabelModel  �����
	// �Ʒ� �� �Լ��� TabelModel �������̽��� �߻��Լ��ε�
	// AbstractTabelModel���� �������� �ʾұ⿡...
	// �ݵ�� ����� ���� �ʼ�!!!!
	
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
	// 2. ������ �÷������� ��ȯ�ϱ�
	//
	//			�⺻������ A, B, C, D ��� �̸����� �÷����� �����ȴ�
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames[column];
		//return super.getColumnName(column);
	}	
}
