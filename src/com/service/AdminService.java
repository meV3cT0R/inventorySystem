package com.service;

import com.model.Cashier;
import java.util.List;

public interface AdminService {
	void addCashier(Cashier cashier);
	List<Cashier> getAllUnverifiedCashiers();
}
