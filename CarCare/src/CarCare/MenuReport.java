package CarCare;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuReport extends JFrame implements ActionListener {
	JButton btnReportCustomer,btnReportFinance, btnReportService, btnReportExit;
	public MenuReport() {
		// TODO Auto-generated constructor stub
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(4,1));
		
		JPanel pReportCustomer = new JPanel();
		btnReportCustomer = new JButton("รายงานข้อมูลลูกค้า");
		btnReportCustomer.setFont(new Font("Tahoma",Font.PLAIN,14));
		pReportCustomer.add(btnReportCustomer);
		c.add(pReportCustomer);
		
		
		JPanel pReportFinance = new JPanel();
		btnReportFinance = new JButton("รายงานข้อมูลการเงิน");
		btnReportFinance.setFont(new Font("Tahoma",Font.PLAIN,14));
		pReportFinance.add(btnReportFinance);
		c.add(pReportFinance);
		
		JPanel pReportService = new JPanel();
		btnReportService = new JButton("รายงานข้อมูลการใช้บริการ");
		btnReportService.setFont(new Font("Tahoma",Font.PLAIN,14));
		pReportService.add(btnReportService);
		c.add(pReportService);
		

		JPanel pReportExit= new JPanel();
		btnReportExit = new JButton("ออกโปรแกรม");
		btnReportExit.addActionListener(this);
		btnReportExit.setFont(new Font("Tahoma",Font.PLAIN,14));
		pReportExit.add(btnReportExit);
		c.add(pReportExit);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnReportExit){
			System.exit(NORMAL);
		}
	}
}
