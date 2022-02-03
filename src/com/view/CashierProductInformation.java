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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class CashierProductInformation extends JFrame {

	private JPanel contentPane;
	private JLabel productInformationHeader;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JLabel productSearchLabel;
	private JTextField productField;
	private JButton searchButton;
	private JTable table;
	private JButton homeButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierProductInformation frame = new CashierProductInformation();
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
	public CashierProductInformation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getProductInformationHeader());
		contentPane.add(getSeparator());
		contentPane.add(getScrollPane());
		contentPane.add(getProductSearchLabel());
		contentPane.add(getProductField());
		contentPane.add(getSearchButton());
		contentPane.add(getHomeButton());
	}

	private JLabel getProductInformationHeader() {
		if (productInformationHeader == null) {
			productInformationHeader = new JLabel("Product Information");
			productInformationHeader.setHorizontalAlignment(SwingConstants.CENTER);
			productInformationHeader.setFont(new Font("Tahoma", Font.BOLD, 23));
			productInformationHeader.setBounds(153, 11, 329, 59);
		}
		return productInformationHeader;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 68, 612, 2);
		}
		return separator;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 126, 612, 232);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JLabel getProductSearchLabel() {
		if (productSearchLabel == null) {
			productSearchLabel = new JLabel("Product");
			productSearchLabel.setBounds(41, 81, 125, 26);
		}
		return productSearchLabel;
	}
	private JTextField getProductField() {
		if (productField == null) {
			productField = new JTextField();
			productField.setBounds(163, 81, 236, 26);
			productField.setColumns(10);
		}
		return productField;
	}
	private JButton getSearchButton() {
		if (searchButton == null) {
			searchButton = new JButton("Search");
			searchButton.setBounds(431, 81, 104, 26);
			searchButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(productField.getText().isBlank())
						return;
					
					displayProducts(productField.getText());
				}
			});
		}
		return searchButton;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Product Id", "Product Name", "Available", "MRP"
				}
			));
		}
		return table;
	}
	private JButton getHomeButton() {
		if (homeButton == null) {
			homeButton = new JButton("Home");
			homeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CashierHome().setVisible(true);
					dispose();
				}
			});
			homeButton.setBounds(533, 34, 89, 23);
		}
		return homeButton;
	}
	
	private void displayProducts(String value) {
		ProductService ps = new ProductServiceImpl();
		List<Product> products = ps.searchProduct(value);
		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);
		System.out.println(products);
		for(Product product : products) {
			tmodel.addRow(new Object[] {product.getId(),product.getFirstName(),product.getQuantityAvailable(),product.getMRP()});
		}
	}
}
