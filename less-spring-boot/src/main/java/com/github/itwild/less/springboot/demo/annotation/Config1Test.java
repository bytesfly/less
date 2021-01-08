package com.github.itwild.less.springboot.demo.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Config1Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config1.class);

        Student student = (Student) applicationContext.getBean("stu");
        System.out.println();
    }
}
