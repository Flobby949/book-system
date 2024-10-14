package com.soft.book.dao;

import com.soft.book.model.entity.Book;

import java.util.List;

/**
 * @author : Flobby
 * @program : book-system
 * @description :
 * @create : 2024-10-14 13:44
 **/

public interface BookDAO {

    List<Book> selectAllBooks();
}
