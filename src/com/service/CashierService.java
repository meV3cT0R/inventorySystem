package com.service;

import com.model.Cashier;
import java.util.List;

public interface CashierService {
	boolean addCashier(Cashier cashier);
	boolean deleteCashier(int id);
	List<Cashier> getAllCashier();
}
