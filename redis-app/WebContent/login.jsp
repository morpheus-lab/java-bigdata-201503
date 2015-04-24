<%@page import="com.bitacademy.nosql.redis.twitter.AuthUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 로그인 처리
String userName = request.getParameter("userName");
String userPass = request.getParameter("userPw");

boolean success = AuthUtil.login(userName, userPass, request, response);

String contextPath = request.getContextPath();

if (!success) {
%>
<!DOCTYPE html>
<html>
<head>
	<script>
		alert('아이디 또는 비밀번호를 확인하세요. <%= userName + ", " + userPass %>');
		location.href = '<%= contextPath %>/';
	</script>
</head>
<body>
</body>
</html>
<%
} else {
	// 홈으로 리디렉트
	response.sendRedirect(contextPath);
}
%>

