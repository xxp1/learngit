package com.jianpu.model;

public class User {
	
	
	private Integer id;
	private String username;
	private String password;
	private String address;
	public String getAddress() {
		return address;
	}public Integer getId() {
		return id;
	}public String getPassword() {
		return password;
	}public String getUsername() {
		return username;
	}public void setAddress(String address) {
		this.address = address;
	}public void setId(Integer id) {
		this.id = id;
	}public void setPassword(String password) {
		this.password = password;
	}public void setUsername(String username) {
		this.username = username;
	}@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
	
}
