package com.urp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
/**
 * 拦截器链开始执行
 * @author a
 *
 */
public class MyFilter implements Filter {
	
	private CommonsMultipartResolver  commonsMultipartResolver;
	
	private FilterConfig filterConfig;
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		String contentType = request.getContentType();
		if (contentType != null && contentType.contains("multipart/form-data")) {
	            MultipartHttpServletRequest multiReq = commonsMultipartResolver.resolveMultipart(request);
	            // 将转化后的 request 放入过滤链中
	            servletRequest = multiReq;
	            request = multiReq;
	     }
		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		filterConfig=filterConfig;
		commonsMultipartResolver=new CommonsMultipartResolver();
	}

}
