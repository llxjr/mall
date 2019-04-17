package cn.funwx.mall.component.interceptor;

import cn.funwx.mall.common.Constants;
import cn.funwx.mall.component.annotation.Authority;
import cn.funwx.mall.pojo.User;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author chj
 * @description 权限拦截器
 * @date 2018/8/23 14:59
 */
public class AuthorityInterceptor extends HandlerInterceptorAdapter {

    @Deprecated
    private static final int PERMISSION_CODE = 0x10;
    /** 请求失败路径 **/
    private static final String redirectUrl = "login.html";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Method method = null;
        if (handler instanceof HandlerMethod) {
            method = ((HandlerMethod) handler).getMethod();
        }
        if (method != null) {
            Authority authority = method.getAnnotation(Authority.class);
            if (authority != null) {
                if (authority.required()) {
                    User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
                    if (user != null && PERMISSION_CODE == user.getAuthorityCode()) {
                        //其他判定条件
                        return true;
                    }
                }
                response.sendRedirect(redirectUrl);
            }
        }
        return true;
    }
}
