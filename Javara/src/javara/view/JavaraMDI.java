package javara.view;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane; /*�߰�*/
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
		
		JMenu mnMember = new JMenu("�к� ������");	// �޴��� ����
		mnMember.setFont(new Font("���� ���", Font.PLAIN, 12));
		menuBar.add(mnMember);
		
		JMenuItem mnStu = new JMenuItem("�кλ� ����");
		mnStu.setFont(new Font("���� ���", Font.PLAIN, 12));
		mnStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentView stuView = new StudentView();	// �л� view
				mdiFormSetting(stuView);
			}
		});
		mnMember.add(mnStu);
		
		JMenuItem mnProf = new JMenuItem("������ ����");
		mnProf.setFont(new Font("���� ���", Font.PLAIN, 12));
		mnProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProfessorView profView = new ProfessorView();	// ���� view
				mdiFormSetting(profView);
			}
		});
		mnMember.add(mnProf);
		
//----------------------------------------------------------------------------------		
		
		JMenu mnTool = new JMenu("������ ����");
		mnTool.setFont(new Font("���� ���", Font.PLAIN, 12));
		menuBar.add(mnTool);
		
		JMenuItem mnToolInfo = new JMenuItem("������ ����");
		mnToolInfo.setFont(new Font("���� ���", Font.PLAIN, 12));
		mnToolInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ToolView toolView = new ToolView();		//������ view
				mdiFormSetting(toolView);
			}
		});
		mnTool.add(mnToolInfo);
		
		JMenuItem mnRent = new JMenuItem("�뿩/�ݳ�");
		mnRent.setFont(new Font("���� ���", Font.PLAIN, 12));
		mnRent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RentView rentView = new RentView(); 	//�뿩 view
				mdiFormSetting(rentView);
			}
		});
		mnTool.add(mnRent);
		
//----------------------------------------------------------------------------------		
		
		JMenu mnProject = new JMenu("���� ���� ����");	// �޴��� ����
		mnProject.setFont(new Font("���� ���", Font.PLAIN, 12));
		
		menuBar.add(mnProject);
		
		JMenuItem mnPjInfo = new JMenuItem("���� �⺻ ����");
		mnPjInfo.setFont(new Font("���� ���", Font.PLAIN, 12));
		mnPjInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jfProject pjtView = new jfProject();	// ���� view
				mdiFormSetting(pjtView);
			}
		});
		mnProject.add(mnPjInfo);
		
		JMenuItem mnPjInfo2 = new JMenuItem("���� ���� ����");
		mnPjInfo2.setFont(new Font("���� ���", Font.PLAIN, 12));
		mnPjInfo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jfProjectPlan pjtPlanView = new jfProjectPlan();	// ���� ���� ���� view
				mdiFormSetting(pjtPlanView);
			}
		});
		mnProject.add(mnPjInfo2);
		
		JMenuItem mnProRep = new JMenuItem("���� ����");
		mnProRep.setFont(new Font("���� ���", Font.PLAIN, 12));
		mnProRep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jfProjectReports pjtReportView = new jfProjectReports();	// ����Ʈ view
				mdiFormSetting(pjtReportView);
			}
		});
		mnProject.add(mnProRep);
		
		JMenuItem mnCoop = new JMenuItem("���»� ����");
		mnCoop.setFont(new Font("���� ���", Font.PLAIN, 12));
		mnCoop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jfCoop coopView = new jfCoop();	// ���»� view
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
