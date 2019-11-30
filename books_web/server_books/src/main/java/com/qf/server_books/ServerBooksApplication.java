package com.qf.server_books;


import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan("com.qf.serviceimpl")
@MapperScan("com.qf.mapper")
public class ServerBooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerBooksApplication.class, args);
    }

}
