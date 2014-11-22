package java63.servlets.test03;

import java.io.InputStream;
import java63.servlets.test03.dao.ProductDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/* ServletContextListner는
 * 웹 애플리케이션이 시작하거나 종료하는 이벤트에 대해 작업 수행!
 * 
 * Context Parameter?
 *  =>Web Application에서 사용할 환경변수를 정의할 때 사용
 * 	=>모든 서블릿이 사용할 수 있다.
 * 
 * <context-param>
 * 	<param-name>KEY</param-name>
 * 	<param-value>VALUE</param-value>
 * </context-param>
 * 
 * 사용방법?
 * ServletContext의 getInitParameter(KEY) 호출
 * 
 */

//@WebListener
public class ContextLoaderListener01 implements ServletContextListener {
  public static ProductDao productDao;
  
	/* WebApplication이 시작(initialize)할 때 호출됨
	 * =>servlet이 사용할 공통 자원(resource)를 준
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ServletContext ctx = sce.getServletContext();
      InputStream inputStream = Resources.getResourceAsStream(
          ctx.getInitParameter("mybatisConfig"));
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
      
      productDao = new ProductDao();
      productDao.setSqlSessionFactory(sqlSessionFactory);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
	}

	/*Web Application이 종료될 때 호출함
	 * => Servlet이 사용한 자원(resource)를 해제할 
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	
}
