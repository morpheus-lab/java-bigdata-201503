<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>모듈화</title>
</head>
<body>
	
	<table border="1" cellpadding="5" align="center" width="600"><!-- align: 수평방향 정렬(left, center, right) -->
		<tr>
			<td colspan="2">
				<jsp:include page="include/top.jsp" flush="false" />
			</td>
		</tr>
		<tr>
			<td valign="top"><!-- valign: 수직방향 정렬 (top, middle, bottom, baseline) -->
				<jsp:include page="include/menu.jsp" flush="false" />
			</td>
			<td width="80%" valign="middle">
				소환사의 계곡에 오신 것을 환영합니다.<br/>
				<img alt="LOL Logo" title="League of Legends" src="images/lol_logo.png" width="200" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<jsp:include page="include/bottom.jsp" flush="false" />
			</td>
		</tr>
	</table>
	
</body>
</html>