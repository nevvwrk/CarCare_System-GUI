package net.formStou;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class formRegister extends JFrame {

	private DefaultTableModel modelRegister;
	JTextField tfId, tfName, tfAddress, tfChw, tfEd, tfMaj;

	public formRegister() {
		initUi();

	}

	public void initUi() {
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel panelHeader = new JPanel();
		panelHeader.setLayout(new GridLayout(4,1));
		
		JLabel header1 = new JLabel("บริษัท STOU-TEC จำกัด",SwingConstants.CENTER);
		JLabel header2 = new JLabel("แบบฟอร์มใบสมัครพนักงาน",SwingConstants.CENTER);
		JLabel header3 = new JLabel("ใบสมัครสำหรับงานด้าน ICT นี้ ให้ผู้สมัครกรอกรายละเอียดต่อไปนี้เพื่อที่",SwingConstants.CENTER);
		JLabel header4 = new JLabel("บริษัท STOU-TEC จำกัด ทำการคัดเลือกตามความเหมาะสม",SwingConstants.CENTER);
		header1.setFont(new Font("Angsana New",Font.BOLD,18));;
		header2.setFont(new Font("Angsana New",Font.BOLD,18));;
		header3.setFont(new Font("Angsana New",Font.BOLD,18));;	
		header4.setFont(new Font("Angsana New",Font.BOLD,18));;	
		
		panelHeader.add(header1);
		panelHeader.add(header2);
		panelHeader.add(header3);
		panelHeader.add(header4);
		
		c.add(panelHeader,BorderLayout.PAGE_START);
		
		GridBagConstraints gbc = new GridBagConstraints();
		//Section for insert into all around
		//set panelInto to GridBagLayout();
		//add panelInto to container
		
		//PanelInto
		JPanel panelInto = new JPanel(new GridBagLayout());
		panelInto.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		c.add(panelInto,BorderLayout.CENTER);
		
		//PanelTyping
		JPanel panelTyping = new JPanel(new GridLayout(7,2,2,2));

		//panel titleSkill
		JPanel titleSkill = new JPanel(new FlowLayout());
		
		//panel Skill
		JPanel panelSkill = new JPanel();
		panelSkill.setLayout(new GridLayout(5,2,1,1));
		
		//panel titlePostion
		JPanel titlePosition = new JPanel(new FlowLayout());
		
		//panel position
		JPanel panelPosition = new JPanel();
		panelPosition.setLayout(new GridLayout(3,2,1,1));
		
		//panel Button submit
		JPanel panelBt = new JPanel();
		panelBt.setLayout(new FlowLayout());

		//Constraints on different panel
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelInto.add(panelTyping, gbc);
				
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelInto.add(titleSkill, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelInto.add(panelSkill, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		panelInto.add(titlePosition, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		panelInto.add(panelPosition, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		panelInto.add(panelBt, gbc);
		
		//J for create UI section
		JLabel ap_id = new JLabel("เลขประจำตัวผู้สมัคร (AP_ID):");
		ap_id.setFont(new Font("Angsana New",Font.PLAIN,20));
		tfId = new JTextField();
		tfId.setFont(new Font("Angsana New",Font.PLAIN,20));
		
		
		JLabel ap_name = new JLabel("ชื่อ-นามสกุล (AP_NAME):");
		ap_name.setFont(new Font("Angsana New",Font.PLAIN,20));
		tfName = new JTextField();		
		tfName.setFont(new Font("Angsana New",Font.PLAIN,20));		
			
		JLabel ap_address = new JLabel("ที่อยู่ (AP_ADDRESS):");
		ap_address.setFont(new Font("Angsana New",Font.PLAIN,20));
		tfAddress = new JTextField();
		tfAddress.setFont(new Font("Angsana New",Font.PLAIN,20));

		JLabel ap_chw = new JLabel("จังหวัด (AP_CHW):");
		ap_chw.setFont(new Font("Angsana New",Font.PLAIN,20));
		tfChw = new JTextField();
		tfChw.setFont(new Font("Angsana New",Font.PLAIN,20));
		
		
		JLabel ap_sex = new JLabel("เพศ (AP_SEX):");
		ap_sex.setFont(new Font("Angsana New",Font.PLAIN,20));
		JPanel rdSex = new JPanel(new FlowLayout());
		JRadioButton rbMale = new JRadioButton("ชาย");
		rbMale.setFont(new Font("Angsana New",Font.PLAIN,20));
		JRadioButton rbFemale = new JRadioButton("หญิง");
		rbFemale.setFont(new Font("Angsana New",Font.PLAIN,20));
		rdSex.add(rbMale);
		rdSex.add(rbFemale);
		
		ButtonGroup groupSex = new ButtonGroup();
		groupSex.add(rbMale); 
		groupSex.add(rbFemale);

		JLabel ap_ed = new JLabel("<html>วุฒิการศึกษาสูงสุด (AP_ED): <br/>(เช่น B.S,B.A,M.S,M.BA,M.A)</html>");
		ap_ed.setFont(new Font("Angsana New",Font.PLAIN,20));
		tfEd = new JTextField();
		tfEd.setFont(new Font("Angsana New",Font.PLAIN,20));

		JLabel ap_maj = new JLabel("วิชาเอก (AP_MAJ):");
		ap_maj.setFont(new Font("Angsana New",Font.PLAIN,20));
		tfMaj = new JTextField();
		tfMaj.setFont(new Font("Angsana New",Font.PLAIN,20));
		
		//create title skill
		JLabel lbltoSkill = new JLabel("<html><b>ความรู้ความสามารถหรือคุณสมบัติเฉพาะตำแหน่ง (QUAL_DESC) (ตอบได้ไม่เกิน 5 รายการ)</b></html>");
		lbltoSkill.setFont(new Font("Angsana New",Font.BOLD,20));
		titleSkill.add(lbltoSkill);
		

		//skill section
		String skillList[]={"Web_ASP","C++","Database Administrator,DB2","Database Administrator,ORACLE","Graphic Design","JAVA","Management","Network","Secretarial work,40 words/min","Secretarial work,60 words/min","System Analyst, Level 1","System Analyst, Level 2","Visual Basic"};
		JLabel skill1 = new JLabel("ความรู้ความสามารถ 1");
		skill1.setFont(new Font("Angsana New",Font.PLAIN,20));
		JComboBox cbSkill1 = new JComboBox(skillList);
	
		
		JLabel skill2 = new JLabel("ความรู้ความสามารถ 2");
		skill2.setFont(new Font("Angsana New",Font.PLAIN,20));
		
		JComboBox cbSkill2 = new JComboBox(skillList);
		
		JLabel skill3 = new JLabel("ความรู้ความสามารถ 3");
		skill3.setFont(new Font("Angsana New",Font.PLAIN,20));
		
		JComboBox cbSkill3 = new JComboBox(skillList);
		
		JLabel skill4 = new JLabel("ความรู้ความสามารถ 4");
		skill4.setFont(new Font("Angsana New",Font.PLAIN,20));
		
		JComboBox cbSkill4 = new JComboBox(skillList);
		
		
		//create position
		JLabel lbltoPosition = new JLabel("<html><b>ตำแหน่งที่ต้องการสมัคร (POS_NAME): (ตอบได้ไม่เกิน 5 รายการ)</b></html>");
		lbltoPosition.setFont(new Font("Angsana New",Font.BOLD,20));
		titlePosition.add(lbltoPosition);

		String position[]= {"Technical Programmer","Web Developer","Ganeral Manager","ICT Specialist","E-Business Analyst","ICT Documenter","Database Administrator","PC Administrator","Network Specialist","ICT Manager"};
		JLabel position1 = new JLabel("ตำแหน่งทีต้องการสมัคร 1");
		position1.setFont(new Font("Angsana New",Font.PLAIN,20));
		JComboBox cbPosition1 = new JComboBox(position);
		
		JLabel position2 = new JLabel("ตำแหน่งที่ต้องการสมัคร 2");
		position2.setFont(new Font("Angsana New",Font.PLAIN,20));
		JComboBox cbPosition2 = new JComboBox(position);
		
		JLabel position3 = new JLabel("ตำแหน่งที่ต้องการสมัคร 3");
		position3.setFont(new Font("Angsana New",Font.PLAIN,20));
		JComboBox cbPosition3 = new JComboBox(position);

		// create button submit
		JButton submit = new JButton("ตกลง");
		submit.setFont(new Font("Angsana New",Font.PLAIN,20));
		
		//create button panel
		//submit button for into information and response to new windows and show information
		

		//work space of panelTyping
		panelTyping.add(ap_id);
		panelTyping.add(tfId);
		panelTyping.add(ap_name);
		panelTyping.add(tfName);
		panelTyping.add(ap_address);
		panelTyping.add(tfAddress);
		panelTyping.add(ap_chw);
		panelTyping.add(tfChw);
		panelTyping.add(ap_sex);
		panelTyping.add(rdSex);
		panelTyping.add(ap_ed);
		panelTyping.add(tfEd);
		panelTyping.add(ap_maj);
		panelTyping.add(tfMaj);

		//work space of panel Skill section
		panelSkill.add(skill1);
		panelSkill.add(cbSkill1);
		panelSkill.add(skill2);
		panelSkill.add(cbSkill2);
		panelSkill.add(skill3);
		panelSkill.add(cbSkill3);
		panelSkill.add(skill4);
		panelSkill.add(cbSkill4);

		//panelPosition workspace
		panelPosition.add(position1);
		panelPosition.add(cbPosition1);
		panelPosition.add(position2);
		panelPosition.add(cbPosition2);
		panelPosition.add(position3);
		panelPosition.add(cbPosition3);

		//panelSubmit button
		panelBt.add(submit);
	}

	public static void main(String[] args) {

		formRegister frame = new formRegister();
		frame.setSize(1000, 800);
		frame.setTitle("STOU Register");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

	}

}
