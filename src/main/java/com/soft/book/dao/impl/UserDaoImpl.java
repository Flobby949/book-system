package com.soft.book.dao.impl;

import com.soft.book.dao.UserDAO;
import com.soft.book.model.dto.UserDTO;
import com.soft.book.model.entity.User;
import com.soft.book.utils.JdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author : Flobby
 * @program : book-system
 * @description :
 * @create : 2024-09-23 16:17
 **/

public class UserDaoImpl implements UserDAO {

    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDataSource());

    @Override
    public boolean insertUser(UserDTO user) {
        String sql = "insert into t_user (username, nickname, password, avatar, gender) values (?,?,?,?,?) ";
        int update = jdbcTemplate.update(sql,
                user.getUsername(),
                user.getNickname(),
                user.getPassword(),
                user.getAvatar(),
                user.getGender()
        );
        return update == 1;
    }

    @Override
    public void selectAllUser() {
        String sql = "select * from t_user ";
        List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(query);
    }
}
