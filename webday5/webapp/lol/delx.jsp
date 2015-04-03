<%@page import="java.sql.PreparedStatement"%>
<%@page import="jdbc.ConnectionContext"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	long no = Long.parseLong(request.getParameter("no"));

	String sql = "DELETE FROM champ WHERE no=?";
	
	Connection conn = ConnectionContext.getConnection();
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setLong(1, no);
	int count = pstmt.executeUpdate();
	pstmt.close();
	conn.close();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>챔프 정보 삭제 처리</title>
</head>
<body>

	삭제 <%= (count > 0) ? "성공" : "실패" %>!<br/><br/>
	<a href="list.jsp">리스트</a>

</body>
</html>

