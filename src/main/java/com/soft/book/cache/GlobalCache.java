package com.soft.book.cache;

import com.soft.book.dao.UserDAO;
import com.soft.book.dao.impl.UserDaoImpl;
import com.soft.book.service.UserService;
import com.soft.book.service.impl.UserServiceImpl;

/**
 * @author : Flobby
 * @program : book-system
 * @description :
 * @create : 2024-10-12 13:40
 **/

public class GlobalCache {

    private static final UserDAO USER_DAO = new UserDaoImpl();
    private static final UserService USER_SERVICE = new UserServiceImpl();

    public static UserDAO getUserDAO() {
        return USER_DAO;
    }

    public static UserService getUserService() {
        return USER_SERVICE;
    }

}
