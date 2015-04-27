<%@page import="com.bitacademy.nosql.redis.twitter.AppControl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 현재 로그인 사용자 아이디
	String userId = (String) session.getAttribute("user_id");
	// 팔로우 대상 사용자 아이디
	String followeeUserId = request.getParameter("userId");
	if (userId != null && followeeUserId != null) {
		// 팔로우 처리
		AppControl.follow(userId, followeeUserId);
	}
	
	response.sendRedirect(request.getContextPath());
%>