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

    private final UserDAO userDAO = GlobalCache.getUserDAO();

    @Override
    public boolean register(String username, String password) {
        // 用户名唯一性校验
        User user = userDAO.selectUserByUsername(username);
        if (user != null) {
            return false;
        }
        // 构造用户
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        userDTO.setNickname(username);
        userDTO.setPassword(Md5Util.encode(password));
        userDTO.setAvatar("");
        userDTO.setGender(0);
        return userDAO.insertUser(userDTO);
    }

    @Override
    public boolean login(String username, String password) {
        User user = userDAO.selectUserByUsername(username);
        return user.getPassword().equals(Md5Util.encode(password));
    }

    @Override
    public boolean validAccount(String username) {
        User user = userDAO.selectUserByUsername(username);
        return user == null;
    }
}
