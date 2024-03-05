package com.book.management.service;

import com.book.management.bean.ResultBean;
import com.book.management.mybatis.pojo.BookList;

/**
 * Created by Mark on 2024/2/27 027.
 */
public interface UpdateService {
    ResultBean create(BookList BookList);

    ResultBean modify(BookList BookList);

    ResultBean delete(Long bookId);
}
