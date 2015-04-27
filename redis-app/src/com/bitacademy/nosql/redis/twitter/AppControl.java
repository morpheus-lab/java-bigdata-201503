package com.bitacademy.nosql.redis.twitter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class AppControl implements ServletContextListener {
	
	private static String REDIS_HOST = null;
	private static int REDIS_PORT = 0;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		REDIS_HOST = sce.getServletContext().getInitParameter("redis-host");
		REDIS_PORT = Integer.parseInt(
				sce.getServletContext().getInitParameter("redis-port"));
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	
	// user id로 username 조회
	public static String getUsername(String userId) {
		String username = null;
		JedisPool pool =  new JedisPool(new JedisPoolConfig(),
				REDIS_HOST, REDIS_PORT);
		try (Jedis jedis = pool.getResource()) {
			username = jedis.hget("user_info", userId + ":username");
		}
		pool.destroy();
		return username;
	}
	
	// 팔로우 기능
	public static void follow(String followerUserId, String followeeUserId) {
		JedisPool pool =  new JedisPool(new JedisPoolConfig(),
				REDIS_HOST, REDIS_PORT);
		try (Jedis jedis = pool.getResource()) {
			jedis.sadd(followerUserId + ":following", followeeUserId);
			jedis.sadd(followeeUserId + ":followers", followerUserId);
		}
		pool.destroy();
	}
	
	// 팔로우 중?
	public static boolean isFollowing(String followerUserId, String followeeUserId) {
		boolean following = false;
		JedisPool pool =  new JedisPool(new JedisPoolConfig(),
				REDIS_HOST, REDIS_PORT);
		try (Jedis jedis = pool.getResource()) {
			following = jedis.sismember(followerUserId + ":following", followeeUserId);
			//jedis.sismember(followeeUserId + ":followers", followerUserId);
		}
		pool.destroy();
		return following;
	}
	
	// 트윗
	public static void twit(String writerUserId, String twitMessage) {
		JedisPool pool =  new JedisPool(new JedisPoolConfig(),
				REDIS_HOST, REDIS_PORT);
		try (Jedis jedis = pool.getResource()) {
			// 트윗 등록 ID 생성
			Long postId = jedis.incr("next_post_id");
			// 트윗 데이터 입력
			jedis.set("post:" + postId,
					writerUserId + "|"
					+ LocalDateTime.now().toString() + "|"
					+ twitMessage);
			
			// 전체 타임라인에 트윗 등록
			jedis.lpush("timeline", postId.toString());
			
			// 사용자 타임라인에 트윗 등록
			jedis.lpush("timeline:" + writerUserId, postId.toString());
			
			// 글쓴이의 팔로워 타임라인에 트윗 등록
			// 팔로워 조회
			Set<String> followers = jedis.smembers(writerUserId + ":followers");
			// 팔로워 타임라인에 트윗 등록
			followers.forEach(new Consumer<String>() {
				@Override
				public void accept(String followerUserId) {
					jedis.lpush("timeline:" + followerUserId,
							postId.toString());
				}
			});
			
			// 본인의 트윗 목록에 트윗 ID 등록
			jedis.lpush(writerUserId + ":posts", postId.toString());
		}
		pool.destroy();
	}
	
	// 트윗 조회 (1) - 전체
	public static List<Post> getTimeline(long start, long end) {
		return getTimeline(null, start, end);
	}
	
	// 트윗 조회 (2) - user id 별
	public static List<Post> getTimeline(String userId, long start, long end) {
		List<Post> posts = new ArrayList<Post>();
		
		JedisPool pool =  new JedisPool(new JedisPoolConfig(),
				REDIS_HOST, REDIS_PORT);
		try (Jedis jedis = pool.getResource()) {
			
			List<String> postIds = jedis.lrange(
					"timeline" + (userId == null ? "" : ":" + userId),
					start, end);
			
			postIds.forEach(new Consumer<String>() {
				@Override
				public void accept(String postId) {
					String post = jedis.get("post:" + postId);
					String[] postFields = post.split("\\|", 3);
					
					Post p = new Post();
					p.setWriterUserId(postFields[0]);
					p.setWriteDateTime(postFields[1]);
					p.setMessage(postFields[2]);
					
					// writerUserId(postFields[0])으로 username 조회
					String writerUserName = jedis.hget("user_info",
							postFields[0] + ":username");
					p.setWriterUserName(writerUserName);
					
					posts.add(p);
				}
			});
		}
		pool.destroy();
		return posts;
	}
	
	public static boolean login(String userName, String password,
			HttpServletRequest request, HttpServletResponse response) {
		boolean result = false;
		
		JedisPool pool =  new JedisPool(new JedisPoolConfig(),
				REDIS_HOST, REDIS_PORT);
		try (Jedis jedis = pool.getResource()) {
			String userId = jedis.hget("user_info", userName + ":user_id");
			String storedPw = jedis.hget("user_info", userId + ":password");
			
			if (storedPw != null && storedPw.equals(sha256Digest(password))) {
				// 새로운 token 발행
				String newAuthToken = UUID.randomUUID().toString().replaceAll("\\-", "");
				// token을 DB에 저장
				jedis.hset("user_info", userId + ":auth", newAuthToken);
				jedis.hset("user_info", newAuthToken + ":user_id", userId);
				// token을 쿠키 저장
				storeCookie("auth", newAuthToken, response, 60 * 60 * 24);
				// request attribute로 user_id 저장
				request.getSession().setAttribute("user_id", userId);
				request.getSession().setAttribute("username", userName);
				
				result = true;
			}
		}
		pool.destroy();
		
		return result;
	}
	
	public static void logout(String userId, HttpServletRequest request,
			HttpServletResponse response) {
		// 세션 정보 삭제
		request.getSession().removeAttribute("user_id");
		request.getSession().removeAttribute("username");
		
		// 쿠키에 저장되어 있던 auth
		String cookieAuth = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if ("auth".equals(c.getName())) {
					cookieAuth = c.getValue();
					break;
				}
			}
		}
		
		// 쿠키 정보 삭제
		storeCookie("auth", "", response, 0);
		
		// Redis DB 정보 삭제
		JedisPool pool =  new JedisPool(new JedisPoolConfig(),
				REDIS_HOST, REDIS_PORT);
		try (Jedis jedis = pool.getResource()) {
			if (cookieAuth != null) {
				jedis.hdel("user_info", cookieAuth + ":user_id");
			}
			
			String auth = jedis.hget("user_info", userId + ":auth");
			jedis.hdel("user_info", userId + ":auth");
			jedis.hdel("user_info", auth + ":user_id");
		}
		pool.destroy();
	}
	
	public static void storeCookie(String cookieName, String cookieValue,
			HttpServletResponse response, int expiry) {
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setMaxAge(expiry);
		response.addCookie(cookie);
	}
	
	/*
	public static void checkAuth(HttpServletRequest req) {
		Cookie authCookie = null;
		Cookie[] cookies = req.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if ("auth".equals(cookies[i].getName())) {
				authCookie = cookies[i];
				break;
			}
		}
		
		if (authCookie == null) return;
		
		String authToken = authCookie.getValue();
		// Redis에서 authToken 조회
		JedisPool pool =  new JedisPool(new JedisPoolConfig(),
				REDIS_HOST, REDIS_PORT);
		try (Jedis jedis = pool.getResource()) {
			String userId = jedis.hget("user_info", authToken + ":user_id");
			if (userId != null && !userId.trim().equals("")) {
				req.getSession().setAttribute("user_id", userId);
			} else {
				req.getSession().removeAttribute("user_id");
			}
		}
		pool.destroy();
	}
	*/
	
	public static String sha256Digest(String str) {
		String sha = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(str.getBytes());
			byte[] byteData = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(
						Integer.toString((byteData[i] & 0xff) + 0x100, 16)
							.substring(1));
			}
			sha = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			sha = null;
		}
		return sha;
	}

	public static void main(String[] args) {
//		String userName = "gdhong";
//		JedisPool pool =  new JedisPool(new JedisPoolConfig(),
//				"192.168.1.37");
//		try (Jedis jedis = pool.getResource()) {
//			Boolean userId = jedis.hexists("user_info", userName + ":user_id");
//			System.out.println(userId);
//		}
//		pool.destroy();
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt.toString());
		
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt.toString());
	}
	
}
