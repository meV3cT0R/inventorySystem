package com.service;

import com.model.Product;
import java.util.List;

public interface ProductService {
	boolean addProduct(Product product);
	List<Product> getAllProduct();
	Product getProductById(int id);
}
