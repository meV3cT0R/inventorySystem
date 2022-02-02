package com.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
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
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierRegister extends JFrame {

	private JPanel contentPane;
	private JLabel registerHeader;
	private JSeparator separator;
	private JLabel firstNameLabel;
	private JTextField firstNameField;
	private JLabel lastNameLabel;
	private JTextField lastNameField;
	private JTextField userNameField;
	private JTextField passWordField;
	private JTextField retypePassWordField;
	private JLabel userNameLabel;
	private JDateChooser dateChooser;
	private JLabel passwordLabel;
	private JLabel retypePassLabel;
	private JLabel birthDateLabel;
	private JLabel addressLabel;
	private JTextField addressField;
	private JButton registerButton;
	private JLabel goBackButton;

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
		contentPane.add(getFirstNameField());
		contentPane.add(getLastNameLabel());
		contentPane.add(getLastNameField());
		contentPane.add(getUserNameField());
		contentPane.add(getPassWordField());
		contentPane.add(getRetypePassWordField());
		contentPane.add(getUserNameLabel());
		contentPane.add(getDateChooser());
		contentPane.add(getPasswordLabel());
		contentPane.add(getRetypePassLabel());
		contentPane.add(getBirthDateLabel());
		contentPane.add(getAddressLabel());
		contentPane.add(getAddressField());
		contentPane.add(getRegisterButton());
		contentPane.add(getGoBackButton());
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
			firstNameLabel.setBounds(20, 89, 112, 14);
		}
		return firstNameLabel;
	}
	private JTextField getFirstNameField() {
		if (firstNameField == null) {
			firstNameField = new JTextField();
			firstNameField.setBounds(108, 80, 203, 23);
			firstNameField.setColumns(10);
		}
		return firstNameField;
	}
	private JLabel getLastNameLabel() {
		if (lastNameLabel == null) {
			lastNameLabel = new JLabel("Last Name");
			lastNameLabel.setBounds(20, 129, 112, 14);
		}
		return lastNameLabel;
	}
	private JTextField getLastNameField() {
		if (lastNameField == null) {
			lastNameField = new JTextField();
			lastNameField.setColumns(10);
			lastNameField.setBounds(108, 120, 203, 23);
		}
		return lastNameField;
	}
	private JTextField getUserNameField() {
		if (userNameField == null) {
			userNameField = new JTextField();
			userNameField.setColumns(10);
			userNameField.setBounds(108, 160, 203, 23);
		}
		return userNameField;
	}
	private JTextField getPassWordField() {
		if (passWordField == null) {
			passWordField = new JTextField();
			passWordField.setColumns(10);
			passWordField.setBounds(108, 200, 203, 23);
		}
		return passWordField;
	}
	private JTextField getRetypePassWordField() {
		if (retypePassWordField == null) {
			retypePassWordField = new JTextField();
			retypePassWordField.setColumns(10);
			retypePassWordField.setBounds(108, 240, 203, 23);
		}
		return retypePassWordField;
	}
	private JLabel getUserNameLabel() {
		if (userNameLabel == null) {
			userNameLabel = new JLabel("Username");
			userNameLabel.setBounds(20, 169, 112, 14);
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
			passwordLabel.setBounds(20, 209, 112, 14);
		}
		return passwordLabel;
	}
	private JLabel getRetypePassLabel() {
		if (retypePassLabel == null) {
			retypePassLabel = new JLabel("Retype Pass");
			retypePassLabel.setBounds(20, 249, 112, 14);
		}
		return retypePassLabel;
	}
	private JLabel getBirthDateLabel() {
		if (birthDateLabel == null) {
			birthDateLabel = new JLabel("Birth Date");
			birthDateLabel.setBounds(20, 289, 112, 14);
		}
		return birthDateLabel;
	}
	private JLabel getAddressLabel() {
		if (addressLabel == null) {
			addressLabel = new JLabel("Address");
			addressLabel.setBounds(20, 329, 112, 14);
		}
		return addressLabel;
	}
	private JTextField getAddressField() {
		if (addressField == null) {
			addressField = new JTextField();
			addressField.setBounds(108, 326, 203, 23);
			addressField.setColumns(10);
		}
		return addressField;
	}
	private JButton getRegisterButton() {
		if (registerButton == null) {
			registerButton = new JButton("Register");
			registerButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!passWordField.getText().equals(retypePassWordField.getText()))
						return;
				}
			});
			registerButton.setBounds(161, 379, 89, 23);
		}
		return registerButton;
	}
	private JLabel getGoBackButton() {
		if (goBackButton == null) {
			goBackButton = new JLabel("");
			goBackButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					setCursor(Cursor.HAND_CURSOR);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					setCursor(Cursor.DEFAULT_CURSOR);
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					new Home().setVisible(true);
					dispose();
				}
			});
			goBackButton.setIcon(new ImageIcon(CashierRegister.class.getResource("/com/images/arrow.png")));
			goBackButton.setBounds(10, 22, 46, 29);
		}
		return goBackButton;
	}
}
