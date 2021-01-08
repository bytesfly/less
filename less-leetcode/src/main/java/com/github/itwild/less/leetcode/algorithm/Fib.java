package com.github.itwild.less.leetcode.algorithm;

/**
 * 题号：509. 斐波那契数
 */
public class Fib {
    /*
    斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

    F(0) = 0，F(1) = 1
    F(n) = F(n - 1) + F(n - 2)，其中 n > 1
    给你 n ，请计算 F(n) 。

    示例 1：
    输入：2
    输出：1
    解释：F(2) = F(1) + F(0) = 1 + 0 = 1

    示例 2：
    输入：3
    输出：2
    解释：F(3) = F(2) + F(1) = 1 + 1 = 2

    示例 3：
    输入：4
    输出：3
    解释：F(4) = F(3) + F(2) = 2 + 1 = 3
    */
    public static void main(String[] args) {
        System.out.println(solution1(4));
        System.out.println(solution2(4));
    }

    public static int solution1(int n) {
        if (n < 2) {
            return n;
        }
        return solution1(n - 1) + solution1(n - 2);
    }

    public static int solution2(int n) {
        if (n < 2) {
            return n;
        }
        int add1 = 0;
        int add2 = 1;

        for (int i = 2; i <= n; i++) {
            int sum = add1 + add2;
            add1 = add2;
            add2 = sum;
        }
        return add2;
    }
}
