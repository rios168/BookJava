package com.book.management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.book.management.mybatis.dao"})
public class ManagementApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("started success");
    }
}
