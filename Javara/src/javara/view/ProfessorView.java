package javara.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import javara.model.ProfessorModel;
import javara.model.StudentModel;
import javara.model.rec.Professor;

import javax.swing.JComboBox;

public class ProfessorView extends JInternalFrame implements ActionListener{

	private JPanel contentPane;
	private JComboBox comProfSearch;
	private JTextField tfSearchProf;
	private JButton bProfSearch = new JButton();
	private JButton bModify = new JButton();

	private ProfessorModel profmodel = null;
	private ProfListTableModel tmProfessor= new ProfListTableModel();
	private JTable tableProf;
	
	private JTextField tfProfNo;
	private JTextField tfProfName;
	private JTextField tfProfTel;
	private JTextField tfProfOffice;
	private JTextField tfMajName;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ProfessorView professorView = new ProfessorView();
	}

	public ProfessorView() {
		setTitle("±³¼öÁ¤º¸Á¶È¸");
		setSize(900,600);
		ProfessorViewLayout();
		setStyle();
		eventProc();
		profmodel = new ProfessorModel();
		setVisible(true);
		setClosable(true);
	}
	
	/**
	 * Create the frame.
	 */
	public void ProfessorViewLayout() {
		
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
		
		JLabel lblNewLabel = new JLabel("±³¼öÁ¤º¸");
		lblNewLabel.setBounds(12, 5, 124, 35);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(250, 78, 447, 53);
		contentPane.add(panel_1);
		
		String searchProf[] = {"ÇÐ°ú¸í", "ÀÌ¸§"};
		comProfSearch = new JComboBox(searchProf);
		comProfSearch.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		panel_1.add(comProfSearch);
		
		tfSearchProf = new JTextField();
		tfSearchProf.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		panel_1.add(tfSearchProf);
		tfSearchProf.setColumns(10);
		
		bProfSearch = new JButton("±³¼ö Á¶È¸");
		bProfSearch.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		panel_1.add(bProfSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(320, 141, 501, 370);
		contentPane.add(scrollPane);
		
		tableProf = new JTable(tmProfessor);
		scrollPane.setViewportView(tableProf);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(52, 134, 247, 377);
		contentPane.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("±³¼ö¹øÈ£");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tfProfNo = new JTextField();
		tfProfNo.setFont(new Font("±¼¸²", Font.BOLD, 12));
		GridBagConstraints gbc_tfProfNo = new GridBagConstraints();
		gbc_tfProfNo.gridwidth = 4;
		gbc_tfProfNo.insets = new Insets(0, 0, 5, 5);
		gbc_tfProfNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfProfNo.gridx = 4;
		gbc_tfProfNo.gridy = 1;
		panel_2.add(tfProfNo, gbc_tfProfNo);
		tfProfNo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ÀÌ¸§");
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 3;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tfProfName = new JTextField();
		tfProfName.setFont(new Font("±¼¸²", Font.BOLD, 12));
		GridBagConstraints gbc_tfProfName = new GridBagConstraints();
		gbc_tfProfName.gridwidth = 4;
		gbc_tfProfName.insets = new Insets(0, 0, 5, 5);
		gbc_tfProfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfProfName.gridx = 4;
		gbc_tfProfName.gridy = 3;
		panel_2.add(tfProfName, gbc_tfProfName);
		tfProfName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ÀüÈ­¹øÈ£");
		lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 5;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		tfProfTel = new JTextField();
		tfProfTel.setFont(new Font("±¼¸²", Font.BOLD, 12));
		GridBagConstraints gbc_tfProfTel = new GridBagConstraints();
		gbc_tfProfTel.gridwidth = 4;
		gbc_tfProfTel.insets = new Insets(0, 0, 5, 5);
		gbc_tfProfTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfProfTel.gridx = 4;
		gbc_tfProfTel.gridy = 5;
		panel_2.add(tfProfTel, gbc_tfProfTel);
		tfProfTel.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("±³¼ö »ç¹«½Ç");
		lblNewLabel_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 7;
		panel_2.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		tfProfOffice = new JTextField();
		tfProfOffice.setFont(new Font("±¼¸²", Font.BOLD, 12));
		GridBagConstraints gbc_tfProfOffice = new GridBagConstraints();
		gbc_tfProfOffice.gridwidth = 4;
		gbc_tfProfOffice.insets = new Insets(0, 0, 5, 5);
		gbc_tfProfOffice.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfProfOffice.gridx = 4;
		gbc_tfProfOffice.gridy = 7;
		panel_2.add(tfProfOffice, gbc_tfProfOffice);
		tfProfOffice.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("ÇÐ°ú¸í");
		lblNewLabel_5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 9;
		panel_2.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		tfMajName = new JTextField();
		tfMajName.setFont(new Font("±¼¸²", Font.BOLD, 12));
		GridBagConstraints gbc_tfMajName = new GridBagConstraints();
		gbc_tfMajName.gridwidth = 4;
		gbc_tfMajName.insets = new Insets(0, 0, 5, 5);
		gbc_tfMajName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMajName.gridx = 4;
		gbc_tfMajName.gridy = 9;
		panel_2.add(tfMajName, gbc_tfMajName);
		tfMajName.setColumns(10);
		
		panel_2.setBorder( new TitledBorder(" ±³¼ö Á¤º¸ " ));
		
		bModify = new JButton("¼öÁ¤");
		bModify.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		GridBagConstraints gbc_bModify = new GridBagConstraints();
		gbc_bModify.insets = new Insets(0, 0, 5, 5);
		gbc_bModify.gridx = 5;
		gbc_bModify.gridy = 11;
		panel_2.add(bModify, gbc_bModify);	
	}
	
	void setStyle(){
		tfProfNo.setEditable(false);
	}
	
	void eventProc(){
		bProfSearch.addActionListener(this);
//		bRegister.addActionListener(this);
		bModify.addActionListener(this);
//		bDelete.addActionListener(this);
		
		tableProf.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tableProf.getSelectedRow();
				int col = 0;
				int pNo = (Integer)tableProf.getValueAt(row, col);
				Professor prof = new Professor();
				
				try {
					prof = profmodel.selectByPf(pNo);
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "±³¼ö°Ë»ö ½ÇÆÐ" + e2.getMessage());
				}
				
				tfProfNo.setText(String.valueOf(prof.getProfno()));
				tfProfName.setText(prof.getProfname());
				tfProfTel.setText(prof.getProftel());
				tfProfOffice.setText(prof.getProfoffice());
				tfMajName.setText(prof.getMajname());
				
				tfMajName.setEditable(false);
			}
		});
	}
	
	public void actionPerformed(ActionEvent ev) {
		Object o = ev.getSource();
		if( o == bProfSearch) {
			selectTable();
			clearScreen();
		}else if (o == bModify) {
			
			int profno = Integer.parseInt(tfProfNo.getText());
			String profname = tfProfName.getText();
			String proftel = tfProfTel.getText();
			String profoffice = tfProfOffice.getText();
			String majname = tfMajName.getText();
			
			Professor prof = new Professor();
			prof.setProfno(profno);
			prof.setProfname(profname);
			prof.setProftel(proftel);
			prof.setProfoffice(profoffice);
			prof.setMajname(majname);
			
			try {
				profmodel.modify(prof);
				JOptionPane.showMessageDialog(null, "¼öÁ¤ ¼º°ø");
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "¼öÁ¤ ½ÇÆÐ" + e.getMessage());
			}
			clearScreen();			
		}
	}
	
	public void clearScreen() {
		tfSearchProf.setText("");
		tfProfNo.setText("");
		tfProfName.setText("");
		tfProfTel.setText("");
		tfProfOffice.setText("");
		tfMajName.setText("");
	}
	
	void selectTable() {
		int sel = comProfSearch.getSelectedIndex();
		String text = tfSearchProf.getText();
		
		try {
			ArrayList list = profmodel.searchProf(sel, text);
			tmProfessor.data = list;
			tableProf.setModel(tmProfessor);
			tmProfessor.fireTableDataChanged();
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "°Ë»ö ½ÇÆÐ" + e.getMessage());
		}

	}
		
	class ProfListTableModel extends AbstractTableModel{

		ArrayList data = new ArrayList();
		String [] columnNames = { "±³¼ö ¹øÈ£", "ÀÌ¸§", "ÀüÈ­¹øÈ£", "±³¼ö »ç¹«½Ç", "ÇÐ°ú¸í"};

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
}
