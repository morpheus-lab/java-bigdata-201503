<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--<form action="reg.jsp" method="post">-->
	<form action="reg2.jsp" method="post">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" size="15"></td>
				<td>비밀번호</td>
				<td><input type="password" name="pw" size="10"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td colspan="3"><input type="text" name="name" size="15"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td colspan="3"><input type="text" name="email" size="30"></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="회원가입 ">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>