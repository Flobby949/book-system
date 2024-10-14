package com.soft.book.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author : Flobby
 * @program : book-system
 * @description :
 * @create : 2024-10-14 13:34
 **/

@WebFilter(urlPatterns = "/index", filterName = "loginFilter")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user == null) {
            System.out.println("LoginFilter.doFilter: 用户未登录");
            request.getRequestDispatcher("/login").forward(request, servletResponse);
        } else {
            filterChain.doFilter(request, servletResponse);
        }
    }
}
