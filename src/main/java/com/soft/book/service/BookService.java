package com.soft.book.service;

import com.soft.book.model.entity.Book;

import java.util.List;

/**
 * @author : Flobby
 * @program : book-system
 * @description :
 * @create : 2024-10-14 13:45
 **/

public interface BookService {

    List<Book> queryAllBooks();

    Book queryBookDetailById(Integer bookId);
}
