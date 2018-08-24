package com.jianpu.advice;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.jianpu.dao.DailyDao;
import com.jianpu.model.Daily;
import com.jianpu.service.DailyService;
import com.jianpu.service.DailyServiceImpl;
import com.jianpu.util.ContextUtil;

@Component
@Aspect
public class Around1 {
	@Around("execution(* com.jianpu.service.*.*(..))")
	public Object intercept(ProceedingJoinPoint p) throws Throwable {
		Object p1 = p.proceed();
		StringBuilder sb = new StringBuilder();
		sb.append("用户");
		//某人在某时间做了什么事情
		//HttpSession session = ContextUtil.getSession();
		//Admin o = (Admin) session.getAttribute("admin");
		//sb.append(o.getName());
	
		
		String time = new SimpleDateFormat("yyyy-MM-dd HH:dd:ss").format(new Date());
		sb.append("在"+time);
		//什么是，即方法名
		Signature s = p.getSignature();
		
		MethodSignature ms = (MethodSignature) s;
		Method method = ms.getMethod();
		
		Detail detail = method.getAnnotation(Detail.class);
		System.out.println(detail);
		if(detail!=null){
			String value = detail.value();
			String name = ms.getName();
			sb.append("进行"+value+"操作");
			
			System.out.println(sb.toString());
			
			
			//������
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/jianpu/spring/spring.xml");
			DailyDao s1 = (DailyDao) ctx.getBean("dailyDao");
			
			
			 Daily d = new Daily();
			 //string转化为utilDate
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 Date utilDate = sdf.parse(time);
			 //utilDate转换为sqlDate
			 long sqlDate = utilDate.getTime();
			 java.sql.Date date = new java.sql.Date(sqlDate);
			 
			 
			 d.setDate(date);
			// d.setUsername(o.getName());
			 d.setDetail(sb.toString());
			s1.insertDaily(d);
			
		}
		return p1;
	}

}
