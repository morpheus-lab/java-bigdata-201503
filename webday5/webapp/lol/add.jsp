<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOL 챔피언 정보 등록</title>
</head>
<body>
	
	<h3>챔피언 정보 등록</h3>
	<hr/>
	
	<form action="addx.jsp" method="post">
	
	<table>
		<tr>
			<td>챔프명</td>
			<td><input type="text" name="name" size="10" /></td>
			<td>타입</td>
			<td><input type="text" name="type" size="10" /></td>
		</tr>
		<tr>
			<td>체력</td>
			<td><input type="text" name="health" size="10" /></td>
			<td>공격력</td>
			<td><input type="text" name="damage" size="10" /></td>
		</tr>
		<tr>
			<td colspan="4" align="center"><input type="submit" value="챔프등록" /></td>
		</tr>
	</table>
	
	</form>
	
</body>
</html>