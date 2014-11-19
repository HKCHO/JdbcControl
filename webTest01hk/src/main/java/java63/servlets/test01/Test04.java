

package java63.servlets.test01;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


/*
 * Web Browser가 보낸 데이터 꺼내기
 * => request.getParameter("파라미터명")
 * 
 */

@WebServlet("/test01/Test04")
public class Test04 extends GenericServlet {


	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");

		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>안녕하세요! "+ name+"님!!</h1>");
		out.println("</body>");
		out.println("</html>");

	}
}
