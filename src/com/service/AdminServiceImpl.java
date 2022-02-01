package com.service;

import java.util.List;

import com.db.DB;
import com.model.Cashier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminServiceImpl implements AdminService{

	@Override
	public void addCashier() {
		
	}

	@Override
	public List<Cashier> getAllUnverifiedCashiers() {
		String query = "SELECT * from temp_cashier";
		List<Cashier> cashiers = new ArrayList<Cashier>();
		
		try {
			Statement stm = DB.getDbConn().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			if(rs.next()) {
				Cashier cashier = new Cashier();
				cashier.setFirstName(rs.getString("firstName"));
				cashier.setLastName(rs.getString("lastName"));
				cashier.setUserName(rs.getString("userName"));
				cashier.setBirthDate(rs.getDate("birthDate"));
				cashier.setAddress(rs.getString("address"));
				cashier.setPassWord(rs.getString("password"));
				
				cashiers.add(cashier);
			}
				
			return cashiers;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return null;
		
	}
	
}
