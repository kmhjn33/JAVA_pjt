package javara.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import javara.model.StudentModel;
import javara.model.rec.Student;

public class StudentView extends JInternalFrame implements ActionListener{

	private JPanel contentPane;
	private JComboBox	comStuSearch;
	private JTextField	tfStuSearch;
	private JButton		bStuSearch = new JButton();
	private JButton bModify = new JButton();
	private JButton bDelete = new JButton();
	
	private StudentModel stumodel = null;
	private StudentTableModel	tmStudent = new StudentTableModel();
	private JTable stutable;
		
	private JTextField tfStuNo;
	private JTextField tfStuName;
	private JTextField tfStuTel;
	private JTextField tfStuAddr;
	private JTextField tfMajName;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 StudentView studentView = new StudentView();
	}
	
	public StudentView() {
		setTitle("ÇÐ»ýÁ¤º¸Á¶È¸");
		setSize(900,600);
		StudentViewLayout();
		setStyle();
		eventProc();
		stumodel = new StudentModel();
		setVisible(true);
		setClosable(true);
	}
	
	/**
	 * Create the frame.
	 */
	public void StudentViewLayout() {
		
//		setBounds(100, 100, 1165, 799);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 1139, 40);
		panel.setBackground(Color.GRAY);
		panel.setForeground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel	sCenter	= new JPanel();
		sCenter.setBorder( new TitledBorder(" ÇÐ		»ý	") );
		
		JLabel lblNewLabel = new JLabel("ÇÐ»ýÁ¤º¸");
		lblNewLabel.setBounds(12, 5, 124, 35);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(244, 77, 447, 53);
		contentPane.add(panel_2);
		
		String serchStu[] = {"ÇÐ¹ø", "ÀÌ¸§"};
		comStuSearch = new JComboBox(serchStu);
		comStuSearch.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		panel_2.add(comStuSearch);
		
		tfStuSearch = new JTextField();
		tfStuSearch.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		panel_2.add(tfStuSearch);
		tfStuSearch.setColumns(10);
		
		bStuSearch = new JButton("ÇÐ»ý Á¶È¸");
		bStuSearch.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		panel_2.add(bStuSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(320, 141, 501, 370);
		contentPane.add(scrollPane);
		
		stutable = new JTable(tmStudent);
		scrollPane.setViewportView(stutable);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(40, 133, 262, 378);
		contentPane.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("ÇÐ¹ø");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		panel_3.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tfStuNo = new JTextField();
		tfStuNo.setFont(new Font("±¼¸²", Font.BOLD, 12));
		GridBagConstraints gbc_tfStuNo = new GridBagConstraints();
		gbc_tfStuNo.gridwidth = 6;
		gbc_tfStuNo.insets = new Insets(0, 0, 5, 5);
		gbc_tfStuNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfStuNo.gridx = 3;
		gbc_tfStuNo.gridy = 1;
		panel_3.add(tfStuNo, gbc_tfStuNo);
		tfStuNo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ÀÌ¸§");
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 3;
		panel_3.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tfStuName = new JTextField();
		tfStuName.setFont(new Font("±¼¸²", Font.BOLD, 12));
		GridBagConstraints gbc_tfStuName = new GridBagConstraints();
		gbc_tfStuName.gridwidth = 6;
		gbc_tfStuName.insets = new Insets(0, 0, 5, 5);
		gbc_tfStuName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfStuName.gridx = 3;
		gbc_tfStuName.gridy = 3;
		panel_3.add(tfStuName, gbc_tfStuName);
		tfStuName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ÀüÈ­¹øÈ£");
		lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 5;
		panel_3.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		tfStuTel = new JTextField();
		tfStuTel.setFont(new Font("±¼¸²", Font.BOLD, 12));
		GridBagConstraints gbc_tfStuTel = new GridBagConstraints();
		gbc_tfStuTel.gridwidth = 6;
		gbc_tfStuTel.insets = new Insets(0, 0, 5, 5);
		gbc_tfStuTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfStuTel.gridx = 3;
		gbc_tfStuTel.gridy = 5;
		panel_3.add(tfStuTel, gbc_tfStuTel);
		tfStuTel.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ÁÖ¼Ò");
		lblNewLabel_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 7;
		panel_3.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		tfStuAddr = new JTextField();
		tfStuAddr.setFont(new Font("±¼¸²", Font.BOLD, 12));
		GridBagConstraints gbc_tfStuAddr = new GridBagConstraints();
		gbc_tfStuAddr.gridwidth = 6;
		gbc_tfStuAddr.insets = new Insets(0, 0, 5, 5);
		gbc_tfStuAddr.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfStuAddr.gridx = 3;
		gbc_tfStuAddr.gridy = 7;
		panel_3.add(tfStuAddr, gbc_tfStuAddr);
		tfStuAddr.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("ÇÐ°ú¸í");
		lblNewLabel_5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 9;
		panel_3.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		tfMajName = new JTextField();
		tfMajName.setFont(new Font("±¼¸²", Font.BOLD, 12));
		GridBagConstraints gbc_tfMajName = new GridBagConstraints();
		gbc_tfMajName.gridwidth = 6;
		gbc_tfMajName.insets = new Insets(0, 0, 5, 5);
		gbc_tfMajName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMajName.gridx = 3;
		gbc_tfMajName.gridy = 9;
		panel_3.add(tfMajName, gbc_tfMajName);
		tfMajName.setColumns(10);
		
			bModify = new JButton("¼öÁ¤");
			bModify.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
			GridBagConstraints gbc_bModify = new GridBagConstraints();
			gbc_bModify.insets = new Insets(0, 0, 5, 5);
			gbc_bModify.gridx = 4;
			gbc_bModify.gridy = 11;
			panel_3.add(bModify, gbc_bModify);
			
			bDelete = new JButton("»èÁ¦");
			bDelete.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
			GridBagConstraints gbc_bDelete = new GridBagConstraints();
			gbc_bDelete.insets = new Insets(0, 0, 5, 5);
			gbc_bDelete.gridx = 6;
			gbc_bDelete.gridy = 11;
			panel_3.add(bDelete, gbc_bDelete);		
			
			panel_3.setBorder( new TitledBorder(" ÇÐ»ý Á¤º¸ " ));
	}
	
	void setStyle() {
		tfStuNo.setEditable(false);
		tfMajName.setEditable(false);
	}
	
	void eventProc(){
		bStuSearch.addActionListener(this);
		bModify.addActionListener(this);
		bDelete.addActionListener(this);
		
		stutable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = stutable.getSelectedRow();
				int col = 0;
				int sNo = (Integer)stutable.getValueAt(row, col);
				Student stu = new Student();
				
				try {
					stu = stumodel.selectBySt(sNo);
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "±³¼ö°Ë»ö ½ÇÆÐ" + e2.getMessage());
				}
				
				tfStuNo.setText(String.valueOf(stu.getStuno()));
				tfStuName.setText(stu.getStuname());
				tfStuTel.setText(stu.getStutel());
				tfStuAddr.setText(stu.getStuaddr());				
				tfMajName.setText(stu.getMajname());
			}
		});
	}
	
	public void actionPerformed(ActionEvent ev) {
		Object o = ev.getSource();
		if( o == bStuSearch) {
			selectTable();
			clearScreen();
			
		}else if (o == bModify) {
			
			int stuno = Integer.parseInt(tfStuNo.getText());
			String stuname = tfStuName.getText();
			String stutel = tfStuTel.getText();
			String stuaddr = tfStuAddr.getText();
			
			Student stu = new Student();
			stu.setStuno(stuno);
			stu.setStuname(stuname);
			stu.setStutel(stutel);
			stu.setStuaddr(stuaddr);
			
			try {
				stumodel.modify(stu);
				JOptionPane.showMessageDialog(null, "¼öÁ¤ ¼º°ø");
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "¼öÁ¤ ½ÇÆÐ" + e.getMessage());
			}
			clearScreen();
			
		}else if (o == bDelete) {
			
			int stuno = Integer.parseInt(tfStuNo.getText());

			try {
				stumodel.stuDelete(stuno);
				JOptionPane.showMessageDialog(null, "»èÁ¦ ¼º°ø");
			} catch (Exception e1) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "»èÁ¦ ½ÇÆÐ" + e1.getMessage());
			}
			clearScreen();	
		}
	}
	
	public void clearScreen() {
		tfStuSearch.setText("");
		tfStuNo.setText("");
		tfStuName.setText("");
		tfStuTel.setText("");
		tfStuAddr.setText("");
		tfMajName.setText("");
		
	}
	
	void selectTable() {
		int sel = comStuSearch.getSelectedIndex();
		String text = tfStuSearch.getText();
		
		try {
			ArrayList list = stumodel.searchStu(sel, text);
			tmStudent.data = list;
			//stutable.setModel(tmStudent);
			tmStudent.fireTableDataChanged();
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "°Ë»ö ½ÇÆÐ" + e.getMessage());
			System.out.println(e.getMessage());
		}

	}
}
	
	class StudentTableModel extends AbstractTableModel{

		ArrayList data = new ArrayList();
		String [] columnNames = { "ÇÐ¹ø", "ÀÌ¸§", "ÀüÈ­¹øÈ£", "ÁÖ¼Ò", "ÇÐ°ú¸í", "ÇÐÀ§¸í", "±³¼ö¸í"};

	    public int getColumnCount() { 
	        return columnNames.length; 
	    } 
	     
	    public int getRowCount() { 
	        return data.size(); 
	    } 

	    public Object getValueAt(int row, int col) { 
	    	ArrayList temp = (ArrayList)data.get( row );
	        return temp.get( col ); 
	    }

		 public String getColumnName(int col) { 
	        return columnNames[col]; 
	    } 
	}

