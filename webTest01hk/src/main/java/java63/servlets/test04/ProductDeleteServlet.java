package java63.servlets.test04;

import java.io.IOException;
import java.io.PrintWriter;
import java63.servlets.test04.dao.ProductDao;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test04/product/delete")
public class ProductDeleteServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));
    //AppInitServlet.productDao.delete(no);
    //ContextLoaderListener.productDao.delete(no);
    ProductDao productDao = (ProductDao) this.getServletContext().getAttribute("productDao");
    productDao.delete(no);
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<link rel='stylesheet'"); 
    out.println("      href='../../css/bootstrap.min.css'>");
    out.println("<link rel='stylesheet'"); 
    out.println("      href='../../css/bootstrap-theme.min.css'>");
    out.println("<link rel='stylesheet' href='../../css/common.css'>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div class='container'>");
    out.println("<h1>삭제 결과</h1>");
    out.println("<p>삭제하였습니다</p>");
    out.println("</div>");
    
    out.println("</body>");
    out.println("</html>");

    HttpServletResponse orginResponse = (HttpServletResponse)response;
    orginResponse.sendRedirect("list");
  }
  
}












