package com.soft.book.service;

/**
 * @author : Flobby
 * @program : book-system
 * @description :
 * @create : 2024-09-23 16:23
 **/

public interface UserService {

    boolean register(String username, String password);

    boolean login(String username, String password);

    boolean validAccount(String username);
}
