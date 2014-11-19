/*
 * 한글 출력할 때 깨지는 문제해결
 * 
 * 이유 :
 * 
 * ServletResponse가 준 출력 스트림은
 * 기본적으로 출력할 때 ISO-8859-1로 인코딩 한다.
 * =>한글은 위 문자 집합에 정의되어 있지 않아, '?'로 대체되어 나타난다.
 * 
 * 
 * 
 * 해결책 : 
 * 
 * ServletReponse로부터 Stream을 얻기 전에,
 * 출력할 내용의 타입과 문자집합을 서정한다.
 * => response.setContentType("text/plain;charset=UTF-8')
 * => response.setCharacterEncoding("UTF-8")
 * 
 * 
 * MIME => 콘텐츠의 타입을 표현
 * 
 */


package java63.servlets.test01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/test01/Test02")
public class Test02 extends GenericServlet {


	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

		//방법1.
		//response.setCharacterEncoding("UTF-8");
		
		//방법2.
		response.setContentType("text/plain;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("안녕하세요. Hello. 곤니찌와");

	}
}
