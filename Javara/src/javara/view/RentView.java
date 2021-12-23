package javara.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import com.toedter.calendar.JDateChooser;

import javara.model.RentModel;
import javara.model.rec.Rent;


public class RentView extends JInternalFrame {

	private JPanel contentPane;
	
	private JTextField tfListSearch;
	private JTextField tfToolSearch;
	private JTextField tfRentDate;
	private JTextField tfToolName;
	private JTextField tfStuNo;
	private JTextField tfReturnDate;
	private JTextField tfReturnRentNo;
	private JTextField tfToolNo;
	
	private RentList rentList = new RentList();
	private ToolList toolList = new ToolList();
	private ReturnList returnList = new ReturnList();
	
	private RentModel model = null;
	private JTable tblRentList;
	private JTable tblToolList;
	private JTable tblReturnList;
	
	private JButton btnRent;
	private JButton btnListSearch;
	private JButton btnListView;
	private JButton btnReturn;
	private JButton btnToolSearch;
	private JButton btnReturnClear;
	private JButton btnReturnDel;
	private JButton btnRefresh;
	
	private JComboBox cmbListSearch;
	private JComboBox cmbListDate;
	
	private String dateSearch[]	= {"�뿩��","�ݳ� ������","�ݳ���"};
	private String txtSearch[]	= {"�뿩 ��ȣ","������ ��ȣ","������ �̸�","�뿩�� �й�","�뿩�� �̸�"};
	
	private JDateChooser dcReturnSchedule;
	private JDateChooser dcListView;
	
	private JRadioButton rdbtnNoReturnListView;
	
	private ArrayList returnSel = new ArrayList();	// �ݳ� ��� ������
	private ArrayList copyList = new ArrayList();	// ���� ���� ������ ����Ʈ �����
	
	
	SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy/MM/dd", Locale.KOREA );
	Date currentTime = new Date ();
	String mTime = mSimpleDateFormat.format(currentTime);


	
	/**
	 * Launch the application.
	 */
	
	//=====================�ӽ� main=====================
//	public static void main(String[] args) {
//		RentView rentView = new RentView();
//	}
	//==================================================
	
	// Constructor
	public RentView() {
		
		model = new RentModel();
		rentViewLayout();
		setToolListTable();
		setRentListTable();
		eventProc();
		//setResizable(true);
		//setMaximizable(true);
		setClosable(true);
		setTitle("������ �뿩/�ݳ�");
		setVisible(true);
		
	} // Constructor-End
	
	
	//=================================================
	
	/**
	 * Create the frame.
	 */
	
	
	
	public void rentViewLayout() {

		setBounds(100, 100, 1170, 836);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel jpTitle = new JPanel();
		jpTitle.setBackground(new Color(153, 153, 153));
		jpTitle.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(102, 102, 102)));
		jpTitle.setBounds(5, 5, 1139, 40);
		jpTitle.setForeground(new Color(153, 153, 153));
		contentPane.add(jpTitle);
		jpTitle.setLayout(null);
		
		JLabel lbTItle = new JLabel("\uAE30\uC790\uC7AC \uB300\uC5EC/\uBC18\uB0A9");
		lbTItle.setForeground(new Color(245, 245, 245));
		lbTItle.setBounds(12, 2, 253, 35);
		lbTItle.setHorizontalAlignment(SwingConstants.LEFT);
		lbTItle.setFont(new Font("���� ���", Font.BOLD, 25));
		jpTitle.add(lbTItle);
		
		JPanel jpRent = new JPanel();
		jpRent.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpRent.setAlignmentX(Component.LEFT_ALIGNMENT);
		jpRent.setBounds(248, 78, 482, 320);
		jpRent.setForeground(Color.WHITE);
		contentPane.add(jpRent);
		jpRent.setLayout(null);
		
		btnRent = new JButton("\uB300\uC5EC");
		btnRent.setForeground(new Color(51, 51, 51));
		btnRent.setFont(new Font("���� ���", Font.PLAIN, 12));
		btnRent.setBounds(373, 277, 97, 33);
		jpRent.add(btnRent);
		
		JPanel jpRentInfoTf = new JPanel();
		jpRentInfoTf.setBounds(140, 10, 330, 267);
		jpRent.add(jpRentInfoTf);
		jpRentInfoTf.setLayout(null);
		
		tfRentDate = new JTextField();
		tfRentDate.setForeground(new Color(51, 51, 51));
		tfRentDate.setText(mTime);
		tfRentDate.setFont(new Font("���� ���", Font.PLAIN, 12));
		tfRentDate.setEditable(false);
		tfRentDate.setColumns(10);
		tfRentDate.setBounds(0, 10, 330, 30);
		jpRentInfoTf.add(tfRentDate);
		
		tfToolName = new JTextField();
		tfToolName.setForeground(new Color(51, 51, 51));
		tfToolName.setFont(new Font("���� ���", Font.PLAIN, 12));
		tfToolName.setEditable(false);
		tfToolName.setColumns(10);
		tfToolName.setBounds(0, 187, 330, 30);
		jpRentInfoTf.add(tfToolName);
		
		tfStuNo = new JTextField();
		tfStuNo.setForeground(new Color(51, 51, 51));
		tfStuNo.setFont(new Font("���� ���", Font.PLAIN, 12));
		tfStuNo.setColumns(10);
		tfStuNo.setBounds(0, 227, 330, 30);
		jpRentInfoTf.add(tfStuNo);
		
		dcReturnSchedule = new JDateChooser();
		dcReturnSchedule.setBounds(0, 50, 330, 30);
		jpRentInfoTf.add(dcReturnSchedule);
		dcReturnSchedule.setDateFormatString("yyyy/MM/dd");
		dcReturnSchedule.setMinSelectableDate(currentTime);
		
		tfToolNo = new JTextField();
		tfToolNo.setForeground(new Color(51, 51, 51));
		tfToolNo.setFont(new Font("���� ���", Font.PLAIN, 12));
		tfToolNo.setColumns(10);
		tfToolNo.setBounds(0, 147, 330, 30);
		jpRentInfoTf.add(tfToolNo);
		
		JPanel jpRentInfoLb = new JPanel();
		jpRentInfoLb.setBounds(12, 10, 116, 267);
		jpRent.add(jpRentInfoLb);
		jpRentInfoLb.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uB300\uC5EC \uC77C\uC790");
		lblNewLabel_1_1.setForeground(new Color(51, 51, 51));
		lblNewLabel_1_1.setFont(new Font("���� ���", Font.PLAIN, 12));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setBounds(12, 10, 92, 30);
		jpRentInfoLb.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uBC18\uB0A9 \uC608\uC815\uC77C");
		lblNewLabel_1_2.setForeground(new Color(51, 51, 51));
		lblNewLabel_1_2.setFont(new Font("���� ���", Font.PLAIN, 12));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setBounds(12, 50, 92, 30);
		jpRentInfoLb.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("\uAE30\uC790\uC7AC \uC774\uB984");
		lblNewLabel_1_3.setForeground(new Color(51, 51, 51));
		lblNewLabel_1_3.setFont(new Font("���� ���", Font.PLAIN, 12));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setBounds(12, 187, 92, 30);
		jpRentInfoLb.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("\uB300\uC5EC\uC790 \uD559\uBC88");
		lblNewLabel_1_4.setForeground(new Color(51, 51, 51));
		lblNewLabel_1_4.setFont(new Font("���� ���", Font.PLAIN, 12));
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_4.setBounds(12, 227, 92, 30);
		jpRentInfoLb.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("\uAE30\uC790\uC7AC \uBC88\uD638");
		lblNewLabel_1_3_1.setForeground(new Color(51, 51, 51));
		lblNewLabel_1_3_1.setFont(new Font("���� ���", Font.PLAIN, 12));
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_1.setBounds(12, 147, 92, 30);
		jpRentInfoLb.add(lblNewLabel_1_3_1);
		
		JPanel jpRentList = new JPanel();
		jpRentList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpRentList.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		jpRentList.setBounds(5, 408, 1139, 342);
		contentPane.add(jpRentList);
		jpRentList.setLayout(null);
		
		btnListSearch = new JButton("\uAC80\uC0C9");
		btnListSearch.setForeground(new Color(51, 51, 51));
		btnListSearch.setFont(new Font("���� ���", Font.PLAIN, 12));
		btnListSearch.setBounds(1030, 10, 97, 23);
		jpRentList.add(btnListSearch);
		
		tfListSearch = new JTextField();
		tfListSearch.setForeground(new Color(51, 51, 51));
		tfListSearch.setFont(new Font("���� ���", Font.PLAIN, 12));
		tfListSearch.setBounds(797, 10, 221, 23);
		jpRentList.add(tfListSearch);
		tfListSearch.setColumns(10);
		
		cmbListSearch = new JComboBox(txtSearch);
		cmbListSearch.setFont(new Font("���� ���", Font.PLAIN, 12));
		cmbListSearch.setBounds(665, 10, 127, 23);
		jpRentList.add(cmbListSearch);
		
		cmbListDate = new JComboBox(dateSearch);
		cmbListDate.setFont(new Font("���� ���", Font.PLAIN, 12));
		cmbListDate.setBounds(12, 10, 127, 23);
		jpRentList.add(cmbListDate);
		
		dcListView = new JDateChooser();
		dcListView.setBounds(142, 10, 153, 23);
		jpRentList.add(dcListView);
		dcListView.setDateFormatString("yyyy/MM/dd");
		
		btnListView = new JButton("\uC870\uD68C");
		btnListView.setForeground(new Color(51, 51, 51));
		btnListView.setFont(new Font("���� ���", Font.PLAIN, 12));
		btnListView.setBounds(307, 10, 79, 23);
		jpRentList.add(btnListView);
		
		rdbtnNoReturnListView = new JRadioButton("\uBBF8\uBC18\uB0A9\uB9CC \uBCF4\uAE30");
		rdbtnNoReturnListView.setForeground(new Color(51, 51, 51));
		rdbtnNoReturnListView.setFont(new Font("���� ���", Font.PLAIN, 12));
		rdbtnNoReturnListView.setBounds(394, 10, 121, 23);
		jpRentList.add(rdbtnNoReturnListView);
		
		JScrollPane spRentList = new JScrollPane();
		spRentList.setBounds(12, 38, 1115, 294);
		jpRentList.add(spRentList);
		
		tblRentList = new JTable(rentList);
		tblRentList.setForeground(new Color(51, 51, 51));
		tblRentList.setFont(new Font("���� ���", Font.PLAIN, 12));
		tblRentList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tblRentList.setRowHeight(20);
		spRentList.setViewportView(tblRentList);
		
		JPanel jpReturn = new JPanel();
		jpReturn.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpReturn.setBounds(742, 78, 400, 320);
		contentPane.add(jpReturn);
		jpReturn.setLayout(null);
		
		btnReturn = new JButton("\uBC18\uB0A9");
		btnReturn.setForeground(new Color(51, 51, 51));
		btnReturn.setFont(new Font("���� ���", Font.PLAIN, 12));
		btnReturn.setBounds(291, 277, 97, 33);
		jpReturn.add(btnReturn);
		
		JPanel jpReturnInfoTf = new JPanel();
		jpReturnInfoTf.setBounds(128, 199, 260, 78);
		jpReturn.add(jpReturnInfoTf);
		jpReturnInfoTf.setLayout(null);
		
		tfReturnRentNo = new JTextField();
		tfReturnRentNo.setForeground(new Color(51, 51, 51));
		tfReturnRentNo.setFont(new Font("���� ���", Font.PLAIN, 12));
		tfReturnRentNo.setColumns(10);
		tfReturnRentNo.setBounds(0, 0, 260, 30);
		jpReturnInfoTf.add(tfReturnRentNo);
		
		tfReturnDate = new JTextField();
		tfReturnDate.setForeground(new Color(51, 51, 51));
		tfReturnDate.setFont(new Font("���� ���", Font.PLAIN, 12));
		tfReturnDate.setBounds(0, 40, 260, 30);
		jpReturnInfoTf.add(tfReturnDate);
		tfReturnDate.setEditable(false);
		tfReturnDate.setColumns(10);
		tfReturnDate.setText(mTime);
		
		JPanel jpReturnInfoLb = new JPanel();
		jpReturnInfoLb.setBounds(12, 199, 104, 78);
		jpReturn.add(jpReturnInfoLb);
		jpReturnInfoLb.setLayout(null);
		
		JLabel label = new JLabel("\uBC18\uB0A9 \uC77C\uC790");
		label.setForeground(new Color(51, 51, 51));
		label.setFont(new Font("���� ���", Font.PLAIN, 12));
		label.setBounds(12, 38, 82, 30);
		jpReturnInfoLb.add(label);
		
		JLabel label_1 = new JLabel("\uB300\uC5EC \uBC88\uD638");
		label_1.setForeground(new Color(51, 51, 51));
		label_1.setBounds(12, 0, 82, 30);
		jpReturnInfoLb.add(label_1);
		label_1.setFont(new Font("���� ���", Font.PLAIN, 12));
		
		JScrollPane spReturnList = new JScrollPane();
		spReturnList.setBounds(12, 10, 376, 179);
		jpReturn.add(spReturnList);
		
		tblReturnList = new JTable(returnList);
		tblReturnList.setForeground(new Color(51, 51, 51));
		tblReturnList.setFont(new Font("���� ���", Font.PLAIN, 12));
		tblReturnList.setRowHeight(20);
		spReturnList.setViewportView(tblReturnList);
		
		btnReturnClear = new JButton("\uCD08\uAE30\uD654");
		btnReturnClear.setForeground(new Color(51, 51, 51));
		btnReturnClear.setFont(new Font("���� ���", Font.PLAIN, 12));
		btnReturnClear.setBounds(12, 287, 77, 23);
		jpReturn.add(btnReturnClear);
		
		btnReturnDel = new JButton("\uC0AD\uC81C");
		btnReturnDel.setForeground(new Color(51, 51, 51));
		btnReturnDel.setFont(new Font("���� ���", Font.PLAIN, 12));
		btnReturnDel.setBounds(101, 287, 77, 23);
		jpReturn.add(btnReturnDel);
		
		JPanel jpReturnTitle = new JPanel();
		jpReturnTitle.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(102, 102, 102)));
		jpReturnTitle.setBackground(new Color(192, 192, 192));
		jpReturnTitle.setBounds(742, 48, 400, 31);
		contentPane.add(jpReturnTitle);
		
		JLabel lbReturnTitle = new JLabel("\uBC18\uB0A9");
		lbReturnTitle.setForeground(new Color(51, 51, 51));
		lbReturnTitle.setFont(new Font("���� ���", Font.PLAIN, 12));
		jpReturnTitle.add(lbReturnTitle);
		
		JPanel jpRentTitle = new JPanel();
		jpRentTitle.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(102, 102, 102)));
		jpRentTitle.setBackground(new Color(192, 192, 192));
		jpRentTitle.setBounds(248, 48, 482, 31);
		contentPane.add(jpRentTitle);
		
		JLabel lbRentTitle = new JLabel("\uB300\uC5EC");
		lbRentTitle.setForeground(new Color(51, 51, 51));
		lbRentTitle.setFont(new Font("���� ���", Font.PLAIN, 12));
		jpRentTitle.add(lbRentTitle);
		
		JPanel jpTool = new JPanel();
		jpTool.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpTool.setBounds(5, 78, 231, 320);
		contentPane.add(jpTool);
		jpTool.setAlignmentY(Component.TOP_ALIGNMENT);
		jpTool.setAlignmentX(Component.RIGHT_ALIGNMENT);
		jpTool.setLayout(null);
		
		btnToolSearch = new JButton("\uCC3E\uAE30");
		btnToolSearch.setForeground(new Color(51, 51, 51));
		btnToolSearch.setFont(new Font("���� ���", Font.PLAIN, 12));
		btnToolSearch.setBounds(153, 276, 66, 34);
		jpTool.add(btnToolSearch);
		
		tfToolSearch = new JTextField();
		tfToolSearch.setForeground(new Color(51, 51, 51));
		tfToolSearch.setFont(new Font("���� ���", Font.PLAIN, 12));
		tfToolSearch.setBounds(12, 277, 140, 33);
		jpTool.add(tfToolSearch);
		tfToolSearch.setColumns(10);
		
		JScrollPane spToolList = new JScrollPane();
		spToolList.setBounds(12, 10, 207, 256);
		jpTool.add(spToolList);
		
		tblToolList = new JTable(toolList);
		tblToolList.setForeground(new Color(51, 51, 51));
		tblToolList.setFont(new Font("���� ���", Font.PLAIN, 12));
		tblToolList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tblToolList.setRowHeight(20);
		spToolList.setViewportView(tblToolList);
		
		JPanel jpToolTitle = new JPanel();
		jpToolTitle.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(102, 102, 102)));
		jpToolTitle.setBackground(new Color(192, 192, 192));
		jpToolTitle.setBounds(5, 48, 231, 31);
		contentPane.add(jpToolTitle);
		
		JLabel lbToolTitle = new JLabel("\uBCF4\uC720 \uAE30\uC790\uC7AC");
		lbToolTitle.setForeground(new Color(51, 51, 51));
		lbToolTitle.setFont(new Font("���� ���", Font.PLAIN, 12));
		jpToolTitle.add(lbToolTitle);
		
		btnRefresh = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		btnRefresh.setForeground(new Color(51, 51, 51));
		btnRefresh.setFont(new Font("���� ���", Font.PLAIN, 12));
		btnRefresh.setBounds(15, 760, 97, 23);
		contentPane.add(btnRefresh);
	} // rentViewLayout()-End

	//=================================================
	
	public void eventProc() {
		// ��ư Ŭ�� �̺�Ʈ
		BtnEvent evt = new BtnEvent();
		
		btnRent.addActionListener(evt); 		// �뿩
		btnListSearch.addActionListener(evt); 	// �뿩 ��� �ؽ�Ʈ �˻�
		btnListView.addActionListener(evt);		// �뿩 ��� ��¥�� �˻�
		btnReturn.addActionListener(evt);		// �ݳ�
		btnToolSearch.addActionListener(evt); 	// ������ �˻�
		tfToolSearch.addActionListener(evt); 	// ������ �˻�â
		btnReturnClear.addActionListener(evt); 	// �ݳ� ����Ʈ �ʱ�ȭ
		btnReturnDel.addActionListener(evt); 	// �ݳ� ����Ʈ �׸� ����
		rdbtnNoReturnListView.addActionListener(evt);	// �̹ݳ��� �뿩 ��ϸ� ����
		btnRefresh.addActionListener(evt); 		// �뿩 ����Ʈ ���ΰ�ħ
		tfListSearch.addActionListener(evt); 	// �뿩 ��� �˻�â
		
		// ToolList ���ڵ� Ŭ�� �� ������ ��ȣ�� �̸��� �뿩 ĭ �ʵ忡 ä��
		tblToolList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tblToolList.getSelectedRow();
				
				String tNo = String.valueOf(tblToolList.getValueAt(row, 0));
				tfToolNo.setText(tNo);
				
				String tName = String.valueOf(tblToolList.getValueAt(row, 1));
				tfToolName.setText(tName);
			}
		});
		
		
		// ������ ��ȣ �Է� �� ���� �� ������ �̸��� �ڵ����� ä����
		tfToolNo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int tNo = Integer.parseInt(tfToolNo.getText());
				String tName = model.searchToolByNo(tNo);
				
				tfToolName.setText(tName);
			}
		});
		
		
		// RentList ���ڵ� ����Ŭ�� �� Return list�� ���
		tblRentList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() > 1) {	// ���� Ŭ�� ����
				
					int row = tblRentList.getSelectedRow();
					
					String ck = tblRentList.getValueAt(row, 7).toString();
					String ckN = "N";
					
					if (ck.equals(ckN)) {	// �ݳ� ���ΰ� N�� ���� ��Ͽ� �߰�
						ArrayList selRow = new ArrayList();
						selRow.add(tblRentList.getValueAt(row, 0)); // �뿩 ��ȣ
						selRow.add(tblRentList.getValueAt(row, 3)); // ������ ��
						selRow.add(tblRentList.getValueAt(row, 1)); // �뿩��
						selRow.add(tblRentList.getValueAt(row, 6)); // �ݳ� ������
						
						if (!returnSel.contains(selRow)) {
							returnSel.add(selRow);
						}
						
						setReturnListTable(returnSel);
					}
				}
			}
		});
		
		// �ݳ� �ǳ��� �뿩 ��ȣ �Է� �� ���� �� returnlist�� �߰�
		tfReturnRentNo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rNo = Integer.parseInt(tfReturnRentNo.getText());
				
				Object obj = model.searchRentNo(rNo);
				
				if (obj != null) {
					returnSel.add(obj);
					setReturnListTable(returnSel);
					tfReturnRentNo.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "�̹� �ݳ��Ǿ����ϴ�.");
				}	/* search�� ����� ���� �� (�뿩 ���ΰ� Y�� ��) ��ȯ�Ǵ� ����Ʈ�� ��� ��(0)�� 
					 * �ݳ� ����Ʈ�� �÷� ���� ���� �ʾ� ����� ������ searchRentNo�޼���� ���⿡�� if ������ ó����
					 *  => try-catch�� ���� ó�� �Ϸ��� setReturnListTable���� throw�ϰų� catch�ؾ� �ϴµ�, 
					 *  	sRLT�� ��ӹ��� �ڽ� Ŭ������ �� �� �Ұ����ϱ� ����
					 */
			
			}
		});
	
		
	} // eventProc()-End
	
	

	
	class BtnEvent implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object evt = e.getSource();
			//---------------������ �˻� ��ư Ŭ��, �ؽ�Ʈ �ʵ� ���� �Է� ��------------------	
			if (evt == btnToolSearch || evt == tfToolSearch) {
				String tName = tfToolSearch.getText();
				
				if (tName == "") {	// �ƹ��͵� �Է����� �ʾ��� ��쿣 ��ü ������ ����� ������
					setToolListTable();
				} else {
					ArrayList list = model.searchToolByName(tName);
					
					toolList.data = list;
					toolList.fireTableDataChanged();
					
					tfToolSearch.setText("");
				}
			//--------------- �뿩 ��ư Ŭ�� ------------------	
			} else if (evt == btnRent) {	
				
				try {
					String returnSche = String.format("%1$tY/%1$tm/%1$td", dcReturnSchedule.getDate());
					int tNo = Integer.parseInt(tfToolNo.getText());
					int stuNo = Integer.parseInt(tfStuNo.getText());
				
					Rent rent = new Rent(tNo, returnSche, stuNo);
					
					boolean poss = model.isRentPossible(tNo);	// �뿩 ���� ���� Ȯ��
					
					if (poss) {	// �뿩 ������ ���
						model.regist(rent);
						tfClear();
						setRentListTable();
					} else {	// �̹� �뿩 ���� ���
						JOptionPane.showMessageDialog(null, "�̹� �뿩�� �Դϴ�.");
					}
				
				} catch (Exception e3) {
					System.out.println("btnRent evt : �� �Էµ��� ����");
				}
			//-------------- �ݳ� ����Ʈ �ʱ�ȭ ��ư Ŭ�� ---------------------
			} else if (evt == btnReturnClear) {
				returnSel.clear();
				setReturnListTable(returnSel);
				
			//-------------- �ݳ� ����Ʈ �׸� ���� ��ư Ŭ�� ------------------
			} else if (evt == btnReturnDel && tblReturnList.getSelectedRow() != -1) {
				// �ƹ� �൵ �������� �ʰ� ���� ��ư�� ���� ��� ���̺� ������ ���� ���� ������ �߻��ϱ� ������ ���ǿ��� ó��
				
				int row = tblReturnList.getSelectedRow();
				Object obj = tblReturnList.getValueAt(row, 0);
				
				for (int i = 0; i < returnSel.size(); i++) {	// �� ��° ��Ҹ� ������ ���� �˾Ƴ��� �ϱ� ������ i�� �̿�
					ArrayList temp = (ArrayList)(returnSel.get(i));
					if (temp.get(0) == obj) {
						returnSel.remove(i);
						break;
					}
				}
				
				setReturnListTable(returnSel);
				
			//-------------- �ݳ� ��ư Ŭ�� ------------------			
			} else if (evt == btnReturn) {
				
				ArrayList ltemp = new ArrayList();
				Rent rtemp = new Rent();
				
				for (Object list : returnSel) {	// �ݳ� ��� ����� ��ҿ��� �뿩 ��ȣ�� �����ϰ�, Rent�� ��� ������ ��� �ݳ� �Լ� ȣ��
					ltemp = (ArrayList)list;
					rtemp.setRentNo(Integer.parseInt(ltemp.get(0).toString()));	// object Ÿ���� list�� string���� ��ȯ �� parseInt�� �̿��� ���������� ��ȯ
					
					model.modify(rtemp);
				}
				
				returnSel.clear();	// �ݳ� ��� ��� �ʱ�ȭ
				setReturnListTable(returnSel);	// �ݳ� ����Ʈ �ʱ�ȭ
				
//				rentList.data = copyList;	// �뿩 ����Ʈ ���ΰ�ħ
				
			//------------- �̹ݳ��� �뿩 ��ϸ� �����ִ� ���� ��ư Ŭ�� --------------
			} else if (evt == rdbtnNoReturnListView) {
				
				if (rdbtnNoReturnListView.isSelected()) { // ���� ��ư�� ���õǾ��� ��
					copyList = (ArrayList)(rentList.data).clone();	// ���� ����Ʈ�� Ŭ���� ��������� �����ص� copyList�� ������ (���� ��ư ���� ���� �� ���)
					
					ArrayList recentList = rentList.data; 	// ���� ȭ�鿡 �������� �ִ� ����Ʈ
					ArrayList noReturn = new ArrayList();	// �̹ݳ� �ุ �Էµ� ����Ʈ
					Object obj = "N";						// ������Ʈ Ÿ�Գ����� �񱳸� ���� ����

					for (int i = 0; i < recentList.size(); i++) {
						ArrayList temp = (ArrayList)(recentList.get(i));
						if (temp.get(7).equals(obj)) {
							noReturn.add(recentList.get(i));
						}
					}
					
					rentList.data = noReturn;
					rentList.fireTableDataChanged();
					
				} else { // ���� ��ư�� ������ �����Ǿ��� ��
					rentList.data = copyList;	// �����صξ��� ���� ��ư Ŭ�� ������ ����Ʈ�� ������
					rentList.fireTableDataChanged();
				}
			
			//-------------- ��¥�� �뿩 ��� ��ȸ ��ư Ŭ�� -----------------------
			} else if (evt == btnListView) {
				
				int cmbSel = cmbListDate.getSelectedIndex();
				String dateSel = String.format("%1$ty/%1$tm/%1$td", dcListView.getDate());
				
				ArrayList list = model.searchByDate(cmbSel, dateSel);

				rentList.data = list;
				rentList.fireTableDataChanged();

			//-------------- �뿩 ��� ���뺰 �˻� ��ư Ŭ�� -----------------------
			} else if (evt == btnListSearch || evt == tfListSearch) {
				
				int cmbSel = cmbListSearch.getSelectedIndex();
				String searchT = tfListSearch.getText();
				
				ArrayList list = model.searchByCol(cmbSel, searchT);

				rentList.data = list;
				rentList.fireTableDataChanged();
				
			//-------------- ���ΰ�ħ ��ư Ŭ�� ---------------------------------
			} else if (evt == btnRefresh) {
				setRentListTable();
				rdbtnNoReturnListView.setSelected(false);
				tfListSearch.setText("");
				dcListView.setDate(null);
				cmbListDate.setSelectedIndex(0);
				cmbListSearch.setSelectedIndex(0);
			}
			
		} // actionPerformed() -End
			
	} // BtnEvent -End
	
	
	public void tfClear() {
		dcReturnSchedule.setDate(null);
		tfToolNo.setText("");
		tfToolName.setText("");
		tfStuNo.setText("");
	} // tfClear() -End
	
	public void setRentListTable() {	// �뿩 ����Ʈ ������ �Է�
		try {
			ArrayList list = model.search();
			rentList.data = list;
			rentList.fireTableDataChanged();
			
		} catch (Exception e3) {
			JOptionPane.showMessageDialog(null, "�뿩 ���� �������� ����" + e3.getMessage());
		}
	} // setRentListTable()-End
	
	class RentList extends AbstractTableModel {		// �뿩 ����Ʈ ���̺�	
		  
		ArrayList data = new ArrayList();
		String [] columnNames = {"�뿩 ��ȣ", "�뿩��", "������ ��ȣ", "������ �̸�", "�й�", "�뿩��", "�ݳ� ������", "�ݳ� ����", "�ݳ���" };

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

	} // RentList-End
	
	public void setToolListTable() {	// ������ ����Ʈ ������ �Է�
		try {
			ArrayList list = model.toolSearch();
			toolList.data = list;
			toolList.fireTableDataChanged();
			
		} catch (Exception e3) {
			JOptionPane.showMessageDialog(null, "�뿩 ���� �������� ����" + e3.getMessage());
		}
	} // setToolListTable()-End
	
	
	class ToolList extends AbstractTableModel {	// ������ ����Ʈ ���̺�

		ArrayList data = new ArrayList();
		String [] columnNames = {"��ȣ", "������ ��"};

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
		
	} // ToolList-End
	
	
	public void setReturnListTable(ArrayList returnSel) {	// �ݳ� ����Ʈ ������ �Է�
		try {
			returnList.data = returnSel;
			returnList.fireTableDataChanged();
			
		} catch (Exception e3) {
			JOptionPane.showMessageDialog(null, "�ݳ� ���� �������� ����" + e3.getMessage());
		}
	} // setReturnListTable()-End
	
	
	class ReturnList extends AbstractTableModel{	// �ݳ� ����Ʈ ���̺�

		
		ArrayList data = new ArrayList();
		String [] columnNames = {"�뿩 ��ȣ", "������ �̸�", "�뿩��", "�ݳ� ������"};

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
		
	} // ReturnList-End
} // RentView-End

