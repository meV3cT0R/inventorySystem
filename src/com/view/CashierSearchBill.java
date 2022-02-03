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
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Bill;
import com.service.BillService;
import com.service.BillServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierSearchBill extends JFrame {

	private JPanel contentPane;
	private JLabel searchBillHeader;
	private JSeparator separator;
	private JTextField billField;
	private JLabel billNoLabel;
	private JButton searchButton;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton goBackButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierSearchBill frame = new CashierSearchBill();
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
	public CashierSearchBill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getSearchBillHeader());
		contentPane.add(getSeparator());
		contentPane.add(getBillField());
		contentPane.add(getBillNoLabel());
		contentPane.add(getSearchButton());
		contentPane.add(getScrollPane());
		contentPane.add(getGoBackButton());
	}

	private JLabel getSearchBillHeader() {
		if (searchBillHeader == null) {
			searchBillHeader = new JLabel("Search Bill");
			searchBillHeader.setFont(new Font("Tahoma", Font.BOLD, 21));
			searchBillHeader.setHorizontalAlignment(SwingConstants.CENTER);
			searchBillHeader.setBounds(145, 11, 264, 45);
		}
		return searchBillHeader;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 63, 566, 2);
		}
		return separator;
	}
	private JTextField getBillField() {
		if (billField == null) {
			billField = new JTextField();
			billField.setBounds(177, 76, 187, 20);
			billField.setColumns(10);
		}
		return billField;
	}
	private JLabel getBillNoLabel() {
		if (billNoLabel == null) {
			billNoLabel = new JLabel("Bill NO");
			billNoLabel.setBounds(41, 79, 109, 17);
		}
		return billNoLabel;
	}
	private JButton getSearchButton() {
		if (searchButton == null) {
			searchButton = new JButton("search");
			searchButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(billField.getText().isBlank())
						return;
					
					
					displayBill(Integer.parseInt(billField.getText()));
				}
			});
			searchButton.setBounds(397, 75, 89, 23);
		}
		return searchButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 116, 566, 250);
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
					"Billno", "Customer Name", "Amount", "Date"
				}
			));
		}
		return table;
	}
	private JButton getGoBackButton() {
		if (goBackButton == null) {
			goBackButton = new JButton("Home");
			goBackButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CashierHome().setVisible(true);
					dispose();
				}
			});
			goBackButton.setBounds(487, 26, 89, 23);
		}
		return goBackButton;
	}
	
	private void displayBill(int id) {
		BillService bs = new BillServiceImpl();
		Bill bill = bs.getBillById(id);
		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);
		tmodel.addRow(new Object[] {bill.getId(),bill.getCustomerName(),bill.getAmount(),bill.getDate()});
	}
}
