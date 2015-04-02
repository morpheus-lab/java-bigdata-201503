<%@page import="java.io.ObjectOutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.util.Date"%>
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
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="user" class="webday5.User" />
<jsp:setProperty name="user" property="*" />
<jsp:setProperty name="user" property="regDate" value="<%= new Date() %>" />

	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>아이디</td>
			<td><jsp:getProperty name="user" property="id" /></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><jsp:getProperty name="user" property="name" /></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><jsp:getProperty name="user" property="email" /></td>
		</tr>
		<tr>
			<td>가입일시</td>
			<td><jsp:getProperty name="user" property="regDate" /></td>
		</tr>
	</table>

<%
// 객체를 파일에 저장
FileOutputStream fos = new FileOutputStream("D:/tmp/" + user.getId() + ".user");
ObjectOutputStream oos = new ObjectOutputStream(fos);
oos.writeObject(user);
oos.close();
%>

</body>
</html>








