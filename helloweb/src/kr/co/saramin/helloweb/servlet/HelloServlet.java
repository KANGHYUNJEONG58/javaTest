package kr.co.saramin.helloweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello") // 어노테이션?
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//	post로 넘어오는 파라미터 인코딩
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("n");
		String sCount = request.getParameter("c");
		
		int count = 0;
		if (sCount != null && sCount.matches("-?\\d+(\\.\\d+)?")) {
			count = Integer.parseInt(sCount);	
		}
		
		//	순서가 중요함. header로 적용하려면 print보다 위에 있어야함.
		response.setContentType("text/html; charset=utf-8");	
		PrintWriter out = response.getWriter();
		for (int i = 0; i < count; i++) {
			out.println("<h1>hello world" + name + "</h1>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
