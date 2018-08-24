
package com.jianpu.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jianpu.model.PageDTO1;
//import com.baizhi.entity.PageDTO1;
import com.jianpu.model.User;
import com.jianpu.service.UserService;
//importm.jianpu.util.POI;
//import com.jianpu.util.UserModel;
import com.jianpu.util.POI;
import com.jianpu.util.UserModel;


@Controller
@RequestMapping("/userP")
public class UserPoi {
	@Resource(name="userService")
	private UserService service;
	
	
	@RequestMapping("/User")
	@ResponseBody
	public void User() throws Exception{
	List<User> list = service.queryUser();
		
		POI poi = new POI();
		poi.UserPOI(list);
	}
	@RequestMapping("/import")
	@ResponseBody
	public void importUser() throws Exception{
		
		UserModel model = new UserModel();
		List<User> user = model.User();
		System.out.println(user);
		for(int i=0;i<user.size();i++){
			
			service.registerUser(user.get(i));
		}
	}

	@RequestMapping("/queryPage")
	@ResponseBody
	public PageDTO1 queryPage(int page,int rows){
		
		int page2 = service.queryU();
		List<User> list = service.queryUser(page, rows);
		PageDTO1 p1 = new PageDTO1();
		p1.setTotal(page2);
		
		p1.setRows(list);
		return p1;
		
	}	
	@RequestMapping("/obtain")
	public @ResponseBody void getCode(String phone){
		
		service.sendCode(phone);
		
	}
	
	@RequestMapping(value={"/check/{phone}"},method=RequestMethod.GET)
	public @ResponseBody Map<String,String> checkCode(@PathVariable("phone")String phone,String code){
		
		Map<String, String> map = service.checkCode(phone,code);
		
		return map;
	}
	
}
