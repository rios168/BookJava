package com.book.management.controller;

import com.book.management.bean.ResultBean;
import com.book.management.service.DetailService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;

@RestController
@RequestMapping("detail")
@Api(tags = "detail")
public class DetailController {

    private final DetailService detailService;

    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping("getBook")
    @ApiImplicitParam(name = "bookId", defaultValue = "1", required = true)
    public ResultBean getBook(Long bookId) {
        return detailService.getBook(bookId);
    }

    @GetMapping("testWebHook")
    public String testWebHook() {
        return "testWebHook: auto master";
    }

    @GetMapping("getAllBook")
    public ResultBean getAllBook() {
        return detailService.getAllBook();
    }


}
