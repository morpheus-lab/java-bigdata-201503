<%@page import="redis.clients.jedis.Jedis"%>
<%@page import="java.util.UUID"%>
<%@page import="redis.clients.jedis.JedisPoolConfig"%>
<%@page import="redis.clients.jedis.JedisPool"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String userName = request.getParameter("userName");
//true	=> 사용 가능
//false	=> 사용 불가능
JedisPool pool =  new JedisPool(new JedisPoolConfig(),
							application.getInitParameter("redis-host"),
							Integer.parseInt(
									application.getInitParameter("redis-port")));
String auth = UUID.randomUUID().toString();
Long userId = null;
Boolean exists = false;
try (Jedis jedis = pool.getResource()) {
	exists = jedis.hexists("user_info", userName + ":user_id");
}
pool.destroy();
%>
<%= !exists %>