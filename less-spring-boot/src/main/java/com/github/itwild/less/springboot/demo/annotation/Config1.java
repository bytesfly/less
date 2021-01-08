package com.github.itwild.less.springboot.demo.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config1 {

    @Bean(name = "stu")
    public Student student() {
        return new Student(1L, "李寻欢", 100.0);
    }
}
