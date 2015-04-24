<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>트위터 비슷한 앱</title>
	<link type="text/css" rel="stylesheet" href="main.css">
</head>
<body>

	<h2><a href="<%= request.getContextPath() %>/" style="text-decoration: none;">트위터</a></h2>
	
	<div class="msg"></div>
	
	<div class="info">
<%
// 로그인 상태
if (session.getAttribute("user_id") != null) {
%>
방가방가, <%= session.getAttribute("username") %>님. | <a href="logout.jsp">로그아웃</a>
<%
}
// 로그아웃 상태
else {
%>
<form action="login.jsp" method="post">
	아 이 디: <input type="text" name="userName"><br>
	비밀번호: <input type="password" name="userPw"><br>
	<input type="submit" value="로그인">
	<input type="button" value="회원가입" onclick="location.href='signup.jsp'">
</form>
<%
}
%>
	</div>
	
	<form action="" method="post">
		<span style="padding-right: 3px">one word</span>
	</form>
	
	<div id="page_title">
		<span id="follow"></span>
	</div>

	<div class="timeline_user"></div>
	<div class="timeline_body"></div>
	<div style="clear: left;"></div>
	<div class="timeline_date"></div>

</body>
</html>





























