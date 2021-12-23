package javara.view;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane; /*추가*/
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JavaraMDI extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane ;
	private ImageIcon icon;
	

	private void mdiFormSetting(JInternalFrame oIframe)
	{		
		boolean bObj= true;
		JInternalFrame[] allFrames = desktopPane.getAllFrames();
	       
		for(int i=0; i<allFrames.length; i++){
			if(allFrames[i].getClass() ==  oIframe.getClass()){
				bObj= false;
				break;
			}			
		}
		
		if(bObj){
			desktopPane.add(oIframe);
			oIframe.setVisible(true);
		}
	}
	/**
	 * Create the frame.
	 */
	public JavaraMDI() {
		setTitle("Javara");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 550);
		
		
//=====================================================================================		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
//----------------------------------------------------------------------------------
		
		JMenu mnMember = new JMenu("학부 구성원");	// 메뉴명 수정
		mnMember.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		menuBar.add(mnMember);
		
		JMenuItem mnStu = new JMenuItem("학부생 정보");
		mnStu.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mnStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentView stuView = new StudentView();	// 학생 view
				mdiFormSetting(stuView);
			}
		});
		mnMember.add(mnStu);
		
		JMenuItem mnProf = new JMenuItem("교직원 정보");
		mnProf.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mnProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProfessorView profView = new ProfessorView();	// 교수 view
				mdiFormSetting(profView);
			}
		});
		mnMember.add(mnProf);
		
//----------------------------------------------------------------------------------		
		
		JMenu mnTool = new JMenu("기자재 관리");
		mnTool.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		menuBar.add(mnTool);
		
		JMenuItem mnToolInfo = new JMenuItem("기자재 정보");
		mnToolInfo.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mnToolInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ToolView toolView = new ToolView();		//기자재 view
				mdiFormSetting(toolView);
			}
		});
		mnTool.add(mnToolInfo);
		
		JMenuItem mnRent = new JMenuItem("대여/반납");
		mnRent.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mnRent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RentView rentView = new RentView(); 	//대여 view
				mdiFormSetting(rentView);
			}
		});
		mnTool.add(mnRent);
		
//----------------------------------------------------------------------------------		
		
		JMenu mnProject = new JMenu("과제 정보 관리");	// 메뉴명 수정
		mnProject.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		menuBar.add(mnProject);
		
		JMenuItem mnPjInfo = new JMenuItem("과제 기본 정보");
		mnPjInfo.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mnPjInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jfProject pjtView = new jfProject();	// 과제 view
				mdiFormSetting(pjtView);
			}
		});
		mnProject.add(mnPjInfo);
		
		JMenuItem mnPjInfo2 = new JMenuItem("과제 예산 정보");
		mnPjInfo2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mnPjInfo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jfProjectPlan pjtPlanView = new jfProjectPlan();	// 과제 예산 정보 view
				mdiFormSetting(pjtPlanView);
			}
		});
		mnProject.add(mnPjInfo2);
		
		JMenuItem mnProRep = new JMenuItem("과제 보고서");
		mnProRep.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mnProRep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jfProjectReports pjtReportView = new jfProjectReports();	// 레포트 view
				mdiFormSetting(pjtReportView);
			}
		});
		mnProject.add(mnProRep);
		
		JMenuItem mnCoop = new JMenuItem("협력사 정보");
		mnCoop.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mnCoop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jfCoop coopView = new jfCoop();	// 협력사 view
				mdiFormSetting(coopView);
			}
		});
		mnProject.add(mnCoop);
		
//=====================================================================================
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		icon = new ImageIcon("./javara.image/back.png");
		contentPane.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane() {
            public void paintComponent(Graphics g) {
            	g.drawImage(icon.getImage(), 0, 0, null);
            	setOpaque(false);
            	super.paintComponent(g);
            }
        };
		contentPane.add(desktopPane);
		
		
		
		
	}
}
