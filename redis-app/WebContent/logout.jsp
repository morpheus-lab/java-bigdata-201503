<%@page import="com.bitacademy.nosql.redis.twitter.AppControl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = (String) session.getAttribute("user_id");
AppControl.logout(userId, request, response);

response.sendRedirect(request.getContextPath());
%>