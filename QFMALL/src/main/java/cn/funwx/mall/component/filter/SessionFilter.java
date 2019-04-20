package cn.funwx.mall.component.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SessionFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//不需要过滤的uri
		String[] noFilterUri = new String[] {"login", "Index", "index", ".", "doLogin"};
		
		//获取请求uri
		String requestUri = request.getRequestURI();
		
		//是否过滤
		boolean isFilter = true;
		for (String str : noFilterUri) {
			if (requestUri.contains(str)) {
				isFilter = false;
				break;
			} 
		}
		
		//判断是否登录
		if (isFilter) {
			//获取登录实体
			Object object = request.getSession().getAttribute("User");
			if (null == object) {
				response.sendRedirect("/");
			} else {
				filterChain.doFilter(request, response);
			}
		} else {
			filterChain.doFilter(request, response);
		}
		
	}

}
