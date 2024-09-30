package com.soft.book.utils;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author : Flobby
 * @program : book-system
 * @description :
 * @create : 2024-09-30 15:07
 **/

public class ResultUtil {

    public static void alertSuccess(HttpServletResponse response) throws IOException {
        alertMessage("操作成功", response);
    }

    public static void alertError(HttpServletResponse response) throws IOException {
        alertMessage("操作失败", response);
    }


    public static void alertMessage(String message, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        String result = String.format("""
                    <script>
                        alert("%s！");
                        location.href = "/"
                    </script>
                """, message);
        response.getWriter().write(result);
    }
}
