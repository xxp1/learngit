package com.jianpu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jianpu.model.User;

public interface UserDao {
	
	public List<User> selectAll();
	
	public void insertUser(User u);
	
	public List<User> selectUser(@Param("page")int page,@Param("rows")int rows);
	
	public int select();
}
