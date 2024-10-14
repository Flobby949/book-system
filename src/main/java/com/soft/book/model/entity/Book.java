package com.soft.book.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : Flobby
 * @program : book-system
 * @description :
 * @create : 2024-10-13 22:43
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Integer pkId;
    private String name;
    private String cover;
    private String author;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
}
