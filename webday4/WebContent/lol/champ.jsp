<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>챔피언 정보</title>
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
				챔피언을 선택하십시오.
				<table border="0" cellpadding="2" bgcolor="#003366">
					<tr align="center">
						<td><img src="./images/champ/Graves.jpg" width="64" /></td>
						<td><img src="./images/champ/Rumble.jpg" width="64" /></td>
						<td><img src="./images/champ/Leona.jpg" width="64" /></td>
						<td><img src="./images/champ/Malphite.jpg" width="64" /></td>
						<td><img src="./images/champ/Blitzcrank.jpg" width="64" /></td>
					</tr>
					<tr align="center" style="color: #ffffff;">
						<td>그레이브즈</td>
						<td>럼블</td>
						<td>레오나</td>
						<td>말파이트</td>
						<td>블리츠크랭</td>
					</tr>
				</table>
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