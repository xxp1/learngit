package com.jianpu.dao;

import java.util.List;

import com.jianpu.model.Daily;

public interface DailyDao {
	
	public void insertDaily(Daily d);
	
	public List<Daily> selectDaily();
}
