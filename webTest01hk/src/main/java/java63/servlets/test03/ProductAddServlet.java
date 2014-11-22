package java63.servlets.test03;

import java.io.IOException;
import java63.servlets.test03.dao.ProductDao;
import java63.servlets.test03.domain.Product;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test03/product/add")
public class ProductAddServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    
    Product product = new Product();
    product.setName(request.getParameter("name"));
    product.setQuantity(Integer.parseInt(request.getParameter("qty")));
    product.setMakerNo(Integer.parseInt(request.getParameter("mkno")));
    
    //ContextLoaderListener.productDao.insert(product);
    
    // ProductDao를 ServletContext보관소에서 꺼내는 방식을 사용
    // => 단점, 이전 방식보다 코드가 늘었다.
    // => 장점, 특정 클래스에 종속(Depdent)되지 않는다. 유지보수에 용이하다.
    // *실무에서 많이 쓰는 방식
    ProductDao productDao = (ProductDao)this.getServletContext().getAttribute("productDao");
    productDao.insert(product);
    
    HttpServletResponse orginResponse = (HttpServletResponse)response;
    orginResponse.sendRedirect("list");
  }
  
}












