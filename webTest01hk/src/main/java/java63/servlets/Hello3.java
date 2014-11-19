package java63.servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/Hello3")
public class Hello3 extends GenericServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("반갑습니다.");
	}
	
}
