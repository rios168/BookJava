package com.book.management.mybatis.dao;

import com.book.management.mybatis.pojo.BookList;
import com.book.management.mybatis.pojo.BookListExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookListDao {
    long countByExample(BookListExample example);

    int deleteByExample(BookListExample example);

    int deleteByPrimaryKey(Long bookId);

    int insert(BookList record);

    int insertSelective(BookList record);

    List<BookList> selectByExample(BookListExample example);

    BookList selectByPrimaryKey(Long bookId);

    int updateByExampleSelective(@Param("record") BookList record, @Param("example") BookListExample example);

    int updateByExample(@Param("record") BookList record, @Param("example") BookListExample example);

    int updateByPrimaryKeySelective(BookList record);

    int updateByPrimaryKey(BookList record);
}