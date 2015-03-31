<%@page pageEncoding="UTF-8" %>
<%@page import="java.io.*"%>
<%
	response.setContentType("image/jpeg");
	response.setHeader("Content-Transfer-Encoding", "binary");
	
	String filename = application.getRealPath("/") + "images/ashe.jpg";
	
	try {
		File file = new File(filename);
		response.setHeader("Content-Length", Long.toString(file.length()));
		
		FileInputStream fis = new FileInputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		
		byte[] buf = new byte[1024];
		for (int i = 0; (i = fis.read(buf)) != -1;) {
			bos.write(buf, 0, i);
		}
	//	int i = 0;
	//	while ((i = fis.read(buf)) != -1) {
	//		bos.write(buf, 0, i);
	//	}
		bos.flush();
	} catch (IOException e) {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html; charset=UTF-8");
%>
<html>
<body>
파일 처리 중 에러가 발생하였습니다.<br/><br/>
<%= e.getMessage() %>
</body>
</html>
<%
	}
%>