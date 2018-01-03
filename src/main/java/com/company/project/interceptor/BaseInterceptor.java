package com.company.project.interceptor;

import com.company.project.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.company.project.common.constant.UserConstant.LOGIN_SESSION_KEY;

/**
 * descrition：
 *
 * @author: ZHZ
 * @create: 2018/1/3
 * @company: www.ideabinder.com
 */
@Component
public class BaseInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(BaseInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI();
        logger.info("UserAgent:{}", request.getHeader("user-agent"));
        logger.info("用户访问地址:{}", uri);
        User user = null;
        HttpSession session = request.getSession();
        if (session != null) {
            user = (User) session.getAttribute(LOGIN_SESSION_KEY);
        }
        if (uri.startsWith("/admin") && !uri.startsWith("/admin/login") && user == null) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
