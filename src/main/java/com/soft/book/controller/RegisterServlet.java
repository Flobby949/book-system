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
 * @create : 2024-09-23 16:36
 **/

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private final UserService userService = GlobalCache.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String verifyCode = req.getParameter("verifyCode");
        String code = (String) req.getSession().getAttribute("code");
        if (!code.equalsIgnoreCase(verifyCode)) {
            ResultUtil.failResult(resp, "注册失败");
            return;
        }
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            ResultUtil.failResult(resp, "注册失败");
            return;
        }
        boolean register = userService.register(username, password);
        if (register) {
            ResultUtil.successResult(resp, "注册成功");
        } else {
            ResultUtil.failResult(resp, "注册失败");
        }
    }
}
