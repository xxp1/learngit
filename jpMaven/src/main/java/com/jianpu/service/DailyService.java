package com.jianpu.service;

import java.util.List;

import com.jianpu.model.Daily;

public interface DailyService {
	public void addDaily(Daily d);
	
	public List<Daily> queryDaily();
}
