<%@page import="java.util.UUID"%>
<%@page import="com.bitacademy.nosql.redis.twitter.AppControl"%>
<%@page import="redis.clients.jedis.JedisPoolConfig"%>
<%@page import="redis.clients.jedis.Jedis"%>
<%@page import="redis.clients.jedis.JedisPool"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>트위터 - 회원가입</title>
	<link type="text/css" rel="stylesheet" href="main.css">
	<script src="js/jquery-1.11.2.js"></script>
	<script>
		var id_ok = false;
		
		function checkId() {
			$('#id_ok').html('');
			// 입력된 아이디 값을 어디론가 전송해서 중복검사하도록 AJAX 통신
			var userName = document.forms[0].userName.value.trim();
			if (!userName) {
				alert('아이디를 입력하세요');
				document.forms[0].userName.focus();
				return;
			}
			$.get('checkId.jsp?userName=' + userName, function (data) {
				id_ok = eval(data.trim());
				if (id_ok) {
					$('#id_ok').css('color', 'blue');
					$('#id_ok').html('사용하셔도 좋습니다.');
				} else {
					$('#id_ok').css('color', 'red');
					$('#id_ok').html('중복된 아이디입니다.');
				}
			});
		}
		
		function validate() {
			var username = document.forms[0].userName.value;
			var password = document.forms[0].userPw.value;
			
			if (!username) {
				alert('아이디를 입력하세요.');
				document.forms[0].userName.focus();
				return false;	// 전송되지 않도록
			}
			
			if (!password) {
				alert('비밀번호를 입력하세요.');
				document.forms[0].userPw.focus();
				return false;	// 전송되지 않도록
			}
			
			if (!id_ok) {
				alert('아이디 중복 검사를 수행하세요.');
				return false;
			}
			
			return true;
		}
		
		function resetIdOk() {
			id_ok = false;
			$('#id_ok').html('');
		}
	</script>
</head>
<body>

	<h2><a href="<%=request.getContextPath()%>/" style="text-decoration: none;">트위터</a></h2>
	
	<h3>회원가입</h3>
	
<%
		String flag = request.getParameter("flag");

	if ("reg".equals(flag)) {
		// 회원 가입 처리
		String userName = request.getParameter("userName");
		String password = request.getParameter("userPw");
		// Redis에 저장
		JedisPool pool =  new JedisPool(new JedisPoolConfig(),
							application.getInitParameter("redis-host"),
							Integer.parseInt(
									application.getInitParameter("redis-port")));
		String auth = UUID.randomUUID().toString();
		String userId = null;
		try (Jedis jedis = pool.getResource()) {
			userId = jedis.incr("next_user_id").toString();
			
			jedis.hset("user_info", userId + ":username", userName);
			jedis.hset("user_info", userId + ":password", AppControl.sha256Digest(password));
			jedis.hset("user_info", userId + ":auth", auth);
			jedis.hset("user_info", auth + ":user_id", userId.toString());
			jedis.hset("user_info", userName + ":user_id", userId.toString());
		}
		pool.destroy();
		
		// 로그인 처리
		if (userId != null) {
			Cookie cookie = new Cookie("auth", auth);
			cookie.setMaxAge(60 * 60 * 24);	// 유효시간: 초 단위
			response.addCookie(cookie);
			
			session.setAttribute("user_id", userId);
			session.setAttribute("username", userName);
		}
		// index.jsp로 리디렉트
		response.sendRedirect(request.getContextPath());
	} else {
	%>
	<form action="./signup.jsp" method="post" onsubmit="return validate()">
		<input type="hidden" name="flag" value="reg">
		아 이 디: <input type="text" name="userName" onchange="resetIdOk()">
		<input type="button" value="중복검사" onclick="checkId()">
		<span id="id_ok"></span><br>
		비밀번호: <input type="password" name="userPw"><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>

<%
}
%>

</body>
</html>