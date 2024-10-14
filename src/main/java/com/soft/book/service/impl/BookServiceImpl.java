package com.soft.book.service.impl;

import com.soft.book.cache.GlobalCache;
import com.soft.book.dao.BookDAO;
import com.soft.book.model.entity.Book;
import com.soft.book.service.BookService;

import java.util.List;

/**
 * @author : Flobby
 * @program : book-system
 * @description :
 * @create : 2024-10-14 13:45
 **/

public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO = GlobalCache.getBookDao();

    @Override
    public List<Book> queryAllBooks() {
        System.out.println("BookServiceImpl.queryAllBooks");
        return bookDAO.selectAllBooks();
    }
}
