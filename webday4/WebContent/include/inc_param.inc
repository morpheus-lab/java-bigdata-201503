<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String param = request.getParameter("name");
	param = URLDecoder.decode(param, "UTF-8");
%>
이름: <%= param %>