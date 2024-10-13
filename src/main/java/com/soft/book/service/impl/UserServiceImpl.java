package com.soft.book.service.impl;

import com.soft.book.cache.GlobalCache;
import com.soft.book.dao.UserDAO;
import com.soft.book.model.dto.UserDTO;
import com.soft.book.model.entity.User;
import com.soft.book.service.UserService;
import com.soft.book.utils.Md5Util;

/**
 * @author : Flobby
 * @program : book-system
 * @description :
 * @create : 2024-09-23 16:23
 **/

public class UserServiceImpl implements UserService {

    private final UserDAO userDao = GlobalCache.getUserDao();

    @Override
    public boolean register(UserDTO user) {
        // 判断用户名是否已经存在
        if (userDao.validUser(user.getUsername()) != null) {
            return false;
        }
        // 对密码进行MD5加密
        user.setPassword(Md5Util.encode(user.getPassword()));
        return GlobalCache.getUserDao().insertUser(user);
    }

    @Override
    public boolean validate(String username) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        return userDao.validUser(username) != null;
    }

    @Override
    public boolean login(String username, String password) {
        User user = userDao.validUser(username);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(Md5Util.encode(password));
    }


}
