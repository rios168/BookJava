package com.book.management.config;


import com.book.management.interceptor.AdminCheckInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public AdminCheckInterceptor adminInterceptor() {
        return new AdminCheckInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminInterceptor()).addPathPatterns("/detail/**").addPathPatterns("/update/**");
    }
}
