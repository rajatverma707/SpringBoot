package com.resttemplate.model;

public class Order {
	
	private Integer orderId;
	private double amount;
	private String name;
	private String address;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", amount=" + amount + ", name=" + name + ", address=" + address + "]";
	}
	
}
