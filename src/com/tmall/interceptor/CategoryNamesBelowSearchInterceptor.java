package com.tmall.interceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.StrutsStatics;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tmall.service.CategoryService;
import com.tmall.pojo.Category;
public class CategoryNamesBelowSearchInterceptor extends AbstractInterceptor {
	
	private static final String List = null;
	@Autowired
	CategoryService categoryService;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(StrutsStatics.HTTP_REQUEST);
		ServletContext servletContext = (ServletContext) ctx.get(StrutsStatics.SERVLET_CONTEXT);
		
		String contextPath =servletContext.getContextPath();
		String uri = request.getRequestURI();
		uri =StringUtils.remove(uri, contextPath);
		if(uri.startsWith("/fore")){
			List<Category>cs =categoryService.list();
			ctx.getSession().put("cs", cs);
		}
		return invocation.invoke();
	}

}
