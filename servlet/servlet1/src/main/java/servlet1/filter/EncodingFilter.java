package servlet1.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/")
public class EncodingFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// 화면에서 서버로 전송할 때
		String encoding = "UTF-8";
		request.setCharacterEncoding(encoding);	
		
		// 서버에서 화면으로 전송할 때
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html; charset=" + encoding);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
