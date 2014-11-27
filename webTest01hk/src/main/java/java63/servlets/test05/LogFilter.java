package java63.servlets.test05;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {
	FilterConfig filterConfig;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		System.out.println("LogFilter 설정완료");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain nextFilter) throws IOException, ServletException {
		
		
		//다음 필터를 실행하기전에 해야할 일
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		System.out.println(httpRequest.getRemoteAddr()); //ip주소를 알려주는 기능
		
		//'다음 필터' 실행하기
		//단, 더이상 '다음 필터'가 없으면 톰캣 서버는 해당 서블릿을 실행한다.
		nextFilter.doFilter(request, response);
		
		//'다음 필터'를 실행한 후에 해야할 일
		System.out.println("LogFilter나가기");
		
	}

	@Override
	public void destroy() {
		
	}
	
}
