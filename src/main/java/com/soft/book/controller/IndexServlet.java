package com.soft.book.controller;

import com.soft.book.cache.GlobalCache;
import com.soft.book.model.entity.Book;
import com.soft.book.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author : Flobby
 * @program : book-system
 * @description :
 * @create : 2024-10-14 13:33
 **/

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    private final BookService bookService = GlobalCache.getBookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> bookList = bookService.queryAllBooks();
        System.out.println("IndexServlet.doGet," + bookList.size());
        req.setAttribute("bookList", bookList);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("IndexServlet.doPost");
    }
}
