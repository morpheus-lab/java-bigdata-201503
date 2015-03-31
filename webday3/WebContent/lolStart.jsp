<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!	// 선언부

	String sGold;	// 멤버 변수
	int gold;	// 멤버 변수
	
	public void jspInit() {
		System.out.println("jspInit() 호출");
		ServletConfig myConfig = getServletConfig();
		sGold = myConfig.getInitParameter("시작골드");
		gold = Integer.parseInt(sGold);
	}
	
	public void jspDestroy() {
		System.out.println("jspDestroy() 호출");
		gold = Integer.parseInt(sGold);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOL Start (lolStart.jsp)</title>
</head>
<body>

현재 골드: <%= gold %>
<%
	gold += 10;
%>

</body>
</html>