package com.service;

import com.model.Bill;

public interface BillService {
	Bill getBillById(int id);
	boolean addBill(Bill bill);
}
