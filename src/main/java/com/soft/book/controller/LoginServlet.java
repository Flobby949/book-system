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
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean flag = userService.login(username, password);
        if (flag) {
            req.getSession().setAttribute("token", username);
            ResultUtil.alertMessage("登录成功", resp, "/index.jsp");
        }  else {
            ResultUtil.alertMessage("用户名或密码错误", resp, "/index.jsp");
        }
    }
}
