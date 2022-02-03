package com.service;

import java.util.List;

import com.db.DB;
import com.model.Cashier;
import com.model.Product;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CashierServiceImpl implements CashierService{

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cashierLogin(String userName,String password) {
		String query = String.format("SELECT * FROM cashier WHERE userName='%s' AND password='%s'", userName.trim(),password.trim());
		try {
			Statement stm = (Statement) DB.getDbConn().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			return rs.next();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean cashierRegister(Cashier cashier) {
		String query = "INSERT INTO temp_cashier(firstName,lastName,userName,password,birthDate,address)VALUES(?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstm = DB.getDbConn().prepareStatement(query);
			pstm.setString(1, cashier.getFirstName());
			pstm.setString(2, cashier.getLastName());
			pstm.setString(3, cashier.getUserName());
			pstm.setString(4, cashier.getPassWord());
			pstm.setDate(5, new Date(cashier.getBirthDate().getTime()));
			pstm.setString(6,cashier.getAddress());
			
			pstm.execute();
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return false;
	}


}
