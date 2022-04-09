package com.control;

import com.entity.Admin;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 斯洪霄
 */
@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("====过滤器LoginFilter初始化====");
    }

    public void destroy() {
        System.out.println("====过滤器LoginFilter销毁====");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        //获得在下面代码中要用的request，response，session对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        //获得用户请求的URL
        String path = request.getRequestURI();

        //从session里取用户
        Admin admin = (Admin) session.getAttribute("admin");
        //登录、注册页面无需过滤
        if ("/Hospital/".equals(path)|| "/Hospital/Login.do".equals(path)|| "/Hospital/Register.do".equals(path) || "/Hospital/login.jsp".equals(path) || "/Hospital/register.jsp".equals(path)){
            filterChain.doFilter(request,response);
            return;
        }

        //判断如果没有取到用户信息，说明这个请求是没有登录就在请求，就跳转到登录页面
        if (admin == null){
            //跳转到登录页面
            response.sendRedirect("/Hospital/login.jsp");
        } else {
            //已经登录，继续此请求
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
