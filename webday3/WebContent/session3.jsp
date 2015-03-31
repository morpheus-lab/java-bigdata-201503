<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>session3.jsp</title>
</head>
<body>
<%
	session.setMaxInactiveInterval(10);	// 세션 유효시간을 10초로 설정
	
	if (session.isNew()) {
%>
		세션이 새로 생성되었습니다.<br/><br/>
<%
	} else {
%>
		이전 세션이 계속 사용되고 있습니다.<br/><br/>
<%
	}
	
	out.println("Session ID: " + session.getId() + "<br/>");
	out.println("Creation Time: " + new Date(session.getCreationTime()) + "<br/>");
	out.println("Last Access Time: " + new Date(session.getLastAccessedTime()) + "<br/>");
	out.println("Max Inactive Interval: " + session.getMaxInactiveInterval() + "<br/>");
%>
</body>
</html>