package com.jianpu.service;

import java.util.List;
import java.util.Map;

import com.jianpu.model.User;

public interface UserService {
	
	public List<User> queryUser();
	
	public void registerUser(User u);
	
	public List<User> queryUser(int page,int rows);
	
	public int queryU();
	
	public void sendCode(String phone);
	
	public Map<String,String> checkCode(String phone,String code);
	
}
