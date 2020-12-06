package com.github.itwild.less.base.concurrent;

import cn.hutool.core.thread.ThreadUtil;

public class DaemonThreadExample {

    public static void main(String[] args) {
        /**
         * daemon线程不会阻止JVM退出，比如GC Thread就是daemon线程
         *
         * 这个例子中:
         *
         * 如果 createThread(false).start();即用户线程(User Thread)，程序不会退出
         *
         * 如果 createThread(true).start();即守护线程(Daemon Thread)，程序退出
         */
        createThread(true).start();

        ThreadUtil.sleep(100L);
        System.out.println("exit");
    }

    public static Thread createThread(boolean isDaemon) {
        Thread thread = new Thread(() -> {
            while (true) {
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + t.getId());

                ThreadUtil.sleep(1000L);
            }
        });
        thread.setName("worker");
        thread.setDaemon(isDaemon);
        return thread;
    }
}
