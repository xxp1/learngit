package com.jianpu.dao;

import java.util.List;

import com.jianpu.model.Menu;

public interface MenuDao {
	
	public List<Menu> selectMenu(int p_id);
	
}
