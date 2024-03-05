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

import java.util.ArrayList;
import java.util.List;

import lombok.val;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class DetailServiceTest {

    private DetailService detailService;

    @Mock
    private BookListDao bookListDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        detailService = new DetailServiceImpl(bookListDao);
    }

    @Test
    void getBookTest() {
        val bookId = 1L;
        val bookBean = new BookList();

        when(bookListDao.selectByPrimaryKey(any())).thenReturn(bookBean);
        ResultBean result = detailService.getBook(bookId);

        Assertions.assertInstanceOf(BookList.class,result.getData());
        Mockito.verify(bookListDao).selectByPrimaryKey(bookId);
    }

    @Test
    void getAllBookTest() {
        val list = new ArrayList<BookList>();
        list.add(new BookList());

        when(bookListDao.selectByExample(null)).thenReturn(list);
        ResultBean result = detailService.getAllBook();

        Assertions.assertNotNull(result.getData());
        Assertions.assertTrue(result.getData() instanceof List);
    }
}