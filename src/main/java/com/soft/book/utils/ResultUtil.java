package com.soft.book.utils;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author : Flobby
 * @program : book-system
 * @description :
 * @create : 2024-10-12 13:56
 **/

public class ResultUtil {

    public static void successResult(HttpServletResponse response, String msg) throws IOException {
        String resultMsg = String.format("""
                     <script>
                                        alert('%s');
                                    </script>\
                """, msg);
        response.getWriter().write(resultMsg);
    }


    public static void successResult(HttpServletResponse response) throws IOException {
        successResult(response, "操作成功");
    }

    public static void failResult(HttpServletResponse response, String msg) throws IOException {
        String resultMsg = String.format("""
                     <script>
                                        alert('%s');
                                    </script>\
                """, msg);
        response.getWriter().write(resultMsg);
    }


    public static void failResult(HttpServletResponse response) throws IOException {
        successResult(response, "操作失败");
    }
}
