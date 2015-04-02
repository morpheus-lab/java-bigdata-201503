<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="user" class="webday5.User" />
<%--
<jsp:setProperty name="user" property="*" />
--%>
<jsp:setProperty name="user" property="id" param="id" />
<%
	// user.setId(request.getParameter("id"));
%>
<jsp:setProperty name="user" property="name" param="name" />
<%
	// user.setName(request.getParameter("name"));
%>
자바빈 처리 완료<br/>
아이디 : <%= user.getId() %>, 이름 : <%= user.getName() %>

</body>
</html>