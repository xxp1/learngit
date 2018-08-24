package com.jianpu.util;

import java.util.Random;

import org.junit.Test;



public class CodeUtil {

	public static String getCode(int len){
		
		//��һ������һ���ֵ�
		String a = "1234567890";
		
		//�ڶ�������һ�������
		Random r = new Random();
		
		//����������һ�������������
		char[] c = new char[len];
		
		for (int i = 0; i < c.length; i++) {
			c[i] = a.charAt(r.nextInt(a.length()));
		}
		
		
		return new String(c);
		
	}
	
	@Test
	public void test(){
		
		System.out.println(getCode(6));
		
	}
}