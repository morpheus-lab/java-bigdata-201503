<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="jdbc.ConnectionContext"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<td>이름</td>
			<td>타입</td>
			<td>체력</td>
			<td>공격력</td>
			<td>등록일</td>
			<td>관리</td>
		</tr>
		<%
			// 챔피언 목록 표시
			String sql = "SELECT * FROM champ ORDER BY no DESC";
			Connection conn = ConnectionContext.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			// ResultSet 메타데이터 조회
//			ResultSetMetaData meta = rs.getMetaData();
			
			while (rs.next()) {
		%>
		<tr>
			<td><%= rs.getString("name") %></td>
			<td><%= rs.getString("type") %></td>
			<td><%= rs.getString("health") %></td>
			<td><%= rs.getString("damage") %></td>
			<td><%= rs.getDate("regdate") %></td>
			<td><a href="edit.jsp?no=<%= rs.getLong("no") %>">수정</a> /
				<a href="delx.jsp?no=<%= rs.getLong("no") %>"
					onclick="return confirm('<%= rs.getString("name") %> 데이터를 삭제하시겠습니까?');">삭제</a>
			</td>
		</tr>
		<%
			}
			rs.close();
			stmt.close();
			conn.close();	// DB 연결 종료
		%>
	</table>
	<a href="add.jsp">신규등록</a>
	
	<br/><br/>
	
	<script type="text/javascript">
		function btnClickHandler() {
			alert("이번엔 자바스크립트 함수에 의해 처리되었습니다.");
		}
	</script>
	
	<input type="button" value="클릭" onclick="alert('클릭했군요!'); btnClickHandler(); return false;" />
	
</body>
</html>