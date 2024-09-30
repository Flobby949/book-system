package com.soft.book.cache;

import com.soft.book.dao.UserDAO;
import com.soft.book.dao.impl.UserDaoImpl;
import com.soft.book.service.UserService;
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

    public static UserDAO getUserDao() {
        return userDao;
    }

    public static UserService getUserService() {
        return userService;
    }
}
