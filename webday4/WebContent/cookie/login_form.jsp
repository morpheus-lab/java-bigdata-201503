<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String rememberedId = "";

Cookie[] cookies = request.getCookies();

if (cookies != null) {
	
	for (int i = 0; i < cookies.length; i++) {
		
		if (cookies[i].getName().equals("login-id")) {
			
			rememberedId = cookies[i].getValue();
			
		}
		
	}
	
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인 (쿠키 이용)</title>
</head>
<body>

관리자 로그인하세요.<br/>

<form action="login.jsp" method="post">

	ID: <input type="text" name="id" value="<%= rememberedId %>" />
	<input type="checkbox" name="remember_id"
		value="1" <%= !rememberedId.equals("") ? "checked" : "" %> /> 아이디 저장<br/>
	
	PW: <input type="password" name="pw" /><br/>
	
	<input type="submit" value="로그인" />
	
</form>

</body>
</html>