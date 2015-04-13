package web2.ajax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateSalesServlet
 */
public class UpdateSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateSalesServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("GET 요청 수신");
		
		BufferedReader reader = request.getReader();
		int c = 0;
		System.out.print("클라이언트가 보낸 데이터: ");
		while ((c = reader.read()) != -1) {
			System.out.print((char) c);
		}
		System.out.println();
		
		// HTTP 응답 메시지 Body에 데이터를 기록할 수 있는 Writer 객체
		PrintWriter writer = response.getWriter();
		
		// 새로운 판매대수
		int newSalesNum = (int) (Math.random() * 2000);	// 0 ~ 1999
		
		writer.print(newSalesNum + "");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("POST 요청 수신");
		
		BufferedReader reader = request.getReader();
		int c = 0;
		System.out.print("클라이언트가 보낸 데이터: ");
		while ((c = reader.read()) != -1) {
			System.out.print((char) c);
		}
		System.out.println();
		
		// HTTP 응답 메시지 Body에 데이터를 기록할 수 있는 Writer 객체
		PrintWriter writer = response.getWriter();
		
		// 새로운 판매대수
		int newSalesNum = (int) (Math.random() * 2000);	// 0 ~ 1999
		
		writer.print(newSalesNum + "");
		
	}

}
