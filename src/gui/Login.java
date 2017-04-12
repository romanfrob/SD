package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;

import bussinesslogic.UserBT;
import datamodel.User;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Login {

	public JFrame frame;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;	
	public String userName = null;
	public int userId = 0;
	//public String userRole;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 429, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtrUsername.setText("Username");
		txtrUsername.setBounds(93, 89, 111, 31);
		frame.getContentPane().add(txtrUsername);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(225, 89, 127, 31);
		frame.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtrPassword.setText("Password");
		txtrPassword.setBounds(93, 131, 111, 31);
		frame.getContentPane().add(txtrPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(225, 131, 127, 31);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UserBT userBT = new UserBT();
				List<User> list = new ArrayList<>();
				
				try {
					list = userBT.getAllUsers();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				String username = textFieldUsername.getText();
				String password = passwordField.getText();
				String userRole = null;
				
				boolean found = false;
				for(int i = 0; i < list.size(); i++){
					User user = list.get(i);
					String userpass = user.getPassword();
					String usernametemp = user.getUsername();
					if( password.equals(userpass) && username.equals(usernametemp)){ 
						found = true;
						userName = user.getUsername();
						userId = user.getIduser();
						userRole = user.getUserrole();
					}					
				}
				
				if(found && userRole.equals("A")){
					JOptionPane.showMessageDialog(null, "Login successfull!");
					frame.dispose();
					AdminFrame adminFrame = new AdminFrame();
					adminFrame.setVisible(true);
				}
				
				if(found && userRole.equals("E")){
					JOptionPane.showMessageDialog(null, "Login successfull!");
					frame.dispose();
					EmployeeFrame empployeeFrame = new EmployeeFrame();
					empployeeFrame.setVisible(true);
				}
				
				if(!found){
					JOptionPane.showMessageDialog(null, "Username or password incorrect!");
				}
								
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setBounds(143, 205, 132, 53);
		frame.getContentPane().add(btnLogin);
	}
}
