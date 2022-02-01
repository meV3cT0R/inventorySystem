package com.model;

public class Product {
	private int id;
	private String firstName;
	private int quantityAvailable;
	private int added;
	private int MRP;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	public int getAdded() {
		return added;
	}
	public void setAdded(int added) {
		this.added = added;
	}
	public int getMRP() {
		return MRP;
	}
	public void setMRP(int mRP) {
		MRP = mRP;
	}
	
	
}
