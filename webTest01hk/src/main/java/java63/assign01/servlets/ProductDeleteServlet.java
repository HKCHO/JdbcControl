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

@WebServlet("/product/delete")
public class ProductDeleteServlet extends GenericServlet{

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
		
		productDelete(req);
		
	}

	private void productDelete(ServletRequest req) {
		int no = Integer.parseInt(req.getParameter("no"));
		
		Product product = productDao.selectOne(no);
    if (product == null) {
      out.println("해당 번호의 제품 정보를 찾을 수 없습니다.");
      return;
    }
    out.println("<html><body><h1>" + product.getName() + "(을)를 삭제하였습니다.</h1></body></html>");
    productDao.delete(no);
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
