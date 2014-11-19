package java63.assign01.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import java63.assign01.dao.ProductDao;
import java63.assign01.domain.Product;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@WebServlet("/product/view")
public class ProductViewServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();

		ProductDao productDao;

		String  resource = "java63/assign01/dao/mybatis-config.xml";

		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		productDao = new ProductDao();
		productDao.setSqlSessionFactory(sqlSessionFactory);

		int no = Integer.parseInt(req.getParameter("no"));
		
		Product product = productDao.selectOne(no);

		if (product == null) {
			out.println("해당 번호의 제품 정보를 찾을 수 없습니다.");
			out.println();
			return;
		}
		
		out.println("<html><body><table border='1'>");
		out.println("<tr><td> 제품번호 </td>  " + "<td> " + no + " </td></tr>");
		out.println("<tr><td> 제품명 </td>  " + "<td> " + product.getName() + " </td></tr>");
		out.println("<tr><td> 재고수량 </td>  " + "<td> " + product.getQuantity() + " </td></tr>");
		out.println("<tr><td> 제조사 번호 </td>  " + "<td> " + product.getMakerNo() + " </td></tr>");
		out.println("</table></body></html>");
		out.println();
	}

}


