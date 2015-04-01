<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String value = request.getParameter("p1");
if(value == null)
	value = "NOPARAM";
%>
<jsp:forward page="paramTo.jsp">
	<jsp:param name="p2" value="<%=value%>"/>
</jsp:forward>
</body>
</html>