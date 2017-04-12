package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bussinesslogic.ClientLogicBT;
import bussinesslogic.ReportBT;
import datamodel.Account;
import datamodel.Client;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class EmployeeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSearch;
	private JTable table;
	private JTable table_1;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldCNP;
	private JTextField textFieldAddress;
	private JTextField textFieldClientId;
	private JTextField textFieldAmount;
	private JTextField textFieldFromClient;
	private JTextField textFieldToClient;
	private JTextField textFieldAmountTransfer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeFrame frame = new EmployeeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1053, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login loginFrame = new Login();
				dispose();
				loginFrame.frame.setVisible(true);
				
			}
		});
		btnLogout.setBounds(0, 0, 89, 23);
		contentPane.add(btnLogout);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(0, 34, 119, 20);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 65, 449, 167);
		contentPane.add(scrollPane);
		
		table = new JTable();

		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(470, 65, 449, 167);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();

		scrollPane_1.setViewportView(table_1);
		
		JTextArea txtrFirstName = new JTextArea();
		txtrFirstName.setText("First name");
		txtrFirstName.setBounds(0, 246, 96, 23);
		contentPane.add(txtrFirstName);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(106, 247, 104, 23);
		contentPane.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		JTextArea txtrLastName = new JTextArea();
		txtrLastName.setText("Last name");
		txtrLastName.setBounds(0, 280, 96, 23);
		contentPane.add(txtrLastName);
		
		JTextArea txtrCnp = new JTextArea();
		txtrCnp.setText("CNP");
		txtrCnp.setBounds(0, 314, 96, 23);
		contentPane.add(txtrCnp);
		
		JTextArea txtrAddress = new JTextArea();
		txtrAddress.setText("Address");
		txtrAddress.setBounds(0, 348, 96, 23);
		contentPane.add(txtrAddress);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(106, 281, 104, 23);
		contentPane.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		textFieldCNP = new JTextField();
		textFieldCNP.setBounds(106, 314, 104, 23);
		contentPane.add(textFieldCNP);
		textFieldCNP.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(106, 348, 104, 23);
		contentPane.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		JButton btnAddClient = new JButton("Add Client");
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstname = textFieldFirstName.getText();
				String lastname  = textFieldLastName.getText();
				String CNP       = textFieldCNP.getText();
				String address   =   textFieldAddress.getText();
				
				ClientLogicBT client = new ClientLogicBT();
				
				try {
					client.insertClient(firstname, lastname, CNP, address);
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
				
				/*
				ReportBT report = new ReportBT();
				Login loginFrame = new Login();
				String statement = "Employee" + loginFrame.userName + "inserted a client with first name = " + firstname + ",lastname " + lastname + ",CNP " + CNP + ", address " + address;
				try {
					report.insertReport(loginFrame.userId, statement);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}*/
			}
		});
		btnAddClient.setBounds(236, 247, 113, 23);
		contentPane.add(btnAddClient);
		
		JButton btnUpdateClient = new JButton("Update Client");
		btnUpdateClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstname = textFieldFirstName.getText();
				String lastname  = textFieldLastName.getText();
				String CNP       = textFieldCNP.getText();
				String address   =   textFieldAddress.getText();
				
				ClientLogicBT client = new ClientLogicBT();
				
				try {
					client.updateClient(firstname, lastname, CNP, address);
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
			}
		});
		btnUpdateClient.setBounds(236, 281, 113, 23);
		contentPane.add(btnUpdateClient);
		
		JButton btnDeleteClient = new JButton("Delete Client");
		btnDeleteClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String firstname = textFieldFirstName.getText();
				String lastname  = textFieldLastName.getText();
				String CNP       = textFieldCNP.getText();
				String address   =   textFieldAddress.getText();				
				ClientLogicBT client = new ClientLogicBT();
				
				try {
					client.deleteClient(CNP);
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
				
			}
		});
		btnDeleteClient.setBounds(236, 315, 113, 23);
		contentPane.add(btnDeleteClient);
		
		JTextArea txtrClientId = new JTextArea();
		txtrClientId.setText("Client Id");
		txtrClientId.setBounds(470, 246, 104, 23);
		contentPane.add(txtrClientId);
		
		textFieldClientId = new JTextField();
		textFieldClientId.setBounds(584, 248, 104, 21);
		contentPane.add(textFieldClientId);
		textFieldClientId.setColumns(10);
		
		JTextArea txtrAmount = new JTextArea();
		txtrAmount.setText("Amount");
		txtrAmount.setBounds(470, 280, 104, 23);
		contentPane.add(txtrAmount);
		
		textFieldAmount = new JTextField();
		textFieldAmount.setBounds(584, 282, 104, 20);
		contentPane.add(textFieldAmount);
		textFieldAmount.setColumns(10);
		
		JButton btnAddAccount = new JButton("Add Account");
		btnAddAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String clientid = textFieldClientId.getText();
				String amount   = textFieldAmount.getText();
				
				double amountToGo = Double.parseDouble(amount);
				int clientidToGo  = Integer.parseInt(clientid);
				 
				
				ClientLogicBT account = new ClientLogicBT();
				
				try {
					account.insertAccount(clientidToGo, amountToGo);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnAddAccount.setBounds(730, 247, 127, 23);
		contentPane.add(btnAddAccount);
		
		JButton btnUpdateAccount = new JButton("Update Account");
		btnUpdateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String clientid = textFieldClientId.getText();
				String amount   = textFieldAmount.getText();
				
				double amountToGo = Double.parseDouble(amount);
				int clientidToGo  = Integer.parseInt(clientid);
				 
				
				ClientLogicBT account = new ClientLogicBT();
				
				try {
					account.updateAccount(clientidToGo, amountToGo);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUpdateAccount.setBounds(730, 281, 127, 23);
		contentPane.add(btnUpdateAccount);
		
		JButton btnDeleteAccount = new JButton("Delete Account");

		btnDeleteAccount.setBounds(730, 315, 127, 23);
		contentPane.add(btnDeleteAccount);
		
		JTextArea txtrFromClientWith = new JTextArea();
		txtrFromClientWith.setText("From Client With Id: ");
		txtrFromClientWith.setBounds(0, 430, 181, 29);
		contentPane.add(txtrFromClientWith);
		
		JTextArea txtrToClientWith = new JTextArea();
		txtrToClientWith.setText("To Client With ID:");
		txtrToClientWith.setBounds(0, 469, 181, 29);
		contentPane.add(txtrToClientWith);
		
		JTextArea txtrAmount_1 = new JTextArea();
		txtrAmount_1.setText("Amount: ");
		txtrAmount_1.setBounds(0, 509, 181, 29);
		contentPane.add(txtrAmount_1);
		
		textFieldFromClient = new JTextField();
		textFieldFromClient.setBounds(191, 430, 89, 29);
		contentPane.add(textFieldFromClient);
		textFieldFromClient.setColumns(10);
		
		textFieldToClient = new JTextField();
		textFieldToClient.setBounds(191, 469, 89, 29);
		contentPane.add(textFieldToClient);
		textFieldToClient.setColumns(10);
		
		textFieldAmountTransfer = new JTextField();
		textFieldAmountTransfer.setBounds(191, 509, 89, 29);
		contentPane.add(textFieldAmountTransfer);
		textFieldAmountTransfer.setColumns(10);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String clientfrom = textFieldFromClient.getText();
				String clientto = textFieldToClient.getText();
				String amount = textFieldAmountTransfer.getText();
				
				int idclientfrom = Integer.parseInt(clientfrom);
				int idclientto = Integer.parseInt(clientto);
				double amounttranfer = Double.parseDouble(amount);
				
				ClientLogicBT clientLogicBt = new ClientLogicBT();
				try {
					clientLogicBt.Transfer(idclientfrom, idclientto, amounttranfer);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnTransfer.setBounds(367, 467, 127, 28);
		contentPane.add(btnTransfer);
		
		Object[] columnsClient = {"Id client", "First Name", "Last name", "CNP", "Address"};
		Object[] columnsAccount = {"Id account", "Id client", "Amount", "Creation date"};
		
		DefaultTableModel modelClient = new DefaultTableModel();
		modelClient.setColumnIdentifiers(columnsClient);
		table.setModel(modelClient);
		
		DefaultTableModel modelAccount = new DefaultTableModel();
		modelAccount.setColumnIdentifiers(columnsAccount);
		table_1.setModel(modelAccount);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientLogicBT clientLogicBT = new ClientLogicBT();
				List<Client> list = new ArrayList<>();
				Object[] row = new Object[5];
				String clientSearch = textFieldSearch.getText();
				modelClient.getDataVector().removeAllElements();
				modelClient.fireTableDataChanged();
				
				if(clientSearch.isEmpty()){
					try {
						list = clientLogicBT.getAllClients();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					for(int i = 0; i < list.size(); i++){
						Client client = list.get(i);
						row[0] = client.getIdclient();
						row[1] = client.getFirst_name();
						row[2] = client.getLast_name();
						row[3] = client.getCNP();
						row[4]=  client.getAddress();
						
						modelClient.addRow(row);				
					}
				}
				else{
					try {
						list = clientLogicBT.searchClient(clientSearch);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					for(int i = 0; i < list.size(); i++){
						Client client = list.get(i);
						row[0] = client.getIdclient();
						row[1] = client.getFirst_name();
						row[2] = client.getLast_name();
						row[3] = client.getCNP();
						row[4]=  client.getAddress();
						
						modelClient.addRow(row);				
					}
				}

			}
					
		});
		btnSearch.setBounds(129, 33, 96, 23);
		contentPane.add(btnSearch);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				int clientid = (int) modelClient.getValueAt(i, 0);
				
				ClientLogicBT clientLogicBT = new ClientLogicBT();
				List<Account> list = new ArrayList<>();
				Object[] row = new Object[4];
				textFieldFirstName.setText(modelClient.getValueAt(i, 1).toString());
				textFieldLastName.setText(modelClient.getValueAt(i, 2).toString());
				textFieldCNP.setText(modelClient.getValueAt(i, 3).toString());
				textFieldAddress.setText(modelClient.getValueAt(i, 4).toString());
				modelAccount.getDataVector().removeAllElements();
				modelAccount.fireTableDataChanged();
				try {
					list = clientLogicBT.searchAccountsByClient(clientid);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				for(int j = 0; j < list.size(); j++){
					Account account = list.get(j);
					row[0] = account.getIdaccount();
					row[1] = account.getIdclient();
					row[2] = account.getAmount();
					row[3] = account.getCreation_date();
					
					modelAccount.addRow(row);				
				}
			}
		});
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table_1.getSelectedRow();
				textFieldClientId.setText(modelAccount.getValueAt(i, 1).toString());
				textFieldAmount.setText(modelAccount.getValueAt(i, 2).toString());
			}
		});
		
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = table_1.getSelectedRow();
				int idaccount = (int) modelAccount.getValueAt(i, 0);
				
				ClientLogicBT account = new ClientLogicBT();
				
				try {
					account.deleteAccount(idaccount);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

}
