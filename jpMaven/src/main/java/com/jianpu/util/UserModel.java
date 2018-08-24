package com.jianpu.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.jianpu.model.User;
import com.sun.rowset.internal.Row;

public class UserModel {
	
	@SuppressWarnings("resource")
	public List<User> User() throws Exception{
		FileInputStream inputStream = new FileInputStream("d://用户信息表.xls");
		
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = workbook.getSheet("用户表");
		//获得总行数
		int rowNum = sheet.getLastRowNum();
		System.out.println(rowNum);
		
		
		List<User> list = new ArrayList<User>();
		org.apache.poi.ss.usermodel.Row row2= null;
		
		for(int i=1;i<=rowNum;i++){
			User user = new User();

			row2 = sheet.getRow(i);
			System.out.println(row2);
			user.setId(Integer.parseInt(row2.getCell(0).getStringCellValue()));
			user.setIphone(Integer.parseInt(row2.getCell(1).getStringCellValue()));
			user.setPassword(row2.getCell(2).getStringCellValue());
			
			user.setImage(row2.getCell(3).getStringCellValue());
			user.setFaming(row2.getCell(4).getStringCellValue());
			user.setUsername(row2.getCell(5).getStringCellValue());
			user.setSex(Integer.parseInt(row2.getCell(6).getStringCellValue()));

			user.setAddress(row2.getCell(7).getStringCellValue());
			user.setQianming(row2.getCell(8).getStringCellValue());

			user.setStatus(Integer.parseInt(row2.getCell(9).getStringCellValue()));
			//System.out.println(user);
			list.add(user);
			System.out.println(list);
		}
		
		
		return list;
	}
}
