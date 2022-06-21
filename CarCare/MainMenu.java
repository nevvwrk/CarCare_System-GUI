package CarCare;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainMenu extends JFrame implements ActionListener {
	
	JButton btnMenuForm,btnMenuReport,btnExit;
	public MainMenu() {
		// TODO Auto-generated constructor stub
		
		Container c = this.getContentPane();
		//layout object
		c.setLayout(new GridLayout(3,1));
		JLabel label1 = new JLabel("����� STOU CARCARE �ӡѴ",SwingConstants.CENTER);
		label1.setFont(new Font("Tahoma",Font.BOLD +Font.ITALIC,25));
		label1.setForeground(Color.green);
		c.add(label1);
				
		JPanel panel1 = new JPanel();
		btnMenuForm = new JButton("�к��Ѵ��â����ž�鹰ҹ");
		btnMenuForm.addActionListener(this);
		btnMenuForm.setFont(new Font("Tahoma",Font.PLAIN,14));
		
		btnMenuReport = new JButton("�к���§ҹ");
		btnMenuReport.addActionListener(this);
		btnMenuReport.setFont(new Font("Tahoma",Font.PLAIN ,14));
				
		panel1.add(btnMenuForm);
		panel1.add(btnMenuReport);
				
		c.add(panel1);
				
		JPanel panel2 = new JPanel();
		btnExit = new JButton("�͡�ҡ�����");
		btnExit.setFont(new Font("Tahoma",Font.PLAIN,14));
		btnExit.addActionListener(this);
		panel2.add(btnExit);
		c.add(panel2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnExit){
			System.exit(NORMAL);
		}
		else if(e.getSource() == btnMenuForm) {
			//open MenuForm
			
			MenuForm menuForm = new MenuForm();
			menuForm.setSize(700,300);
			menuForm.setTitle("�к��Ѵ��â����ž�鹰ҹ :���СԨ����ö¹��");
			menuForm.setVisible(true);
			menuForm.setDefaultCloseOperation(EXIT_ON_CLOSE);
			menuForm.setLocationRelativeTo(null);
		}
		else if(e.getSource() == btnMenuReport) {
			MenuReport menuReport = new MenuReport();
			menuReport.setSize(700,300);
			menuReport.setTitle("��èѴ�����§ҹ :���СԨ�����ѡ��ö¹��");
			menuReport.setVisible(true);
			menuReport.setDefaultCloseOperation(EXIT_ON_CLOSE);
			menuReport.setLocationRelativeTo(null);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainMenu menu1 = new MainMenu();
		menu1.setTitle("�к�����ö¹��");
		menu1.setSize(650,250);
		menu1.setVisible(true);
		
		
	}

}
