package com.service;

import com.db.DB;
import com.model.Bill;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BillServiceImpl implements BillService{
	@Override
	public Bill getBillById(int id) {
		String query = String.format("SELECT * FROM bill WHERE id = '%d'",id);
		
		try {
			Statement stm = DB.getDbConn().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Bill bill = new Bill();
			if(rs.next()) {
				bill.setAmount(rs.getInt("mrp"));
				bill.setCustomerName(rs.getString("customerName"));
				bill.setId(rs.getInt("id"));
				bill.setDate(rs.getDate("date"));
			}
			
			return bill;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addBill(Bill bill) {
		String query = "INSERT INTO bill(customerName,mrp,date)VALUES(?,?,?)";
		
		try {
			PreparedStatement pstm = DB.getDbConn().prepareStatement(query);
			pstm.setString(1, bill.getCustomerName());
			pstm.setInt(2, bill.getAmount());
			pstm.setDate(3, new Date(bill.getDate().getTime()));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

}
