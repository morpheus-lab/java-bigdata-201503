<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String adminID = application.getInitParameter("AdminID");
String adminPW = application.getInitParameter("AdminPW");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키 이용 로그인 처리</title>
</head>
<body>
	
<%
// 사용자가 입력한 아이디/비밀번호와 context-param 값들이 일치하는지?
if (adminID.equals(id) && adminPW.equals(pw)) {
	// 정상 로그인 처리
	session.setAttribute("AdminId", id);
	out.println("로그인 성공!<br/><a href='login_form.jsp'>로그인 페이지로</a><br/>"
				+ "<a href='login_check.jsp'>로그인 체크 페이지로</a>");
	// 쿠키 저장
	String idsave = request.getParameter("idsave");
	if (idsave != null) {
		Cookie cookie = new Cookie("id", id);
		response.addCookie(cookie);
	}
	// 쿠키 삭제
	else {
		Cookie cookie = new Cookie("id", null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
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