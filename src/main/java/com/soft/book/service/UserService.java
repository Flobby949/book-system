package com.soft.book.service;

import com.soft.book.model.dto.UserDTO;
import com.soft.book.model.vo.UserVO;

/**
 * @author : Flobby
 * @program : book-system
 * @description :
 * @create : 2024-09-23 16:23
 **/

public interface UserService {

    boolean register(UserDTO user);

    boolean validate(String username);

    UserVO login(String username, String password);

}
