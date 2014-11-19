package java63.assign01.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/help")
public class HelpServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		out.println("<html><body><h1>명령어 모음</h1><br/>"
				+ "<hr>"
				+ "<p>no : 제품번호, name : 이름, qty : 수량, mkno : 제조사 번호</p>"
				+ "<table border='1'>"
				+ "<tr>"
				+ "<td>명령</td><td>내용</td></tr>"
				+ "<tr><td>  /product/add  </td><td>  제품등록(파라미터) : name, qty, mkno</td></tr>"
				+ "<tr><td>  /product/list  </td><td>  제품조회(파라미터) : pageNo, pageSize</td></tr>"
				+ "<tr><td>  /product/delete  </td><td>  제품삭제(파라미터) : no</td></tr>"
				+ "<tr><td>  /product/update  </td><td>  내용변경(파라미터) : no, name, qty, mkno  </td></tr>"
				+ "<tr><td>  /product/view  </td><td>  상세조회(파라미터) : no</td></tr>"
				+ "</body></html>");
	}

}
