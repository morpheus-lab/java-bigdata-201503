<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// web.xml에 설정된 <context-param> 값 불러오기
String adminID = application.getInitParameter("AdminID");
String adminPW = application.getInitParameter("AdminPW");
// 사용자 입력한 아이디/비밀번호 불러오기
String id = request.getParameter("id");
String pw = request.getParameter("pw");

// 아이디 저장 체크박스 체크 여부
String rememberId = request.getParameter("remember_id");
boolean isChecked = false;
if (rememberId != null && rememberId.equals("1")) {
	isChecked = true;
}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 처리</title>
</head>
<body>

<%
// 사용자가 입력한 아이디/비밀번호와 context-param 값들이 일치하는지?
if (adminID.equals(id) && adminPW.equals(pw)) {
	// 정상 로그인 처리
	session.setAttribute("AdminId", id);
	out.println("로그인 성공!<br/><a href='login.html'>로그인 페이지로</a><br/>"
				+ "<a href='login_check.jsp'>로그인 체크 페이지로</a>");
	if (isChecked) {
		Cookie cookie = new Cookie("login-id", id);	// 새로운 쿠키 생성
		response.addCookie(cookie); // response 객체에 쿠키 싣기
	}
} else if (adminID.equals(id)) {
	// 비밀번호가 틀렸다는 메시지를 출력
	out.println("<script type='text/javascript'>alert('비밀번호가 틀렸습니다.');"
				+ "history.back();"
				+ "</script>");
} else {
	// 아이디가 틀린 경우
	out.println("<script type='text/javascript'>alert('아이디가 틀렸습니다.');"
			+ "history.back();"
			+ "</script>");
}
%>


</body>
</html>