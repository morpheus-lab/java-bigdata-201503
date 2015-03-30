<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String savePath = application.getRealPath("/upload");
int sizeLimit = 5 * 1024 * 1024;

MultipartRequest mr = new MultipartRequest(request, savePath, sizeLimit,
		"UTF-8", new DefaultFileRenamePolicy());

File file = mr.getFile("f");	// "f"라는 이름으로 전송되는 파일 
String fileName = file.getName();
long fileSize = file.length();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
if (fileName == null) {
	// 파일 전송 실패
	out.print("파일 업로드 실패");
} else {
%>
	파일명: <%= fileName %><br/>
	파일크기: <%= fileSize %><br/>
	설명: <%= mr.getParameter("desc") %>
<%
}
%>

</body>
</html>
















