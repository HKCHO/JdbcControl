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

		productView(req);
		
	}

	private void productView(ServletRequest req) {
		int no = Integer.parseInt(req.getParameter("no"));
		
		Product product = productDao.selectOne(no);

		if (product == null) {
			out.println("<html><body><h1>해당 번호의 제품 정보를 찾을 수 없습니다.</h1></body></html>");
			return;
		}
		
		out.println("<html><body><table border='1'>");
		out.println("<tr><td> 제품번호 </td>  " + "<td> " + no + " </td></tr>");
		out.println("<tr><td> 제품명 </td>  " + "<td> " + product.getName() + " </td></tr>");
		out.println("<tr><td> 재고수량 </td>  " + "<td> " + product.getQuantity() + " </td></tr>");
		out.println("<tr><td> 제조사 번호 </td>  " + "<td> " + product.getMakerNo() + " </td></tr>");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		productDao = new ProductDao(sqlSessionFactory);
	}
}


