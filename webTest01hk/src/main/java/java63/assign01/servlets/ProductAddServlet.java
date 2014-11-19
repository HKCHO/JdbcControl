package java63.assign01.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import java63.assign01.dao.ProductDao;
import java63.assign01.domain.Product;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/product/add")
public class ProductAddServlet extends GenericServlet {
	ProductDao productDao;
	

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

		
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		String name = req.getParameter("name");
		int qty = Integer.parseInt(req.getParameter("qty"));
		int mkno = Integer.parseInt(req.getParameter("mkno"));
		
		try {
			Product product = new Product();
			product.setName(name);
			product.setQuantity(qty);
			product.setMakerNo(mkno);
			
			productDao.insert(product);
			out.println("<html><body><h1> 제품명 : "
					+ name +", 재고수량 : " + qty + ", 제조사 번호 : " + mkno + " " + "  <= 저장되었습니다. </h1></body></html>");
		
		} catch (Exception e) {
			e.printStackTrace();
			out.println("<html><body><h1>데이터 처리중 오류발생 : 다시 시도해주세요</h1></body></html>");
		}
		
		
	}
}
