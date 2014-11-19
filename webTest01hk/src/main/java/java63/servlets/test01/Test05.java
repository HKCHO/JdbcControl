

package java63.servlets.test01;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


/*
 * 요청 파라미터 값 다루기
 * => 웹 브라우저가 전송한 데이터
 */

@WebServlet("/test01/Test05")
public class Test05 extends GenericServlet {


	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		
		int a = Integer.parseInt(request.getParameter("a"));
		String op = request.getParameter("op");
		int b = Integer.parseInt(request.getParameter("b"));

		int result = 0;
		
		switch(op){
			case "+": result = a + b; op = "\\+" ; break;
			case "-": result = a - b; break;
			case "*": result = a * b; break;
			case "/": result = a * b; break;
		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<p>" + a + " " + op + " " +  b + " = " + result + "</p>");
		out.println("</body>");
		out.println("</html>");

	}
}
