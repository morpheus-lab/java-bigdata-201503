<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//HTTP 1.1
response.setHeader("Cache-Control","no-cache");
//HTTP 1.0
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방문자 카운터</title>
</head>
<body>
<%
	if (session.isNew()) {
		Integer count = (Integer) application.getAttribute("count");
		count++;
		application.setAttribute("count", count);
	}
%>
방문자 수: <%= application.getAttribute("count") %>

</body>
</html>