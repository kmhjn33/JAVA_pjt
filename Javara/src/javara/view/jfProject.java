package javara.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Panel;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.security.auth.Subject;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JFormattedTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JSeparator;


import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

import javara.model.SubjectInfoModel;
import javara.model.rec.SubjectInfo;
import oracle.net.aso.i;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JList;
import java.awt.Scrollbar;
import java.awt.Component;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


import java.util.Locale;

public class jfProject extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtSiGoalSubject;
	private JTextField TXT_SI_BUDGET;
	private JTextField TXT_SI_PAY;
	private JTable TBL_SUBJECT;
	private JTextField textStuCount;
	private JTable TBL_SUBJECT_STU;
	private JTable TBL_STUDENT;
	private JComboBox cboPro;
	private JComboBox cboMajor;
	private JTextArea txtDetail;
	
	private SubjectInfoModel subject_model= new SubjectInfoModel();
	private String[] columnTitles= {"과제번호","과제타이틀","게시일","종료일","예산액","학과번호","교수번호"};
	private String[] columnSubjectStudent= {"과제번호" , "학생번호" ,"학생 이름"};
	private String[] columnStudent= {"학생번호" ,"학생 이름"};
	
	private ArrayList pro_list;
	private ArrayList major_list;

	private SubjectListTableModel subjectList = new SubjectListTableModel(columnTitles,0);
	private SubjectListTableModel subjectStudent = new SubjectListTableModel(columnSubjectStudent,0);
	private SubjectListTableModel modelStudent = new SubjectListTableModel(columnStudent,0);

	private JTextField textSTU_Name;
	private JTextField TXT_SI_NO;
	private JTextField textSDate;
	private JTextField textEDate;
	
	private JDateChooser dateStart;
	private JDateChooser dateEnd;
	

	
	/**
	 * Create the frame.
	 */
	public jfProject() {
		
		addlayout();
		initComboBox();
		Date date = new Date();
		dateStart.setDate(date);
		dateEnd.setDate(date);
		setVisible(true);
		setResizable(true);
		setClosable(true);
		setTitle("과제 기본 정보");
	}

	
	void initComboBox() {
		

	    		
		
	}
	
	void initDisplay() {
		TXT_SI_NO.setText("");    //(sj.getSi_no());
		txtTitle.setText("");
		txtSiGoalSubject.setText("");
		TXT_SI_BUDGET.setText("0");
		TXT_SI_PAY.setText("0");
		txtDetail.setText("");
		//textSDate.setText(sj.getSi_publishing_date().substring(0,10));
		//textEDate.setText(sj.getSi_end_date().substring(0,10));
	}
	
	void addlayout() {
		
		setBounds(100, 100, 1165, 799);
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
		
		JLabel lblNewLabel = new JLabel("\uACFC\uC81C\uC815\uBCF4");
		lblNewLabel.setBounds(12, 5, 124, 35);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_1.setBounds(5, 108, 437, 135);
		panel_1.setForeground(Color.WHITE);
		contentPane.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{23, 80, 21, 115, 80, 89, 0, 0};
		gbl_panel_1.rowHeights = new int[]{35, 35, 35, 35, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uACFC\uC81C \uBC88\uD638");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		TXT_SI_NO = new JTextField();
		GridBagConstraints gbc_TXT_SI_NO = new GridBagConstraints();
		gbc_TXT_SI_NO.insets = new Insets(0, 0, 5, 5);
		gbc_TXT_SI_NO.fill = GridBagConstraints.BOTH;
		gbc_TXT_SI_NO.gridx = 3;
		gbc_TXT_SI_NO.gridy = 0;
		panel_1.add(TXT_SI_NO, gbc_TXT_SI_NO);
		TXT_SI_NO.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("\uB2F4\uB2F9 \uAD50\uC218");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 4;
		gbc_lblNewLabel_10.gridy = 0;
		panel_1.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		
		this.pro_list=subject_model.SelectProfessor_info(0);
		cboPro = new JComboBox(pro_list.toArray());	
		GridBagConstraints gbc_cboPro = new GridBagConstraints();
		gbc_cboPro.gridwidth = 2;
		gbc_cboPro.insets = new Insets(0, 0, 5, 0);
		gbc_cboPro.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboPro.gridx = 5;
		gbc_cboPro.gridy = 0;
		panel_1.add(cboPro, gbc_cboPro);
		
		
		this.major_list= subject_model.SelectMajorInfo();
		cboMajor= new JComboBox(this.major_list.toArray());
		GridBagConstraints gbc_cboMajor = new GridBagConstraints();
		gbc_cboMajor.gridwidth = 4;
		gbc_cboMajor.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboMajor.gridx = 3;
		gbc_cboMajor.gridy = 3;
		panel_1.add(cboMajor, gbc_cboMajor);
		

		JLabel lblNewLabel_2 = new JLabel("\uACFC\uC81C \uC81C\uBAA9");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 1;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtTitle = new JTextField();
		GridBagConstraints gbc_txtTitle = new GridBagConstraints();
		gbc_txtTitle.gridwidth = 4;
		gbc_txtTitle.insets = new Insets(0, 0, 5, 0);
		gbc_txtTitle.fill = GridBagConstraints.BOTH;
		gbc_txtTitle.gridx = 3;
		gbc_txtTitle.gridy = 1;
		panel_1.add(txtTitle, gbc_txtTitle);
		txtTitle.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\uC218\uD589 \uACFC\uC81C \uBAA9\uD45C");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 2;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtSiGoalSubject = new JTextField();
		GridBagConstraints gbc_txtSiGoalSubject = new GridBagConstraints();
		gbc_txtSiGoalSubject.gridwidth = 4;
		gbc_txtSiGoalSubject.insets = new Insets(0, 0, 5, 0);
		gbc_txtSiGoalSubject.fill = GridBagConstraints.BOTH;
		gbc_txtSiGoalSubject.gridx = 3;
		gbc_txtSiGoalSubject.gridy = 2;
		panel_1.add(txtSiGoalSubject, gbc_txtSiGoalSubject);
		txtSiGoalSubject.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("\uD559\uACFC\uC815\uBCF4");
		lblNewLabel_9.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_9.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_9.gridx = 1;
		gbc_lblNewLabel_9.gridy = 3;
		panel_1.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(454, 108, 347, 135);
		contentPane.add(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{1, 58, 68, 81, 51, 90, 15, 0};
		gbl_panel_4.rowHeights = new int[]{1, 15, 15, 15, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblNewLabel_7 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 0;
		panel_4.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_5 = new JLabel("\uAC8C\uC2DC\uC77C");
		lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 1;
		panel_4.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textSDate = new JTextField();
		GridBagConstraints gbc_textSDate = new GridBagConstraints();
		gbc_textSDate.gridwidth = 2;
		gbc_textSDate.insets = new Insets(0, 0, 5, 5);
		gbc_textSDate.fill = GridBagConstraints.BOTH;
		gbc_textSDate.gridx = 2;
		gbc_textSDate.gridy = 1;
		panel_4.add(textSDate, gbc_textSDate);
		textSDate.setColumns(10);
		
		dateStart = new JDateChooser();
		dateStart.setDateFormatString("yyyy-MM-dd");
		GridBagConstraints gbc_dateStart = new GridBagConstraints();
		gbc_dateStart.gridwidth = 2;
		gbc_dateStart.insets = new Insets(0, 0, 5, 5);
		gbc_dateStart.fill = GridBagConstraints.BOTH;
		gbc_dateStart.gridx = 4;
		gbc_dateStart.gridy = 1;
		panel_4.add(dateStart, gbc_dateStart);
		
		JLabel lblNewLabel_12 = new JLabel("\uC885\uB8CC\uC77C");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 1;
		gbc_lblNewLabel_12.gridy = 2;
		panel_4.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		textEDate = new JTextField();
		GridBagConstraints gbc_textEDate = new GridBagConstraints();
		gbc_textEDate.gridwidth = 2;
		gbc_textEDate.insets = new Insets(0, 0, 5, 5);
		gbc_textEDate.fill = GridBagConstraints.BOTH;
		gbc_textEDate.gridx = 2;
		gbc_textEDate.gridy = 2;
		panel_4.add(textEDate, gbc_textEDate);
		textEDate.setColumns(10);
		
		dateEnd = new JDateChooser();
		dateEnd.setDateFormatString("yyyy-MM-dd");
		GridBagConstraints gbc_dateEnd = new GridBagConstraints();
		gbc_dateEnd.gridwidth = 2;
		gbc_dateEnd.insets = new Insets(0, 0, 5, 5);
		gbc_dateEnd.fill = GridBagConstraints.BOTH;
		gbc_dateEnd.gridx = 4;
		gbc_dateEnd.gridy = 2;
		panel_4.add(dateEnd, gbc_dateEnd);
		
		JLabel lblNewLabel_6 = new JLabel("\uC608\uC0B0");
		lblNewLabel_6.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 3;
		panel_4.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		TXT_SI_BUDGET = new JTextField();
		GridBagConstraints gbc_TXT_SI_BUDGET = new GridBagConstraints();
		gbc_TXT_SI_BUDGET.gridwidth = 4;
		gbc_TXT_SI_BUDGET.insets = new Insets(0, 0, 5, 5);
		gbc_TXT_SI_BUDGET.fill = GridBagConstraints.BOTH;
		gbc_TXT_SI_BUDGET.gridx = 2;
		gbc_TXT_SI_BUDGET.gridy = 3;
		panel_4.add(TXT_SI_BUDGET, gbc_TXT_SI_BUDGET);
		TXT_SI_BUDGET.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\uAC1C\uBCC4\uC218\uB2F9");
		lblNewLabel_8.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 4;
		panel_4.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		TXT_SI_PAY = new JTextField();
		GridBagConstraints gbc_TXT_SI_PAY = new GridBagConstraints();
		gbc_TXT_SI_PAY.gridwidth = 2;
		gbc_TXT_SI_PAY.insets = new Insets(0, 0, 5, 5);
		gbc_TXT_SI_PAY.fill = GridBagConstraints.BOTH;
		gbc_TXT_SI_PAY.gridx = 2;
		gbc_TXT_SI_PAY.gridy = 4;
		panel_4.add(TXT_SI_PAY, gbc_TXT_SI_PAY);
		TXT_SI_PAY.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("\uCC38\uC5EC\uC778\uC6D0");
		lblNewLabel_11.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_11.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 4;
		gbc_lblNewLabel_11.gridy = 4;
		panel_4.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		textStuCount = new JTextField();
		GridBagConstraints gbc_textStuCount = new GridBagConstraints();
		gbc_textStuCount.insets = new Insets(0, 0, 5, 5);
		gbc_textStuCount.fill = GridBagConstraints.BOTH;
		gbc_textStuCount.gridx = 5;
		gbc_textStuCount.gridy = 4;
		panel_4.add(textStuCount, gbc_textStuCount);
		textStuCount.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(990, 47, 159, 51);
		contentPane.add(panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{16, 0, 0, 0};
		gbl_panel_6.rowHeights = new int[]{23, 0, 0, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JButton btnSearch = new JButton("\uC870\uD68C");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectSubjectList();
//				selectSubjectStuList(0);
//				selectStuList("");
			}
		});
		
		JButton btnSave = new JButton("\uC800\uC7A5");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				registSubjectInfo();
				selectSubjectList();
				initDisplay();
				
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.anchor = GridBagConstraints.EAST;
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 1;
		panel_6.add(btnSave, gbc_btnSave);
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearch.anchor = GridBagConstraints.EAST;
		gbc_btnSearch.gridx = 2;
		gbc_btnSearch.gridy = 1;
		panel_6.add(btnSearch, gbc_btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1140, 746, -1133, -340);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(5, 404, 1139, 356);
		contentPane.add(scrollPane_1);
		
		
		
		TBL_SUBJECT = new JTable(subjectList);
		TBL_SUBJECT.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row=TBL_SUBJECT.getSelectedRow();
				selectSubjectStuList((int)TBL_SUBJECT.getValueAt(row, 0));
				selectSubject((int)TBL_SUBJECT.getValueAt(row, 0));
			}
		});
		scrollPane_1.setViewportView(TBL_SUBJECT);
		JTableHeader header =TBL_SUBJECT.getTableHeader();
      //TBL_SUBJECT.setFont(font15);
      	TBL_SUBJECT.setRowHeight(30);
      	TBL_SUBJECT.setFillsViewportHeight(true);
      	TBL_SUBJECT.setBackground(Color.WHITE);
      	TBL_SUBJECT.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
      	
      	JScrollPane scrollPane_2 = new JScrollPane();
      	scrollPane_2.setBounds(5, 253, 796, 139);
      	contentPane.add(scrollPane_2);
      	
      	txtDetail = new JTextArea();
      	scrollPane_2.setViewportView(txtDetail);
      	
      	JLabel lblNewLabel_4 = new JLabel("\uACFC\uC81C \uC0C1\uC138 \uB0B4\uC6A9");
      	scrollPane_2.setColumnHeaderView(lblNewLabel_4);
      	lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 12));
      	lblNewLabel_4.setBackground(Color.WHITE);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setViewportBorder(null);
		scrollPane_3.setToolTipText("\uCC38\uC5EC\uC790 \uC815\uBCF4");
		scrollPane_3.setBounds(810, 253, 327, 139);
		contentPane.add(scrollPane_3);
		
		TBL_SUBJECT_STU = new JTable(subjectStudent);
		TBL_SUBJECT_STU.setToolTipText("\uC624\uB978\uCABD \uB9C8\uC6B0\uC2A4 \uD074\uB9AD");
		scrollPane_3.setViewportView(TBL_SUBJECT_STU);
		JTableHeader subject_stu_header =TBL_SUBJECT_STU.getTableHeader();
		TBL_SUBJECT_STU.setRowHeight(30);
		TBL_SUBJECT_STU.setFillsViewportHeight(true);
		TBL_SUBJECT_STU.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TBL_SUBJECT_STU.setBackground(Color.WHITE);
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		addPopup(TBL_SUBJECT_STU, popupMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\uACFC\uC81C \uCC38\uC5EC \uC911\uB2E8");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("mntmNewMenuItem  mousePressed 이벤트 발생");
				String stu_no=TBL_SUBJECT_STU.getValueAt(TBL_SUBJECT_STU.getSelectedRow(),1).toString();
				System.out.println("선택학생 고유번호 : " + stu_no);
				removeStudentBySubJectNo(stu_no);
			}
		});
		popupMenu_1.add(mntmNewMenuItem_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(813, 108, 324, 23);
		contentPane.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{130, 64, 78, 51, 0};
		gbl_panel_2.rowHeights = new int[]{15, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_10_1 = new JLabel("\uD559\uC0DD \uAC80\uC0C9");
		lblNewLabel_10_1.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_10_1 = new GridBagConstraints();
		gbc_lblNewLabel_10_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_10_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_10_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_10_1.gridx = 0;
		gbc_lblNewLabel_10_1.gridy = 0;
		panel_2.add(lblNewLabel_10_1, gbc_lblNewLabel_10_1);
		lblNewLabel_10_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		textSTU_Name = new JTextField();
		GridBagConstraints gbc_textSTU_Name = new GridBagConstraints();
		gbc_textSTU_Name.gridwidth = 2;
		gbc_textSTU_Name.insets = new Insets(0, 0, 0, 5);
		gbc_textSTU_Name.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSTU_Name.gridx = 1;
		gbc_textSTU_Name.gridy = 0;
		panel_2.add(textSTU_Name, gbc_textSTU_Name);
		textSTU_Name.setColumns(10);
		
		JButton btnNewButton = new JButton("\uD559\uC0DD \uAC80\uC0C9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textSTU_Name.getText();
				System.out.println("검색 학생 이름 : " +  name);
				selectStuList(name);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 0;
		panel_2.add(btnNewButton, gbc_btnNewButton);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_4.setBounds(813, 135, 324, 93);
		contentPane.add(scrollPane_4);
		
		TBL_STUDENT = new JTable(modelStudent);
		TBL_STUDENT.setToolTipText("\uC624\uB978\uCABD \uB9C8\uC6B0\uC2A4 \uD074\uB9AD");
		scrollPane_4.setViewportView(TBL_STUDENT);
		TBL_STUDENT.setRowHeight(30);
		TBL_STUDENT.setFillsViewportHeight(true);
		TBL_STUDENT.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TBL_STUDENT.setBackground(Color.WHITE);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(TBL_STUDENT, popupMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\uCC38\uC5EC \uD559\uC0DD \uCD94\uAC00");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("mntmNewMenuItem  mousePressed 이벤트 발생");
				//String stu_no=TBL_STUDENT.getValueAt(TBL_STUDENT.getSelectedRow(),TBL_STUDENT.getSelectedColumn()).toString();
				String stu_no=TBL_STUDENT.getValueAt(TBL_STUDENT.getSelectedRow(),0).toString();
				System.out.println("선택학생 고유번호 : " + stu_no);
				registStudentBySubJectNo(stu_no);	
		
			}
		});
		popupMenu.add(mntmNewMenuItem);
	
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(813, 233, 324, 23);
		contentPane.add(panel_2_1);
		GridBagLayout gbl_panel_2_1 = new GridBagLayout();
		gbl_panel_2_1.columnWidths = new int[]{130, 64, 78, 51, 0};
		gbl_panel_2_1.rowHeights = new int[]{15, 0};
		gbl_panel_2_1.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2_1.setLayout(gbl_panel_2_1);
		
		JLabel lblNewLabel_10_1_1 = new JLabel("\uCC38\uC5EC \uD559\uC0DD");
		lblNewLabel_10_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10_1_1.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_10_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_10_1_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_10_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_10_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_10_1_1.gridx = 0;
		gbc_lblNewLabel_10_1_1.gridy = 0;
		panel_2_1.add(lblNewLabel_10_1_1, gbc_lblNewLabel_10_1_1);
		

	}
	
	void selectSubjectList() {
		try {
			ArrayList list = new ArrayList();
			list=subject_model.search();
		 	subjectList= new SubjectListTableModel(columnTitles,list);
		 	//TBL_SUBJECT = new JTable(subjectList);
			this.TBL_SUBJECT.setModel(subjectList);
			subjectList.fireTableDataChanged();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	void selectSubjectStuList(int Subject_No) {
		try {
			ArrayList list = new ArrayList();
			list=subject_model.searchStudentBySubJectNo(Subject_No);
		 	subjectStudent= new SubjectListTableModel(columnSubjectStudent,list);
		 	//TBL_SUBJECT = new JTable(subjectList);
			this.TBL_SUBJECT_STU.setModel(subjectStudent);
			subjectStudent.fireTableDataChanged();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	void selectStuList(String stu_name) {
		try {
			ArrayList list = new ArrayList();
			list=subject_model.searchStudentByname(stu_name);
		 	modelStudent= new SubjectListTableModel(columnStudent,list);
		 	//TBL_SUBJECT = new JTable(subjectList);
			this.TBL_STUDENT.setModel(modelStudent);
			modelStudent.fireTableDataChanged();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
		
	}
	
	void selectSubject(int si_no) {
		DisplaySubjectInfo(subject_model.searchbySI_No(si_no));
	}
	public void DisplaySubjectInfo(SubjectInfo sj) {
		try {
			TXT_SI_NO.setText(String.valueOf(sj.getSi_no()));    //(sj.getSi_no());
			txtTitle.setText(sj.getSi_title());
			txtSiGoalSubject.setText(sj.getSi_goal_subject());
			TXT_SI_BUDGET.setText(sj.getSi_budget().toString());
			TXT_SI_PAY.setText(sj.getSi_pay().toString());
			txtDetail.setText(sj.getSi_detail());
			textSDate.setText(sj.getSi_publishing_date().substring(0,10));
			textEDate.setText(sj.getSi_end_date().substring(0,10));
			//dateStart.getJCalendar().getDayChooser().setDays(sj.getSi_publishing_date());
			//dateEnd.setDate((java.util.Date) sj.getSi_end_date());
			
			
			for (int i=0, n=pro_list.size(); i < n; i++) {
	                    
				String[] proinfo=cboPro.getItemAt(i).toString().split("-");
				int proinfo_no=Integer.valueOf(proinfo[0].toString().replace("[", ""));
				
	            if (proinfo_no==sj.getProf_no()) {
	            	cboPro.setSelectedIndex(i);
	            	break;
	            }
				
	        }
			
			for (int i=0, n=pro_list.size(); i < n; i++) {
                
				String[] majorinfo=cboMajor.getItemAt(i).toString().split("-");
				int major_no=Integer.valueOf(majorinfo[0].toString().replace("[", ""));
				
	            if (major_no==sj.getMaj_no()) {
	            	cboMajor.setSelectedIndex(i);
	            	break;
	            }
				
	        }
			textStuCount.setText(String.valueOf(TBL_SUBJECT_STU.getRowCount()));
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("오류가 발생하였습니다" + e.getMessage());
			
		}
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	private void registStudentBySubJectNo(String stu_no) {
		
		try {
				String intsubject_no = TXT_SI_NO.getText();
				System.out.println("과제정보 : " + intsubject_no);
				if(intsubject_no=="") {
					System.out.println("대상 과제 정보가 없어요~ 히힝");
					return;
				}else {
					System.out.println("학생정보 : " + stu_no + " 과제정보 : " + intsubject_no);
					subject_model.registStudentBySubJectNo(Integer.valueOf(intsubject_no),Integer.valueOf(stu_no));
					System.out.println("과제 학생정보가 추가되었습니다.");
				}
				selectSubjectStuList(Integer.valueOf(intsubject_no));
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("과제 학생 정보가 추가 실패 : " + e.getMessage());
			}
	}
	private void removeStudentBySubJectNo(String stu_no) {
		
		try {
				String intsubject_no = TXT_SI_NO.getText();
				System.out.println("과제정보 : " + intsubject_no);
				if(intsubject_no=="") {
					System.out.println("대상 과제 정보가 없어요~ 히힝");
					return;
				}else {
					System.out.println("학생정보 : " + stu_no + " 과제정보 : " + intsubject_no);
					subject_model.removeStudentBySubJectNo(Integer.valueOf(intsubject_no),Integer.valueOf(stu_no));
					System.out.println("과제 참여 정보가 삭제되었습니다.");
				}
		
				selectSubjectStuList(Integer.valueOf(intsubject_no));
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("과제 참여 정보 삭제 실패 : " + e.getMessage());
			}
	}
	private void registSubjectInfo() {
		try {
			SubjectInfo subject = new SubjectInfo();
			
			if(TXT_SI_NO.getText().length()==0) {
				subject.setSi_no(0);
			}else {
				subject.setSi_no(Integer.valueOf(TXT_SI_NO.getText()));
			}
			
			subject.setSi_title(txtTitle.getText());
			
			subject.setSi_goal_subject(txtSiGoalSubject.getText());
			
			if(TXT_SI_BUDGET.getText()=="") {
				subject.setSi_budget(0.0);
			}else {
				subject.setSi_budget(Double.valueOf(TXT_SI_BUDGET.getText()));
			}
			
			if(TXT_SI_PAY.getText()=="") {
				subject.setSi_pay(0.0);
			}else {
				subject.setSi_pay(Double.valueOf(TXT_SI_PAY.getText()));
			}
			
			subject.setSi_detail(txtDetail.getText());
			
			String[] proinfo=cboPro.getSelectedItem().toString().split("-");
			int proinfo_no=Integer.valueOf(proinfo[0].toString().replace("[", ""));
			subject.setProf_no(proinfo_no);
			
			String[] majorinfo=cboMajor.getSelectedItem().toString().split("-");
			int major_no=Integer.valueOf(majorinfo[0].toString().replace("[", ""));
			subject.setMaj_no(major_no);
			
			
			DateFormat df =new SimpleDateFormat("yyyy-MM-dd");
			textSDate.setText(df.format(dateStart.getDate()));
			subject.setSi_publishing_date(textSDate.getText());
			
			textEDate.setText(df.format(dateEnd.getDate()));
			subject.setSi_end_date(textEDate.getText());		
			
			
			
			
			
			
			if (subject.getSi_no()==0) {
				subject_model.regist(subject);	
			}else {
				subject_model.modify(subject);
			}
			initDisplay();
			
			
			//textSDate.setText(df.format(dateStart.getCalendar().DATE));
			
			//Date ed = dateEnd.getdate();
			//textEDate.setText(df.format(dateEnd.getDate()));
			
			//textSDate.setText(sj.getSi_publishing_date().toString());
			//textEDate.setText(sj.getSi_end_date().toString());
			

		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("과제 참여 정보 추가 실패 : " + e.getMessage());
		}
	}
}