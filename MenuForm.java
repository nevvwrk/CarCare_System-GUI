import java.awt.Button;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import FormDatabase.FormCustomer;

public class MenuForm extends JFrame implements ActionListener {

	JButton btnCustomer, btnInvoice, btnService, btnEmployee, btnInv_serv;
	public MenuForm() {
		// TODO Auto-generated constructor stub
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(5,1));
		
		JPanel pCustomer = new JPanel();
		btnCustomer = new JButton("ข้อมูลลูกค้า (CUSTOMER)");
		btnCustomer.addActionListener(this);
		btnCustomer.setFont(new Font("Tahoma",Font.PLAIN,14));
		pCustomer.add(btnCustomer);
		c.add(pCustomer);
		
		JPanel pInvoice = new JPanel();
		btnInvoice = new JButton("ข้อมูลใบแจ้งหนี้ (INVOICE)");
		btnInvoice.setFont(new Font("Tahoma",Font.PLAIN,14));
		pInvoice.add(btnInvoice);
		c.add(pInvoice);
		
		JPanel pService = new JPanel();
		btnService = new JButton("ข้อมูลบริการ (SERVICE)");
		btnService.setFont(new Font("Tahoma",Font.PLAIN,14));
		pService.add(btnService);	
		c.add(pCustomer);
		
		
		JPanel pEmployee = new JPanel();
		btnEmployee = new JButton("ข้อมูลพนักงาน (EMPLOYEE)");
		btnEmployee.setFont(new Font("Tahoma",Font.PLAIN,14));
		pEmployee.add(btnEmployee);	
		c.add(pEmployee);
		
		JPanel pInv_serv = new JPanel();
		btnInv_serv = new JButton("ข้อมูใบแจ้งหนี้ระบุการบริการ(INV_SERV)");
		btnInv_serv.setFont(new Font("Tahoma",Font.PLAIN,14));
		pInv_serv.add(btnInv_serv);
		c.add(pInv_serv);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCustomer) {
		FormCustomer formCustomer = new FormCustomer();
		formCustomer.setSize(800,400);
		formCustomer.setTitle("การจัดการข้อมูลลูกค้า (CUSTOMER)");
		formCustomer.setVisible(true);
		formCustomer.setDefaultCloseOperation(EXIT_ON_CLOSE);
		formCustomer.setLocationRelativeTo(null);
		}
	}

}
