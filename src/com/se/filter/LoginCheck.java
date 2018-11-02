package com.se.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se.member.MemberDTO;


/**
 * Servlet Filter implementation class LoginCheck
 */
@WebFilter("/LoginCheck")
public class LoginCheck implements Filter {
	Map<String, String> map;
    /**
     * Default constructor. 
     */
    public LoginCheck() {
     map = new HashMap<>();
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		String command =((HttpServletRequest)request).getPathInfo();
		String check= map.get(command);
		if(check != null) {
		HttpSession session =((HttpServletRequest)request).getSession();
		MemberDTO memberDTO =(MemberDTO)request.getAttribute("memberDTO");
		if(memberDTO != null) {
			chain.doFilter(request, response);
		}else {
			((HttpServletResponse)response).sendRedirect("../index.jsp");
		}
		}else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		map.put("/qnaSelectOne.do", "");
		map.put("/noticeWrite.do", "");
		map.put("/qnaWrite.do", "");
		
	}

}
