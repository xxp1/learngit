package com.jianpu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jianpu.advice.Detail;
import com.jianpu.dao.DailyDao;
import com.jianpu.model.Daily;
@Service("dailyService")
@Transactional
public class DailyServiceImpl implements DailyService {
	@Resource(name="dailyDao")
	private DailyDao dao;
	
	
	@Detail("添加日志")
	public void addDaily(Daily d) {
		dao.insertDaily(d);
		
	}


	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	@Detail("查询所有日志")
	public List<Daily> queryDaily() {
		
		return dao.selectDaily();
	}

}
