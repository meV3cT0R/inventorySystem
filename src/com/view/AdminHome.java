package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Cashier;
import com.service.AdminService;
import com.service.AdminServiceImpl;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminHome extends JFrame {

	private JPanel contentPane;
	private JLabel unVerifiedCashierEmployee;
	private JLabel adminHomeHeader;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton verifyButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
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
	public AdminHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getUnVerifiedCashierEmployee());
		contentPane.add(getAdminHomeHeader());
		contentPane.add(getSeparator());
		contentPane.add(getScrollPane());
		contentPane.add(getVerifyButton());
		getUnverifiedCashiers();
	}

	private JLabel getUnVerifiedCashierEmployee() {
		if (unVerifiedCashierEmployee == null) {
			unVerifiedCashierEmployee = new JLabel("Unverified Casiers");
			unVerifiedCashierEmployee.setBounds(10, 67, 133, 21);
		}
		return unVerifiedCashierEmployee;
	}
	private JLabel getAdminHomeHeader() {
		if (adminHomeHeader == null) {
			adminHomeHeader = new JLabel("Admin Dashboard");
			adminHomeHeader.setHorizontalAlignment(SwingConstants.CENTER);
			adminHomeHeader.setFont(new Font("Tahoma", Font.BOLD, 18));
			adminHomeHeader.setBounds(146, 11, 325, 45);
		}
		return adminHomeHeader;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 54, 621, 2);
		}
		return separator;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 133, 621, 213);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"id", "First Name", "Last Name", "Username", "password", "Birth Date", "Address"
				}
			));
		}
		return table;
	}
	private JButton getVerifyButton() {
		if (verifyButton == null) {
			verifyButton = new JButton("Verify");
			verifyButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					setCursor(Cursor.HAND_CURSOR);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					setCursor(Cursor.DEFAULT_CURSOR);
				}
			});
			verifyButton.setEnabled(false);
			verifyButton.setBackground(Color.GREEN);
			verifyButton.setForeground(Color.BLACK);
			verifyButton.setBounds(530, 99, 89, 23);
		}
		return verifyButton;
	}
	
	private void getUnverifiedCashiers() {
		AdminService as = new AdminServiceImpl();
		
		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		for(Cashier cashier : as.getAllUnverifiedCashiers()) {
			tmodel.addRow(new Object[] {cashier.getFirstName(),cashier.getLastName(),cashier.getUserName(),cashier.getBirthDate(),cashier.getAddress()});
		}
		
	}
}
