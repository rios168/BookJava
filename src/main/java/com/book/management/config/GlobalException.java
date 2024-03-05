package com.book.management.config;


import com.book.management.bean.ResultBean;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;


@RestControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public ResultBean allException(Exception e, HttpServletRequest request) {
        e.printStackTrace();
        if (request != null) {
            log.debug(request.getRequestURI() + "  " + request.getMethod());
        } else {
            log.debug("request==null");
        }
        return ResultBean.fail(e.getMessage() + "");
    }
}

