package java63.assign01.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java63.assign01.dao.ProductDao;
import java63.assign01.domain.Product;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

@WebServlet("/product/lifesst")
public class ProductListServlet extends GenericServlet {
	SqlSessionFactory sqlSessionFactory;
	
	public List<Product> selectList(int pageNo, int pageSize) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", ((pageNo - 1) * pageSize));
		paramMap.put("pageSize", pageSize);
		
		
		try {
			return sqlSession.selectList(
					"java63.assign01.dao.ProductDao.selectList", 
					paramMap );
		} finally {
			sqlSession.close();
		}
	}
	
	
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		int pageNo = Integer.parseInt(req.getParameter("pageNo"));
		int pageSize = Integer.parseInt(req.getParameter("pageSize"));
		
		ProductDao productDao = null;
		productDao.selectList(pageNo,pageSize);
		
		res.setContentType("text/html;charset=UTF-8");
		
		
		
    if (req.getParameter("pageNo") != null ) {
      pageNo = Integer.parseInt(req.getParameter("pageNo"));
      pageSize = 3;
    }
    
    if (req.getParameter("pageSize") != null) {
      pageSize = Integer.parseInt(req.getParameter("pageSize"));
    }
    
    
    
    PrintWriter out = res.getWriter();
    
    out.println("<html><body><h1>제품 리스트를 조회합니다.</h1><br/>");
    out.println("<hr>");
    out.println("<table border ='1'><tr><td>제품번호</td><td>제품이름</td><td>제품수량</td><td>제품번호</td></tr>");
    
    for (Product product : productDao.selectList(pageNo, pageSize)) {
    	out.println("<tr><td>" + product.getNo() + "<td>"
    			+ 			"<td>" + product.getName() + "<td>"
    			+				"<td>" + product.getQuantity() + "<td>"
    			+				"<td>" + product.getMakerNo() + "<td></tr>");
    }
    
    out.println("</table></body></html>");
		
	}
	
}
