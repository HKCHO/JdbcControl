/*servlet container에 의해서 실행 되는 클래스*/
package java02.test22;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Hello implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig()");
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("service()");

	}

	@Override
	public String getServletInfo() {
		System.out.println(getServletInfo());
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("destroy()");
		
	}

}
