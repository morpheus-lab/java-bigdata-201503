<%@page import="java.util.function.Consumer"%>
<%@page import="com.bitacademy.nosql.redis.twitter.AppControl"%>
<%@page import="com.bitacademy.nosql.redis.twitter.Post"%>
<%@page import="java.util.List"%>
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

String paramUserId = request.getParameter("userId");
%>
	<div id="page_title">
		<%= paramUserId == null ?
				"" : AppControl.getUsername(paramUserId) + "님의 트위터" %>
<%
// 로그인 상태 확인
if (session.getAttribute("user_id") != null) {
	// "{USER_ID}:following"이라는 키의
	// Set 데이터에 상대방 user_id가 존재하는 지 여부 확인
	// 존재한다면 "Following" 출력
	// 그렇지 않다면 "Follow" 링크 출력
	String myUserId = (String) session.getAttribute("user_id");
	
	if (paramUserId != null && !paramUserId.trim().equals("")
			&& !myUserId.equals(paramUserId)	// 자기 자신을 팔로잉 할 수 없음
		) {
%>
		<span id="follow">
<%
		if (!AppControl.isFollowing(myUserId, paramUserId)) {
			// 팔로우 가능
%>
			<a href="follow.jsp?userId=<%= paramUserId %>">Follow</a>
<%
		} else {
			// 이미 팔로우하고 있는 상태
%>
			Following
<%
		}
%>
		</span>
<%
	}
}
%>
	</div>

<%
List<Post> posts = null;

if (paramUserId != null && !paramUserId.trim().equals("")) {
	posts = AppControl.getTimeline(paramUserId, 0, 9);
} else {
	if (session.getAttribute("user_id") != null) {
		// 로그인 상태
		posts = AppControl.getTimeline(
				(String) session.getAttribute("user_id"), 0, 9);
	} else {
		// 로그아웃 상태
		posts = AppControl.getTimeline(0, 9);
	}
}

if (posts != null) {
	for (int i = 0; i < posts.size(); i++) {
		Post p = posts.get(i);	
%>
	<div>
		<div class="timeline_user">
			<!-- 글쓴이 userName -->
			<a href="?userId=<%= p.getWriterUserId() %>"><%= p.getWriterUserName() %></a>
		</div>
		<div class="timeline_body"><!-- 글 내용 --><%= p.getMessage() %></div>
		<div style="clear: left;"></div>
		<div class="timeline_date"><!-- 글 쓴 날짜 --><%= p.getWriteDateTime() %></div>
	</div>
<%
	}
}
%>
</body>
</html>





























