package javara.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Scrollbar;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.ImageIcon;
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
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;

import com.toedter.calendar.JDateChooser;

import javara.model.ToolModel;




public class ToolView extends JInternalFrame {

	private JPanel contentPane;
	private JTextField T_NO;
	private JTextField CATE_NO;
	private JTextField T_NAME;
	private JTextField STOR_NO;
	
	public ToolModel TM = new ToolModel();
	private ToolModel Tool_Model= new ToolModel();
	private JTextField T_NOTE;
	private ToolTableModel TTM = new ToolTableModel() ;
	private JTable TOOL_TBL;
	private JTextField T_LIMIT_DATE_TXT;
	private JTextField T_FINAL_CK_TXT;
	private JTextField textField;
	private JTextField t_no1;
	public JTextField getT_no1() {
		return t_no1;
	}

	public void setT_no1(JTextField t_no1) {
		this.t_no1 = t_no1;
	}





	
	
	private JTextField cate_no1;
	private JTextField t_name1;
	private JTextField t_buy_date1;
	private JTextField t_limit_date1;
	private JTextField t_reg_date1;
	private JTextField stor_no1;
	private JTextField t_final_ck1;
	private JTextField t_note1;
	
	/**
	 * Launch the application.
	 */
	
	class ImagePanel extends JPanel{
		
		private Image img;
		
		public ImagePanel(Image img) {
			this.img = img;
			setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
			setLayout(null);
			
		}
		
		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, null);
			
			
		}
		
		
		
		
		
	}
	
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//
//					ToolView frame = new ToolView();
//					frame.setVisible(true);
//					frame.setPreferredSize(new Dimension(1180,1180/12*8));
//					frame.setSize(1240,1240/12*9);
//					frame.setLocationRelativeTo(null);
//					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//					frame.setResizable(false);
//					
//					frame.pack();
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	/**
	 * Create the frame.
	 */
	public ToolView() {
		setBackground(Color.DARK_GRAY);
		setResizable(false);
		setTitle("기자재 정보");
		//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspace\\Java\\Javara\\src\\javara.image\\Tool2.jpg"));
		setBounds(100, 100, 1157, 782);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setClosable(true);
		

		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 10, 1080, 47);
		panel.setBackground(Color.GRAY);
		panel.setForeground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uAE30\uC790\uC7AC\uC815\uBCF4");
		lblNewLabel.setBounds(386, 10, 266, 35);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 32));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_1.setBounds(37, 108, 405, 149);
		panel_1.setForeground(Color.WHITE);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uAE30\uC790\uC7AC\uBC88\uD638");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(30, 10, 136, 29);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 17));
		panel_1.add(lblNewLabel_1);
		
		T_NO = new JTextField();
		T_NO.setBounds(223, 10, 136, 24);
		panel_1.add(T_NO);
		T_NO.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uBD84\uB958\uBC88\uD638");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(30, 39, 136, 29);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 17));
		panel_1.add(lblNewLabel_2);
		
		CATE_NO = new JTextField();
		CATE_NO.setBounds(223, 39, 136, 24);
		panel_1.add(CATE_NO);
		CATE_NO.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\uAE30\uC790\uC7AC\uBA85");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(30, 73, 136, 29);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 17));
		panel_1.add(lblNewLabel_3);
		
		T_NAME = new JTextField();
		T_NAME.setBounds(223, 74, 136, 29);
		panel_1.add(T_NAME);
		T_NAME.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("\uBCF4\uAD00\uC18C\uBC88\uD638");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(30, 107, 136, 34);
		lblNewLabel_9.setFont(new Font("굴림", Font.BOLD, 17));
		panel_1.add(lblNewLabel_9);
		
		STOR_NO = new JTextField();
		STOR_NO.setBounds(223, 113, 136, 26);
		panel_1.add(STOR_NO);
		STOR_NO.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel_2.setBounds(35, 445, 781, 286);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 2));
		scrollPane.setBounds(57, 70, 666, 180);
		panel_2.add(scrollPane);
		
		TOOL_TBL = new JTable();
		//----------------------------------------
		//표 행들 선택시
		//-----------------------------------
		TOOL_TBL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row0 = TOOL_TBL.getSelectedRow();
				int col0 = 0;
				int t_no = (Integer)TOOL_TBL.getValueAt(row0, col0);
				
				int row1 = TOOL_TBL.getSelectedRow();
				int col1 = 1;
				int cate_no = (Integer)TOOL_TBL.getValueAt(row1, col1);
				
				int row2 = TOOL_TBL.getSelectedRow();
				int col2 = 2;
				String t_name_txt = (String) TOOL_TBL.getValueAt(row2, col2);
				
				int row3 = TOOL_TBL.getSelectedRow();
				int col3 = 3;
				Date t_buy_date = (Date) TOOL_TBL.getValueAt(row3, col3);
				
				int row4 = TOOL_TBL.getSelectedRow();
				int col4 = 4;
				Date t_limit_date = (Date) TOOL_TBL.getValueAt(row4, col4);
				
				int row5 = TOOL_TBL.getSelectedRow();
				int col5 = 5;
				Date t_reg_date = (Date) TOOL_TBL.getValueAt(row5, col5);
				
				int row6 = TOOL_TBL.getSelectedRow();
				int col6 = 6;
				int stor_no = (Integer)TOOL_TBL.getValueAt(row6, col6);
				
				int row7 = TOOL_TBL.getSelectedRow();
				int col7 = 7;
				Date t_final_ck = (Date) TOOL_TBL.getValueAt(row7, col7);
				
				int row8 = TOOL_TBL.getSelectedRow();
				int col8 = 8;
				String t_note_txt = (String) TOOL_TBL.getValueAt(row8, col8);
				
				
				
				try {
					
//					TM.selectByTNo(t_no);
					
					System.out.println("표선택 작동");
					
//					String t_txt = String.valueOf(TOOL_TBL.getValueAt(row, col));
					//String t_no_txt = String.valueOf(t_no);									
					System.out.println(t_no);
					t_no1.setText(String.valueOf(t_no));
					
					//String cate_no_txt = String.valueOf(cate_no);
					System.out.println(cate_no);
					cate_no1.setText(String.valueOf(cate_no));
					
					System.out.println(t_name_txt);
					t_name1.setText(t_name_txt);
					
					//String cate_no_txt = String.valueOf(cate_no);
					System.out.println(t_buy_date);
					t_buy_date1.setText(String.valueOf(t_buy_date));
					
					System.out.println(t_limit_date);
					t_limit_date1.setText(String.valueOf(t_limit_date));
					
					System.out.println(t_reg_date);
					t_reg_date1.setText(String.valueOf(t_reg_date));
					
					//String stor_no_txt = String.valueOf(stor_no);
					System.out.println(stor_no);
					stor_no1.setText(String.valueOf(stor_no));
					
					System.out.println(t_final_ck);
					t_final_ck1.setText(String.valueOf(t_final_ck));
					
					System.out.println(t_note_txt);
					t_note1.setText(t_note_txt);
					
//					System.out.println(t_no+"기자재번호 습득 완료");
//					System.out.println(TM.tl.getT_no()+"메소드로부터 기자재번호 습득1");
					
				}catch (Exception ex) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "기자재 검색 실패" + ex.getMessage());
					
				}
//				System.out.println(TM.tl.getT_no() + "메소드로부터 기자재번호 습득2");
//				t_no1.setText(String.valueOf(TM.tl.getT_no()));
				
				
				
				
				
				
				
			}
		});
		scrollPane.setViewportView(TOOL_TBL);
		TOOL_TBL.setDragEnabled(true);
		TOOL_TBL.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		TOOL_TBL.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		TOOL_TBL.setBackground(SystemColor.info);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField.setFont(new Font("굴림", Font.BOLD, 20));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("\uAE30\uC790\uC7AC \uC815\uBCF4 \uD14C\uC774\uBE14");
		textField.setBounds(261, 12, 242, 38);
		panel_2.add(textField);
		textField.setColumns(10);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_3.setBackground(SystemColor.menu);
		panel_3.setBounds(454, 108, 359, 327);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("\uBE44\uACE0(\uAD00\uB828\uB2E8\uC5B4 \uAC80\uC0C9\uC2DC \uBAA8\uB450 \uAC80\uC0C9)");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(56, 10, 264, 58);
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 17));
		lblNewLabel_4.setBackground(Color.WHITE);
		panel_3.add(lblNewLabel_4);
		
		T_NOTE = new JTextField();

		T_NOTE.setBounds(56, 78, 264, 214);
		panel_3.add(T_NOTE);
		T_NOTE.setColumns(10);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBounds(0, 0, 0, 0);
		panel_3.add(scrollbar);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(34, 263, 405, 172);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(0, 0, 0, 0);
		panel_4.add(lblNewLabel_7);
		
		JDateChooser T_LIMIT_DATE = new JDateChooser();
		T_LIMIT_DATE.setBounds(27, 15, 140, 31);
		T_LIMIT_DATE.setDateFormatString("yyyy-MM-dd");
		panel_4.add(T_LIMIT_DATE);
		//T_LIMIT_DATE.setDateFormatString("YY/MM/dd");
		
		
		JLabel lblNewLabel_5 = new JLabel("\uC0AC\uC6A9\uAE30\uD55C \uB118\uC9C0 \uC54A\uC740 \uBB3C\uD488\uB4E4");
		lblNewLabel_5.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_5.setBounds(12, 48, 174, 31);
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_5);
		
		
		JDateChooser T_FINAL_CK = new JDateChooser();
		T_FINAL_CK.setBounds(217, 15, 166, 31);
		panel_4.add(T_FINAL_CK);
		
		JLabel lblNewLabel_12 = new JLabel("\uC55E\uC73C\uB85C \uB2E4\uAC00\uC62C \uCD5C\uC885\uC810\uAC80\uC77C\uC790");
		lblNewLabel_12.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_12.setBounds(217, 48, 166, 31);
		panel_4.add(lblNewLabel_12);
		
		T_LIMIT_DATE_TXT = new JTextField();
		T_LIMIT_DATE_TXT.setBounds(27, 122, 140, 21);
		
		panel_4.add(T_LIMIT_DATE_TXT);
		T_LIMIT_DATE_TXT.setColumns(10);
		
		JButton btnNewButton_7 = new JButton("\uC0AC\uC6A9\uAE30\uD55C \uAC80\uC0C9");
		btnNewButton_7.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton_7.setFont(new Font("굴림", Font.BOLD, 12));
		btnNewButton_7.setBounds(27, 81, 140, 31);
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectToolTLimitDate();
			}
		});
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DateFormat df =new SimpleDateFormat("YY/MM/dd");
				T_LIMIT_DATE_TXT.setText(df.format(T_LIMIT_DATE.getDate()));
				
				
				
				
				
				
//				Date date = new Date(df.parse(strDate).getTime());
//				Date date = df.parse(d);
				
			}
		});
		panel_4.add(btnNewButton_7);
		
		T_FINAL_CK_TXT = new JTextField();
		T_FINAL_CK_TXT.setBounds(217, 122, 166, 21);
		panel_4.add(T_FINAL_CK_TXT);
		T_FINAL_CK_TXT.setColumns(10);
		
		JButton btnNewButton_8 = new JButton("\uCD5C\uC885\uC810\uAC80\uC77C\uC790 \uAC80\uC0C9");
		btnNewButton_8.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton_8.setFont(new Font("굴림", Font.BOLD, 12));
		btnNewButton_8.setBounds(217, 81, 166, 31);
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				selectToolTFinalCk();
				
				
			}
		});
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				DateFormat df =new SimpleDateFormat("YY/MM/dd");
				T_FINAL_CK_TXT.setText(df.format(T_FINAL_CK.getDate()));
				
				
				
			}
		});
		panel_4.add(btnNewButton_8);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_5_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_5_1.setBounds(840, 112, 277, 619);
		contentPane.add(panel_5_1);
		panel_5_1.setLayout(null);
		
		JLabel lblNewLabel_10_1 = new JLabel("\uAE30\uC790\uC7AC\uCD94\uAC00 \uBC0F \uC218\uC815");
		lblNewLabel_10_1.setBounds(39, 0, 206, 38);
		lblNewLabel_10_1.setFont(new Font("굴림", Font.BOLD, 17));
		lblNewLabel_10_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5_1.add(lblNewLabel_10_1);
		
		JButton btnNewButton_1 = new JButton("\uCD94\uAC00");
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int t_no2=Integer.parseInt(t_no1.getText());
				
				int cate_no2=Integer.parseInt(cate_no1.getText());
				String t_name2=t_name1.getText();
				
				String t_buy_date2=t_buy_date1.getText();
				
				String t_limit_date2=t_limit_date1.getText();
				
				String t_reg_date2=t_reg_date1.getText();
				
				int stor_no2=Integer.parseInt(stor_no1.getText());
				
				String t_final_ck2=t_final_ck1.getText();
						
				String t_note2=t_note1.getText();
				
				System.out.println("기자재번호"+t_no2 + "얻어오기 성공");
				
				
				Tool_Model.regist(cate_no2, t_name2, t_buy_date2, t_limit_date2, t_reg_date2, stor_no2, t_final_ck2, t_note2);
				
				
//				Tool_Model.insertCN(t_no2, cate_no2);
//				
//				Tool_Model.insertTN(t_no2, t_name2);
//				
//				Tool_Model.insertTBD(t_no2, t_name2);
//				
//				Tool_Model.insertTLD(t_no2, stor_no2);
//				
//				Tool_Model.insertTRD(t_no2, t_final_ck2);
//				
//				Tool_Model.insertSN(t_no2, t_note2);
//				
//				Tool_Model.insertTFC(t_no2, t_name2);
//				
//				Tool_Model.insertTNT(t_no2, t_name2);
				
				ClearScreen();
			}
		});
		btnNewButton_1.setBounds(39, 558, 97, 50);
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 19));
		panel_5_1.add(btnNewButton_1);
		
		JButton mod = new JButton("\uC218\uC815");
		mod.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		mod.setFont(new Font("굴림", Font.BOLD, 18));

		mod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				
				
				
				
				
				int t_no2=Integer.parseInt(t_no1.getText());
				
				int cate_no2=Integer.parseInt(cate_no1.getText());
				String t_name2=t_name1.getText();
				
				int stor_no2=Integer.parseInt(stor_no1.getText());
				
				String t_final_ck2=t_final_ck1.getText();
						
				String t_note2=t_note1.getText();
				
				
				
				
				
				
				
				System.out.println("기자재번호"+t_no2 + "얻어오기 성공");
				
				
				
				
				Tool_Model.modifyCN(t_no2, cate_no2);
				Tool_Model.modifyTN(t_no2, t_name2);
				
				Tool_Model.modifySN(t_no2, stor_no2);
				
				Tool_Model.modifyTFC(t_no2, t_final_ck2);
				
				Tool_Model.modifyTNT(t_no2, t_note2);
				
				
				
				
				
				
				//Tool_Model.modify(t_no2);
				
				
				ClearScreen();
				
				
//					int t_no2 = Integer.valueOf(t_no1.getText());
//					int cate_no2 = Integer.valueOf(cate_no1.getText());
//					
//					String t_name2 = t_name1.getText();
//					
//					int stor_no2 = Integer.valueOf(stor_no1.getText());
//					
//					String t_note2 = t_note1.getText();
//					
//					try {
//						
//						Tool_Model.modify(cate_no2, t_name2, stor_no2, t_note2, t_no2);
//						
//						System.out.println("기자재 수정 성공");
//						//ClearScreen();
//				
//					}catch (Exception e1) {
//						JOptionPane.showMessageDialog(null, "기자재 등록 실패 :" + e1.getMessage());
//						// TODO: handle exception
//					}
				
				
				
			}
		});
		mod.setBounds(158, 559, 88, 47);
		panel_5_1.add(mod);
		
		t_no1 = new JTextField();
		t_no1.setEditable(false);
		t_no1.setBounds(39, 73, 206, 21);
		panel_5_1.add(t_no1);
		t_no1.setColumns(10);
		
		cate_no1 = new JTextField();
		cate_no1.setBounds(39, 129, 206, 21);
		panel_5_1.add(cate_no1);
		cate_no1.setColumns(10);
		
		t_name1 = new JTextField();
		t_name1.setBounds(39, 189, 206, 21);
		panel_5_1.add(t_name1);
		t_name1.setColumns(10);
		
		t_buy_date1 = new JTextField();
		t_buy_date1.setBounds(39, 245, 206, 21);
		panel_5_1.add(t_buy_date1);
		t_buy_date1.setColumns(10);
		
		t_limit_date1 = new JTextField();
		t_limit_date1.setBounds(39, 297, 206, 21);
		panel_5_1.add(t_limit_date1);
		t_limit_date1.setColumns(10);
		
		t_reg_date1 = new JTextField();
		t_reg_date1.setBounds(39, 353, 206, 21);
		panel_5_1.add(t_reg_date1);
		t_reg_date1.setColumns(10);
		
		stor_no1 = new JTextField();
		stor_no1.setBounds(39, 396, 206, 21);
		panel_5_1.add(stor_no1);
		stor_no1.setColumns(10);
		
		t_final_ck1 = new JTextField();
		t_final_ck1.setBounds(39, 448, 206, 21);
		panel_5_1.add(t_final_ck1);
		t_final_ck1.setColumns(10);
		
		t_note1 = new JTextField();
		t_note1.setBounds(39, 493, 206, 55);
		panel_5_1.add(t_note1);
		t_note1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\uAE30\uC790\uC7AC\uBC88\uD638");
		lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(39, 48, 206, 15);
		panel_5_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("\uBD84\uB958\uBC88\uD638");
		lblNewLabel_8.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_8.setBounds(118, 104, 57, 15);
		panel_5_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_10 = new JLabel("\uAE30\uC790\uC7AC\uBA85");
		lblNewLabel_10.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(118, 164, 57, 15);
		panel_5_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("\uAD6C\uC785\uC77C\uC790");
		lblNewLabel_11.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(118, 220, 57, 15);
		panel_5_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_13 = new JLabel("\uC0AC\uC6A9\uAE30\uD55C");
		lblNewLabel_13.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(118, 276, 57, 15);
		panel_5_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("\uB4F1\uB85D\uC77C");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_14.setBounds(118, 328, 57, 15);
		panel_5_1.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("\uBCF4\uAD00\uC18C\uBC88\uD638");
		lblNewLabel_15.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setBounds(105, 373, 82, 15);
		panel_5_1.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("\uCD5C\uC885\uC810\uAC80\uC77C\uC790");
		lblNewLabel_16.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setBounds(105, 427, 88, 15);
		panel_5_1.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("\uBE44\uACE0");
		lblNewLabel_17.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setBounds(115, 479, 72, 15);
		panel_5_1.add(lblNewLabel_17);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(37, 51, 1082, 47);
		contentPane.add(panel_6);
				
				JButton btnNewButton_4 = new JButton("\uAE30\uC790\uC7AC\uBC88\uD638\uC870\uD68C");
				btnNewButton_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				btnNewButton_4.setFont(new Font("굴림", Font.BOLD, 12));
				btnNewButton_4.setBounds(229, 10, 135, 27);
				
						btnNewButton_4.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								
								
								selectToolTNo();
								
							}
						});
						
						JButton btnNewButton_2 = new JButton("\uC804\uCCB4\uC870\uD68C");
						btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
						btnNewButton_2.setBounds(50, 8, 122, 27);
						btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 20));
						btnNewButton_2.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e1) {
//표에서 선택된거 입력칸에 그대로 옮기기				
//				int row = TBL_TOOL.getSelectedRow();
//				int col = 0;
//				int tNO = (Integer)TBL_TOOL.getValueAt(row, col);
//				ArrayList<Tool> tl = new ArrayList<Tool>();
//				try {
//					tl = Tool_Model.search();
//							
//							
//							
//				}catch(Exception e2) {
//					JOptionPane.showMessageDialog(null, "조회실패"+e2.getMessage());
//				}
//				
								selectToolList();
								
								

							}
						});
						panel_6.setLayout(null);
						panel_6.add(btnNewButton_2);
						panel_6.add(btnNewButton_4);
				
				JButton btnNewButton_3 = new JButton("\uBE44\uACE0\uC870\uD68C");
				btnNewButton_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				btnNewButton_3.setFont(new Font("굴림", Font.BOLD, 12));
				btnNewButton_3.setBounds(947, 10, 105, 27);
				
						btnNewButton_3.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								
								
								selectToolListTNote();
								
								
							}
						});
						
						JButton btnNewButton_6 = new JButton("\uBCF4\uAD00\uC18C\uBC88\uD638\uC870\uD68C");
						btnNewButton_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
						btnNewButton_6.setFont(new Font("굴림", Font.BOLD, 12));
						btnNewButton_6.setBounds(784, 10, 122, 27);
						btnNewButton_6.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								
								selectToolStorNo();
								
								
								
							}
						});
						
						JButton btnNewButton = new JButton("\uAE30\uC790\uC7AC\uBA85\uC870\uD68C");
						btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
						btnNewButton.setFont(new Font("굴림", Font.BOLD, 12));
						btnNewButton.setBounds(619, 10, 117, 23);
						btnNewButton.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e2) {
								selectToolListTName();
							}
						});
						
						JButton btnNewButton_5 = new JButton("\uBD84\uB958\uBC88\uD638\uC870\uD68C");
						btnNewButton_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
						btnNewButton_5.setFont(new Font("굴림", Font.BOLD, 13));
						btnNewButton_5.setBounds(433, 10, 117, 27);
						
								btnNewButton_5.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										
										selectToolCateNo();
										
										
									}
								});
								panel_6.add(btnNewButton_5);
						panel_6.add(btnNewButton);
						panel_6.add(btnNewButton_6);
						panel_6.add(btnNewButton_3);
						
						
						//뒤의 배경화면
//		ImagePanel mainpanel = new ImagePanel (new ImageIcon("./image/Ocean1.jpg").getImage());
//		
//		mainpanel.setVisible(true);
//		mainpanel.setPreferredSize(new Dimension(1240,1240/12*9));
//		mainpanel.setSize(1240,1240/12*9);
//		//mainpanel.setLocationRelativeTo(null);
//		contentPane.add(mainpanel);
//		
//		
//		
//		mainpanel.setLayout(null);
//		
		
		
		
						
						
						
	}
	
	//화면 청소
	void ClearScreen() {
		t_no1.setText("");
		cate_no1.setText("");
		t_name1.setText("");
		t_buy_date1.setText("");
		t_limit_date1.setText("");
		t_reg_date1.setText("");
		stor_no1.setText("");
		t_final_ck1.setText("");
		t_note1.setText("");
	}
	
//	void selectTable() {
//		
//		
//		
//		
//		
//	}
	
	
	
	
	
	
	//전체조회
	void selectToolList() {
	try {
			
			ArrayList list = Tool_Model.search();
			TTM.data=list;
			TOOL_TBL.setModel(TTM);
			TTM.fireTableDataChanged();
			System.out.println("confirmall");
			
			
		}catch (Exception e) {System.out.println("errorall");
			// TODO: handle exception
			
		}
		
	}
	
	
	//기자재번호로 조회
	void selectToolTNo() {
		
		int t_no = Integer.parseInt(T_NO.getText());
		
	try {
			
			ArrayList list = Tool_Model.searchByTNo(t_no);
			TTM.data=list;
			TOOL_TBL.setModel(TTM);
			TTM.fireTableDataChanged();
			System.out.println("confirmtno");
			
			
		}catch (Exception e) {System.out.println("errortno");
			// TODO: handle exception
			
		}
		
	}
	
	
	//분류번호로조회
	void selectToolCateNo() {
		
		int cate_no = Integer.parseInt(CATE_NO.getText());
		
	try {
			
			ArrayList list = Tool_Model.searchByCateNo(cate_no);
			TTM.data=list;
			TOOL_TBL.setModel(TTM);
			TTM.fireTableDataChanged();
			System.out.println("confirmcateno");
			
			
		}catch (Exception e) {System.out.println("errorcateno");
			// TODO: handle exception
			
		}
		
	}
	
	
	
	
	//기자재명으로 조회
	void selectToolListTName() {
		
		String tname = T_NAME.getText();
	
		
		
		
	try {
			
			ArrayList list = Tool_Model.searchByTName(tname);
			TTM.data=list;
			TOOL_TBL.setModel(TTM);
			TTM.fireTableDataChanged();
			System.out.println("confirmname");
			
			
		}catch (Exception e) {System.out.println("errorname");
			// TODO: handle exception
			
		}
		
	}
	
	//사용기한 조회
	void selectToolTLimitDate() {
		
		//밑의 주석안의 코드들은 실험도중에 삽입


//		Date date = new Date (df.parse(t_limit_date).getTime());
//		String t_limit_date = (T_LIMIT_DATE_TXT.getText());
//		
//		Date date = df.parse(t_limit_date).getTime();
		
		
		String t_limit_date = T_LIMIT_DATE_TXT.getText();
		System.out.println(t_limit_date +"값들어왔는지 1차 확인");
		
		//밑의 주석안의 코드들은 실험도중에 삽입
		
//		
		// 문자열
//		String dateStr = "19/01/10";
//		// 포맷터
//		SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd");
//		// 문자열 -> Date
//		
//		
//		Date date = (Date) formatter.parse(dateStr);
//		System.out.println(date);
			

		 // Sat Jun 19 21:05:07 KST 2021
		
		
		





		

		//밑의 변수는 실험
		//String string = "19/01/10";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd", Locale.KOREA);
		LocalDate localDate = LocalDate.parse(t_limit_date, formatter);

		System.out.println(localDate + "lcd");
		System.out.println(formatter.format(localDate)+"lcl+formatter");
		
		
		
		// 1. LocalDate 객체 생성(현재 시간)
//		LocalDate localDate = LocalDate.now();
		// 2. LocalDate -> Date 변환
		Date date = java.sql.Date.valueOf(localDate);
		// 3. LocalDate, Date 결과 출력

		System.out.println(date + "date"); // 클릭한 날
		
		
		//밑의 주석안의 코드들은 실험도중에 삽입
		
		
		
//		String string = "19/01/10";
		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd", Locale.KOREA);
//		LocalDate date = LocalDate.parse(t_limit_date, formatter);

//		System.out.println(date);
//		System.out.println(formatter.format(date));
		
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        
//        Date date = new Date(sdf.parse(t_limit_date).getTime());
        
		
		
		
	try {	
		
		//밑의 주석안의 코드들은 실험도중에 삽입
		
//			String t_limit_date = T_LIMIT_DATE_TXT.getText();
//			System.out.println(t_limit_date);
//		
//		// 문자열
//		//String dateStr = "19/01/10";
//		// 포맷터
//			SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd");
//		// 문자열 -> Date
//			Date date;
//			date = (Date) formatter.parse(t_limit_date);
//			System.out.println(date);
			ArrayList list = Tool_Model.searchByTLimitDate(date);
			TTM.data=list;
			TOOL_TBL.setModel(TTM);
			TTM.fireTableDataChanged();
			System.out.println("confirmtlimitdate");
			
			
		}catch (Exception e) {System.out.println("errortlimitdate");
			// TODO: handle exception
			
		}
		
	}
	
	
	
	//보관소 조회
	void selectToolStorNo() {
		
		int stor_no = Integer.parseInt(STOR_NO.getText());
		
	try {
			
			ArrayList list = Tool_Model.searchByStorNo(stor_no);
			TTM.data=list;
			TOOL_TBL.setModel(TTM);
			TTM.fireTableDataChanged();
			System.out.println("confirmstorno");
			
			
		}catch (Exception e) {System.out.println("errorstorno");
			// TODO: handle exception
			
		}
		
	}
	
	
	
	//최종점검일자 조회
	void selectToolTFinalCk() {
		
		//밑의 주석안의 코드들은 실험도중에 삽입


//		Date date = new Date (df.parse(t_limit_date).getTime());
//		String t_limit_date = (T_LIMIT_DATE_TXT.getText());
//		
//		Date date = df.parse(t_limit_date).getTime();
		
		
		String t_final_ck = T_FINAL_CK_TXT.getText();
		System.out.println(t_final_ck +"값들어왔는지 1차 확인");
//		
		// 문자열
//		String dateStr = "19/01/10";
//		// 포맷터
//		SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd");
//		// 문자열 -> Date
//		
//		
//		Date date = (Date) formatter.parse(dateStr);
//		System.out.println(date);
			

		 // Sat Jun 19 21:05:07 KST 2021
		
		
		





		

		//밑의 변수는 실험
		//String string = "19/01/10";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd", Locale.KOREA);
		LocalDate localDate = LocalDate.parse(t_final_ck, formatter);

		System.out.println(localDate + "lcd");
		System.out.println(formatter.format(localDate)+"lcl+formatter");
		
		//밑의 주석안의 코드들은 실험도중에 삽입
		
		// 1. LocalDate 객체 생성(현재 시간)
//		LocalDate localDate = LocalDate.now();
		// 2. LocalDate -> Date 변환
		Date date = java.sql.Date.valueOf(localDate);
		// 3. LocalDate, Date 결과 출력

		System.out.println(date + "date"); // 클릭한 날
		
		
		
		//밑의 주석안의 코드들은 실험도중에 삽입
		
//		String string = "19/01/10";
		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd", Locale.KOREA);
//		LocalDate date = LocalDate.parse(t_limit_date, formatter);

//		System.out.println(date);
//		System.out.println(formatter.format(date));
		
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        
//        Date date = new Date(sdf.parse(t_limit_date).getTime());
        
		
		//밑의 주석안의 코드들은 실험도중에 삽입
		
	try {		
//			String t_limit_date = T_LIMIT_DATE_TXT.getText();
//			System.out.println(t_limit_date);
//		
//		// 문자열
//		//String dateStr = "19/01/10";
//		// 포맷터
//			SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd");
//		// 문자열 -> Date
//			Date date;
//			date = (Date) formatter.parse(t_limit_date);
//			System.out.println(date);
			ArrayList list = Tool_Model.searchByTFinalCk(date);
			TTM.data=list;
			TOOL_TBL.setModel(TTM);
			TTM.fireTableDataChanged();
			System.out.println("confirmTFinalCk");
			
			
		}catch (Exception e) {System.out.println("errorTFinalCk");
			// TODO: handle exception
			
		}
		
	}
	
	
	
	
	//비고 조회
	void selectToolListTNote() {
		
		String tnote = T_NOTE.getText();
		
		
	try {
			
			ArrayList list = Tool_Model.searchByTNote(tnote);
			TTM.data=list;
			TOOL_TBL.setModel(TTM);
			TTM.fireTableDataChanged();
			System.out.println("confirmnote");
			
			
		}catch (Exception e) {System.out.println("errornote");
			// TODO: handle exception
			
		}
		
	}
	
	
	
	
	
	
	class ToolTableModel extends AbstractTableModel{
		
		ArrayList data = new ArrayList();
		String columnNames[] = {"기자재번호","분류번호","기자재명","구입일자","사용기한","등록일","보관소번호","최종점검일자","비고"};



		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columnNames.length;
		}
		
		
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.size();
					
		}
		

		@Override
		public Object getValueAt(int row, int col) {
			// TODO Auto-generated method stub
			ArrayList temp = (ArrayList)data.get( row );
			return temp.get( col );
		}
		
		
		public String getColumnName(int col) { 
		        return columnNames[col]; 
		}
		
		
		
		
	}
	

	
	public class l8{
		
	}
	
	
	
	
	
	
}
