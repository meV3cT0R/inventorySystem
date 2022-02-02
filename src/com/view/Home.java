package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JLabel homePageHeading;
	private JLabel companyLogo;
	private JLabel companyName;
	private JButton adminLoginBtn;
	private JButton cashierLoginBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getHomePageHeading());
		contentPane.add(getCompanyLogo());
		contentPane.add(getCompanyName());
		contentPane.add(getAdminLoginBtn());
		contentPane.add(getCashierLoginBtn());
	}
	private JLabel getHomePageHeading() {
		if (homePageHeading == null) {
			homePageHeading = new JLabel("Welcome To Super Market Billing System");
			homePageHeading.setFont(new Font("SansSerif", Font.BOLD, 18));
			homePageHeading.setHorizontalAlignment(SwingConstants.CENTER);
			homePageHeading.setBounds(36, 11, 419, 79);
		}
		return homePageHeading;
	}
	private JLabel getCompanyLogo() {
		if (companyLogo == null) {
			companyLogo = new JLabel("");
			companyLogo.setIcon(new ImageIcon(new ImageIcon(Home.class.getResource("/com/images/yotsuba.jpg")).getImage().getScaledInstance(100, 100, DO_NOTHING_ON_CLOSE)));
			companyLogo.setHorizontalAlignment(SwingConstants.CENTER);
			companyLogo.setBounds(108, 102, 100, 100);
		}
		return companyLogo;
	}
	private JLabel getCompanyName() {
		if (companyName == null) {
			companyName = new JLabel("Quick Bill");
			companyName.setFont(new Font("Tahoma", Font.BOLD, 16));
			companyName.setHorizontalAlignment(SwingConstants.CENTER);
			companyName.setBounds(108, 201, 100, 30);
		}
		return companyName;
	}
	private JButton getAdminLoginBtn() {
		if (adminLoginBtn == null) {
			adminLoginBtn = new JButton("Admin Login");
			adminLoginBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AdminLogin().setVisible(true);
					dispose();
				}
			});
			adminLoginBtn.setBounds(294, 122, 124, 23);
		}
		return adminLoginBtn;
	}
	private JButton getCashierLoginBtn() {
		if (cashierLoginBtn == null) {
			cashierLoginBtn = new JButton("Cashier Login");
			cashierLoginBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CashierLogin().setVisible(true);
					dispose();
				}
			});
			cashierLoginBtn.setBounds(294, 167, 124, 23);
		}
		return cashierLoginBtn;
	}
}
