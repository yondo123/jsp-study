package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class testFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws SecurityException {
		System.out.println(">>filter init()");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println(">>filter doFilter()");

		// request Filter
		req.setCharacterEncoding("UTF-8");
		chain.doFilter(req, res);

		// responseFilter
	}

	@Override
	public void destroy() {
		System.out.println(">>filter destroy()");
	}
}
