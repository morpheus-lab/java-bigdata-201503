<%@page import="java.sql.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="jdbc.ConnectionContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String user = null;
	Date now = null;	// java.sql.Date
	
	String sql = "SELECT user, sysdate now FROM dual";
	Connection conn = ConnectionContext.getConnection();	// DB 연결 얻기
	if (conn != null) {
		PreparedStatement pstmt = conn.prepareStatement(sql);	// 쿼리문 실행 준비
		ResultSet rs = pstmt.executeQuery();	// 쿼리 실행 및 결과 반환
		if (rs.next()) {
			user = rs.getString("user");
			now = rs.getDate("now");
		}
		rs.close();
		pstmt.close();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	Oracle USER: <%= user %><br/>
	NOW: <%= now %>

</body>
</html>