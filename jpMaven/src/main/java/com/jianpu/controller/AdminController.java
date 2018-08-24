package com.jianpu.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	@RequestMapping("/login")
	public void login(String username,String password,String code){
		// 调用service 进行认证
		
		//获得主体
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken token = new UsernamePasswordToken(username,password);
		//认证
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("是否认证成功: "+subject.isAuthenticated());
	}
}
