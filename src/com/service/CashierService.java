package com.service;

import com.model.Cashier;
import java.util.List;
import com.model.Product;

public interface CashierService {
	List<Product> getAllProduct();
	boolean cashierLogin(String userName,String passWord);
	boolean cashierRegister(Cashier cashier);
}
