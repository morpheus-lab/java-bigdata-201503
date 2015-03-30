<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

단순 문자열 출력: <%= "<b>심플 스트링</b>" %>
<hr />
<%
	int i = 0;
	java.util.Calendar cal = java.util.Calendar.getInstance();
%>
변수 값 출력: <%= i %>
<hr />
수식 값 (1 ~ 10 까지 합): <%= 1+2+3+4+5+6+7+8+9+10 %>
<hr />
메소드 리턴 값 출력: <%= cal.getTime() %>
<hr/>
변수 i를 활용한 문자열과 연산의 결합: <%= "i + 10=" + (i + 10) %>

</body>
</html>