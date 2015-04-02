<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="user" class="webday5.User" scope="request" />

<%
user.setId("admin");
user.setName("관리자");
user.setPw("1234");
user.setEmail("admin@java.com");
user.setRegDate(new Date());
%>
<jsp:forward page="useBean.jsp" />