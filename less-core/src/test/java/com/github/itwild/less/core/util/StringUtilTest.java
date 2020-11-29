package com.github.itwild.less.core.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilTest {

    /**
     * 去除开头所有的'/'
     */
    @Test
    public void t1() {
        String str = "//////tmp/a";
        String result = StringUtil.trimLeadingCharacter(str, '/');

        System.out.println(result);
        assertEquals("tmp/a", result);
    }

    /**
     * 去除末尾所有的'/'
     */
    @Test
    public void t2() {
        String str = "http://www.baidu.com/////////";
        String result = StringUtil.trimTrailingCharacter(str, '/');

        System.out.println(result);
        assertEquals("http://www.baidu.com", result);
    }
}
