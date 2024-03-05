package com.book.management.service;

import com.book.management.bean.ResultBean;
import com.book.management.mybatis.dao.BookListDao;
import com.book.management.mybatis.pojo.BookList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import lombok.val;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

class UpdateServiceTest {

    private UpdateService updateService;

    @Mock
    private BookListDao bookListDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        updateService = new UpdateServiceImpl(bookListDao);
    }

    @Test
    void createTest() {
        val bookBean = new BookList();
        bookBean.setBookId(1L);
        when(bookListDao.insert(any())).thenReturn(1);
        ResultBean result = updateService.create(bookBean);
        Assertions.assertEquals(result.getMsg(), ResultBean.success().getMsg());

        when(bookListDao.insert(any())).thenReturn(0);
        result = updateService.create(bookBean);
        Assertions.assertEquals(result.getMsg(), ResultBean.fail().getMsg());

        Mockito.verify(bookListDao, times(2)).insert(bookBean);
    }

    @Test
    void modifyTest() {
        val bookBean = new BookList();
        bookBean.setBookId(1L);
        when(bookListDao.updateByPrimaryKey(any())).thenReturn(1);
        ResultBean result = updateService.modify(bookBean);
        Assertions.assertEquals(result.getMsg(), ResultBean.success().getMsg());

        when(bookListDao.updateByPrimaryKey(any())).thenReturn(0);
        result = updateService.modify(bookBean);
        Assertions.assertEquals(result.getMsg(), ResultBean.fail().getMsg());

        Mockito.verify(bookListDao, times(2)).updateByPrimaryKey(bookBean);
    }

    @Test
    void deleteTest() {
        val bookId = 1L;
        when(bookListDao.deleteByPrimaryKey(any())).thenReturn(1);
        ResultBean result = updateService.delete(bookId);
        Assertions.assertEquals(result.getMsg(), ResultBean.success().getMsg());

        when(bookListDao.deleteByPrimaryKey(any())).thenReturn(0);
        result = updateService.delete(bookId);
        Assertions.assertEquals(result.getMsg(), ResultBean.fail().getMsg());

        Mockito.verify(bookListDao, times(2)).deleteByPrimaryKey(bookId);
    }
}