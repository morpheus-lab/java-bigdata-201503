<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String noodle = request.getParameter("noodle");
String pie = request.getParameter("pie");
String[] game = request.getParameterValues("game");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>form4 jsp</title>
</head>
<body>

선택한 항목은 다음과 같습니다.<br/>
면류: <%= noodle %><br/>
빵류: <%= pie %><br/>
게임: <%
if (game != null) {
	for (int i = 0; i < game.length; i++) {
		if (i > 0)
			out.print(", ");
		out.print(game[i]);
	}
}
%><br/>

</body>
</html>