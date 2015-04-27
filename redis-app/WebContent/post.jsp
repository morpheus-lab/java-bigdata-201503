<%@page import="com.bitacademy.nosql.redis.twitter.AppControl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
String userId = (String) session.getAttribute("user_id");
String message = request.getParameter("message");

if (userId != null) {
	AppControl.twit(userId, message);
}

response.sendRedirect(request.getContextPath());
%>