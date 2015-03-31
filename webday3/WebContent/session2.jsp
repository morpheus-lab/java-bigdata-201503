<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>session2.jsp</title>
</head>
<body>
<%
if( session.isNew() ) {
	out.println("NEW <br/>");
} else {
	out.println("OLD <br/>");
	out.println("Session ID: " + session.getId() + "<br/>");
	out.println("Creation Time: " + new Date(session.getCreationTime()) + "<br/>");
	out.println("Last Access Time: " + new Date(session.getLastAccessedTime()) + "<br/>");
	out.println("Max Inactive Interval: " + session.getMaxInactiveInterval() + "<br/>");
	
	session.invalidate();
}
%>
</body>
</html>