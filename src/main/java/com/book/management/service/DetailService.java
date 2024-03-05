package com.book.management.service;

import com.book.management.bean.ResultBean;

/**
 * Created by Mark on 2024/2/27 027.
 */
public interface DetailService {
    ResultBean getBook(Long bookId);

    ResultBean getAllBook();
}
