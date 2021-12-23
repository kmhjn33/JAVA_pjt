package javara.view;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import oracle.net.aso.l;

public class SubjectComboBoxModel extends AbstractListModel implements ComboBoxModel {
	
	ArrayList list = new ArrayList();
	String selection =null;
	String[] selData=null;
	
	
	public SubjectComboBoxModel(ArrayList list) {
		// TODO Auto-generated constructor stub
		
		this.list=list;
		String listdata[] = new String[list.size()];
		for(int i=0;i < list.size();i ++) {
			listdata[i]=list.get(i).toString();
		}
//		super( list.toArray());
	}	
	
	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return list.get(index).toString();
		
		
	}
	public String getElementID() {
		
		//String value=list.get(index).toString();
		return selData[0];
	}
	public String getElementName() {
		return selData[1];
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return list.size();
	}
	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		selection=(String)anItem;
		selData=selection.split("-");
	}
    @Override
    public Object getSelectedItem() {
    	// TODO Auto-generated method stub
    	return selection;
    }

}
