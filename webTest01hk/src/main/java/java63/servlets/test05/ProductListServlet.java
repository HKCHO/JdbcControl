package java63.servlets.test05;

import java.io.IOException;
import java.util.List;
import java63.servlets.test05.dao.ProductDao;
import java63.servlets.test05.domain.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("/test05/product/list")
public class ProductListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  static final int PAGE_DEFAULT_SIZE = 3;
  
  @Override
  public void doGet(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    int pageNo = 0;
    int pageSize = 0;
    
    try {
      if (request.getParameter("pageNo") != null) {
        pageNo = Integer.parseInt(request.getParameter("pageNo"));
        pageSize = PAGE_DEFAULT_SIZE;
      }
      
      if (request.getParameter("pageSize") != null) {
        pageSize = Integer.parseInt(request.getParameter("pageSize"));
      }
      
      //스프링의 ContextLoaderListener가 준비한 
      //ApplicationContext 객체 꺼내기
      ApplicationContext appCtx =
          WebApplicationContextUtils.getWebApplicationContext(
              this.getServletContext());
      
      ProductDao productDao = (ProductDao)appCtx.getBean("productDao");
      List<Product> products = productDao.selectList(pageNo, pageSize);
      request.setAttribute("products", products);
      
      // include를 수행할 때는 여기에서 콘텐츠 타입을 설정해야 한다.
      response.setContentType("text/html;charset=UTF-8");
      
      // 결과를 출력하기 위해 JSP에게 위임한다.
      RequestDispatcher rd = request.getRequestDispatcher(
          "/test05/product/ProductList.jsp");
      rd.include(request, response);
    } catch (Exception e) {
      RequestDispatcher rd = 
          request.getRequestDispatcher("/common/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
  }
  
}












