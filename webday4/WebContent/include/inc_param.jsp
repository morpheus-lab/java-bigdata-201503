<%@page import="java.net.URLEncoder"%>
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
	String p = URLEncoder.encode("우르곳", "UTF-8");
	//String p = "우르곳";
%>
<jsp:include page="inc_param.inc" flush="false">
	<jsp:param name="name" value="<%= p %>" />
</jsp:include>

</body>
</html>