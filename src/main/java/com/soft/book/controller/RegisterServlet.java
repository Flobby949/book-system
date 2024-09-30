package com.soft.book.controller;

import com.soft.book.cache.GlobalCache;
import com.soft.book.model.dto.UserDTO;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            ResultUtil.alertMessage("用户名或密码不能为空", resp);
        }
        String verifyCode = req.getParameter("verifyCode");
        String code = (String)req.getSession().getAttribute("code");
        if (!code.equalsIgnoreCase(verifyCode)) {
            ResultUtil.alertMessage("验证码错误", resp);
        }
        boolean resultFlag = GlobalCache.getUserService().register(UserDTO.builder()
                .username(username)
                .password(password)
                .build());
        if (resultFlag) {
            ResultUtil.alertMessage("注册成功", resp);
        } else {
            ResultUtil.alertMessage("注册失败", resp);
        }
    }
}
