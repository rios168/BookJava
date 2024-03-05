package com.book.management.interceptor;


import com.book.management.bean.ResultBean;
import com.book.management.config.SwaggerConfig;
import com.book.management.utils.JsonUtils;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class AdminCheckInterceptor implements HandlerInterceptor {


    public static boolean falseResult(int errorCode, String msg, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        ResultBean resultBody = new ResultBean(errorCode, msg);
        response.getWriter().println(JsonUtils.toJson(resultBody));
        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userToken = request.getHeader("token");//设备唯一id
        if (SwaggerConfig.token.equals(userToken)) {
            return true;
        } else {
            return falseResult(0, "token error", response);
        }
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
