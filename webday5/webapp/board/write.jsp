<%-- write.jsp : 새 글 쓰기 DB 작업 처리 페이지 --%>
<%@page import="java.io.File"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="jdbc.ConnectionContext"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String savePath = "D:/tmp/attach";
	int sizeLimit = 10 * 1024 * 1024;

	MultipartRequest mr = new MultipartRequest(request, savePath, sizeLimit,
		"UTF-8", new DefaultFileRenamePolicy());
//	request.setCharacterEncoding("UTF-8");

	// 넘어온 파라미터 수신
	String subject = mr.getParameter("subject");
	String writer = mr.getParameter("writer");
	String content = mr.getParameter("content");
	
	// DB 연결
	Connection conn = ConnectionContext.getConnection();
	conn.setAutoCommit(false);
	
	PreparedStatement pstmt = null;
	
	try {
		Long postId = null;
		// 시퀀스로부터 posts.id로 사용할 값 생성
		ResultSet rs = conn.createStatement().executeQuery("SELECT seq_posts.NEXTVAL FROM dual");
		if (rs.next()) {
			postId = rs.getLong(1);
		}
		
		/**** posts 테이블 INSERT ****/
		// SQL 쿼리문 작성
		String sqlInsertPosts = "INSERT INTO posts VALUES (?, ?, ?, ?, SYSDATE, 0)";
		// 쿼리문 실행 준비
		pstmt = conn.prepareStatement(sqlInsertPosts);
		pstmt.setLong(1, postId);
		pstmt.setString(2, subject);
		pstmt.setString(3, writer);
		pstmt.setString(4, content);
		// 쿼리문 실행
		int count = pstmt.executeUpdate();
		
		/**** attach 테이블 INSERT ****/
		File attach1 = mr.getFile("attach1");
		if (attach1 != null) {
			// attach INSERT
		}
		
		File attach2 = mr.getFile("attach2");
		if (attach2 != null) {
			// attach INSERT
		}
		
		// 모두 정상 처리된 경우, 커밋
		conn.commit();
		
	} catch (Exception e) {
		// 예외 발생한 경우, 롤백
		conn.rollback();
	} finally {
		// 리소스 정리
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>새 글 쓰기 처리 페이지</title>
</head>
<body>

<%
	// 성공?
			
	// 실패?
	
%>

</body>
</html>