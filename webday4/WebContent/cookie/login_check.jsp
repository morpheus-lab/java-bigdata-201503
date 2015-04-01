<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 체크</title>
</head>
<body>
<%
String adminID = (String) session.getAttribute("AdminId");
boolean isLogin = false;
// 로그인 상태 체크 (세션 attribute 체크)
if (adminID != null
		&& adminID.equals(application.getInitParameter("AdminID"))) {
	isLogin = true;
}

if (isLogin) {
%>
아이디 <%= adminID %>로 로그인 한 상태입니다.<br/><br/>
<a href="logout.jsp">로그아웃</a>
<%
} else {
%>
로그인 하지 않은 상태입니다.
<%
}
%>

</body>
</html>