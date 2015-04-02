<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = "";
Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (Cookie c : cookies) {
		if (c.getName().equals("id")) {
			id = c.getValue();
			break;
		}
	}
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키 이용 로그인 폼</title>
</head>
<body>
	<h3>쿠키 이용 로그인</h3>
	<hr/>
	로그인하세요.<br />

	<form action="login.jsp" method="post">
		ID: <input type="text" name="id" value="<%= id %>" />
		<input type="checkbox" name="idsave" value="store" <%= "".equals(id) ? "" : "checked" %> /> 아이디 기억<br />
		PW: <input type="password" name="pw" /><br />
		<input type="submit" value="로그인" />
	</form>
</body>
</html>