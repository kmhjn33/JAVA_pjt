package javara.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JToolBar;
import javax.swing.JTable;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javara.model.SubjectPlanModel;
import javara.model.rec.SubjectInfo;
import javara.model.rec.SubjectPlan;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.TableModel;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class jfProjectPlan extends JInternalFrame {

	private JPanel contentPane;
	private JTextField TXT_ACCOUNT;
	private JTextField TXT_Acc_Detail;
	private JTextField TXT_ACC_ITEM;
	private JTextField TXT_PurposeOfUse;
	
	private JTextField TXT_NO;
	private JComboBox cboMajor;
	private JComboBox cboSubject;
	private ArrayList major_list;
	private ArrayList subject_list;
	
	
	private SubjectPlanModel plan_model = new SubjectPlanModel(); 
	private String[] columnTitles= {"예산 No","예산정보","활용내역","항목","금액","사용처"};
	private SubjectListTableModel plan_list = new SubjectListTableModel(columnTitles,0);
	private JTable TBL_PLAN;
	private JTextField TXT_AMOUNT;

	/**
	 * Create the frame.
	 */
	public jfProjectPlan() {
		initLayout();
		setVisible(true);
		setClosable(true);
		setTitle("과제 예산 정보");
	}
	
	public void initDisPlay() {
		
	}
	
	public void initLayout() {
		setBounds(100, 100, 1048, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.GRAY);
		
		JLabel lblNewLabel = new JLabel("\uACFC\uC81C\uBCC4 \uC608\uC0B0 \uC815\uBCF4");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setBounds(12, 5, 285, 35);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{80, 62, 325, 90, 286, 90, 70, 0};
		gbl_panel_1.rowHeights = new int[]{25, 23, 24, 24, 22, 24, 7, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_8 = new JLabel("\uD559\uACFC\uC815\uBCF4");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_8.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 0;
		panel_1.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		this.major_list= plan_model.SelectMajorInfo();
		cboMajor = new JComboBox(major_list.toArray());
		cboMajor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// 선택 학과에 대한 정보 확인
				String[] majorinfo=cboMajor.getSelectedItem().toString().split("-");
				int major_no=Integer.valueOf(majorinfo[0].toString().replace("[", ""));
				selectSubjectPlan(major_no);
			}
		});
		GridBagConstraints gbc_cboMajor = new GridBagConstraints();
		gbc_cboMajor.gridwidth = 2;
		gbc_cboMajor.insets = new Insets(0, 0, 5, 5);
		gbc_cboMajor.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboMajor.gridx = 1;
		gbc_cboMajor.gridy = 0;
		panel_1.add(cboMajor, gbc_cboMajor);
		
		JButton BTN_SAVE = new JButton("\uC800\uC7A5");

		BTN_SAVE.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				registSubject();
				if (cboSubject.getItemCount() > 0 ) {
					String[] subjectInfo=cboSubject.getSelectedItem().toString().split("-");
					int subject_no=Integer.valueOf(subjectInfo[0].toString().replace("[", ""));
					selectSubjectPlanList(subject_no);
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
				GridBagConstraints gbc_BTN_SAVE = new GridBagConstraints();
				gbc_BTN_SAVE.fill = GridBagConstraints.BOTH;
				gbc_BTN_SAVE.insets = new Insets(0, 0, 5, 5);
				gbc_BTN_SAVE.gridx = 5;
				gbc_BTN_SAVE.gridy = 0;
				panel_1.add(BTN_SAVE, gbc_BTN_SAVE);
		
		JButton btnDEL = new JButton("\uC0AD\uC81C");
		btnDEL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDEL.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				if (TBL_PLAN.getRowCount() > 0) {
					int row = TBL_PLAN.getSelectedRow();
					plan_model.delete((int)TBL_PLAN.getValueAt(0,row ));
					if (cboSubject.getItemCount() > 0 ) {
						String[] subjectInfo=cboSubject.getSelectedItem().toString().split("-");
						int subject_no=Integer.valueOf(subjectInfo[0].toString().replace("[", ""));
						selectSubjectPlanList(subject_no);
					}
				}
				
				
			}
		});


		GridBagConstraints gbc_btnDEL = new GridBagConstraints();
		gbc_btnDEL.fill = GridBagConstraints.BOTH;
		gbc_btnDEL.insets = new Insets(0, 0, 5, 0);
		gbc_btnDEL.gridx = 6;
		gbc_btnDEL.gridy = 0;
		panel_1.add(btnDEL, gbc_btnDEL);
		
		JLabel lblNewLabel_6 = new JLabel("\uACFC\uC81C\uC815\uBCF4");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 1;
		panel_1.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		cboSubject = new JComboBox();
		cboSubject.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cboSubject.getItemCount() > 0 ) {
					String[] subjectInfo=cboSubject.getSelectedItem().toString().split("-");
					int subject_no=Integer.valueOf(subjectInfo[0].toString().replace("[", ""));
					selectSubjectPlanList(subject_no);
				}
				
			}
		});
		GridBagConstraints gbc_cboSubject = new GridBagConstraints();
		gbc_cboSubject.gridwidth = 4;
		gbc_cboSubject.insets = new Insets(0, 0, 5, 5);
		gbc_cboSubject.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboSubject.gridx = 1;
		gbc_cboSubject.gridy = 1;
		panel_1.add(cboSubject, gbc_cboSubject);
		
		JLabel lblNewLabel_7 = new JLabel("\uC608\uC0B0 \uC815\uBCF4 \uBC88\uD638");
		lblNewLabel_7.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_7.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 2;
		panel_1.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		TXT_NO = new JTextField();
		TXT_NO.setEditable(false);
		GridBagConstraints gbc_TXT_NO = new GridBagConstraints();
		gbc_TXT_NO.fill = GridBagConstraints.BOTH;
		gbc_TXT_NO.insets = new Insets(0, 0, 5, 5);
		gbc_TXT_NO.gridx = 1;
		gbc_TXT_NO.gridy = 2;
		panel_1.add(TXT_NO, gbc_TXT_NO);
		TXT_NO.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uC608\uC0B0\uC815\uBCF4");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		TXT_ACCOUNT = new JTextField();
		GridBagConstraints gbc_TXT_ACCOUNT = new GridBagConstraints();
		gbc_TXT_ACCOUNT.gridwidth = 2;
		gbc_TXT_ACCOUNT.fill = GridBagConstraints.BOTH;
		gbc_TXT_ACCOUNT.insets = new Insets(0, 0, 5, 5);
		gbc_TXT_ACCOUNT.gridx = 1;
		gbc_TXT_ACCOUNT.gridy = 3;
		panel_1.add(TXT_ACCOUNT, gbc_TXT_ACCOUNT);
		TXT_ACCOUNT.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\uC608\uC0B0 \uD56D\uBAA9");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 3;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		TXT_ACC_ITEM = new JTextField();
		GridBagConstraints gbc_TXT_ACC_ITEM = new GridBagConstraints();
		gbc_TXT_ACC_ITEM.fill = GridBagConstraints.BOTH;
		gbc_TXT_ACC_ITEM.insets = new Insets(0, 0, 5, 5);
		gbc_TXT_ACC_ITEM.gridx = 4;
		gbc_TXT_ACC_ITEM.gridy = 3;
		panel_1.add(TXT_ACC_ITEM, gbc_TXT_ACC_ITEM);
		TXT_ACC_ITEM.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uC608\uC0B0 \uC0C1\uC138 \uC815\uBCF4");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		TXT_Acc_Detail = new JTextField();
		GridBagConstraints gbc_TXT_Acc_Detail = new GridBagConstraints();
		gbc_TXT_Acc_Detail.fill = GridBagConstraints.BOTH;
		gbc_TXT_Acc_Detail.insets = new Insets(0, 0, 5, 5);
		gbc_TXT_Acc_Detail.gridwidth = 4;
		gbc_TXT_Acc_Detail.gridx = 1;
		gbc_TXT_Acc_Detail.gridy = 4;
		panel_1.add(TXT_Acc_Detail, gbc_TXT_Acc_Detail);
		TXT_Acc_Detail.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\uC0AC\uC6A9\uCC98");
		lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		TXT_PurposeOfUse = new JTextField();
		GridBagConstraints gbc_TXT_PurposeOfUse = new GridBagConstraints();
		gbc_TXT_PurposeOfUse.gridwidth = 2;
		gbc_TXT_PurposeOfUse.fill = GridBagConstraints.BOTH;
		gbc_TXT_PurposeOfUse.insets = new Insets(0, 0, 5, 5);
		gbc_TXT_PurposeOfUse.gridx = 1;
		gbc_TXT_PurposeOfUse.gridy = 5;
		panel_1.add(TXT_PurposeOfUse, gbc_TXT_PurposeOfUse);
		TXT_PurposeOfUse.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\uC608\uC0B0 \uCD1D\uC561");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 3;
		gbc_lblNewLabel_4.gridy = 5;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE))
					.addGap(0))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
					.addGap(7))
		);
		
		TXT_AMOUNT = new JTextField();
		GridBagConstraints gbc_TXT_AMOUNT = new GridBagConstraints();
		gbc_TXT_AMOUNT.insets = new Insets(0, 0, 5, 5);
		gbc_TXT_AMOUNT.fill = GridBagConstraints.HORIZONTAL;
		gbc_TXT_AMOUNT.gridx = 4;
		gbc_TXT_AMOUNT.gridy = 5;
		panel_1.add(TXT_AMOUNT, gbc_TXT_AMOUNT);
		TXT_AMOUNT.setColumns(10);
		
		TBL_PLAN = new JTable(plan_list);
		TBL_PLAN.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (TBL_PLAN.getRowCount() > 0) {
					int row = TBL_PLAN.getSelectedRow();
					selectSubjectPlanInfo((int)TBL_PLAN.getValueAt(row,0 ));
					
				}
				
			}
		});
		TBL_PLAN.setRowHeight(30);
		TBL_PLAN.setFillsViewportHeight(true);
		TBL_PLAN.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TBL_PLAN.setBackground(Color.WHITE);
		scrollPane.setViewportView(TBL_PLAN);
		contentPane.setLayout(gl_contentPane);
	}
	
	//학과별 과제 정보 가져오기
	void selectSubjectPlan(int subject_no) {
		try {
			ArrayList list = new ArrayList();
			list=plan_model.searchSubjectInfobyMajorNo(subject_no);
		 	cboSubject.removeAllItems();
		 	if(list.size() > 0) {
		 	cboSubject.addItem(list);
		 	}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
	}
	
	
	
	//학과별 Project List 조회
	void selectSubjectPlanList(int subject_no) {
		try {
			ArrayList list = new ArrayList();
			list=plan_model.search(subject_no);
		 	this.plan_list= new SubjectListTableModel(columnTitles,list);
		 	//TBL_SUBJECT = new JTable(subjectList);
			 TBL_PLAN.setModel(plan_list);
			 plan_list.fireTableDataChanged();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	//과제별 예산 정보 가져오기
	void selectSubjectPlanInfo(int plan_no) {
		try {
			SubjectPlan subjectplan = new SubjectPlan();
			subjectplan=plan_model.searchbyPlanNo(plan_no);
			this.TXT_NO.setText(String.valueOf(subjectplan.getSp_No()));
			this.TXT_ACCOUNT.setText(subjectplan.getSp_Account());
			this.TXT_Acc_Detail.setText(subjectplan.getSp_Acc_Detail());
			this.TXT_ACC_ITEM.setText(subjectplan.getSp_Acc_Item());
			this.TXT_AMOUNT.setText(String.valueOf(subjectplan.getSp_Amount()));
			this.TXT_PurposeOfUse.setText(subjectplan.getPurposeofUse());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("과제별 예산정보 가져오기" + e.getMessage());
			
		}
	}
		
	private void registSubject() {
		
		try {
		
			SubjectPlan sp = new SubjectPlan();
			sp=ObjectDataSetSubjectPlan();
			if (sp.getSp_No() > 0) {
				plan_model.modify(sp);
			}else {
				plan_model.regist(sp);	
			}
			
			TXT_NO.setText("0");
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("SubjectPlan 정보 등록 실패 :" + e.getMessage());
		}
		
	}
	private void deleteSubject() {
		try {
			
			SubjectPlan sp = new SubjectPlan();
			sp=ObjectDataSetSubjectPlan();
			if (sp.getSp_No() > 0) {
				plan_model.modify(sp);
			}else {
				plan_model.regist(sp);	
			}
			
			TXT_NO.setText("0");
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("SubjectPlan 정보 등록 실패 :" + e.getMessage());
		}
	}
	

	
	
	private SubjectPlan ObjectDataSetSubjectPlan() {
		
		
		SubjectPlan subject_plan = new SubjectPlan();
		try {
			if(TXT_NO.getText().length()==0) {
				subject_plan.setSp_No(0);
			}else {
				subject_plan.setSp_No(Integer.valueOf(TXT_NO.getText()));
			}
			
			subject_plan.setSp_Account(this.TXT_ACCOUNT.getText());
			subject_plan.setSp_Acc_Detail(this.TXT_Acc_Detail.getText());
			subject_plan.setSp_Acc_Item(this.TXT_ACC_ITEM.getText());
			
			if(this.TXT_AMOUNT.getText().length()==0) {
				subject_plan.setSp_Amount(0.0);
			}else {
				subject_plan.setSp_Amount(Double.valueOf(this.TXT_AMOUNT.getText()));
			}
			subject_plan.setPurposeofUse(this.TXT_PurposeOfUse.getText());
			
			String[] subject_info=cboSubject.getSelectedItem().toString().split("-");
			int subject_no=Integer.valueOf(subject_info[0].toString().replace("[", ""));
			subject_plan.setSi_No(subject_no);
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("과제 참여 정보 추가 실패 : " + e.getMessage());
		}
		return subject_plan;
	}
}
