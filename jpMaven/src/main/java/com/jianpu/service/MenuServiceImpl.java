package com.jianpu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jianpu.advice.Detail;
import com.jianpu.dao.MenuDao;
import com.jianpu.model.Menu;
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {
	@Resource(name="menuDao")
	private MenuDao dao;
	
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	@Detail("查询菜单")
	public List<Menu> queryMenu(int p_id) {
		List<Menu> list = dao.selectMenu(p_id);
		return list;
	}

}
