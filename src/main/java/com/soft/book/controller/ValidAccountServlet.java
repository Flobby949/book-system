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
 * @create : 2024-10-12 14:18
 **/

@WebServlet("/validAccount/*")
public class ValidAccountServlet extends HttpServlet {

    private final UserService userService = GlobalCache.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        System.out.println("uri = " + uri);
        String username = uri.substring(uri.lastIndexOf('/') + 1);
        boolean flag = userService.validAccount(username);
        resp.getWriter().print(flag);
    }
}
