package com.jianpu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.jianpu.model.Menu;
import com.jianpu.service.MenuService;

@Controller
@RequestMapping("menu")
public class MenuController {
	@Resource(name="menuService")
	private MenuService service;
	
	@RequestMapping("query")
	@ResponseBody
	public List<Menu> query(){
		
		List<Menu> query = service.queryMenu(0);
		ArrayList<Menu> list = new ArrayList<Menu>();
		for (Menu m : query) {
			
			List<Menu> list1 = service.queryMenu(m.getId());
			
			m.setList(list1);
			list.add(m);
		}
		
		return list;
		
	}
	
}
