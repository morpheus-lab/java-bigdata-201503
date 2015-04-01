<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>REQUEST ATTRIBUTE RECEIVER</title>
</head>
<body>
<%
Calendar cal = (Calendar) request.getAttribute("cal");
String name = (String) request.getAttribute("name");
%>
<%= name %> 부활시간:
<%= cal.get(Calendar.HOUR_OF_DAY) %>시
<%= cal.get(Calendar.MINUTE) %>분
<%= cal.get(Calendar.SECOND) %>초입니다.
</body>
</html>