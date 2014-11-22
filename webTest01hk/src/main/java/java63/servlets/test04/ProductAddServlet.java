package java63.servlets.test04;

import java.io.IOException;
import java63.servlets.test04.dao.ProductDao;
import java63.servlets.test04.domain.Product;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test04/product/add")
public class ProductAddServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    //request.setCharacterEncoding("UTF-8"); <= 이 코드는 필터로 대체합니다.
    
    Product product = new Product();
    product.setName(request.getParameter("name"));
    product.setQuantity(Integer.parseInt(request.getParameter("qty")));
    product.setMakerNo(Integer.parseInt(request.getParameter("mkno")));
    
    ProductDao productDao = (ProductDao)this.getServletContext().getAttribute("productDao");
    try {
    	
    productDao.insert(product);
    
    } catch (Exception e) {
    	RequestDispatcher rd = request.getRequestDispatcher("/common/error");
    	request.setAttribute("error", e);
    	//forward로 다른 서블릿에게 제어권 위임하기
    	//	=> 제어권이 넘어가면 돌아오지 않는다.
      rd.forward(request,response);
    }
    HttpServletResponse orginResponse = (HttpServletResponse)response;
    orginResponse.sendRedirect("list");
  }
  
}












