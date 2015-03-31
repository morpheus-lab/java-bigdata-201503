<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% // application 이 내장한 모듞 속성 이름 얻어오기
	Enumeration enums = application.getAttributeNames();
	String name = null;
	Object value = null;
	int i = 1;
	while (enums.hasMoreElements()) {
		name = (String)enums.nextElement();
		value = application.getAttribute(name); // 각 속성 이름에 대한 값 가져오기
		out.println("<b>application 속성" + i + "</b>: " + name + " = " + value + "<br>");
		i++;
	}
%>
</body>
</html>