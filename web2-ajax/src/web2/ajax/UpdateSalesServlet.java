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
		
		System.out.println("GET ��û ����");
		
		BufferedReader reader = request.getReader();
		int c = 0;
		System.out.print("Ŭ���̾�Ʈ�� ���� ������: ");
		while ((c = reader.read()) != -1) {
			System.out.print((char) c);
		}
		System.out.println();
		
		// HTTP ���� �޽��� Body�� �����͸� ����� �� �ִ� Writer ��ü
		PrintWriter writer = response.getWriter();
		
		// ���ο� �ǸŴ��
		int newSalesNum = (int) (Math.random() * 2000);	// 0 ~ 1999
		
		writer.print(newSalesNum + "");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("POST ��û ����");
		
		BufferedReader reader = request.getReader();
		int c = 0;
		System.out.print("Ŭ���̾�Ʈ�� ���� ������: ");
		while ((c = reader.read()) != -1) {
			System.out.print((char) c);
		}
		System.out.println();
		
		// HTTP ���� �޽��� Body�� �����͸� ����� �� �ִ� Writer ��ü
		PrintWriter writer = response.getWriter();
		
		// ���ο� �ǸŴ��
		int newSalesNum = (int) (Math.random() * 2000);	// 0 ~ 1999
		
		writer.print(newSalesNum + "");
		
	}

}
