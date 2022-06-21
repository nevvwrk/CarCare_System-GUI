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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import CarCare.MyConnect;

public class FormCustomer extends JFrame{
	
	Connection conn = MyConnect.getConnection();
	
	
	JTextField txtCustNum, txtCustName, txtCustAddr, txtCustPhone,
	txtCustMail,txtSearchCust;
	
	JButton cmdSaveCust, cmdClear;
		
	JTable tableCust;
	DefaultTableModel modelCustomer;
		
	public FormCustomer() {
		
		if(conn != null) {
			System.out.println("Database connected ");

		} else {
			System.out.println("Not Connected");
		}
		
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
		//automatic search when key insert
		txtSearchCust.addKeyListener(new KeyAdapter(){
					public void keyReleased(KeyEvent e) {
						showData();
					}
				});
		
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
		cmdSaveCust = new JButton("เพิ่มข้อมูล");
		cmdSaveCust.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						//when mouse click button
						//will call insert()
						insert();
					}
				}
				);
		
		
		JButton cmdEditCust = new JButton("แก้ไข");
		cmdEditCust.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						//when mouse click button
						//will call update()
						update();
					}
				}
				);
		JButton cmdDeleteCust = new JButton("ลบ");
		cmdDeleteCust.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						delete();
					}
				}
				);
		//clear form
		cmdClear = new JButton("ยกเลิก");
		cmdClear.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						showData();
						cmdSaveCust.setEnabled(true);
						txtCustNum.setEditable(true);
						txtCustNum.setText("");
						txtCustName.setText("");
						txtCustAddr.setText("");
						txtCustPhone.setText("");
						txtCustMail.setText("");
					}
				}
				);
		panelButton.add(cmdSaveCust);
		panelButton.add(cmdEditCust);
		panelButton.add(cmdDeleteCust);
		panelButton.add(cmdClear);
		
		
		//table
		JPanel panelTable = new JPanel();
		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setPreferredSize(new Dimension(400,103));
		
		tableCust = new JTable();
		tableCust.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//get value and keep value to index
				int index = tableCust.getSelectedRow();
				//txtCustNum can't edit
				cmdSaveCust.setEnabled(true);
				txtCustNum.setEditable(false);
				txtCustNum.setText(tableCust.getValueAt(index, 0).toString());
				txtCustName.setText(tableCust.getValueAt(index, 1).toString());
				txtCustAddr.setText(tableCust.getValueAt(index, 2).toString());
				txtCustPhone.setText(tableCust.getValueAt(index, 3).toString());
				txtCustMail.setText(tableCust.getValueAt(index, 4).toString());				
			}
			
		});
		
		Object data[][] = {
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				
		};
		String header[] = {"เลขที่ลูกค้า","ชื่อลูกค้า","ที่อยู่ลูกค้า","เบอร์โทรศัพท์ลูกค้า","อีเมลลูกค้า"};
		
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
		
		showData();
	}
	
	public void showData() {
		/*
		 * 1.ลบข้อมูลออกจาก JTable
		 * 2. เขีนย SQL
		 * 3.ประมวล SQL
		 * 4. resultset
		 * 5.mode --> JTable
		 */
		
		try {
			int totalRow = tableCust.getRowCount()-1;
			
			while(totalRow > -1) {
				modelCustomer.removeRow(totalRow);
				totalRow--;
			}
			
			//String search is push value of txtSearch to String search
			//.trim() is remove spacing on textField
			String search = txtSearchCust.getText().trim();
			String SQL = "select * from customer"
					//between form and where need spacing
					+ " WHERE CUST_NUM LIKE '%"+search+"%' OR"
					+ " CUST_NAME LIKE '%"+search+"%' OR"
					+ " CUST_ADDR LIKE '%"+search +"%' OR"
					+ " CUST_PHONE LIKE '%"+search+"%' OR"
					+ " CUST_MAIL LIKE '%"+search+"%' ";

			ResultSet rs = conn.createStatement().executeQuery(SQL);
			
			
			int row=0;
			while(rs.next()) {
				modelCustomer.addRow(new Object[0]);
				
				modelCustomer.setValueAt(rs.getString("CUST_NUM"), row, 0);
				modelCustomer.setValueAt(rs.getString("CUST_NAME"), row, 1);
				modelCustomer.setValueAt(rs.getString("CUST_ADDR"), row, 2);
				modelCustomer.setValueAt(rs.getString("CUST_PHONE"), row, 3);
				modelCustomer.setValueAt(rs.getString("CUST_MAIL"), row, 4);
				row++;
			}
			tableCust.setModel(modelCustomer);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void insert() {
			
		try {
		//check null insert or not 4 words
		if(txtCustNum.getText().trim() == "" || txtCustNum.getText().trim().length() !=4) {
			JOptionPane.showMessageDialog(
					this,
					"กรุณากรอกเลขที่ลูกค้า (4 หลัก)",
					"ผลกรทำงาน",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		String sql = "INSERT INTO CUSTOMER VALUES (?,?,?,?,?)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1,txtCustNum.getText().trim());
		pre.setString(2,txtCustName.getText().trim());
		pre.setString(3, txtCustAddr.getText().trim());
		pre.setString(4, txtCustPhone.getText().trim());
		pre.setString(5, txtCustMail.getText().trim());
		
		if(pre.executeUpdate() != -1) {
			JOptionPane.showMessageDialog(
					this,
					"บันทึกข้อมูลเรียบร้อยแล้ว",
					"ผลกรทำงาน",
					JOptionPane.INFORMATION_MESSAGE
					);
			showData();
			txtCustNum.setText("");
			txtCustName.setText("");
			txtCustAddr.setText("");
			txtCustPhone.setText("");
			txtCustMail.setText("");
		}
		} catch(SQLException e){
			e.printStackTrace();
		}
	
	}
	public void update() {
		
		try {
		
		String sql = "UPDATE CUSTOMER SET CUST_NAME=?," 
				+ " CUST_ADDR=?, "
				+ " CUST_PHONE=?, "
				+ " CUST_MAIL=? "
				+ " WHERE CUST_NUM=? " ;
		PreparedStatement pre = conn.prepareStatement(sql);
		
		pre.setString(1,txtCustName.getText().trim());
		pre.setString(2, txtCustAddr.getText().trim());
		pre.setString(3, txtCustPhone.getText().trim());
		pre.setString(4, txtCustMail.getText().trim());
		pre.setString(5,txtCustNum.getText().trim());
		
		if(pre.executeUpdate() != -1) {
			JOptionPane.showMessageDialog(
					this,
					"อัพเดทข้อมูลสำเร็จแล้ว",
					"ผลกรทำงาน",
					JOptionPane.INFORMATION_MESSAGE
					);
			showData();
			cmdSaveCust.setEnabled(true);
			txtCustNum.setEditable(true);
			txtCustNum.setText("");
			txtCustName.setText("");
			txtCustAddr.setText("");
			txtCustPhone.setText("");
			txtCustMail.setText("");
		}
		} catch(SQLException e){
			e.printStackTrace();
		}
	
	}
	public void delete() {
	try {
		
		String sql = "DELETE FROM CUSTOMER" 
				+ " WHERE CUST_NUM=? " ;
				
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1,txtCustNum.getText().trim());
		
		if(pre.executeUpdate() != -1) {
			JOptionPane.showMessageDialog(
					this,
					"ลบข้อมูลเรียบร้อยแล้ว",
					"ผลกรทำงาน",
					JOptionPane.INFORMATION_MESSAGE
					);
			showData();
			cmdSaveCust.setEnabled(true);
			txtCustNum.setEditable(true);
			txtCustNum.setText("");
			txtCustName.setText("");
			txtCustAddr.setText("");
			txtCustPhone.setText("");
			txtCustMail.setText("");
		}
		} catch(SQLException e){
			e.printStackTrace();
		}
	
	}
}
