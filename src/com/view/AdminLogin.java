package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.service.AdminService;
import com.service.AdminServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JLabel userNameLabel;
	private JTextField userNameField;
	private JLabel passwordLabel;
	private JTextField passwordField;
	private JButton loginButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getSeparator());
		contentPane.add(getUserNameLabel());
		contentPane.add(getUserNameField());
		contentPane.add(getPasswordLabel());
		contentPane.add(getPasswordField());
		contentPane.add(getLoginButton());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Admin Login");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(90, 11, 237, 45);
		}
		return lblNewLabel;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 63, 402, 2);
		}
		return separator;
	}
	private JLabel getUserNameLabel() {
		if (userNameLabel == null) {
			userNameLabel = new JLabel("Username");
			userNameLabel.setBounds(37, 88, 104, 23);
		}
		return userNameLabel;
	}
	private JTextField getUserNameField() {
		if (userNameField == null) {
			userNameField = new JTextField();
			userNameField.setBounds(134, 88, 203, 23);
			userNameField.setColumns(10);
		}
		return userNameField;
	}
	private JLabel getPasswordLabel() {
		if (passwordLabel == null) {
			passwordLabel = new JLabel("Password");
			passwordLabel.setBounds(37, 146, 104, 23);
		}
		return passwordLabel;
	}
	private JTextField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JTextField();
			passwordField.setColumns(10);
			passwordField.setBounds(134, 146, 203, 23);
		}
		return passwordField;
	}
	private JButton getLoginButton() {
		if (loginButton == null) {
			loginButton = new JButton("Log In");
			loginButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AdminService as = new AdminServiceImpl();
					System.out.println(as.adminLogin(userNameField.getText(), passwordField.getText()));
					if(as.adminLogin(userNameField.getText(), passwordField.getText())) {
						JOptionPane.showMessageDialog(null, "Succesfully Logged In");
						new AdminHome().setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Login Failed");
					}
				}
			});
			loginButton.setBounds(181, 200, 89, 23);
		}
		return loginButton;
	}
}
