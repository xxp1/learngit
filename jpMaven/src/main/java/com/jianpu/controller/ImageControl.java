package com.jianpu.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jianpu.util.SecurityCode;
import com.jianpu.util.SecurityImage;

@Controller
@RequestMapping("/image")
public class ImageControl {
	
	
	@RequestMapping("/image1")
	public void createImage(HttpServletResponse response,HttpServletRequest request) throws IOException{
		
		//�õ���֤��
		String code = new SecurityCode().getSecurityCode();
		//��session����֤��
		HttpSession session = request.getSession();
		session.setAttribute("yzm", code);
		
		
		//������֤��ͼƬ
		BufferedImage image = SecurityImage.createImage(code);
		
		ImageIO.write(image, "jpg", response.getOutputStream());
		
		
	}
	
	
}
