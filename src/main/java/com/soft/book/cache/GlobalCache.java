package com.soft.book.cache;

import com.soft.book.dao.BookDAO;
import com.soft.book.dao.UserDAO;
import com.soft.book.dao.impl.BookDaoImpl;
import com.soft.book.dao.impl.UserDaoImpl;
import com.soft.book.service.BookService;
import com.soft.book.service.UserService;
import com.soft.book.service.impl.BookServiceImpl;
import com.soft.book.service.impl.UserServiceImpl;

/**
 * @author : Flobby
 * @program : book-system
 * @description :
 * @create : 2024-09-30 14:48
 **/

public class GlobalCache {

    private static UserDAO userDao = new UserDaoImpl();

    private static UserService userService = new UserServiceImpl();

    private static BookDAO bookDao = new BookDaoImpl();

    private static BookService bookService = new BookServiceImpl();

    public static UserDAO getUserDao() {
        return userDao;
    }

    public static UserService getUserService() {
        return userService;
    }

    public static BookDAO getBookDao() {
        return bookDao;
    }

    public static BookService getBookService() {
        return bookService;
    }
}
