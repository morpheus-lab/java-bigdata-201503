<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.bitacademy.bbs.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page import="com.bitacademy.ConnectionContext"%>
<%@ page import="java.sql.Connection"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int pageNum = 1;
try {
	pageNum = Integer.parseInt(request.getParameter("pageNum"));
} catch (Exception e) {}
int pageSize = 10;
try {
	pageSize = Integer.parseInt(request.getParameter("pageSize"));
} catch (Exception e) {}

String sql =	"SELECT * " +
				"FROM ( " +
				"  SELECT rownum rn, " +
				"         A.* " +
				"  FROM (SELECT * FROM posts ORDER BY id DESC) A " +
				") " +
				"WHERE rn > (? - 1) * ? AND rn < ? * ? + 1";

Connection conn = ConnectionContext.getConnection();

PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, pageNum);
pstmt.setInt(2, pageSize);
pstmt.setInt(3, pageSize);
pstmt.setInt(4, pageNum);

ArrayList<Board> bList = new ArrayList<Board>();

ResultSet rs = pstmt.executeQuery();
while (rs.next()) {
	Board board = new Board();
	board.setId(rs.getLong("id"));
	board.setSubject(rs.getString("subject"));
	board.setWriter(rs.getString("writer"));
	board.setWriteDate(rs.getString("wrtDtm"));
	board.setCnt(rs.getInt("cnt"));
	
	bList.add(board);
}
rs.close();
pstmt.close();

// 전체 페이지 수 조회
long totalPosts = 0;
sql = "SELECT COUNT(*) FROM posts";
pstmt = conn.prepareStatement(sql);
rs = pstmt.executeQuery();
if (rs.next()) {
	totalPosts = rs.getLong(1);
}
int totalPages = (int) Math.ceil((double) totalPosts / pageSize);

rs.close();
pstmt.close();
conn.close();

// bList 객체 => JSON
Gson gson = new GsonBuilder().create();
%>
{
  "list": <%= gson.toJson(bList) %>,
  "totalPages": <%= totalPages %>,
  "currPage": <%= pageNum %>,
  "pageSize": <%= pageSize %>
}