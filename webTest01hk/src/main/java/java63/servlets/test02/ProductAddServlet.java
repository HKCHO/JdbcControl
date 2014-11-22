package java63.servlets.test02;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import java63.servlets.test02.dao.ProductDao;
import java63.servlets.test02.domain.Product;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


@WebServlet("/test02/product/add")
public class ProductAddServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
	ProductDao productDao;
	SqlSessionFactory sqlSessionFactory;

	public ProductAddServlet() {
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
		
		/* POST요청처리
		 * => 한글이 깨지는 문제 해결
		 * => 처음 getParameter()를 호출하기전에, request.setCharacterEncoding("UTF-8") 호출하라
		 * 			=> 클라이언트가 보내는 데이터의 문자 집합을 알려줘라!
		 */
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Product product = new Product();
		product.setName(request.getParameter("name"));
		product.setQuantity(Integer.parseInt(request.getParameter("qty")));
		product.setMakerNo(Integer.parseInt(request.getParameter("mkno")));

		productDao.insert(product);

		HttpServletResponse originResponse = (HttpServletResponse)response;
		originResponse.sendRedirect("list");
	}
}
