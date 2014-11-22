package java63.servlets.test02;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java63.servlets.test02.dao.ProductDao;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/*
 * Refresh 하기
 * => <meta> 태그에 refresh 넣기
 * 
 */

//@WebServlet("/test02/product/delete")
public class ProductDeleteServlet03 extends GenericServlet {
	private static final long serialVersionUID = 1L;
	ProductDao productDao;
	SqlSessionFactory sqlSessionFactory;

	public ProductDeleteServlet03() {
		try {
			String resource = "java63/servlets/test02/dao/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(inputStream);

			productDao = new ProductDao();
			productDao.setSqlSessionFactory(sqlSessionFactory);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));

		productDao.delete(no);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv='Refresh' content='5; url=list'>"); //메타 태그에 리프레쉬 넣기
		out.println("<link rel='stylesheet' href='../../css/bootstrap.min.css'>");
		out.println("<link rel='stylesheet' href='../../css/bootstrap-theme.min.css'>");
		out.println("<link rel='stylesheet' href='../../css/common.css'>");
		
		out.println("</head>");

		out.println("<body>");
		out.println("<div class='container'>");
		out.println("<h1>삭제결과</h1><hr>");
		out.println("<p>삭제되었습니다.</p>");
		out.println("</div>");
		
		out.println("</body>");
		out.println("</html>");
	}
}
