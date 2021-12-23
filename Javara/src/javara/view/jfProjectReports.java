package javara.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import com.toedter.components.JSpinField;

import javara.model.SubjectReportsModel;
import javara.model.rec.SubjectDivision;
import javara.model.rec.SubjectReports;

import javax.swing.JComboBox;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JCheckBox;

import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;


public class jfProjectReports extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtReportDate;
	private JTextField txtReportTitle;
	private JTextField txtTestDate;
	private JTextField txtLoc;
	private JTextField txtPurpose;
	private JTextField txtMethod;
	private JTextField txtNote;
	private JTable TBL_REPORT;
	private JTextField txtDNo;
	private JTextPane txtSRNo;
	
	private JTextArea txtDetailInfo;
	private JTextArea txtProgress;
	
	private JOptionPane msg=new JOptionPane();
	
	private JComboBox cboMajor;
	private JComboBox cboSubject;
	private JComboBox cboStu;
	private JSpinner countPeople;
	private JSpinner spinCount;
	private JTextArea txtResult;
	
	private JDateChooser dateReport;
	private JDateChooser dateTest;

	private SubjectReportsModel report_model = new SubjectReportsModel();
	private String[] columnTitles= {"보고서NO","제출일자","제목","실험일자","실험장소"};
	private SubjectListTableModel plan_list = new SubjectListTableModel(columnTitles,0);
	private JTextField txtManager;
	

	void selectDivisionInfo() {
		
	}
	void Display_DivisionInfo(SubjectDivision di ) {
		
		try {

			
			if (di.getSd_no()==0) {
				txtDNo.setText("0");
				this.txtManager.setText("");
				this.txtTitle.setText("");
				this.txtDetailInfo.setText("");
			}else {
				//조회 정보 표시
				this.txtDNo.setText(String.valueOf(di.getSd_no()));
				this.txtManager.setText(di.getSd_Confirm_Manager());
				this.txtTitle.setText(di.getSd_title());
				this.txtDetailInfo.setText(di.getSd_title());
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("화면 정보 표시 오류 SubjectDivision :" +  e.getMessage());
		}
	}
	
	void Save_DivisionInfo() {
		
		if (cboStu.getItemCount()==0){
			System.out.println("업무 분담 정보 추가/수정 실패 : 학생정보가 없습니다.");
			return;
		}else {
		
		
		try {
			
			
				SubjectDivision sd =new SubjectDivision();
				
				if (txtDNo.getText()=="") {
					sd.setSd_no(0);
				}else {
					sd.setSd_no(Integer.valueOf( txtDNo.getText()));
				}
				sd.setSd_Confirm_Manager(this.txtManager.getText());
				sd.setSd_title(this.txtTitle.getText());
				sd.setSd_detail_info(this.txtTitle.getText());
				String[] stuinfo=cboStu.getSelectedItem().toString().split("-");
				int stuno=Integer.valueOf(stuinfo[0].toString().replace("[", ""));
				sd.setStu_no(stuno);
				
				String[] subjectinfo=cboSubject.getSelectedItem().toString().split("-");
				int subjectno=Integer.valueOf(subjectinfo[0].toString().replace("[", ""));
				sd.setSi_no(subjectno);
				
				
				if (sd.getSd_no()==0) {
					report_model.registDivision(sd);
				}else {
					report_model.modifyDivision(sd);
				}
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("분담정보 저장 실패 : " + e.getMessage());
			}
		}
	}
	
	
	void selectSubjectReportList() {
		try {
			ArrayList list = new ArrayList();
			list=report_model.searchSubjectReportBySD_No(Integer.valueOf(txtDNo.getText()));
		 	plan_list= new SubjectListTableModel(columnTitles,list);
		 	//TBL_SUBJECT = new JTable(subjectList);
			this.TBL_REPORT.setModel(plan_list);
			plan_list.fireTableDataChanged();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	private SubjectReports SetObjectReportInfo() {
		
		SubjectReports Sr = new SubjectReports();
		try {
			
			Sr.setSr_no(Integer.valueOf(txtSRNo.getText()));							// 과제보고서 고유번호
			
			DateFormat df =new SimpleDateFormat("yyyy-MM-dd");
			txtReportDate.setText(df.format(this.dateReport.getDate()));
			Sr.setSr_report_date(txtReportDate.getText());                 // 보고일자
			
			txtTestDate.setText(df.format(this.dateTest.getDate()));
			Sr.setSr_experimen_date(txtTestDate.getText());              // 실험일자
	
			Sr.setSr_participant(Integer.valueOf(countPeople.getValue().toString()));                  // 참여인원
			Sr.setSr_title(txtTitle.getText());                     // 보고서 타이틀
			Sr.setSr_laboflocate(txtLoc.getText());               // 실험장소
			Sr.setSr_purpose(txtPurpose.getText());                   // 실험목적
			Sr.setSr_repetitions(Integer.valueOf(this.spinCount.getValue().toString()));                  // 실험 반복 횟수
			Sr.setSr_simulationmethod(txtMethod.getText());          // 실험 기법
			Sr.setSr_experimentalprocedure(this.txtProgress.getText());     // 실험 과정
			Sr.setSr_simulationresult(txtResult.getText());          // 실험결과
			Sr.setSr_note(txtNote.getText()); // 기타추가사항
			Sr.setSd_no(Integer.valueOf(txtDNo.getText()));                      // 업무분담 고유 번호
			
			
		}catch (Exception e) {
			// TODO: handle exception
			msg.showMessageDialog(null,"오류발생" + e.getMessage());
		}
		return Sr;
		
	}
	
	
	private void GetObjectReportInfo(SubjectReports Sr) {
		try {	
			txtSRNo.setText(String.valueOf(Sr.getSr_no()));							// 과제보고서 고유번호
			txtReportDate.setText(Sr.getSr_report_date());                 // 보고일자
			txtTestDate.setText(Sr.getSr_experimen_date());              // 실험일자
	
			countPeople.setValue(Sr.getSr_participant());                  // 참여인원
			txtTitle.setText(Sr.getSr_title());                     // 보고서 타이틀
			txtLoc.setText(Sr.getSr_laboflocate());               // 실험장소
			txtPurpose.setText(Sr.getSr_purpose());                   // 실험목적
			spinCount.setValue(Sr.getSr_repetitions());                  // 실험 반복 횟수
			txtMethod.setText(Sr.getSr_simulationmethod());          // 실험 기법
			txtProgress.setText(Sr.getSr_experimentalprocedure());     // 실험 과정
			txtResult.setText(Sr.getSr_simulationresult());          // 실험결과
			txtNote.setText(Sr.getSr_note()); // 기타추가사항
			txtDNo.setText(String.valueOf(Sr.getSd_no()));                      // 업무분담 고유 번호
		}catch (Exception e) {
			// TODO: handle exception
			msg.showMessageDialog(null,"오류발생" + e.getMessage());
		}
		
	}
	
	private void initReportInfo() {
		try {	
			txtSRNo.setText("0");							// 과제보고서 고유번호
			txtTitle.setText("");                     // 보고서 타이틀
			txtLoc.setText("");               // 실험장소
			txtPurpose.setText("");                   // 실험목적
			countPeople.setValue(1);
			spinCount.setValue(1);                  // 실험 반복 횟수
			txtMethod.setText("");          // 실험 기법
			txtProgress.setText("");     // 실험 과정
			txtResult.setText("");          // 실험결과
			txtNote.setText(""); // 기타추가사항
			txtDNo.setText("");                      // 업무분담 고유 번호
		}catch (Exception e) {
			// TODO: handle exception
			msg.showMessageDialog(null,"오류발생" + e.getMessage());
		}
		
	}

	/**
	 * Create the frame.
	 */
	public jfProjectReports() {
		
		
		addlayout();
		txtSRNo.setText("0");
		txtDNo.setText("0");
		DateFormat df =new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		dateReport.setDate(date);
		dateTest.setDate(date);
		txtReportDate.setText(df.format(this.dateReport.getDate()));	
		txtTestDate.setText(df.format(this.dateTest.getDate()));
		setVisible(true);
		setClosable(true);
		setTitle("과제 리포트 제출");
	}
	
	
	
	
	public void addlayout() {
		setBounds(100, 100, 1362, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{13, 0, 28, 24, 0, 0, 0, 0, 65, 116, 0, 0, 0, 114, 76, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{30, 30, 30, 89, 3, 30, 121, 91, 30, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 25;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{286, 124, 0};
		gbl_panel.rowHeights = new int[]{35, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("  \uACFC\uC81C \uB9AC\uD3EC\uD2B8 \uC81C\uCD9C");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC5C5\uBB34 \uBD84\uB2F4 \uB4F1\uB85D");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uD559\uACFC \uC120\uD0DD");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 1;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		

		cboMajor = new JComboBox(report_model.SelectMajorInfo().toArray());
		cboMajor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cboSubject.removeAllItems();
				if (cboMajor.getItemCount() > 0) {
					cboStu.removeAllItems();
					String[] majorinfo=cboMajor.getSelectedItem().toString().split("-");
					int major_no=Integer.valueOf(majorinfo[0].toString().replace("[", ""));
					
					ArrayList list = new ArrayList();
					list=report_model.searchSubjectInfobyMajorNo(major_no);
					if (list.size() > 0 ) { 
						for(int i=0;i<list.size();i++) {
							cboSubject.addItem(list.get(i).toString());
						}
					}
				}
				
			}
		});
		
		txtDNo = new JTextField();
		txtDNo.setEditable(false);
		GridBagConstraints gbc_txtDNo = new GridBagConstraints();
		gbc_txtDNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtDNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDNo.gridx = 2;
		gbc_txtDNo.gridy = 1;
		contentPane.add(txtDNo, gbc_txtDNo);
		txtDNo.setColumns(10);
		GridBagConstraints gbc_cboMajor = new GridBagConstraints();
		gbc_cboMajor.gridwidth = 2;
		gbc_cboMajor.insets = new Insets(0, 0, 5, 5);
		gbc_cboMajor.fill = GridBagConstraints.BOTH;
		gbc_cboMajor.gridx = 8;
		gbc_cboMajor.gridy = 1;
		contentPane.add(cboMajor, gbc_cboMajor);
		
		JLabel lblNewLabel_3 = new JLabel("\uCC38\uC5EC \uACFC\uC81C \uC120\uD0DD");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 10;
		gbc_lblNewLabel_3.gridy = 1;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		cboSubject = new JComboBox();
		cboSubject.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// 참여자 정보 가져오기
				if (cboSubject.getItemCount() > 0 ) {
					cboStu.removeAllItems();
					String[] subjectinfo=cboSubject.getSelectedItem().toString().split("-");
					int subjectno=Integer.valueOf(subjectinfo[0].toString().replace("[", ""));
					ArrayList list=new ArrayList();
					list=report_model.searchStudentInfobySubjectNo(subjectno);
					if (list.size() > 0) {
						for(int i=0;i<list.size();i++) {
							cboStu.addItem(list.get(i).toString());
						}
					}
				}
				
			}
		});
		GridBagConstraints gbc_cboSubject = new GridBagConstraints();
		gbc_cboSubject.gridwidth = 3;
		gbc_cboSubject.insets = new Insets(0, 0, 5, 5);
		gbc_cboSubject.fill = GridBagConstraints.BOTH;
		gbc_cboSubject.gridx = 11;
		gbc_cboSubject.gridy = 1;
		contentPane.add(cboSubject, gbc_cboSubject);
		
		JLabel lblNewLabel_4 = new JLabel("\uCC38\uC5EC\uC790 \uC120\uD0DD");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 14;
		gbc_lblNewLabel_4.gridy = 1;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		cboStu = new JComboBox();
		cboStu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//SubjectDivision 정보 저장
				if (cboStu.getItemCount() > 0) {
					String[] subjectinfo=cboSubject.getSelectedItem().toString().split("-");
					int subjectno=Integer.valueOf(subjectinfo[0].toString().replace("[", ""));
					
					String[] stuinfo=cboStu.getSelectedItem().toString().split("-");
					int stuno=Integer.valueOf(stuinfo[0].toString().replace("[", ""));
					SubjectDivision Divisioninfo = new SubjectDivision();
					Divisioninfo=report_model.searchDivisionInfo(subjectno,stuno);
					Display_DivisionInfo(Divisioninfo);
					txtDNo.setText(String.valueOf(Divisioninfo.getSd_no()));
					report_model.searchSubjectReportBySD_No(Divisioninfo.getSd_no());
					selectSubjectReportList();
				}
			}
		});
		GridBagConstraints gbc_cboStu = new GridBagConstraints();
		gbc_cboStu.gridwidth = 5;
		gbc_cboStu.insets = new Insets(0, 0, 5, 5);
		gbc_cboStu.fill = GridBagConstraints.BOTH;
		gbc_cboStu.gridx = 15;
		gbc_cboStu.gridy = 1;
		contentPane.add(cboStu, gbc_cboStu);
		
		JLabel lblNewLabel_18 = new JLabel("\uAD00\uB9AC\uC790");
		GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
		gbc_lblNewLabel_18.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_18.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_18.gridx = 20;
		gbc_lblNewLabel_18.gridy = 1;
		contentPane.add(lblNewLabel_18, gbc_lblNewLabel_18);
		
		txtManager = new JTextField();
		GridBagConstraints gbc_txtManager = new GridBagConstraints();
		gbc_txtManager.gridwidth = 3;
		gbc_txtManager.insets = new Insets(0, 0, 5, 5);
		gbc_txtManager.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtManager.gridx = 21;
		gbc_txtManager.gridy = 1;
		contentPane.add(txtManager, gbc_txtManager);
		txtManager.setColumns(10);
		
		JButton btnSAVE = new JButton("\uBD84\uB2F4 \uC815\uBCF4 \uC800\uC7A5");
		btnSAVE.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 업무 분담 정보 저장
				Save_DivisionInfo();
			}
		});
		GridBagConstraints gbc_btnSAVE = new GridBagConstraints();
		gbc_btnSAVE.anchor = GridBagConstraints.EAST;
		gbc_btnSAVE.insets = new Insets(0, 0, 5, 0);
		gbc_btnSAVE.gridx = 24;
		gbc_btnSAVE.gridy = 1;
		contentPane.add(btnSAVE, gbc_btnSAVE);
		
		JLabel lblNewLabel_5 = new JLabel("\uB2F4\uB2F9 \uACFC\uC81C \uC5C5\uBB34");
		lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 2;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		txtTitle = new JTextField();
		GridBagConstraints gbc_txtTitle = new GridBagConstraints();
		gbc_txtTitle.gridwidth = 22;
		gbc_txtTitle.insets = new Insets(0, 0, 5, 0);
		gbc_txtTitle.fill = GridBagConstraints.BOTH;
		gbc_txtTitle.gridx = 3;
		gbc_txtTitle.gridy = 2;
		contentPane.add(txtTitle, gbc_txtTitle);
		txtTitle.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\uC5F0\uAD6C \uC0C1\uC138 \uD56D\uBAA9");
		lblNewLabel_6.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 3;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridwidth = 22;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 3;
		gbc_scrollPane_1.gridy = 3;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		
		txtDetailInfo = new JTextArea();
		scrollPane_1.setViewportView(txtDetailInfo);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uC5F0\uAD6C \uB9AC\uD3EC\uD2B8 \uC81C\uCD9C");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 4;
		contentPane.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		JLabel lblNewLabel_7 = new JLabel("\uC81C\uCD9C\uC77C\uC790");
		lblNewLabel_7.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 4;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		txtSRNo = new JTextPane();
		txtSRNo.setEditable(false);
		txtSRNo.setText("0");
		GridBagConstraints gbc_txtSRNo = new GridBagConstraints();
		gbc_txtSRNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtSRNo.fill = GridBagConstraints.BOTH;
		gbc_txtSRNo.gridx = 2;
		gbc_txtSRNo.gridy = 4;
		contentPane.add(txtSRNo, gbc_txtSRNo);
		
		txtReportDate = new JTextField();
		GridBagConstraints gbc_txtReportDate = new GridBagConstraints();
		gbc_txtReportDate.gridwidth = 6;
		gbc_txtReportDate.insets = new Insets(0, 0, 5, 5);
		gbc_txtReportDate.fill = GridBagConstraints.BOTH;
		gbc_txtReportDate.gridx = 3;
		gbc_txtReportDate.gridy = 4;
		contentPane.add(txtReportDate, gbc_txtReportDate);
		txtReportDate.setColumns(10);
		
		dateReport = new JDateChooser();
		dateReport.setDateFormatString("yyyy-MM-dd");
		GridBagConstraints gbc_dateReport = new GridBagConstraints();
		gbc_dateReport.insets = new Insets(0, 0, 5, 5);
		gbc_dateReport.fill = GridBagConstraints.BOTH;
		gbc_dateReport.gridx = 9;
		gbc_dateReport.gridy = 4;
		contentPane.add(dateReport, gbc_dateReport);
		
		JLabel lblNewLabel_8 = new JLabel("\uC218\uD589\uC778\uC6D0");
		lblNewLabel_8.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 10;
		gbc_lblNewLabel_8.gridy = 4;
		contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		countPeople = new JSpinner();
		GridBagConstraints gbc_countPeople = new GridBagConstraints();
		gbc_countPeople.fill = GridBagConstraints.VERTICAL;
		gbc_countPeople.insets = new Insets(0, 0, 5, 5);
		gbc_countPeople.gridx = 11;
		gbc_countPeople.gridy = 4;
		contentPane.add(countPeople, gbc_countPeople);
		
		JLabel lblNewLabel_9 = new JLabel("\uACFC\uC81C \uC81C\uBAA9");
		lblNewLabel_9.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_9.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 12;
		gbc_lblNewLabel_9.gridy = 4;
		contentPane.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		txtReportTitle = new JTextField();
		GridBagConstraints gbc_txtReportTitle = new GridBagConstraints();
		gbc_txtReportTitle.gridwidth = 11;
		gbc_txtReportTitle.insets = new Insets(0, 0, 5, 5);
		gbc_txtReportTitle.fill = GridBagConstraints.BOTH;
		gbc_txtReportTitle.gridx = 13;
		gbc_txtReportTitle.gridy = 4;
		contentPane.add(txtReportTitle, gbc_txtReportTitle);
		txtReportTitle.setColumns(10);
		
		JButton btnReportSave = new JButton("\uB9AC\uD3EC\uD2B8 \uC81C\uCD9C");
		btnReportSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnReportSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtSRNo.getText()=="0" || txtDNo.getText()=="0") {
					msg = new JOptionPane();
					msg.showMessageDialog(null, "참여자 등록이 되지 않았습니다. 참여자 등록 후 리포트 등록이 가능합니다.");
					return;
				}else {
					SubjectReports Sr = new SubjectReports();
					Sr=SetObjectReportInfo();
					if (Sr.getSr_no()==0) {
						report_model.regist(Sr);
					}else {
						report_model.modify(Sr);
					}
					initReportInfo();
					selectSubjectReportList();
				}
					
			}
		});

		GridBagConstraints gbc_btnReportSave = new GridBagConstraints();
		gbc_btnReportSave.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReportSave.insets = new Insets(0, 0, 5, 0);
		gbc_btnReportSave.gridx = 24;
		gbc_btnReportSave.gridy = 4;
		contentPane.add(btnReportSave, gbc_btnReportSave);
		
		JLabel lblNewLabel_10 = new JLabel("\uC2E4\uD5D8\uC77C\uC790");
		lblNewLabel_10.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_10.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 1;
		gbc_lblNewLabel_10.gridy = 5;
		contentPane.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		txtTestDate = new JTextField();
		GridBagConstraints gbc_txtTestDate = new GridBagConstraints();
		gbc_txtTestDate.gridwidth = 6;
		gbc_txtTestDate.insets = new Insets(0, 0, 5, 5);
		gbc_txtTestDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTestDate.gridx = 3;
		gbc_txtTestDate.gridy = 5;
		contentPane.add(txtTestDate, gbc_txtTestDate);
		txtTestDate.setColumns(10);
		
		dateTest = new JDateChooser();
		dateTest.setDateFormatString("yyyy-MM-dd");
		GridBagConstraints gbc_dateTest = new GridBagConstraints();
		gbc_dateTest.insets = new Insets(0, 0, 5, 5);
		gbc_dateTest.fill = GridBagConstraints.BOTH;
		gbc_dateTest.gridx = 9;
		gbc_dateTest.gridy = 5;
		contentPane.add(dateTest, gbc_dateTest);
		
		JLabel lblNewLabel_12 = new JLabel("\uBC18\uBCF5\uD69F\uC218");
		lblNewLabel_12.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 10;
		gbc_lblNewLabel_12.gridy = 5;
		contentPane.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		spinCount = new JSpinner();
		GridBagConstraints gbc_spinCount = new GridBagConstraints();
		gbc_spinCount.insets = new Insets(0, 0, 5, 5);
		gbc_spinCount.gridx = 11;
		gbc_spinCount.gridy = 5;
		contentPane.add(spinCount, gbc_spinCount);
		
		JLabel lblNewLabel_11 = new JLabel("\uC9C4\uD589 \uC7A5\uC18C");
		lblNewLabel_11.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 12;
		gbc_lblNewLabel_11.gridy = 5;
		contentPane.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		txtLoc = new JTextField();
		GridBagConstraints gbc_txtLoc = new GridBagConstraints();
		gbc_txtLoc.gridwidth = 4;
		gbc_txtLoc.insets = new Insets(0, 0, 5, 5);
		gbc_txtLoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLoc.gridx = 13;
		gbc_txtLoc.gridy = 5;
		contentPane.add(txtLoc, gbc_txtLoc);
		txtLoc.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("\uC2E4\uD5D8\uBAA9\uC801");
		lblNewLabel_13.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_13.gridx = 17;
		gbc_lblNewLabel_13.gridy = 5;
		contentPane.add(lblNewLabel_13, gbc_lblNewLabel_13);
		
		txtPurpose = new JTextField();
		GridBagConstraints gbc_txtPurpose = new GridBagConstraints();
		gbc_txtPurpose.gridwidth = 7;
		gbc_txtPurpose.insets = new Insets(0, 0, 5, 0);
		gbc_txtPurpose.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPurpose.gridx = 18;
		gbc_txtPurpose.gridy = 5;
		contentPane.add(txtPurpose, gbc_txtPurpose);
		txtPurpose.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("\uC2E4\uD5D8\uAE30\uBC95");
		lblNewLabel_14.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridx = 1;
		gbc_lblNewLabel_14.gridy = 6;
		contentPane.add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		txtMethod = new JTextField();
		GridBagConstraints gbc_txtMethod = new GridBagConstraints();
		gbc_txtMethod.anchor = GridBagConstraints.NORTH;
		gbc_txtMethod.gridwidth = 7;
		gbc_txtMethod.insets = new Insets(0, 0, 5, 5);
		gbc_txtMethod.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMethod.gridx = 3;
		gbc_txtMethod.gridy = 6;
		contentPane.add(txtMethod, gbc_txtMethod);
		txtMethod.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("\uC2E4\uD5D8\uACFC\uC815");
		lblNewLabel_15.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_15.gridx = 10;
		gbc_lblNewLabel_15.gridy = 6;
		contentPane.add(lblNewLabel_15, gbc_lblNewLabel_15);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 14;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 11;
		gbc_scrollPane.gridy = 6;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		txtProgress = new JTextArea();
		scrollPane.setViewportView(txtProgress);
		
		JLabel lblNewLabel_16 = new JLabel("\uC2E4\uD5D8\uACB0\uACFC");
		lblNewLabel_16.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_16.gridx = 1;
		gbc_lblNewLabel_16.gridy = 7;
		contentPane.add(lblNewLabel_16, gbc_lblNewLabel_16);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridwidth = 22;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 3;
		gbc_scrollPane_2.gridy = 7;
		contentPane.add(scrollPane_2, gbc_scrollPane_2);
		
		txtResult = new JTextArea();
		scrollPane_2.setViewportView(txtResult);
		
		JLabel lblNewLabel_17 = new JLabel("\uAE30\uD0C0");
		lblNewLabel_17.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_17.gridx = 1;
		gbc_lblNewLabel_17.gridy = 8;
		contentPane.add(lblNewLabel_17, gbc_lblNewLabel_17);
		
		txtNote = new JTextField();
		GridBagConstraints gbc_txtNote = new GridBagConstraints();
		gbc_txtNote.insets = new Insets(0, 0, 5, 0);
		gbc_txtNote.gridwidth = 22;
		gbc_txtNote.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNote.gridx = 3;
		gbc_txtNote.gridy = 8;
		contentPane.add(txtNote, gbc_txtNote);
		txtNote.setColumns(10);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.gridheight = 3;
		gbc_scrollPane_3.gridwidth = 25;
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 0;
		gbc_scrollPane_3.gridy = 9;
		contentPane.add(scrollPane_3, gbc_scrollPane_3);
		
		TBL_REPORT = new JTable();
		TBL_REPORT.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (TBL_REPORT.getRowCount() > 0) {
					SubjectReports sr = new SubjectReports();
					int row= TBL_REPORT.getSelectedRow();
					int sd_no=Integer.valueOf(TBL_REPORT.getValueAt(row, 0).toString());
					sr=report_model.search(sd_no);
					if (sr.getSr_no() > 0 ) GetObjectReportInfo(sr);
	
				}
				
			}
		});
		scrollPane_3.setViewportView(TBL_REPORT);
	}
	

}
