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
	
	private String dateSearch[]	= {"대여일","반납 예정일","반납일"};
	private String txtSearch[]	= {"대여 번호","기자재 번호","기자재 이름","대여자 학번","대여자 이름"};
	
	private JDateChooser dcReturnSchedule;
	private JDateChooser dcListView;
	
	private JRadioButton rdbtnNoReturnListView;
	
	private ArrayList returnSel = new ArrayList();	// 반납 목록 보관용
	private ArrayList copyList = new ArrayList();	// 라디오 선택 이전의 리스트 복사용
	
	
	SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy/MM/dd", Locale.KOREA );
	Date currentTime = new Date ();
	String mTime = mSimpleDateFormat.format(currentTime);


	
	/**
	 * Launch the application.
	 */
	
	//=====================임시 main=====================
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
		setTitle("기자재 대여/반납");
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
		lbTItle.setFont(new Font("맑은 고딕", Font.BOLD, 25));
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
		btnRent.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnRent.setBounds(373, 277, 97, 33);
		jpRent.add(btnRent);
		
		JPanel jpRentInfoTf = new JPanel();
		jpRentInfoTf.setBounds(140, 10, 330, 267);
		jpRent.add(jpRentInfoTf);
		jpRentInfoTf.setLayout(null);
		
		tfRentDate = new JTextField();
		tfRentDate.setForeground(new Color(51, 51, 51));
		tfRentDate.setText(mTime);
		tfRentDate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tfRentDate.setEditable(false);
		tfRentDate.setColumns(10);
		tfRentDate.setBounds(0, 10, 330, 30);
		jpRentInfoTf.add(tfRentDate);
		
		tfToolName = new JTextField();
		tfToolName.setForeground(new Color(51, 51, 51));
		tfToolName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tfToolName.setEditable(false);
		tfToolName.setColumns(10);
		tfToolName.setBounds(0, 187, 330, 30);
		jpRentInfoTf.add(tfToolName);
		
		tfStuNo = new JTextField();
		tfStuNo.setForeground(new Color(51, 51, 51));
		tfStuNo.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
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
		tfToolNo.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tfToolNo.setColumns(10);
		tfToolNo.setBounds(0, 147, 330, 30);
		jpRentInfoTf.add(tfToolNo);
		
		JPanel jpRentInfoLb = new JPanel();
		jpRentInfoLb.setBounds(12, 10, 116, 267);
		jpRent.add(jpRentInfoLb);
		jpRentInfoLb.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uB300\uC5EC \uC77C\uC790");
		lblNewLabel_1_1.setForeground(new Color(51, 51, 51));
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setBounds(12, 10, 92, 30);
		jpRentInfoLb.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uBC18\uB0A9 \uC608\uC815\uC77C");
		lblNewLabel_1_2.setForeground(new Color(51, 51, 51));
		lblNewLabel_1_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setBounds(12, 50, 92, 30);
		jpRentInfoLb.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("\uAE30\uC790\uC7AC \uC774\uB984");
		lblNewLabel_1_3.setForeground(new Color(51, 51, 51));
		lblNewLabel_1_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setBounds(12, 187, 92, 30);
		jpRentInfoLb.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("\uB300\uC5EC\uC790 \uD559\uBC88");
		lblNewLabel_1_4.setForeground(new Color(51, 51, 51));
		lblNewLabel_1_4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_4.setBounds(12, 227, 92, 30);
		jpRentInfoLb.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("\uAE30\uC790\uC7AC \uBC88\uD638");
		lblNewLabel_1_3_1.setForeground(new Color(51, 51, 51));
		lblNewLabel_1_3_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
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
		btnListSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnListSearch.setBounds(1030, 10, 97, 23);
		jpRentList.add(btnListSearch);
		
		tfListSearch = new JTextField();
		tfListSearch.setForeground(new Color(51, 51, 51));
		tfListSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tfListSearch.setBounds(797, 10, 221, 23);
		jpRentList.add(tfListSearch);
		tfListSearch.setColumns(10);
		
		cmbListSearch = new JComboBox(txtSearch);
		cmbListSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		cmbListSearch.setBounds(665, 10, 127, 23);
		jpRentList.add(cmbListSearch);
		
		cmbListDate = new JComboBox(dateSearch);
		cmbListDate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		cmbListDate.setBounds(12, 10, 127, 23);
		jpRentList.add(cmbListDate);
		
		dcListView = new JDateChooser();
		dcListView.setBounds(142, 10, 153, 23);
		jpRentList.add(dcListView);
		dcListView.setDateFormatString("yyyy/MM/dd");
		
		btnListView = new JButton("\uC870\uD68C");
		btnListView.setForeground(new Color(51, 51, 51));
		btnListView.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnListView.setBounds(307, 10, 79, 23);
		jpRentList.add(btnListView);
		
		rdbtnNoReturnListView = new JRadioButton("\uBBF8\uBC18\uB0A9\uB9CC \uBCF4\uAE30");
		rdbtnNoReturnListView.setForeground(new Color(51, 51, 51));
		rdbtnNoReturnListView.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		rdbtnNoReturnListView.setBounds(394, 10, 121, 23);
		jpRentList.add(rdbtnNoReturnListView);
		
		JScrollPane spRentList = new JScrollPane();
		spRentList.setBounds(12, 38, 1115, 294);
		jpRentList.add(spRentList);
		
		tblRentList = new JTable(rentList);
		tblRentList.setForeground(new Color(51, 51, 51));
		tblRentList.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
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
		btnReturn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnReturn.setBounds(291, 277, 97, 33);
		jpReturn.add(btnReturn);
		
		JPanel jpReturnInfoTf = new JPanel();
		jpReturnInfoTf.setBounds(128, 199, 260, 78);
		jpReturn.add(jpReturnInfoTf);
		jpReturnInfoTf.setLayout(null);
		
		tfReturnRentNo = new JTextField();
		tfReturnRentNo.setForeground(new Color(51, 51, 51));
		tfReturnRentNo.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tfReturnRentNo.setColumns(10);
		tfReturnRentNo.setBounds(0, 0, 260, 30);
		jpReturnInfoTf.add(tfReturnRentNo);
		
		tfReturnDate = new JTextField();
		tfReturnDate.setForeground(new Color(51, 51, 51));
		tfReturnDate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
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
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		label.setBounds(12, 38, 82, 30);
		jpReturnInfoLb.add(label);
		
		JLabel label_1 = new JLabel("\uB300\uC5EC \uBC88\uD638");
		label_1.setForeground(new Color(51, 51, 51));
		label_1.setBounds(12, 0, 82, 30);
		jpReturnInfoLb.add(label_1);
		label_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		JScrollPane spReturnList = new JScrollPane();
		spReturnList.setBounds(12, 10, 376, 179);
		jpReturn.add(spReturnList);
		
		tblReturnList = new JTable(returnList);
		tblReturnList.setForeground(new Color(51, 51, 51));
		tblReturnList.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tblReturnList.setRowHeight(20);
		spReturnList.setViewportView(tblReturnList);
		
		btnReturnClear = new JButton("\uCD08\uAE30\uD654");
		btnReturnClear.setForeground(new Color(51, 51, 51));
		btnReturnClear.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnReturnClear.setBounds(12, 287, 77, 23);
		jpReturn.add(btnReturnClear);
		
		btnReturnDel = new JButton("\uC0AD\uC81C");
		btnReturnDel.setForeground(new Color(51, 51, 51));
		btnReturnDel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnReturnDel.setBounds(101, 287, 77, 23);
		jpReturn.add(btnReturnDel);
		
		JPanel jpReturnTitle = new JPanel();
		jpReturnTitle.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(102, 102, 102)));
		jpReturnTitle.setBackground(new Color(192, 192, 192));
		jpReturnTitle.setBounds(742, 48, 400, 31);
		contentPane.add(jpReturnTitle);
		
		JLabel lbReturnTitle = new JLabel("\uBC18\uB0A9");
		lbReturnTitle.setForeground(new Color(51, 51, 51));
		lbReturnTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jpReturnTitle.add(lbReturnTitle);
		
		JPanel jpRentTitle = new JPanel();
		jpRentTitle.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(102, 102, 102)));
		jpRentTitle.setBackground(new Color(192, 192, 192));
		jpRentTitle.setBounds(248, 48, 482, 31);
		contentPane.add(jpRentTitle);
		
		JLabel lbRentTitle = new JLabel("\uB300\uC5EC");
		lbRentTitle.setForeground(new Color(51, 51, 51));
		lbRentTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
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
		btnToolSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnToolSearch.setBounds(153, 276, 66, 34);
		jpTool.add(btnToolSearch);
		
		tfToolSearch = new JTextField();
		tfToolSearch.setForeground(new Color(51, 51, 51));
		tfToolSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tfToolSearch.setBounds(12, 277, 140, 33);
		jpTool.add(tfToolSearch);
		tfToolSearch.setColumns(10);
		
		JScrollPane spToolList = new JScrollPane();
		spToolList.setBounds(12, 10, 207, 256);
		jpTool.add(spToolList);
		
		tblToolList = new JTable(toolList);
		tblToolList.setForeground(new Color(51, 51, 51));
		tblToolList.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
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
		lbToolTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jpToolTitle.add(lbToolTitle);
		
		btnRefresh = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		btnRefresh.setForeground(new Color(51, 51, 51));
		btnRefresh.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnRefresh.setBounds(15, 760, 97, 23);
		contentPane.add(btnRefresh);
	} // rentViewLayout()-End

	//=================================================
	
	public void eventProc() {
		// 버튼 클릭 이벤트
		BtnEvent evt = new BtnEvent();
		
		btnRent.addActionListener(evt); 		// 대여
		btnListSearch.addActionListener(evt); 	// 대여 목록 텍스트 검색
		btnListView.addActionListener(evt);		// 대여 목록 날짜별 검색
		btnReturn.addActionListener(evt);		// 반납
		btnToolSearch.addActionListener(evt); 	// 기자재 검색
		tfToolSearch.addActionListener(evt); 	// 기자재 검색창
		btnReturnClear.addActionListener(evt); 	// 반납 리스트 초기화
		btnReturnDel.addActionListener(evt); 	// 반납 리스트 항목 삭제
		rdbtnNoReturnListView.addActionListener(evt);	// 미반납된 대여 목록만 보기
		btnRefresh.addActionListener(evt); 		// 대여 리스트 새로고침
		tfListSearch.addActionListener(evt); 	// 대여 목록 검색창
		
		// ToolList 레코드 클릭 시 기자재 번호와 이름을 대여 칸 필드에 채움
		tblToolList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tblToolList.getSelectedRow();
				
				String tNo = String.valueOf(tblToolList.getValueAt(row, 0));
				tfToolNo.setText(tNo);
				
				String tName = String.valueOf(tblToolList.getValueAt(row, 1));
				tfToolName.setText(tName);
			}
		});
		
		
		// 기자재 번호 입력 후 엔터 시 기자재 이름이 자동으로 채워짐
		tfToolNo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int tNo = Integer.parseInt(tfToolNo.getText());
				String tName = model.searchToolByNo(tNo);
				
				tfToolName.setText(tName);
			}
		});
		
		
		// RentList 레코드 더블클릭 시 Return list에 등록
		tblRentList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() > 1) {	// 더블 클릭 조건
				
					int row = tblRentList.getSelectedRow();
					
					String ck = tblRentList.getValueAt(row, 7).toString();
					String ckN = "N";
					
					if (ck.equals(ckN)) {	// 반납 여부가 N일 때만 목록에 추가
						ArrayList selRow = new ArrayList();
						selRow.add(tblRentList.getValueAt(row, 0)); // 대여 번호
						selRow.add(tblRentList.getValueAt(row, 3)); // 기자재 명
						selRow.add(tblRentList.getValueAt(row, 1)); // 대여일
						selRow.add(tblRentList.getValueAt(row, 6)); // 반납 예정일
						
						if (!returnSel.contains(selRow)) {
							returnSel.add(selRow);
						}
						
						setReturnListTable(returnSel);
					}
				}
			}
		});
		
		// 반납 판넬의 대여 번호 입력 후 엔터 시 returnlist에 추가
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
					JOptionPane.showMessageDialog(null, "이미 반납되었습니다.");
				}	/* search의 결과가 없을 때 (대여 여부가 Y일 때) 반환되는 리스트의 요소 수(0)가 
					 * 반납 리스트의 컬럼 수와 맞지 않아 생기는 오류를 searchRentNo메서드와 여기에서 if 문으로 처리함
					 *  => try-catch로 예외 처리 하려면 setReturnListTable에서 throw하거나 catch해야 하는데, 
					 *  	sRLT는 상속받은 자식 클래스라 둘 다 불가능하기 때문
					 */
			
			}
		});
	
		
	} // eventProc()-End
	
	

	
	class BtnEvent implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object evt = e.getSource();
			//---------------기자재 검색 버튼 클릭, 텍스트 필드 엔터 입력 시------------------	
			if (evt == btnToolSearch || evt == tfToolSearch) {
				String tName = tfToolSearch.getText();
				
				if (tName == "") {	// 아무것도 입력하지 않았을 경우엔 전체 기자재 목록을 보여줌
					setToolListTable();
				} else {
					ArrayList list = model.searchToolByName(tName);
					
					toolList.data = list;
					toolList.fireTableDataChanged();
					
					tfToolSearch.setText("");
				}
			//--------------- 대여 버튼 클릭 ------------------	
			} else if (evt == btnRent) {	
				
				try {
					String returnSche = String.format("%1$tY/%1$tm/%1$td", dcReturnSchedule.getDate());
					int tNo = Integer.parseInt(tfToolNo.getText());
					int stuNo = Integer.parseInt(tfStuNo.getText());
				
					Rent rent = new Rent(tNo, returnSche, stuNo);
					
					boolean poss = model.isRentPossible(tNo);	// 대여 가능 여부 확인
					
					if (poss) {	// 대여 가능할 경우
						model.regist(rent);
						tfClear();
						setRentListTable();
					} else {	// 이미 대여 중인 경우
						JOptionPane.showMessageDialog(null, "이미 대여중 입니다.");
					}
				
				} catch (Exception e3) {
					System.out.println("btnRent evt : 값 입력되지 않음");
				}
			//-------------- 반납 리스트 초기화 버튼 클릭 ---------------------
			} else if (evt == btnReturnClear) {
				returnSel.clear();
				setReturnListTable(returnSel);
				
			//-------------- 반납 리스트 항목 삭제 버튼 클릭 ------------------
			} else if (evt == btnReturnDel && tblReturnList.getSelectedRow() != -1) {
				// 아무 행도 선택하지 않고 삭제 버튼을 누를 경우 테이블 구성에 대한 범위 오류가 발생하기 때문에 조건에서 처리
				
				int row = tblReturnList.getSelectedRow();
				Object obj = tblReturnList.getValueAt(row, 0);
				
				for (int i = 0; i < returnSel.size(); i++) {	// 몇 번째 요소를 지워야 할지 알아내야 하기 때문에 i를 이용
					ArrayList temp = (ArrayList)(returnSel.get(i));
					if (temp.get(0) == obj) {
						returnSel.remove(i);
						break;
					}
				}
				
				setReturnListTable(returnSel);
				
			//-------------- 반납 버튼 클릭 ------------------			
			} else if (evt == btnReturn) {
				
				ArrayList ltemp = new ArrayList();
				Rent rtemp = new Rent();
				
				for (Object list : returnSel) {	// 반납 대기 목록의 요소에서 대여 번호를 추출하고, Rent의 멤버 변수에 담아 반납 함수 호출
					ltemp = (ArrayList)list;
					rtemp.setRentNo(Integer.parseInt(ltemp.get(0).toString()));	// object 타입인 list를 string으로 변환 후 parseInt를 이용해 정수형으로 변환
					
					model.modify(rtemp);
				}
				
				returnSel.clear();	// 반납 대기 목록 초기화
				setReturnListTable(returnSel);	// 반납 리스트 초기화
				
//				rentList.data = copyList;	// 대여 리스트 새로고침
				
			//------------- 미반납된 대여 목록만 보여주는 라디오 버튼 클릭 --------------
			} else if (evt == rdbtnNoReturnListView) {
				
				if (rdbtnNoReturnListView.isSelected()) { // 라디오 버튼이 선택되었을 때
					copyList = (ArrayList)(rentList.data).clone();	// 현재 리스트를 클래스 멤버변수로 선언해둔 copyList에 복사함 (라디오 버튼 선택 해제 시 사용)
					
					ArrayList recentList = rentList.data; 	// 현재 화면에 보여지고 있는 리스트
					ArrayList noReturn = new ArrayList();	// 미반납 행만 입력될 리스트
					Object obj = "N";						// 오브젝트 타입끼리의 비교를 위한 변수

					for (int i = 0; i < recentList.size(); i++) {
						ArrayList temp = (ArrayList)(recentList.get(i));
						if (temp.get(7).equals(obj)) {
							noReturn.add(recentList.get(i));
						}
					}
					
					rentList.data = noReturn;
					rentList.fireTableDataChanged();
					
				} else { // 라디오 버튼의 선택이 해제되었을 때
					rentList.data = copyList;	// 복사해두었던 라디오 버튼 클릭 이전의 리스트를 보여줌
					rentList.fireTableDataChanged();
				}
			
			//-------------- 날짜별 대여 목록 조회 버튼 클릭 -----------------------
			} else if (evt == btnListView) {
				
				int cmbSel = cmbListDate.getSelectedIndex();
				String dateSel = String.format("%1$ty/%1$tm/%1$td", dcListView.getDate());
				
				ArrayList list = model.searchByDate(cmbSel, dateSel);

				rentList.data = list;
				rentList.fireTableDataChanged();

			//-------------- 대여 목록 내용별 검색 버튼 클릭 -----------------------
			} else if (evt == btnListSearch || evt == tfListSearch) {
				
				int cmbSel = cmbListSearch.getSelectedIndex();
				String searchT = tfListSearch.getText();
				
				ArrayList list = model.searchByCol(cmbSel, searchT);

				rentList.data = list;
				rentList.fireTableDataChanged();
				
			//-------------- 새로고침 버튼 클릭 ---------------------------------
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
	
	public void setRentListTable() {	// 대여 리스트 데이터 입력
		try {
			ArrayList list = model.search();
			rentList.data = list;
			rentList.fireTableDataChanged();
			
		} catch (Exception e3) {
			JOptionPane.showMessageDialog(null, "대여 내역 가져오기 실패" + e3.getMessage());
		}
	} // setRentListTable()-End
	
	class RentList extends AbstractTableModel {		// 대여 리스트 테이블	
		  
		ArrayList data = new ArrayList();
		String [] columnNames = {"대여 번호", "대여일", "기자재 번호", "기자재 이름", "학번", "대여자", "반납 예정일", "반납 여부", "반납일" };

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
	
	public void setToolListTable() {	// 기자재 리스트 데이터 입력
		try {
			ArrayList list = model.toolSearch();
			toolList.data = list;
			toolList.fireTableDataChanged();
			
		} catch (Exception e3) {
			JOptionPane.showMessageDialog(null, "대여 내역 가져오기 실패" + e3.getMessage());
		}
	} // setToolListTable()-End
	
	
	class ToolList extends AbstractTableModel {	// 기자재 리스트 테이블

		ArrayList data = new ArrayList();
		String [] columnNames = {"번호", "기자재 명"};

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
	
	
	public void setReturnListTable(ArrayList returnSel) {	// 반납 리스트 데이터 입력
		try {
			returnList.data = returnSel;
			returnList.fireTableDataChanged();
			
		} catch (Exception e3) {
			JOptionPane.showMessageDialog(null, "반납 내역 가져오기 실패" + e3.getMessage());
		}
	} // setReturnListTable()-End
	
	
	class ReturnList extends AbstractTableModel{	// 반납 리스트 테이블

		
		ArrayList data = new ArrayList();
		String [] columnNames = {"대여 번호", "기자재 이름", "대여일", "반납 예정일"};

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

