<%-- bbs_write.jsp --%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.bitacademy.ConnectionContext"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

// 제목, 글쓴이, 내용
String subject = request.getParameter("subject");
String writer = request.getParameter("writer");
String content = request.getParameter("content");

// INSERT SQL 구문
String sql = "INSERT INTO posts VALUES(seq_posts.nextval, ?, ?, ?, sysdate, 0)";
// DB 커넥션
Connection conn = ConnectionContext.getConnection();
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, subject);
pstmt.setString(2, writer);
pstmt.setString(3, content);
// 쿼리 실행
int result = pstmt.executeUpdate();
// 결과

// 자원 정리
pstmt.close();
conn.close();
%>
