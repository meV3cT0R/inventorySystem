package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.service.CashierService;
import com.service.CashierServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierLogin extends JFrame {

	private JPanel contentPane;
	private JLabel loginHeader;
	private JSeparator separator;
	private JLabel userNameLbl;
	private JTextField userNameField;
	private JLabel passwordLabel;
	private JTextField passWordField;
	private JButton loginButton;
	private JLabel newAccountLink;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierLogin frame = new CashierLogin();
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
	public CashierLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLoginHeader());
		contentPane.add(getSeparator());
		contentPane.add(getUserNameLbl());
		contentPane.add(getUserNameField());
		contentPane.add(getPasswordLabel());
		contentPane.add(getPassWordField());
		contentPane.add(getLoginButton());
		contentPane.add(getNewAccountLink());
	}
	private JLabel getLoginHeader() {
		if (loginHeader == null) {
			loginHeader = new JLabel("User Login");
			loginHeader.setFont(new Font("Tahoma", Font.BOLD, 18));
			loginHeader.setHorizontalAlignment(SwingConstants.CENTER);
			loginHeader.setBounds(115, 11, 162, 49);
		}
		return loginHeader;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 73, 414, 2);
		}
		return separator;
	}
	private JLabel getUserNameLbl() {
		if (userNameLbl == null) {
			userNameLbl = new JLabel("Username");
			userNameLbl.setBounds(75, 100, 101, 14);
		}
		return userNameLbl;
	}
	private JTextField getUserNameField() {
		if (userNameField == null) {
			userNameField = new JTextField();
			userNameField.setBounds(149, 97, 128, 20);
			userNameField.setColumns(10);
		}
		return userNameField;
	}
	private JLabel getPasswordLabel() {
		if (passwordLabel == null) {
			passwordLabel = new JLabel("password");
			passwordLabel.setBounds(75, 139, 85, 14);
		}
		return passwordLabel;
	}
	private JTextField getPassWordField() {
		if (passWordField == null) {
			passWordField = new JTextField();
			passWordField.setBounds(149, 136, 128, 20);
			passWordField.setColumns(10);
		}
		return passWordField;
	}
	private JButton getLoginButton() {
		if (loginButton == null) {
			loginButton = new JButton("Log In");
			loginButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CashierService cs = new CashierServiceImpl();
					if(cs.cashierLogin(userNameField.getText(), passWordField.getText())) {
						JOptionPane.showMessageDialog(null, "Successfully Logged In");
						new CashierHome().setVisible(true);
						dispose();
					}
				}
			});
			loginButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					setCursor(Cursor.HAND_CURSOR);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					setCursor(Cursor.DEFAULT_CURSOR);
				}
			});
			loginButton.setBounds(149, 179, 89, 23);
		}
		return loginButton;
	}
	private JLabel getNewAccountLink() {
		if (newAccountLink == null) {
			newAccountLink = new JLabel("Click here to create new Account");
			newAccountLink.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					newAccountLink.setForeground(new Color(0x7a08cc));
					setCursor(Cursor.HAND_CURSOR);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					newAccountLink.setForeground(new Color(0,0,0));
					setCursor(Cursor.DEFAULT_CURSOR);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					new CashierRegister().setVisible(true);
					dispose();
				}
			});
			newAccountLink.setBounds(114, 224, 188, 14);
		}
		return newAccountLink;
	}
}
