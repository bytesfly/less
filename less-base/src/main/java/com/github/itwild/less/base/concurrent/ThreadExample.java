package com.github.itwild.less.base.concurrent;

import cn.hutool.core.thread.ThreadUtil;

public class ThreadExample {

    public static void main(String[] args) {
        m1();
        m2();
    }

    /**
     * 获取 JVM中与当前线程同组的所有线程
     */
    public static void m1() {
        Thread[] threads = ThreadUtil.getThreads();
        System.out.println(threads.length);
    }

    /**
     * 获取 进程的主线程
     */
    public static void m2() {
        Thread mainThread = ThreadUtil.getMainThread();
        System.out.println(mainThread.getName() + mainThread.getId());
    }
}
