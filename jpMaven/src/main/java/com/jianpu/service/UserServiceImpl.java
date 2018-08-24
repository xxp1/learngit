package com.jianpu.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jianpu.advice.Detail;

//import redis.clients.jedis.Jedis;


import com.jianpu.dao.UserDao;
import com.jianpu.model.User;
import com.jianpu.util.CodeUtil;
//import com.baizhi.util.CodeUtil;
import com.jianpu.util.JedisUtil;
import com.jianpu.util.Send;

import redis.clients.jedis.Jedis;
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource(name="userDao")
	private UserDao dao;
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	@Detail("查询所有用户")
	public List<User> queryUser() {
		
		return dao.selectAll();
	}
	@Transactional
	@Detail("注册用户")
	public void registerUser(User u) {
		dao.insertUser(u);
		
	}
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	@Detail("分页查询用户")
	public List<User> queryUser(int page, int rows) {
		List<User> list = dao.selectUser(page, rows);
		return list;
	}
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	@Detail("查询所有用户人数")
	public int queryU() {
		int select = dao.select();
		return select;
	}
	
	public void sendCode(String phone) {
		// 第一步生成验证码
		String code = CodeUtil.getCode(4);
		String ret = null;
		try {
			// 第二步调用第三方平台发送验证码
			String PostData = "account=xxp982460&password=xxp982460&mobile="
					+ phone
					+ "&content="
					+ URLEncoder.encode("您的验证码是：" + code + "。如需帮助请联系客服。",
							"utf-8");
			// out.println(PostData);
			ret = Send.SMS(PostData, "http://sms.106jiekou.com/utf8/sms.aspx");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 第三步 如果相应状态成功 进行Redis存储
		if (ret.equals("100\n")) {
			Jedis jedis = JedisUtil.getJedis();

			jedis.select(1);

			jedis.setex(phone, 90, code);
		}
	}

	public Map<String, String> checkCode(String phone, String code) {
		// 第一步从Redis获取存储的验证码
		Jedis jedis = JedisUtil.getJedis();

		jedis.select(1);
		String rCode = jedis.get(phone);

		HashMap<String, String> map = new HashMap<String, String>();
		// 第二步进行校验
		if (rCode == null) {
			map.put("result", "fail");
		} else if (code.equals(rCode)) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}

		return map;

	}
	
}
