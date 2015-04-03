<%-- post.jsp : 새 글 쓰기 입력 폼 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>새 글 쓰기</title>
</head>
<body>

	<form action="write.jsp" method="post" enctype="multipart/form-data">

	<table border="0" cellspacing="1" cellpadding="3" bgcolor="#ff0000">
		<tr bgcolor="#ffffff">
			<td>제목</td>
			<td><input type="text" name="subject" /></td>
		</tr>
		<tr bgcolor="#ffffff">
			<td>글쓴이</td>
			<td><input type="text" name="writer" /></td>
		</tr>
		<tr bgcolor="#ffffff">
			<td>내용</td>
			<td><textarea name="content" rows="8" cols="24"></textarea></td>
		</tr>
		<tr bgcolor="#ffffff">
			<td>첨부파일1</td>
			<td><input type="file" name="attach1" /></td>
		</tr>
		<tr bgcolor="#ffffff">
			<td>첨부파일2</td>
			<td><input type="file" name="attach2" /></td>
		</tr>
		<tr bgcolor="#ffffff">
			<td colspan="2" align="center">
				<input type="submit" value="저장" />
				<input type="reset" value="초기화" />
				<input type="button" value="취소" onclick="history.back();" />
			</td>
		</tr>
	</table>

	</form>

</body>
</html>