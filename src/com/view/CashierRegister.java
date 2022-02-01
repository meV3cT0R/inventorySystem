package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class CashierRegister extends JFrame {

	private JPanel contentPane;
	private JLabel registerHeader;
	private JSeparator separator;
	private JLabel firstNameLabel;
	private JTextField textField;
	private JLabel lastNameLabel;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel userNameLabel;
	private JDateChooser dateChooser;
	private JLabel passwordLabel;
	private JLabel retypePassLabel;
	private JLabel birthDateLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierRegister frame = new CashierRegister();
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
	public CashierRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getRegisterHeader());
		contentPane.add(getSeparator());
		contentPane.add(getFirstNameLabel());
		contentPane.add(getTextField());
		contentPane.add(getLastNameLabel());
		contentPane.add(getTextField_1());
		contentPane.add(getTextField_2());
		contentPane.add(getTextField_3());
		contentPane.add(getTextField_4());
		contentPane.add(getUserNameLabel());
		contentPane.add(getDateChooser());
		contentPane.add(getPasswordLabel());
		contentPane.add(getRetypePassLabel());
		contentPane.add(getBirthDateLabel());
	}
	private JLabel getRegisterHeader() {
		if (registerHeader == null) {
			registerHeader = new JLabel("Register");
			registerHeader.setFont(new Font("Tahoma", Font.BOLD, 18));
			registerHeader.setHorizontalAlignment(SwingConstants.CENTER);
			registerHeader.setBounds(84, 11, 210, 50);
		}
		return registerHeader;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 59, 360, 2);
		}
		return separator;
	}
	private JLabel getFirstNameLabel() {
		if (firstNameLabel == null) {
			firstNameLabel = new JLabel("First Name");
			firstNameLabel.setBounds(20, 90, 112, 14);
		}
		return firstNameLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(108, 80, 203, 23);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLastNameLabel() {
		if (lastNameLabel == null) {
			lastNameLabel = new JLabel("Last Name");
			lastNameLabel.setBounds(20, 130, 112, 14);
		}
		return lastNameLabel;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(108, 120, 203, 23);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(108, 160, 203, 23);
		}
		return textField_2;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(108, 200, 203, 23);
		}
		return textField_3;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(108, 240, 203, 23);
		}
		return textField_4;
	}
	private JLabel getUserNameLabel() {
		if (userNameLabel == null) {
			userNameLabel = new JLabel("Username");
			userNameLabel.setBounds(20, 170, 112, 14);
		}
		return userNameLabel;
	}
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setBounds(108, 280, 203, 23);
		}
		return dateChooser;
	}
	private JLabel getPasswordLabel() {
		if (passwordLabel == null) {
			passwordLabel = new JLabel("Password");
			passwordLabel.setBounds(20, 210, 112, 14);
		}
		return passwordLabel;
	}
	private JLabel getRetypePassLabel() {
		if (retypePassLabel == null) {
			retypePassLabel = new JLabel("Retype Pass");
			retypePassLabel.setBounds(20, 250, 112, 14);
		}
		return retypePassLabel;
	}
	private JLabel getBirthDateLabel() {
		if (birthDateLabel == null) {
			birthDateLabel = new JLabel("Birth Date");
			birthDateLabel.setBounds(20, 290, 112, 14);
		}
		return birthDateLabel;
	}
}
