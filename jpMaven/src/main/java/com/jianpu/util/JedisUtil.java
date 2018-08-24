package com.jianpu.util;

import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
	private static JedisPool jedisPool;
	static {
		JedisPoolConfig config = new JedisPoolConfig();
		// 璁剧疆鏈�ぇ杩炴帴鏁�
		config.setMaxTotal(20);

		// 璁剧疆杩炴帴鏃堕暱
		config.setMaxWaitMillis(5000);

		// 璁剧疆鏈�ぇ瀛樻椿鏁�
		config.setMaxIdle(10);
		
		jedisPool = new JedisPool(config, "192.168.246.128", 6379);
	
	}

	public static Jedis getJedis() {

		Jedis jedis = jedisPool.getResource();

		return jedis;
	}

	public static void closeJedis(Jedis jedis) {

		jedis.close();
		
	}

	@Test
	public void test() {
		Jedis jedis = getJedis();

		jedis.select(1);

		jedis.zadd("articleName", 1, "01");
		jedis.zadd("articleName", 5, "02");
		jedis.zadd("articleName", 7, "03");
		jedis.zadd("articleName", 2, "05");
		
		Set<String> zrange = jedis.zrange("articleName", 0, -1);
		for (String key : zrange) {
			System.out.println(key);
			Double zscore = jedis.zscore("articleName", key);
			System.out.println(zscore);
		}
		//closeJedis(jedis);

	}
}
