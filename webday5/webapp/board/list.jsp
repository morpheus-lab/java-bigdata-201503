<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="jdbc.ConnectionContext"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
<%
	// 총 글 수
	int totalPosts = 0;
	String sql = "SELECT COUNT(*) FROM posts";
	Connection conn = ConnectionContext.getConnection();
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	if (rs.next()) {
		totalPosts = rs.getInt(1);	// 조회된 첫 번째 컬럼 값을 가져옴
	}
	stmt.close();
	rs.close();
%>
<%
	// 페이지 사이즈
	// 페이지 번호
	int pageSize = 0;
	int pageNum = 0;
	
	// list.jsp?pageSize=aaa&pageNum=-1
	
	String paramPageSize = request.getParameter("pageSize");
	String paramPageNum = request.getParameter("pageNum");
	try {
		pageSize = Integer.parseInt(paramPageSize);
	} catch (Exception e) {
	} finally {
		if (pageSize < 1) pageSize = 10;
	}
	try {
		pageNum = Integer.parseInt(paramPageNum);
	} catch (Exception e) {
	} finally {
		if (pageNum < 1) pageNum = 1;
	}
	
	// SQL 쿼리
	sql = "SELECT *" +
			"FROM (" +
			"  SELECT rownum rn," +
			"         A.*" +
			"  FROM (SELECT * FROM posts ORDER BY id DESC) A" +
			")" +
			"WHERE rn > (? - 1) * ? AND rn < ? * ? + 1";
	// 쿼리 구문 준비
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, pageNum);
	pstmt.setInt(2, pageSize);
	pstmt.setInt(3, pageSize);
	pstmt.setInt(4, pageNum);
	// 쿼리 실행
	rs = pstmt.executeQuery();
	while (rs.next()) {
%>
		<%= rs.getLong("id") %> -
		<%= rs.getString("subject") %> -
		<%= rs.getString("writer") %> -
		<%= rs.getDate("wrtdtm") %> -
		<%= rs.getInt("cnt") %>
		<br/>
<%
	}
	rs.close();
	pstmt.close();
	conn.close();
%>

<%-- 페이지 내비게이션 --%>
<%
	if (pageNum > 1) {
%>
	<a href="list.jsp?pageSize=<%= pageSize %>&pageNum=<%= pageNum - 1 %>">◀이전</a>
<%
	}
%>

<%
	// 총 페이지 수
	int totalPages = (int) Math.ceil((double) totalPosts / pageSize);
	for (int p = 1; p <= totalPages; p ++) {
		if (p == pageNum) {
%>
			<%= p %>
<%
		} else {
%>
		<a href="list.jsp?pageSize=<%= pageSize %>&pageNum=<%= p %>"><%= p %></a>
<%
		}
	}
	
	if (pageNum < totalPages) {
%>
	<a href="list.jsp?pageSize=<%= pageSize %>&pageNum=<%= pageNum + 1 %>">다음▶</a>
<%
	}
%>
</body>
</html>





























