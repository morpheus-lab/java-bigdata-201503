<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>에러 페이지</title>
</head>
<body>

<h3>나눗셈 연산 중 에러가 발생했습니다.</h3>
<hr/>
입력값을 다시 검토해 보십시오.<br/><br/>

<%= exception.getMessage() %>

</body>
</html>