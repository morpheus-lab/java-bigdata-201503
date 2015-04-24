<%@page import="com.bitacademy.nosql.redis.twitter.AuthUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String userId = (String) session.getAttribute("user_id");
AuthUtil.logout(userId, request, response);

response.sendRedirect(request.getContextPath());
%>