package com.service;

import java.util.List;

import com.db.DB;
import com.model.Cashier;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminServiceImpl implements AdminService{

	@Override
	public void addCashier(Cashier cashier) {
		String query = "INSERT INTO cashier(firstName,lastName,userName,passWord,birthDate,address) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = DB.getDbConn().prepareStatement(query);
			pstm.setString(1, cashier.getFirstName());
			pstm.setString(2, cashier.getLastName());
			pstm.setString(3, cashier.getUserName());
			pstm.setString(4, cashier.getPassWord());
			pstm.setDate(5, new Date(cashier.getBirthDate().getTime()));
			pstm.setString(6,cashier.getAddress());
		
			pstm.execute();
				
			String deleteQuery = String.format("DELETE FROM temp_cashier WHERE userName = '%s'",cashier.getUserName());
			System.out.println(deleteQuery);
			Statement stm = DB.getDbConn().createStatement();
			stm.executeUpdate(deleteQuery);
				
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Cashier> getAllUnverifiedCashiers() {
		String query = "SELECT * from temp_cashier";
		List<Cashier> cashiers = new ArrayList<Cashier>();
		
		Cashier cashier = new Cashier();
		try {
			Statement stm = DB.getDbConn().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			
			if(rs.next()) {
				
				cashier.setFirstName(rs.getString("firstName"));
				cashier.setLastName(rs.getString("lastName"));
				cashier.setUserName(rs.getString("userName"));
				cashier.setBirthDate(rs.getDate("birthDate"));
				cashier.setAddress(rs.getString("address"));
				cashier.setPassWord(rs.getString("password"));
				
				cashiers.add(cashier);
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return cashiers;
		
	}

	@Override
	public boolean adminLogin(String userName, String passWord) {
		String query = String.format("SELECT * FROM admins WHERE userName = '%s' AND password = '%s'",userName.trim(),passWord.trim());
		try {
			Statement stm = DB.getDbConn().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			return rs.next();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
}
