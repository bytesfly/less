package com.github.itwild.less.base.jvm;

public class TryDemo {

    public static int m1() {
        int n = 10;
        try {
            return n += 1;
        } catch (Exception e) {
            return n += 2;
        } finally {
            return n += 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(m1());
    }
}
