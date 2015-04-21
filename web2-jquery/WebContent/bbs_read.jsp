<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.bitacademy.ConnectionContext"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String content = "";
long postId = 0;
try {
	postId = Long.parseLong(request.getParameter("id"));
	
	String sql = "SELECT content FROM posts WHERE id = ?";
	Connection conn = ConnectionContext.getConnection();
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setLong(1, postId);
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()) {
		content = rs.getString(1);
	}
	rs.close();
	pstmt.close();
	
	sql = "UPDATE posts SET cnt = cnt + 1 WHERE id = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setLong(1, postId);
	pstmt.executeUpdate();
	pstmt.close();
		
	conn.close();
} catch (Exception e) {
	
}
%><%= content %>