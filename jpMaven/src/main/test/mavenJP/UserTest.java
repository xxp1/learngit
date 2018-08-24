package mavenJP;



import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.jianpu.dao.DailyDao;
import com.jianpu.dao.UserDao;
import com.jianpu.model.Daily;
import com.jianpu.model.User;
//import com.jianpu.service.DailyService;
import com.jianpu.service.UserService;

public class UserTest {
	
	
	@SuppressWarnings("resource")
	@Test
	public void tset1(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/com/jianpu/spring/spring.xml");
		UserDao s = (UserDao) ctx.getBean("userDao");
		List<User> list = s.selectAll();
		System.out.println(list);
		
	}
	
	@SuppressWarnings("resource")
	@Test
	public void tset2(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/jianpu/spring/spring.xml");
		UserService s = (UserService) ctx.getBean("userService");
		List<User> list = s.queryUser();
		System.out.println(list);
		
	}
	


	@SuppressWarnings("resource")
	@Test
	public void tset4(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/jianpu/spring/spring.xml");
		SqlSessionFactory s = (SqlSessionFactory) ctx.getBean("sqlSessionFactoryBean");
		System.out.println(s.openSession().getConnection());
		
		
		
	}
	
	
}
	