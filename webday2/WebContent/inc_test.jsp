<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>include 지시문</title>
</head>
<body>
<%
String start =">>";
String end ="<<";
%>
현재의 날짜와 시각은
<%@ include file="date.jinc" %>
입니다.
<br/>
<%= incVar %>
<hr/>
<%@ include file="dateNotify.inc" %>
</body>
</html>