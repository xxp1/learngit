package com.jianpu.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jianpu.dao.UserDao;
import com.jianpu.model.User;

public class POI{

	public void UserPOI(List<User> list) throws Exception{
		
		//创建表格
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("�û���");
		
		//数据
		String[] titles={"编号","手机号","密码","图片","法名","用户名","性别","地址","签名","状态"};
		
	
		
		//ͨ通过反射得到User所有属性
		
		Class<? extends User> userClass = new User().getClass();
		Field[] fields = userClass.getDeclaredFields();
		
		//创建标题行
		HSSFRow row = sheet.createRow(0);
		for(int i=0;i<fields.length;i++){
			HSSFCell cell = row.createCell(i);
			//获得属性名称
			String name = fields[i].getName();
			System.out.println(name);
			cell.setCellValue(name);
		}
		
		for(int i=0;i<list.size();i++){
			//创建行
			HSSFRow row2 = sheet.createRow(i+1);
			//创建列
			for(int j=0;j<fields.length;j++){
				//创建单元格
				HSSFCell cell = row2.createCell(j);
				
				//打破封装װ
				fields[j].setAccessible(true);
				
				
				//遍历获得每一个属性的值，基于反射
				Object val = fields[j].get(list.get(i));
				System.out.println(val.toString());
				
				cell.setCellValue(val.toString());
				
			}
		}
		File file = new File("d://","用户信息表.xls");
		
		FileOutputStream stream = new FileOutputStream(file);
		
		workbook.write(stream);
	}
}
