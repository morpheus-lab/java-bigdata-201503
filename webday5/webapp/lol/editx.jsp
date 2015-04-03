<%@page import="java.sql.PreparedStatement"%>
<%@page import="jdbc.ConnectionContext"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="champ" class="webday5.Champ" />
<jsp:setProperty name="champ" property="*" />
<%
//	String name = request.getParameter("name");
//	String type = request.getParameter("type");
//	int health = Integer.parseInt(request.getParameter("health"));
//	int damage = Integer.parseInt(request.getParameter("damage"));
//	long no = Long.parseLong(request.getParameter("no"));
	
	String sql = "UPDATE champ SET name=?, type=?, health=?, damage=? WHERE no=?";
	
	// DB 연결 객체 얻기
	Connection conn = ConnectionContext.getConnection();
//	conn.setAutoCommit(false);
//	conn.commit();
//	conn.rollback();
//	conn.setSavepoint("SAVEPOINT_A");
	// 쿼리문 준비
	PreparedStatement pstmt = conn.prepareStatement(sql);
//	pstmt.setString(1, name);
//	pstmt.setString(2, type);
//	pstmt.setInt(3, health);
//	pstmt.setInt(4, damage);
//	pstmt.setLong(5, no);
	pstmt.setString(1, champ.getName());
	pstmt.setString(2, champ.getType());
	pstmt.setInt(3, champ.getHealth());
	pstmt.setInt(4, champ.getDamage());
	pstmt.setLong(5, champ.getNo());
	// 쿼리문 실행
	int count = pstmt.executeUpdate();
	// 리소스 정리
	pstmt.close();
	conn.close();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>챔피언 정보 수정 처리</title>
</head>
<body>
	
<%
	if (count > 0) {	// 업데이트 성공
%>
		챔피언 정보 업데이트에 성공하였습니다.
<%
	} else {	// 업데이트 실패
%>
		챔피언 정보 업데이트에 실패하였습니다.
<%
	}
%>
	
	<br/><br/>
	
	<a href="list.jsp">리스트</a>
	
</body>
</html>



















