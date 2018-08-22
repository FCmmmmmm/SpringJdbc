package com.fcmmmmmm.entity;

public class Item {
	private Long id;
	private Order order;
	private String product;
	private double price;
	private int quantity;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Order getOrder() {
		return order;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public String getProduct() {
		return product;
	}
	
	
}
