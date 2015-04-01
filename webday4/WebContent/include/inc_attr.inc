<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String param = (String) request.getAttribute("name");
%>
이름: <%= param %>