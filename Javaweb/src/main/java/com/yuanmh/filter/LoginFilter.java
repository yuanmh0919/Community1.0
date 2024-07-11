package com.yuanmh.filter;

import com.yuanmh.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author: Yuanmh
 * @Date: 下午2:03 2024/7/10
 * @Describe: 添加登录拦截器
 */

/*
存在问题 不知到为什么拦截不住list.html
 */
@WebFilter("*.html")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //配置字符集
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //获取路径
        String uri = request.getRequestURI();
        System.out.println("访问路径：" + uri);///community/pages/login.html
        if (uri.contains("login.html") || uri.contains("register.html")) {
            filterChain.doFilter(request, response);
        }
        if (uri.contains("/list.html") || uri.contains("/postDetail.html") || uri.contains("/updateUser.html") || uri.contains("/addPost.html")) {
            //判断是否登录
            User user = (User) request.getSession().getAttribute("user");
            if (user != null) {
                filterChain.doFilter(request, response);
            } else {
                //未登录，跳转到登录页面
                System.out.println("未登录，跳转到登录页面");
                response.sendRedirect(request.getContextPath() + "/pages/login.html");
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
