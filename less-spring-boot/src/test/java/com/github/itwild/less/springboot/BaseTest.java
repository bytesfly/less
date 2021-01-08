package com.github.itwild.less.springboot;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LessSpringbootTest.class)
public class BaseTest {

    @BeforeClass
    public static void before() {
        System.out.println("******* Before Test *******");
    }
}
