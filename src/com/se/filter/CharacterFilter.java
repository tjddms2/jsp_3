package com.se.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class CharacterFilter
 */
@WebFilter("/CharacterFilter") 
public class CharacterFilter implements Filter {
	private String encode;
    /**
     * Default constructor. 
     */
    public CharacterFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 *//*기본생성자*/
	public void destroy() {
		// TODO Auto-generated method stub
		/*이 클래스의 객체가 소멸시 객체가 없어질때 한번씩 나오는것.*/
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		//요청 발생시, 실행! (들어가기 전)
		System.out.println("CharacterFilter In");
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		//응답 발생시 실행	(나온 후)
		System.out.println("CharacterFilter Out");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 *//*init :초기화 순서: 객체를 만들려면 생성자 호출하고 나서 이것을 실행하는것. 객체가 없어질때  destroy가 실행이 됨.*/
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		/*이 클래스의 객체가 생성될 때*/
		encode=fConfig.getInitParameter("encode");
	}

}
