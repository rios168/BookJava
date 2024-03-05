package com.book.management.controller;

import com.book.management.bean.ResultBean;
import com.book.management.mybatis.pojo.BookList;
import com.book.management.service.UpdateService;

import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("update")
@Api(tags = "update")
public class UpdateController {

    private final UpdateService updateService;

    public UpdateController(UpdateService updateService) {
        this.updateService = updateService;
    }

    @PostMapping("create")
    public ResultBean create(@RequestBody BookList bookList) {
        return updateService.create(bookList);
    }

    @PostMapping("modify")
    public ResultBean modify(@RequestBody BookList bookList) {
        return updateService.modify(bookList);
    }

    @GetMapping("delete")
    public ResultBean delete(Long bookId) {
        return updateService.delete(bookId);
    }


}
