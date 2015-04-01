<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>REQUEST ATTRIBUTE</title>
</head>
<body>

<%
	Calendar cal = Calendar.getInstance();
	request.setAttribute("cal", cal);
	
	request.setAttribute("name", "우르곳");
%>
<jsp:forward page="recv_attr.jsp" />
</body>
</html>