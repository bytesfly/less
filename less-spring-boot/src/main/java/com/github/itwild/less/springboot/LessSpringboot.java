package com.github.itwild.less.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.github.itwild.less.springboot"})
@MapperScan(basePackages = {"com.github.itwild.less.springboot.service.mapper"})
@EnableFeignClients
public class LessSpringboot {

    public static void main(String[] args) {
        SpringApplication.run(LessSpringboot.class);
    }
}
