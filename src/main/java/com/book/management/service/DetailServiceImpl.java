package com.book.management.service;

import com.book.management.bean.ResultBean;
import com.book.management.mybatis.dao.BookListDao;
import com.book.management.mybatis.pojo.BookList;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mark on 2024/2/27 027.
 */

@Service
class DetailServiceImpl implements DetailService {

    private final BookListDao bookListDao;

    public DetailServiceImpl(BookListDao bookListDao) {
        this.bookListDao = bookListDao;
    }

    @Override
    public ResultBean getBook(Long bookId) {
        BookList bookList = bookListDao.selectByPrimaryKey(bookId);
        return ResultBean.success(bookList);
    }

    @Override
    public ResultBean getAllBook() {
        List<BookList> bookLists = bookListDao.selectByExample(null);
        return ResultBean.success(bookLists);
    }
}
