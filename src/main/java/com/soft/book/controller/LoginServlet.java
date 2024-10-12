package com.soft.book.controller;

import com.soft.book.cache.GlobalCache;
import com.soft.book.service.UserService;
import com.soft.book.utils.ResultUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author : Flobby
 * @program : book-system
 * @description :
 * @create : 2024-09-30 14:36
 **/

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService = GlobalCache.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            ResultUtil.failResult(resp, "登录失败");
            return;
        }
        boolean login = userService.login(username, password);
        if (login) {
            resp.sendRedirect("/index.jsp");
        } else {
            ResultUtil.failResult(resp, "登录失败");
        }
    }
}
