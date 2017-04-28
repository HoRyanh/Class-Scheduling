package GUI;
import Functions.DBConnecter;
import Model.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static boolean logined = false;
	private  JTextField textField;
	private  JPasswordField passwordField;
	private static User user1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginPage dialog = new LoginPage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginPage() {
		setBackground(Color.WHITE);
		setBounds(100, 100, 414, 244);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setFont(new Font("Apple Color Emoji", lblNewLabel.getFont().getStyle() | Font.BOLD, lblNewLabel.getFont().getSize() + 3));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(150, 6, 103, 38);
		contentPanel.add(lblNewLabel);
		
		JLabel lblUser = new JLabel("User ");
		lblUser.setFont(new Font("AppleGothic", lblUser.getFont().getStyle(), lblUser.getFont().getSize()));
		lblUser.setBounds(49, 56, 61, 16);
		contentPanel.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("AppleGothic", lblPassword.getFont().getStyle(), lblPassword.getFont().getSize()));
		lblPassword.setBounds(49, 100, 61, 16);
		contentPanel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(120, 49, 152, 28);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(120, 94, 152, 28);
		contentPanel.add(passwordField);
		
		JLabel warning = new JLabel("You Entered Invalid UserID and Password!");
		warning.setForeground(Color.RED);
		warning.setBounds(70, 174, 266, 32);
		warning.setVisible(false);
		contentPanel.add(warning);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login(warning);
			}
		});
		btnLogIn.setBounds(283, 95, 95, 29);
		contentPanel.add(btnLogIn);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(49, 134, 117, 29);
		contentPanel.add(btnSignUp);
		
		JButton btnForgetPassword = new JButton("Forget Password?");
		btnForgetPassword.setBounds(178, 134, 200, 28);
		contentPanel.add(btnForgetPassword);
		

	}
	public boolean login(JLabel warn){
		if(!logined){
			String ID = new String(textField.getText());
			String pass=new String(passwordField.getPassword());
			user1=new User(ID,pass);

			if(DBConnecter.userLogin(user1)){
				logined = true;
				warn.setText(user1.getUserName());
				textField.setText(""); passwordField.setText("");
				dispose();
			}
			else{
				warn.setVisible(true);
			}
		}
		return logined;
	}
	public static boolean checkLogin(){
		return logined;
	}
	
	public static void setLogin(boolean logined) {
		LoginPage.logined = logined;
	}

	public static User getUser(){
		return user1;
	}
}
