package com.jianpu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jianpu.model.Daily;
import com.jianpu.service.DailyService;

@Controller
@RequestMapping("daily")
public class DailyContoller {
	@Resource(name="dailyService")
	private DailyService service;
	@RequestMapping("/query")
	@ResponseBody
	public List<Daily> query(){
		List<Daily> list = service.queryDaily();
		
		return list;
	}
	
	
}
