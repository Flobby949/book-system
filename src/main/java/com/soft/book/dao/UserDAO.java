package com.soft.book.dao;

import com.soft.book.model.dto.UserDTO;
import com.soft.book.model.entity.User;

/**
 * @author : Flobby
 * @program : book-system
 * @description :
 * @create : 2024-09-23 16:16
 **/

public interface UserDAO {

    boolean insertUser(UserDTO user);

    void selectAllUser();

    User selectUserByUsername(String username);

}
