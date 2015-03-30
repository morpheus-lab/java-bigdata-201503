<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form 처리</title>
</head>
<body>
입력한 정보입니다.<br/>
ID: <%= request.getParameter("id") %><br/>
비번: <%= request.getParameter("pw") %><br/>
자기소개: <%= request.getParameter("desc") %><br/>
</body>
</html>