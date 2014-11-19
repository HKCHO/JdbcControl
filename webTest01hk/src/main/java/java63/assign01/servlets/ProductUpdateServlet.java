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

@WebServlet("/product/update")
public class ProductUpdateServlet extends GenericServlet {

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
		
		try {
      Product product = new Product();
      product.setNo(Integer.parseInt(req.getParameter("no")));
      product.setName(req.getParameter("name"));
      product.setQuantity(Integer.parseInt(req.getParameter("qty")));
      product.setMakerNo(Integer.parseInt(req.getParameter("mkno")));
      
      
      productDao.update(product);
      out.println("<html><body><h1>변경하였습니다.</h1></body></html>");
      out.println();
      
    } catch (Exception e) {
      e.printStackTrace();
      out.println("<html><body><h1>서버가 바쁩니다. 잠시 후 다시 시도하세요.</h1></body></html>");
      out.println();
    }
		
	}

}
