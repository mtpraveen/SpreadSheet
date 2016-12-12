package com.ipl.auth;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipl.model.User;

public class AuthenticationFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		
			HttpSession sess=req.getSession();
			User user=(User) sess.getAttribute("user");
			if(user==null)
			{
				res.sendRedirect("loginPage");
				return;
			}
			chain.doFilter(request, response);
		
	}

	

	
}