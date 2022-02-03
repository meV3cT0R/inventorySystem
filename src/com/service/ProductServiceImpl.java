package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.db.DB;
import com.model.Product;

public class ProductServiceImpl implements ProductService {

	@Override
	public boolean addProduct(Product product) {
		
		return false;
	}

	@Override
	public List<Product> getAllProduct() {
		
		return null;
	}

	@Override
	public Product getProductById(int id) {
		
		return null;
	}

	@Override
	public List<Product> searchProduct(String searchValue) {
		String query = "SELECT * FROM products WHERE productName LIKE '"+searchValue+"%'";
		System.out.println(query);
		try {
			List<Product> products = new ArrayList<>();
			PreparedStatement stm = DB.getDbConn().prepareStatement(query);
			
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setFirstName(rs.getString("productName"));
				product.setQuantityAvailable(rs.getInt("quantityAvailable"));
				product.setMRP(rs.getInt("MRP"));
				products.add(product);
			}
			
			return products;
		}catch (SQLException exception) {
			exception.printStackTrace();
		}
		return null;
	}
	
}
