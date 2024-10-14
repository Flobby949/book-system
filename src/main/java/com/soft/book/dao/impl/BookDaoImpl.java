package com.soft.book.dao.impl;

import com.soft.book.dao.BookDAO;
import com.soft.book.model.entity.Book;
import com.soft.book.utils.JdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collections;
import java.util.List;

/**
 * @author : Flobby
 * @program : book-system
 * @description :
 * @create : 2024-10-14 13:44
 **/

public class BookDaoImpl implements BookDAO {

    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDataSource());

    @Override
    public List<Book> selectAllBooks() {
        String sql = "select * from t_book where delete_flag = 0";
        try {
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
