package javara.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Scrollbar;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import javara.model.CoopModel;
import javara.model.SubjectInfoModel;
import javara.model.ToolModel;
import javara.model.coopinfoModel;
import javara.model.rec.Coop;
import javara.model.rec.coopinfo;

import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;

public class jfCoop extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textNo;
	private JTextField textName;
	private JTextField textTel;
	private JTextArea textDetail;
	
	private SubjectListTableModel subjectList = new SubjectListTableModel();
	private SubjectInfoModel subject_model= new SubjectInfoModel();
	private JTable tablecoop;
	
	private CoopModel model = null;
	private CoopModel model1 = null;
	private CoopModel model2 = null;
	private CoopModel modelSI = null;
	private coopinfoModel model3 = new coopinfoModel();
	
	private CoopTableModelsi ctmsi = new CoopTableModelsi();
	private CoopTableModel1 ctm1 = new CoopTableModel1();
	private CoopTableModel ctm = new CoopTableModel();
	private JTextField textSearch;
	
	private String[] cmbList = {"기관 이름", "전화번호"}; 
	private JComboBox comboBox;
	private JTable tableIn;
	private JTextField textshsi;
	private JTable tablesi1;
	private JTextField sinotxt;
	private JTextField conotxt;
	private JTextField cisdatetxt;
	private JTextField cedate;
	private JTextField cinotxt;
	
	/*
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public jfCoop() {
		
		setVisible(true);
		setResizable(true);
		setClosable(true);
		setTitle("협력사 정보");
		
		model = new CoopModel();
		model1 = new CoopModel();
		model2 = new CoopModel();
		modelSI = new CoopModel();
		selectCoopList();
		selectCoopList1();
		
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
		
		JLabel lblNewLabel = new JLabel("\uD611\uB825\uAE30\uAD00\uC815\uBCF4");
		lblNewLabel.setBounds(12, 5, 186, 35);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 108, 437, 135);
		panel_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_1.setForeground(Color.WHITE);
		contentPane.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{23, 80, 21, 348, 14, 0};
		gbl_panel_1.rowHeights = new int[]{35, 35, 35, 35, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uD611\uB825 \uAE30\uAD00 \uC815\uBCF4 \uBC88\uD638");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textNo = new JTextField();
		textNo.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textNo.setEditable(false);
		GridBagConstraints gbc_textNo = new GridBagConstraints();
		gbc_textNo.fill = GridBagConstraints.BOTH;
		gbc_textNo.insets = new Insets(0, 0, 5, 5);
		gbc_textNo.gridx = 3;
		gbc_textNo.gridy = 0;
		panel_1.add(textNo, gbc_textNo);
		textNo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uD611\uB825 \uAE30\uAD00 \uC774\uB984");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 1;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textName = new JTextField();
		textName.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		GridBagConstraints gbc_textName = new GridBagConstraints();
		gbc_textName.insets = new Insets(0, 0, 5, 5);
		gbc_textName.fill = GridBagConstraints.BOTH;
		gbc_textName.gridx = 3;
		gbc_textName.gridy = 1;
		panel_1.add(textName, gbc_textName);
		textName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 2;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textTel = new JTextField();
		textTel.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		GridBagConstraints gbc_textTel = new GridBagConstraints();
		gbc_textTel.insets = new Insets(0, 0, 5, 5);
		gbc_textTel.fill = GridBagConstraints.BOTH;
		gbc_textTel.gridx = 3;
		gbc_textTel.gridy = 2;
		panel_1.add(textTel, gbc_textTel);
		textTel.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 408, 1139, 342);
		panel_2.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 2));
		scrollPane.setBounds(38, 46, 463, 286);
		panel_2.add(scrollPane);
		
		tablecoop = new JTable(ctm);			//수정!!!
		tablecoop.setBackground(SystemColor.info);
		tablecoop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row0 = tablecoop.getSelectedRow();
				int co0 = 0;
				String no = (String)tablecoop.getValueAt(row0, co0);
				
				int row1 = tablecoop.getSelectedRow();
				int co1 = 1;
				String name = (String)tablecoop.getValueAt(row1, co1);
				
				int row2 = tablecoop.getSelectedRow();
				int co2 = 2;
				String tel = (String)tablecoop.getValueAt(row2, co2);
				
				int row3 = tablecoop.getSelectedRow();
				int co3 = 3;
				String detail = (String)tablecoop.getValueAt(row3, co3);
				
				
				
				
				try {
					
					textNo.setText(no);
					conotxt.setText(no);
					
					textName.setText(name);
					
					textTel.setText(tel);
					
					textDetail.setText(detail);
					
					
				}catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "협력기관 정보 검색 실패" + e1.getMessage());
				
					
				}
				
				
				
				
				
			}
		});
		scrollPane.setViewportView(tablecoop);
		
		JLabel lblNewLabel_6 = new JLabel("\uACFC\uC81C \uD611\uB825 \uAE30\uAD00");
		lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(727, 0, 182, 15);
		panel_2.add(lblNewLabel_6);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new LineBorder(new Color(130, 135, 144), 2));
		scrollPane_1.setBounds(530, 50, 561, 188);
		panel_2.add(scrollPane_1);
		
		tableIn = new JTable(ctm1);
		tableIn.setBackground(SystemColor.info);
		tableIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				int row0 = tableIn.getSelectedRow();
				int co0 = 0;
				String cino1 = (String) tableIn.getValueAt(row0, co0);
				System.out.println(cino1);
				
				
//				String sino = Integer.toString(no);
				
				
				
				
				try {
					
					cinotxt.setText(cino1);
					
					
				}catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "협력기관 정보 검색 실패" + e1.getMessage());
				
					
				}
				
				
				
			}
		});
		scrollPane_1.setViewportView(tableIn);
		
		JLabel lblNewLabel_7 = new JLabel("\uD611\uB825 \uAE30\uAD00 \uC815\uBCF4");
		lblNewLabel_7.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(178, 21, 175, 15);
		panel_2.add(lblNewLabel_7);
		
		sinotxt = new JTextField();
		sinotxt.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		sinotxt.setBounds(649, 278, 89, 21);
		panel_2.add(sinotxt);
		sinotxt.setColumns(10);
		
		conotxt = new JTextField();
		conotxt.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		conotxt.setBounds(763, 278, 97, 21);
		panel_2.add(conotxt);
		conotxt.setColumns(10);
		
		cisdatetxt = new JTextField();
		cisdatetxt.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		cisdatetxt.setBounds(888, 278, 89, 21);
		panel_2.add(cisdatetxt);
		cisdatetxt.setColumns(10);
		
		cedate = new JTextField();
		cedate.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		cedate.setBounds(1002, 278, 89, 21);
		panel_2.add(cedate);
		cedate.setColumns(10);
		
		JButton ciregbt = new JButton("\uB4F1\uB85D");
		ciregbt.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		ciregbt.setFont(new Font("굴림", Font.BOLD, 14));
		ciregbt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int cisn1 =Integer.parseInt(sinotxt.getText());
				int cicn1 =Integer.parseInt(conotxt.getText());
				
//				String  cisn1 = sinotxt.getText();
//				String  cicn1 = conotxt.getText();
				String  cics1 = cisdatetxt.getText();
				String  cice1 = cedate.getText();
				
				model3.registcm(cisn1, cicn1, cics1, cice1);
				
				ClearScreenCi();
				
			}
		});
		ciregbt.setBounds(641, 309, 97, 23);
		panel_2.add(ciregbt);
		
		JButton cidelbt = new JButton("\uC0AD\uC81C");
		cidelbt.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		cidelbt.setFont(new Font("굴림", Font.BOLD, 15));
		cidelbt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int delcino1 =Integer.parseInt(cinotxt.getText());
				System.out.println("삭제되면 성공" );
						
				   
				model3.coopInfoModelDel(delcino1);
				
				ClearScreenCi();
				
			}
		});
		cidelbt.setBounds(880, 309, 97, 23);
		panel_2.add(cidelbt);
		
		cinotxt = new JTextField();
		cinotxt.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		cinotxt.setEditable(false);
		cinotxt.setBounds(530, 280, 89, 21);
		panel_2.add(cinotxt);
		cinotxt.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("\uACFC\uC81C\uD611\uB825\uAE30\uAD00\uBC88\uD638");
		lblNewLabel_9.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(513, 248, 122, 22);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("\uACFC\uC81C\uBC88\uD638");
		lblNewLabel_10.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(649, 248, 89, 20);
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("\uD611\uB825\uAE30\uAD00\uC815\uBCF4\uBC88\uD638");
		lblNewLabel_11.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(763, 253, 107, 15);
		panel_2.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("\uC2DC\uC791\uC77C");
		lblNewLabel_12.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(902, 253, 57, 15);
		panel_2.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("\uC885\uB8CC\uC77C");
		lblNewLabel_13.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(1014, 253, 57, 15);
		panel_2.add(lblNewLabel_13);
		
		JButton coopinforefresh = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		coopinforefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				selectCoopList1();
				
			}
		});
		coopinforefresh.setBorder(new LineBorder(new Color(0, 0, 0)));
		coopinforefresh.setBounds(985, 18, 97, 23);
		panel_2.add(coopinforefresh);
		
		JButton btnNewButton = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		btnNewButton.setBounds(404, 13, 97, 23);
		panel_2.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				selectCoopList();
				
				
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(5, 253, 516, 145);
		panel_3.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_3.setBackground(SystemColor.menu);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		textDetail = new JTextArea();
		textDetail.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textDetail.setBounds(30, 39, 445, 94);
		panel_3.add(textDetail);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBounds(481, 20, 17, 113);
		panel_3.add(scrollbar);
		
		JLabel lblNewLabel_4 = new JLabel("\uD611\uB825 \uAE30\uAD00 \uC0C1\uC138 \uB0B4\uC6A9");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(184, 10, 147, 15);
		panel_3.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_4.setBackground(Color.WHITE);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(5, 57, 1139, 47);
		contentPane.add(panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{521, 97, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_6.rowHeights = new int[]{23, 0, 0, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
				
				JButton btnSearch = new JButton("\uAC80\uC0C9");
				btnSearch.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				btnSearch.setBounds(558, 156, 143, 23);
				btnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {	// 검색 버튼 클릭 시 이벤트 처리
						
						String sh = textSearch.getText();
						int selIdx = comboBox.getSelectedIndex();
					    ArrayList al = model.searchCoop(sh , selIdx);
					    
					    
					    
						ctm.data=al;
						ctm.fireTableDataChanged();

					}
				});
				contentPane.add(btnSearch);
				
				
				
				JButton btnUpD = new JButton("\uC218\uC815");		//마우스 클릭시 수정
				btnUpD.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				btnUpD.setBounds(442, 169, 79, 23);
				btnUpD.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						
						int no1 =Integer.parseInt(textNo.getText());
						String name1 = textName.getText();
						String tel1 = textTel.getText();
						String detail1 = textDetail.getText();
						
						System.out.println("들어가면 성공" );
//						ArrayList data = new ArrayList();
						System.out.println(no1 + name1 + tel1 + detail1 + "번호" + "이름" + "전화번호" + "상세정보");
						
						model.jfTel(no1, tel1);    //전화번호
						
						
					}
				});
				contentPane.add(btnUpD);
				
				
				
				JButton btnDel = new JButton("\uC0AD\uC81C");
				btnDel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				btnDel.setBounds(442, 220, 79, 23);

				btnDel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {		//삭제 번튼 클릭
					
						
						
						int no2 =Integer.parseInt(textNo.getText());
						System.out.println("삭제되면 성공" );
						System.out.println(no2 + ":다시 시작하세요");		
						   
						model.jfDel(no2);
					
					
					}
				});
				contentPane.add(btnDel);
				
				
				
				
				
				
				JButton btnNew = new JButton("\uB4F1\uB85D");
				btnNew.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				btnNew.setBounds(442, 108, 79, 23);
				btnNew.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {	// 등록 버튼 클릭

						String  name = textName.getText();
						String  tel = textTel.getText();
						String  detail = textDetail.getText();
						
						Coop cp = new Coop(0, name, tel, detail);
						
						model.regist(cp);
						dong();
						selectCoopList();
						
						JOptionPane.showMessageDialog(null, "등록 완료");
					}
				});
				contentPane.add(btnNew);
				
				comboBox = new JComboBox(cmbList);
				comboBox.setBounds(558, 108, 143, 23);
				contentPane.add(comboBox);
				
				textSearch = new JTextField();
				textSearch.setBorder(new LineBorder(new Color(171, 173, 179), 2));
				textSearch.setBounds(558, 132, 143, 27);
				contentPane.add(textSearch);
				textSearch.setColumns(10);
				
				JLabel lblNewLabel_8 = new JLabel("\uACFC\uC81C\uC815\uBCF4 \uD45C");
				lblNewLabel_8.setFont(new Font("굴림", Font.BOLD, 18));
				lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_8.setBounds(718, 203, 207, 40);
				contentPane.add(lblNewLabel_8);
				
				JButton btnsino = new JButton("\uAC80\uC0C9");
				btnsino.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				btnsino.setFont(new Font("굴림", Font.BOLD, 15));
				btnsino.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
//						String  title = textshsi.getText();
//						System.out.println(title);
						
//						System.out.println(title);
//						model.jfsi(title);
//						System.out.println(model.jfsi(title));
						selectSI1ListTNote();
						System.out.println("작동성공");
						
					}
				});
				btnsino.setBounds(896, 156, 97, 23);
				contentPane.add(btnsino);
				
				textshsi = new JTextField();
				textshsi.setBorder(new LineBorder(new Color(171, 173, 179), 2));
				textshsi.setBounds(738, 155, 146, 23);
				contentPane.add(textshsi);
				textshsi.setColumns(10);
				
				JScrollPane scrollPane_2 = new JScrollPane();
				scrollPane_2.setBorder(new LineBorder(new Color(130, 135, 144), 2));
				scrollPane_2.setBounds(533, 253, 560, 145);
				contentPane.add(scrollPane_2);
				
				tablesi1 = new JTable();
				tablesi1.setBackground(SystemColor.info);
				tablesi1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						int row0 = tablesi1.getSelectedRow();
						int co0 = 0;
						int no = (int) tablesi1.getValueAt(row0, co0);
						System.out.println(no);
						String sino = Integer.toString(no); 
						
						
						try {
							
							sinotxt.setText(sino);
							
							
						}catch (Exception e1) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null, "협력기관 정보 검색 실패" + e1.getMessage());
						
							
						}
						
						
						
					}
				});
				scrollPane_2.setViewportView(tablesi1);
				
				JLabel lblNewLabel_14 = new JLabel("\uACFC\uC81C\uD0C0\uC774\uD2C0");
				lblNewLabel_14.setFont(new Font("굴림", Font.BOLD, 18));
				lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_14.setBounds(738, 124, 146, 23);
				contentPane.add(lblNewLabel_14);
				
				JButton subjectinforefresh = new JButton("\uC0C8\uB85C\uACE0\uCE68");
				subjectinforefresh.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						selectSubjectInfoList1();
						
					}
				});
				subjectinforefresh.setBorder(new LineBorder(new Color(0, 0, 0)));
				subjectinforefresh.setBounds(996, 220, 97, 23);
				contentPane.add(subjectinforefresh);
				
				
				

	}
	
	void dong () {
		textNo.setText("");
		textName.setText("");
		textTel.setText("");
		textDetail.setText("");
	}
	
	void ClearScreenCi() {
		
		cinotxt.setText("");
		sinotxt.setText("");
		conotxt.setText("");
		cisdatetxt.setText("");
		cedate.setText("");

	}
	
	
	void selectCoopList() {
		try {
			ArrayList list = model.searchAll();
			ctm.data=list;
			ctm.fireTableDataChanged();
		}catch (Exception e) {
			// TODO: handle exception
			
		}
		
	}
	
	void selectCoopList1() {
		try {
			ArrayList list = model1.searchAll1();
			ctm1.data=list;
			ctm1.fireTableDataChanged();
		}catch (Exception e) {
			// TODO: handle exception
			
		}
		
	}
	
	void selectSubjectInfoList1() {
		try {
			ArrayList list = modelSI.searchallsi();
			ctmsi.data=list;
			tablesi1.setModel(ctmsi);
			ctmsi.fireTableDataChanged();
			System.out.println(list);
			System.out.println("confirmnote");
			
		}catch (Exception e) {System.out.println("errornote");
			// TODO: handle exception
			
		}
		
	}
	
	
	
	void selectSI1ListTNote() {
		
		String  title = textshsi.getText();
//		String tnote = T_NOTE.getText();
		
		System.out.println(title);
	try {
			
			ArrayList list = model2.searchByTitle(title);
			ctmsi.data=list;
			tablesi1.setModel(ctmsi);
			ctmsi.fireTableDataChanged();
			System.out.println(list);
			System.out.println("confirmnote");
			
			
		}catch (Exception e) {System.out.println("errornote");
			// TODO: handle exception
			
		}
		
	}
	
	
	
	
	class CoopTableModel extends AbstractTableModel { // AbstractTableModel 라는 추상클래스 상속받아서 만듦

		ArrayList data = new ArrayList();
		String[] columnNames = { "번호", "이름", "전화번호", "상세정보"};

//=============================================================
// 1. 기본적인 TabelModel  만들기
// 아래 세 함수는 TabelModel 인터페이스의 추상메소드인데
// AbstractTabelModel에서 구현되지 않았기에...
// 반드시 사용자 구현 필수!!!!

		public int getColumnCount() { // 컬럼이 몇 개인지
			return columnNames.length;
		}

		public int getRowCount() { // 리스트 사이즈
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}

//===============================================================
// 2. 지정된 컬럼명으로 변환하기
//
//		기본적으로 A, B, C, D 라는 이름으로 컬럼명이 지정된다
		public String getColumnName(int col) {
			return columnNames[col];
		}
	}
	
//	----------------------------------------------------------

	
	class CoopTableModel1 extends AbstractTableModel { // AbstractTableModel 라는 추상클래스 상속받아서 만듦

		ArrayList data = new ArrayList();
		String[] columnNames = { "과제번호", "과제번호(Fk)", "정보번호(FK)", "시작일", "종료일"};

//=============================================================
// 1. 기본적인 TabelModel  만들기
// 아래 세 함수는 TabelModel 인터페이스의 추상메소드인데
// AbstractTabelModel에서 구현되지 않았기에...
// 반드시 사용자 구현 필수!!!!

		public int getColumnCount() { // 컬럼이 몇 개인지
			return columnNames.length;
		}

		public int getRowCount() { // 리스트 사이즈
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}

//===============================================================
// 2. 지정된 컬럼명으로 변환하기
//
//		기본적으로 A, B, C, D 라는 이름으로 컬럼명이 지정된다
		public String getColumnName(int col) {
			return columnNames[col];
		}
	}
	
	
	class CoopTableModelsi extends AbstractTableModel { // AbstractTableModel 라는 추상클래스 상속받아서 만듦

		ArrayList data = new ArrayList();
		String[] columnNames = {"과제번호","과제타이틀"};

//=============================================================
// 1. 기본적인 TabelModel  만들기
// 아래 세 함수는 TabelModel 인터페이스의 추상메소드인데
// AbstractTabelModel에서 구현되지 않았기에...
// 반드시 사용자 구현 필수!!!!

		public int getColumnCount() { // 컬럼이 몇 개인지
			return columnNames.length;
		}

		public int getRowCount() { // 리스트 사이즈
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}

//===============================================================
// 2. 지정된 컬럼명으로 변환하기
//
//		기본적으로 A, B, C, D 라는 이름으로 컬럼명이 지정된다
		public String getColumnName(int col) {
			return columnNames[col];
		}
	}
	
	
	
	
}



