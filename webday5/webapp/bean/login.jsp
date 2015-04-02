<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="webday5.User"%>
<%@page import="java.io.ObjectInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	String beanId = null;
	String beanPw = null;
	
	// 사용자가 입력한 아이디에 대한 회원정보 파일이 존재?
	
	try {
		FileInputStream fis = new FileInputStream("D:/tmp/" + id + ".user");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		/*
		URL beanFileOnWebServer = new URL("http://www.morpheus.world/object/coffee.user");
		URLConnection conn = beanFileOnWebServer.openConnection();
		ObjectInputStream ois = new ObjectInputStream(conn.getInputStream());
		*/
		User userBean = (User) ois.readObject();
		
		beanId = userBean.getId();
		beanPw = userBean.getPw();
		
		ois.close();
	} catch (IOException e) {
%>
<%--
	<script type="text/javascript">
		alert("회원정보 처리 중 오류가 발생");
	</script>
--%>
<%
	}
	
	// beanId가 null인 경우
	if (beanId == null) {
%>
	<script type="text/javascript">
		alert("회원정보가 없습니다.");
		history.back();
	</script>
<%
	}
	// 로그인 처리
	else if (beanId.equals(id) && beanPw.equals(pw)) {
		session.setAttribute("userId", id);
%>
	로그인 성공<br/><br/>
	<a href="login_form.jsp">로그인 화면으로</a>
<%
	} else if (beanId.equals(id))  {
%>
	<script type="text/javascript">
		alert("패스워드가 틀렸습니다.");
		history.back();
	</script>
<%
	} else {
%>
	<script type="text/javascript">
		alert("아이디가 틀렸습니다.");
		history.back();
	</script>
<%
	}
%>

</body>
</html>