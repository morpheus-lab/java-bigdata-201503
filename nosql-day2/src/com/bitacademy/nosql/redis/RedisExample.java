package com.bitacademy.nosql.redis;

import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisExample {
	
	public static void main(String[] args) throws Exception {
		
		JedisPool pool =  new JedisPool(new JedisPoolConfig(),
										"192.168.1.37");
		
		try (Jedis jedis = pool.getResource()) {
			
			// 데이터 저장
			jedis.set("jedis", "awesome");
			
			// 데이터 조회
			String value = jedis.get("jedis");
			System.out.println("jedis: " + value);
			
			// Set 타입 데이터 저장
			jedis.zadd("z2", 10, "KOREA");
			jedis.zadd("z2", 20, "USA");
			jedis.zadd("z2", 30, "CHINA");
			jedis.zadd("z2", 30, "JAPAN");
			
			// Set 타입 데이터 조회
			Set<String> z2 = jedis.zrange("z2", 0, -1);
			/*
			z2.forEach(new Consumer<String>() {
				@Override
				public void accept(String t) {
					System.out.println(t);
				}
			});
			*/
			Iterator<String> iter = z2.iterator();
			while (iter.hasNext()) {
				String t = iter.next();
				System.out.println(t);
			}
		}
		
		/*
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
		} catch (Exception e) {
			
		} finally {
			if (jedis != null)
				jedis.close();
		}
		*/
		
		pool.destroy();
		
	}
	
}
