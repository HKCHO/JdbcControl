

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
 * 
 * GET으로 전달되는 데이터
 * => tomcat8(자동처리)
 * => tomcat7 하위버전 : server.xml 파일을 편집해야한다. 
 * 		 --server.xml 파일 connector 태그에 URIEncoding속성 추가
 * 
 *     ex) <Connenctor connectionTimeout= .....     .... redirectPort="8443"  URIEncoding="UTF-8"/>
 * 
 * POST로 전달되는 데이터
 * => tomcat8(?)
 * => tomcat7 하위버젼 : 
 *   1) request.setCharacterEncoding("UTF-8");
 *   2) 1번을 먼저 호출한 다음에 getParameter()를 호출해야한다.
 *   3) 무조건 getParameter()를 호출하기 전에 1번을 수행해야한다.
 *   		단, 한번이라도 getParameter()가 호출된 다으멩 1번을 수행하면
 *   		아무런 효과가 없다.
 */

@WebServlet("/test01/Test04")
public class Test04 extends GenericServlet {


	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		System.out.println(name.length());

		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>안녕하세요! "+ name+"님!!</h1>");
		out.println("</body>");
		out.println("</html>");

	}
}
