package webday1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("HELLO-INIT!!");
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("HELLO-DO_GET!!!");
		resp.setContentType("text/html");	// ���� �޽��� ��� �߰�(Content-Type: text/html)
		PrintWriter out = resp.getWriter();	// ���� �޽��� �ٵ� ����ϴ� writer
		out.write("<html>");
		out.write("<body>");
		out.write("I'm Hello Servlet!!");
		out.write("</body>");
		out.println("</html>");
	}
	
	@Override
	public void destroy() {
		System.out.println("HELLO-DESTROY!!!");
	}
	
}
