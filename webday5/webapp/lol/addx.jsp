<%@page import="java.sql.PreparedStatement"%>
<%@page import="jdbc.ConnectionContext"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 전송 문자셋을 UTF-8로 설정
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="champ" class="webday5.Champ" />
<jsp:setProperty name="champ" property="*" />
<%
	// DB 작업
	String sql = "INSERT INTO champ VALUES (seq_champ.NEXTVAL, ?, ?, ?, ?, SYSDATE)";
	Connection conn = ConnectionContext.getConnection();	// DB 연결 객체
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, champ.getName());
	pstmt.setString(2, champ.getType());
	pstmt.setInt(3, champ.getHealth());
	pstmt.setInt(4, champ.getDamage());
	
	int count = pstmt.executeUpdate();
	
	pstmt.close();
	conn.close();	// 커넥션 풀에 커넥션 반납
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOL 챔피언 정보 등록 처리</title>
</head>
<body>

<%
	if (count > 0) {
%>
		챔피언 정보가 성공적으로 등록되었습니다.<br/><br/>
<%
	} else {
%>
		챔피언 정보 등록에 실패하였습니다.<br/><br/>
<%
	}
%>

<a href="list.jsp">목록</a><br/>
<a href="add.jsp">신규등록</a><br/><br/>

count = <%= count %>

</body>
</html>