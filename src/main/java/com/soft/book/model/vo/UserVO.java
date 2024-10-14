package com.soft.book.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : Flobby
 * @program : book-system
 * @description : 用户表实体类
 * @create : 2024-09-23 16:05
 **/


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {

    private Integer id;
    private String username;
    private String nickname;
    private String password;
    private String avatar;
    private Integer gender;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;

}
