<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="jdbc.ConnectionContext"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 요청 파라미터에서 userid 꺼내기
request.setCharacterEncoding("UTF-8");
String userId = request.getParameter("userid");

// DB에서 쿼리
String sql = "SELECT e.id, e.userid, e.last_name, e.first_name, e.salary, e.title, d.name " + 
			 "FROM test01.s_emp e, test01.s_dept d " +
			 "WHERE e.dept_id = d.id " +
			 "  AND e.userid LIKE ? || '%'";

Connection conn = ConnectionContext.getConnection();

PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, userId);

ResultSet rs = pstmt.executeQuery();

// 결과 출력
%>
<%-- JS 배열 시작 --%>
[
<%
int count = 0;
while (rs.next()) {
%>
<%-- JS 객체 시작 --%>
	<%= count++ > 0 ? "," : "" %>
	{
		"id": <%= rs.getLong("id") %>,<%-- JS Number 타입: 따옴표 없이 --%>
		"userId": "<%= rs.getString("userid") %>",<%-- JS string 타입: 따옴표 있이 --%>
		"name": "<%= rs.getString("first_name") %> <%= rs.getString("last_name") %>",
		"title": "<%= rs.getString("title") %>",
		"deptName": "<%= rs.getString("name") %>",
		"salary": <%= rs.getInt("salary") %>
	}
<%-- JS 객체 끝 --%>
<%
}
rs.close();
pstmt.close();
conn.close();
%>
]
<%-- JS 배열 끝 --%>