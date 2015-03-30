<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form2 jsp</title>
</head>
<body>
당신의 관심제품은 <br/>
<%
String[] chks = request.getParameterValues("chk");
for(int i=0; i<chks.length; i++) {
out.println("<b>"+chks[i]+"</b>,");
}
%> 이고, <br/>
요금제는 <b><%= request.getParameter("rate") %></b>를 선택하셨습니다.
</body>
</html>