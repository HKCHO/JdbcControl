package java63.assign01.servlets;

import java.io.IOException;
import java.io.InputStream;
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

@WebServlet("/product/list")
public class ProductListServlet extends GenericServlet {

	PrintWriter out;
	String resource;
	InputStream inputStream;
	SqlSessionFactory sqlSessionFactory;
	ProductDao productDao;

	@Override
	public void init() throws ServletException {
		prepareProductDao();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

		encodeResponse(res);

		productList(req);

	}

	private void productList(ServletRequest req) {
		int pageNo = 0;
		int pageSize = 0;

		if (req.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(req.getParameter("pageNo"));
			pageSize = 3;
		}

		if (req.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(req.getParameter("pageSize"));
		}

		out.println("<html><body><h1>제품 리스트를 조회합니다.</h1><br/>");
		out.println("<hr>");
		out.println("<table border ='1'><tr><td>제품번호</td><td>제품이름</td><td>제품수량</td><td>제품번호</td></tr>");

		for (Product product : productDao.selectList(pageNo, pageSize)) {
			out.println("<tr><td>" + product.getNo() + "</td>"
					+ 			"<td>" + product.getName() + "</td>"
					+				"<td>" + product.getQuantity() + "</td>"
					+				"<td>" + product.getMakerNo() + "</td></tr>");
		}

		out.println("</table></body></html>");
	}

	private void encodeResponse(ServletResponse res) throws IOException {

		res.setContentType("text/html;charset=UTF-8");
		out = res.getWriter();

	}

	private void prepareProductDao() {

		resource = "java63/assign01/dao/mybatis-config.xml";

		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		productDao = new ProductDao(sqlSessionFactory);
	}

}
