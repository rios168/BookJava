package com.book.management.service;

import com.book.management.bean.ResultBean;
import com.book.management.mybatis.dao.BookListDao;
import com.book.management.mybatis.pojo.BookList;

import org.springframework.stereotype.Service;

/**
 * Created by Mark on 2024/2/27 027.
 */

@Service
class UpdateServiceImpl implements UpdateService {

    private final BookListDao bookListDao;

    public UpdateServiceImpl(BookListDao bookListDao) {
        this.bookListDao = bookListDao;
    }

    @Override
    public ResultBean create(BookList bookBean) {
        bookBean.setBookId(null);
        int insert = bookListDao.insert(bookBean);
        if (insert > 0) {
            return ResultBean.success(bookBean.getBookId());
        } else {
            return ResultBean.fail();
        }
    }

    @Override
    public ResultBean modify(BookList bookBean) {
        int i = bookListDao.updateByPrimaryKey(bookBean);
        if (i > 0) {
            return ResultBean.success();
        } else {
            return ResultBean.fail();
        }
    }

    @Override
    public ResultBean delete(Long bookId) {
        int i = bookListDao.deleteByPrimaryKey(bookId);
        if (i > 0) {
            return ResultBean.success();
        } else {
            return ResultBean.fail();
        }
    }
}
