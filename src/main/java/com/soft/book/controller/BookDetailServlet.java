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

/**
 * @author : Flobby
 * @program : book-system
 * @description :
 * @create : 2024-10-14 15:50
 **/

@WebServlet("/detail/*")
public class BookDetailServlet extends HttpServlet {

    private final BookService bookService = GlobalCache.getBookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        Integer bookId = Integer.parseInt(uri.substring(uri.lastIndexOf("/") + 1));
        Book book = bookService.queryBookDetailById(bookId);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/book_detail.jsp").forward(req, resp);
    }
}
