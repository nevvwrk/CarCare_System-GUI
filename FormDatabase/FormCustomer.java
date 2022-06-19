package FormDatabase;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class FormCustomer extends JFrame{
	JTextField txtCustNum, txtCustName, txtCustAddr, txtCustPhone,
	txtCustMail,txtSearchCust;
		
	JTable tableCust;
	DefaultTableModel modelCustomer;
		
	public FormCustomer() {
		UIManager.put("OptionPane.messageFont", new Font("Tahoma", Font.PLAIN, 13));
		UIManager.put("TitledBorder.font",(new Font("Tahoma", Font.PLAIN, 13)));
		UIManager.put("Label.font", new Font("Tahoma", Font.PLAIN, 13));
		UIManager.put("Button.font", new Font("Tahoma", Font.PLAIN, 13));
		UIManager.put("Table.font", new Font("Tahoma", Font.PLAIN, 13));
		UIManager.put("TableHeader.font", new Font("Tahoma", Font.PLAIN, 13));
		UIManager.put("TextField.font", new Font("Tahoma", Font.PLAIN, 13));
		
		
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		//left of container
		JPanel pNorth = new JPanel();
		pNorth.setLayout(new GridBagLayout()); 
		pNorth.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		//right of container 
		JPanel pEnd = new JPanel();
		pEnd.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		
		pEnd.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		//Panel for keep object in column one on pNorth
		JPanel panelForm = new JPanel();
		panelForm.setLayout(new GridLayout(10,1));
		JLabel labelCustNum = new JLabel("เลขที่ลูกค้า (CUST_NUM)");
		txtCustNum = new JTextField();
		txtCustNum.setPreferredSize(new Dimension(200,30));
		panelForm.add(labelCustNum);
		panelForm.add(txtCustNum);
		
		
		JLabel labelCustName = new JLabel("ชื่อลูกค้า (CUST_NAME)");
		txtCustName= new JTextField();
		txtCustName.setPreferredSize(new Dimension(200,30));
		panelForm.add(labelCustName);
		panelForm.add(txtCustName);
		
		JLabel labelCustAddr= new JLabel("ที่อยู่ลูกค้า (CUST_ADDR)");
		txtCustAddr= new JTextField();
		txtCustAddr.setPreferredSize(new Dimension(200,30));
		panelForm.add(labelCustAddr);
		panelForm.add(txtCustAddr);
		
		JLabel labelCustPhone = new JLabel("โทรศัพท์ลูกค้า (CUST_PHONE)");
		txtCustPhone= new JTextField();
		txtCustPhone.setPreferredSize(new Dimension(200,30));
		panelForm.add(labelCustPhone);
		panelForm.add(txtCustPhone);
		
		JLabel labelCustMail = new JLabel("อีเมลลูกค้า (CUST_MAIL)");
		txtCustMail = new JTextField();
		txtCustMail.setPreferredSize(new Dimension(200,30));
		panelForm.add(labelCustMail);
		panelForm.add(txtCustMail);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setLayout(new FlowLayout());
		JLabel lblSearch = new JLabel("ค้นหา");
		//float left search TextField
		//panelSearch.setLayout(new FlowLayout(FlowLayout.LEFT));
		txtSearchCust= new JTextField();
		txtSearchCust.setPreferredSize(new Dimension(200,30));
		panelSearch.add(lblSearch);
		panelSearch.add(txtSearchCust);
		
		//add panelSearch on pNorth in column two of pNorth
		
		//it's column one in pNorth
		//pNorth it's keep JLabel and JTextField all in windows
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		pNorth.add(panelSearch,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		pNorth.add(panelForm,gbc);
		
		c.add(pNorth,BorderLayout.LINE_START);
		////END LEFT SECTION OF CONTAINER
		
		//Button section
		JPanel panelButton = new JPanel();
		JButton cmdSaveCust = new JButton("เพิ่มข้อมูล");
		JButton cmdEditCust = new JButton("แก้ไข");
		JButton cmdDeleteCust = new JButton("ลบ");
		panelButton.add(cmdSaveCust);
		panelButton.add(cmdEditCust);
		panelButton.add(cmdDeleteCust);
		
		
		//table
		JPanel panelTable = new JPanel();
		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setPreferredSize(new Dimension(400,103));
		
		tableCust = new JTable();
		Object data[][] = {
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				
		};
		String header[] = {"เลขที่ลูกค้า","ชื่อลูกค้า","ที่อยู่ลูกค้า","เบอร์โทรศัพท์","อีเมล"};
		
		modelCustomer = new DefaultTableModel(data,header) {
			public boolean isCellEditable(int row,int columns) {
				return false;
			}
		};
			
		tableCust.setModel(modelCustomer);
		//if have items to much will show scroll bar
		scrollTable.setViewportView(tableCust);
		panelTable.add(scrollTable);
		

		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		pEnd.add(panelButton,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		pEnd.add(panelTable,gbc);
		
		c.add(pEnd,BorderLayout.LINE_END);
		////END RIGHT OF CONTAINER
	}
	

}
