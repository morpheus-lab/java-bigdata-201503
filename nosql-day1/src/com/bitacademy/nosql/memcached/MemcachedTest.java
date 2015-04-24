package com.bitacademy.nosql.memcached;

import java.net.InetSocketAddress;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

public class MemcachedTest {
	
	public static void main(String[] args) throws Exception {
		
//		MemcachedClient c = new MemcachedClient(
//				new InetSocketAddress("192.168.1.37", 11211));
		
		MemcachedClient c = new MemcachedClient(
				AddrUtil.getAddresses("192.168.1.37:11211 192.168.1.50:11211"));
		
		c.set("app", 600, "hello1");
		c.set("test", 600, "hello2");
		c.set("java", 600, "coffee");
		c.set("apple", 600, "iPhone");
		c.set("samsung", 600, "S6");
		
//		Object value = c.get("test");
//		
//		System.out.println(value);
		
	}
	
}
