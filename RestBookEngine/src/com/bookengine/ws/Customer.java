package com.bookengine.ws;

public class Customer {
	 
	private String name;
	private String address;
	private String phone;
	private String custId;
	private String username;
	private String password;
	
	public Customer(){
		
	}
	
	public Customer(String name, String address, String phone, String custId, String username, String password){
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.custId = custId;
		this.username = username;
		this.password = password;
		
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
