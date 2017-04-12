package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bussinesslogic.ReportBT;
import bussinesslogic.UserBT;
import datamodel.Report;
import datamodel.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldSearch;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JTextField textFieldRole;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
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
	public AdminFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login loginFrame = new Login();
				dispose();
				loginFrame.frame.setVisible(true);
			}
		});
		btnLogout.setBounds(0, 0, 89, 23);
		contentPane.add(btnLogout);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 441, 153);
		contentPane.add(scrollPane);
		
		table = new JTable();

		scrollPane.setViewportView(table);
		
		Object[] columns = {"User Id", "Username", "Password", "Userrole"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(10, 49, 100, 20);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserBT userBT = new UserBT();
				List<User> list = new ArrayList<>();
				Object[] row = new Object[4];
				String userSearch = textFieldSearch.getText();
				model.getDataVector().removeAllElements();
				model.fireTableDataChanged();
				if(userSearch.isEmpty()){
					try {
						list = userBT.getAllEmpUsers();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					for(int i = 0; i < list.size(); i++){
						User user = list.get(i);
						row[0] = user.getIduser();
						row[1] = user.getUsername();
						row[2] = user.getPassword();
						row[3] = user.getUserrole();
						
						model.addRow(row);				
					}
				}
				else{
					try {
						list = userBT.searchUsers(userSearch);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					for(int i = 0; i < list.size(); i++){
						User user = list.get(i);
						row[0] = user.getIduser();
						row[1] = user.getUsername();
						row[2] = user.getPassword();
						row[3] = user.getUserrole();
						
						model.addRow(row);				
					}
				}
		
			}
		});
		btnSearch.setBounds(120, 48, 89, 23);
		contentPane.add(btnSearch);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(141, 257, 106, 20);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setText("Username");
		txtrUsername.setBounds(10, 255, 106, 23);
		contentPane.add(txtrUsername);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setText("Password");
		txtrPassword.setBounds(10, 289, 106, 20);
		contentPane.add(txtrPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(141, 288, 106, 20);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		textFieldRole = new JTextField();
		textFieldRole.setBounds(141, 319, 106, 20);
		contentPane.add(textFieldRole);
		textFieldRole.setColumns(10);
		
		JTextArea txtrRole = new JTextArea();
		txtrRole.setText("Role");
		txtrRole.setBounds(10, 320, 106, 20);
		contentPane.add(txtrRole);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = textFieldUsername.getText();
				String password = textFieldPassword.getText();
				String userrole = textFieldRole.getText();
				
				UserBT user = new UserBT();
				try {
					user.insertUser(username, password, userrole);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		
				
			}
		});
		btnAdd.setBounds(363, 256, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textFieldUsername.getText();
				String password = textFieldPassword.getText();
				String userrole = textFieldRole.getText();
				
				UserBT user = new UserBT();
				try {
					user.updateUser(username, password, userrole);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(363, 287, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textFieldUsername.getText();
		
				UserBT user = new UserBT();
				try {
					user.deleteUser(username);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(363, 318, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnReport = new JButton("Generate Report");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportBT report = new ReportBT();
				
				int i = table.getSelectedRow();
				int iduser = (int) model.getValueAt(i, 0);
				try {
					report.generateReport(iduser);
				} catch (Exception e1) {				
					e1.printStackTrace();
				}
				
			}
		});
		btnReport.setBounds(177, 397, 175, 40);
		contentPane.add(btnReport);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				textFieldUsername.setText(model.getValueAt(i, 1).toString());
				textFieldPassword.setText(model.getValueAt(i, 2).toString());
				textFieldRole.setText(model.getValueAt(i, 3).toString());
			}
		});
		

		
 		
	}
}
