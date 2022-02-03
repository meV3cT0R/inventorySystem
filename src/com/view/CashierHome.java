package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Bill;
import com.service.BillService;
import com.service.BillServiceImpl;
import com.toedter.calendar.JDateChooser;

public class CashierHome extends JFrame {

	private JPanel contentPane;
	private JButton logoutButton;
	private JLabel createBillLabel;
	private JLabel companyLogo;
	private JLabel searchBillLabel;
	private JLabel productInformationLabel;
	private JLabel salesLabel;
	private JSeparator separator;
	private JLabel billNoLabel;
	private JTextField billNoField;
	private JLabel customerNameLabel;
	private JTextField customerNameField;
	private JLabel productNameVariable;
	private JTextField productNameField;
	private JLabel mrpLabel;
	private JTextField mrpField;
	private JLabel quantityLabel;
	private JTextField quantityField;
	private JLabel discountLabel;
	private JTextField discountField;
	private JButton addBillButton;
	private JButton removeButton;
	private JScrollPane scrollPane;
	private JTable table;
	private JDateChooser dateChooser;
	private JLabel dateLabel;
	private JLabel totalLabel;
	private JTextField textField_5;
	private JButton printButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierHome frame = new CashierHome();
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
	public CashierHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLogoutButton());
		contentPane.add(getCreateBillLabel());
		contentPane.add(getCompanyLogo());
		contentPane.add(getSearchBillLabel());
		contentPane.add(getProductInformationLabel());
		contentPane.add(getSalesLabel());
		contentPane.add(getSeparator());
		contentPane.add(getBillNoLabel());
		contentPane.add(getBillNoField());
		contentPane.add(getCustomerNameLabel());
		contentPane.add(getCustomerNameField());
		contentPane.add(getProductNameVariable());
		contentPane.add(getProductNameField());
		contentPane.add(getMrpLabel());
		contentPane.add(getMrpField());
		contentPane.add(getQuantityLabel());
		contentPane.add(getQuantityField());
		contentPane.add(getDiscountLabel());
		contentPane.add(getDiscountField());
		contentPane.add(getAddBillButton());
		contentPane.add(getRemoveButton());
		contentPane.add(getScrollPane());
		contentPane.add(getDateChooser());
		contentPane.add(getDateLabel());
		contentPane.add(getTotalLabel());
		contentPane.add(getTextField_5());
		contentPane.add(getPrintButton());
	}
	private JButton getLogoutButton() {
		if (logoutButton == null) {
			logoutButton = new JButton("Log Out");
			logoutButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Home().setVisible(true);
					dispose();
				}
			});
			logoutButton.setBounds(560, 29, 89, 23);
		}
		return logoutButton;
	}
	private JLabel getCreateBillLabel() {
		if (createBillLabel == null) {
			createBillLabel = new JLabel("Creat Bill");
			
			createBillLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					setCursor(Cursor.HAND_CURSOR);
					createBillLabel.setForeground(new Color(0x7a08cc));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					setCursor(Cursor.DEFAULT_CURSOR);
					createBillLabel.setForeground(new Color(0x000000));
				}
				
			});
			createBillLabel.setBounds(89, 33, 56, 14);
		}
		return createBillLabel;
	}
	private JLabel getCompanyLogo() {
		if (companyLogo == null) {
			companyLogo = new JLabel("");
			companyLogo.setIcon(new ImageIcon(new ImageIcon(CashierHome.class.getResource("/com/images/yotsuba.jpg")).getImage().getScaledInstance(46, 41, DO_NOTHING_ON_CLOSE)));
			companyLogo.setBounds(10, 11, 46, 41);
		}
		return companyLogo;
	}
	private JLabel getSearchBillLabel() {
		if (searchBillLabel == null) {
			searchBillLabel = new JLabel("Search Bill");
			searchBillLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					setCursor(Cursor.HAND_CURSOR);
					searchBillLabel.setForeground(new Color(0x7a08cc));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					setCursor(Cursor.DEFAULT_CURSOR);
					searchBillLabel.setForeground(new Color(0x000000));
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					new CashierSearchBill().setVisible(true);
					dispose();
				}
			});
			searchBillLabel.setBounds(155, 33, 66, 14);
		}
		return searchBillLabel;
	}
	private JLabel getProductInformationLabel() {
		if (productInformationLabel == null) {
			productInformationLabel = new JLabel("Product Information");
			productInformationLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					setCursor(Cursor.HAND_CURSOR);
					productInformationLabel.setForeground(new Color(0x7a08cc));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					setCursor(Cursor.DEFAULT_CURSOR);
					productInformationLabel.setForeground(new Color(0x000000));
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					new CashierProductInformation().setVisible(true);
					dispose();
				}
			});
			productInformationLabel.setBounds(231, 33, 153, 14);
		}
		return productInformationLabel;
	}
	private JLabel getSalesLabel() {
		if (salesLabel == null) {
			salesLabel = new JLabel("sales");
			salesLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					setCursor(Cursor.HAND_CURSOR);
					salesLabel.setForeground(new Color(0x7a08cc));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					setCursor(Cursor.DEFAULT_CURSOR);
					salesLabel.setForeground(new Color(0x000000));
				}
				
			});
			salesLabel.setBounds(353, 33, 46, 14);
		}
		return salesLabel;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 67, 655, 2);
		}
		return separator;
	}
	private JLabel getBillNoLabel() {
		if (billNoLabel == null) {
			billNoLabel = new JLabel("Bill NO.");
			billNoLabel.setBounds(10, 92, 46, 14);
		}
		return billNoLabel;
	}
	private JTextField getBillNoField() {
		if (billNoField == null) {
			billNoField = new JTextField();
			billNoField.setBounds(99, 89, 86, 20);
			billNoField.setColumns(10);
		}
		return billNoField;
	}
	private JLabel getCustomerNameLabel() {
		if (customerNameLabel == null) {
			customerNameLabel = new JLabel("Custome Name");
			customerNameLabel.setBounds(10, 134, 100, 14);
		}
		return customerNameLabel;
	}
	private JTextField getCustomerNameField() {
		if (customerNameField == null) {
			customerNameField = new JTextField();
			customerNameField.setBounds(99, 131, 146, 23);
			customerNameField.setColumns(10);
		}
		return customerNameField;
	}
	private JLabel getProductNameVariable() {
		if (productNameVariable == null) {
			productNameVariable = new JLabel("Product Name");
			productNameVariable.setBounds(10, 181, 100, 14);
		}
		return productNameVariable;
	}
	private JTextField getProductNameField() {
		if (productNameField == null) {
			productNameField = new JTextField();
			productNameField.setBounds(99, 178, 146, 23);
			productNameField.setColumns(10);
		}
		return productNameField;
	}
	private JLabel getMrpLabel() {
		if (mrpLabel == null) {
			mrpLabel = new JLabel("Mrp");
			mrpLabel.setBounds(10, 226, 46, 14);
		}
		return mrpLabel;
	}
	private JTextField getMrpField() {
		if (mrpField == null) {
			mrpField = new JTextField();
			mrpField.setBounds(99, 223, 146, 23);
			mrpField.setColumns(10);
		}
		return mrpField;
	}
	private JLabel getQuantityLabel() {
		if (quantityLabel == null) {
			quantityLabel = new JLabel("Quantity");
			quantityLabel.setBounds(10, 271, 46, 14);
		}
		return quantityLabel;
	}
	private JTextField getQuantityField() {
		if (quantityField == null) {
			quantityField = new JTextField();
			quantityField.setBounds(99, 267, 146, 23);
			quantityField.setColumns(10);
		}
		return quantityField;
	}
	private JLabel getDiscountLabel() {
		if (discountLabel == null) {
			discountLabel = new JLabel("discountLabel");
			discountLabel.setBounds(10, 318, 100, 14);
		}
		return discountLabel;
	}
	private JTextField getDiscountField() {
		if (discountField == null) {
			discountField = new JTextField();
			discountField.setBounds(99, 315, 146, 23);
			discountField.setColumns(10);
		}
		return discountField;
	}
	private JButton getAddBillButton() {
		if (addBillButton == null) {
			addBillButton = new JButton("add");
			addBillButton.setBounds(21, 372, 89, 23);
			addBillButton.addActionListener(new ActionListener() {
				@Override 
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
					Double price = Double.parseDouble(quantityField.getText())*Double.parseDouble(mrpField.getText());
					Double priceWithDiscount = price - ((Double.parseDouble(discountField.getText())/100)*price);
					tmodel.addRow(new Object[] {quantityField.getText(),productNameField.getText(),mrpField.getText(),priceWithDiscount});
					Double totalValue = Double.parseDouble(textField_5.getText());
					textField_5.setText(String.valueOf(totalValue+priceWithDiscount));
				}
			});
		}
		return addBillButton;
	}
	private JButton getRemoveButton() {
		if (removeButton == null) {
			removeButton = new JButton("remove");
			removeButton.setBounds(156, 372, 89, 23);
		}
		return removeButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(333, 127, 311, 214);
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
					"Quantity", "Name", "Mrp", "Price"
				}
			));
		}
		return table;
	}
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setBounds(409, 86, 190, 23);
		}
		return dateChooser;
	}
	private JLabel getDateLabel() {
		if (dateLabel == null) {
			dateLabel = new JLabel("date");
			dateLabel.setBounds(333, 92, 46, 14);
		}
		return dateLabel;
	}
	private JLabel getTotalLabel() {
		if (totalLabel == null) {
			totalLabel = new JLabel("Total");
			totalLabel.setBounds(409, 352, 89, 20);
		}
		return totalLabel;
	}
	private JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setText("0");
			textField_5.setEditable(false);
			textField_5.setBounds(456, 352, 86, 20);
			textField_5.setColumns(10);
			
		}
		return textField_5;
	}
	private JButton getPrintButton() {
		if (printButton == null) {
			printButton = new JButton("print");
			printButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					BillService billService = new BillServiceImpl();
					Bill bill = new Bill();
					bill.setCustomerName(customerNameField.getText());
					bill.setAmount(Double.parseDouble(textField_5.getText()));
					bill.setDate(dateChooser.getDate());
					billService.addBill(bill);
					DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
					tmodel.setRowCount(0);
					customerNameField.setText("");
					productNameField.setText("");
					mrpField.setText("");
					quantityField.setText("");
					discountField.setText("");
					billNoField.setText("");
				}
			}); 
			printButton.setBounds(560, 372, 89, 23);
		}
		return printButton;
	}
}
