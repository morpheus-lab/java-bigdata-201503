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
	
<%-- 로그인 된 상태에서만 트윗 등록할 수 있도록 작성 --%>
<%
if (session.getAttribute("user_id") != null) {
%>
	<form id="" action="post.jsp" method="post">
		<textarea name="message" rows="3" cols="30" style="width: 200px; height: 40px;"></textarea>
		<input type="submit" value="트윗" style="height: 40px; ">
	</form>
<%
}
%>

	<div id="page_title">
		<span id="follow">
<%
// 로그인 상태 확인
if (session.getAttribute("user_id") != null) {
	// "{USER_ID}:following"이라는 키의
	// Set 데이터에 상대방 user_id가 존재하는 지 여부 확인
	// 존재한다면 "Following" 출력
	// 그렇지 않다면 "Follow" 링크 출력
%>
		<!--
			이미 팔로우한 경우		=> "Following"
			팔로우하지 않은 경우	=> "Follow" 링크 출력
		-->
<%
}
%>
		</span>
	</div>

<%
%>
	<div>
		<div class="timeline_user"><!-- 글쓴이 userName --></div>
		<div class="timeline_body"><!-- 글 내용 --></div>
		<div style="clear: left;"></div>
		<div class="timeline_date"><!-- 글 쓴 날짜 --></div>
	</div>
<%
%>
</body>
</html>





























