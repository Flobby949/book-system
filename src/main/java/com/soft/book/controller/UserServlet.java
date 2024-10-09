package com.soft.book.controller;

import com.soft.book.cache.GlobalCache;
import com.soft.book.service.UserService;
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
 * @create : 2024-09-23 16:21
 **/

@WebServlet("/user/*")
public class UserServlet extends HttpServlet {

    private final UserService userService = GlobalCache.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("/validate")) {
            String[] strArr = uri.split("/");
            boolean validate = userService.validate(strArr[strArr.length - 1]);
            if (validate) {
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("false");
            }
        } else if (uri.endsWith("/userinfo")) {
            System.out.println("userinfo");
        } else {
            System.out.println("error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
