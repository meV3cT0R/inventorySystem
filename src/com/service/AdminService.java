package com.service;

import com.model.Cashier;
import java.util.List;

public interface AdminService {
	void addCashier();
	List<Cashier> getAllUnverifiedCashiers();
}
