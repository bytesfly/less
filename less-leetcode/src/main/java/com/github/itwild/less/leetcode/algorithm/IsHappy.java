package com.github.itwild.less.leetcode.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 题号：202. 快乐数
 */
public class IsHappy {

    /*
    编写一个算法来判断一个数 n 是不是快乐数。

            「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。

    如果 n 是快乐数就返回 True ；不是，则返回 False 。
             
    示例：

    输入：19
    输出：true
    解释：x`
            12 + 92 = 82
            82 + 22 = 68
            62 + 82 = 100
            12 + 02 + 02 = 1

    */
    public static void main(String[] args) {

    }

    public static boolean solution(int n) {
        return happy(n, new HashSet<>());
    }

    public static boolean happy(int n, Set<Integer> nums) {
        if (nums.contains(n)) {
            return false;
        }
        int next = squareSum(n);
        if (next == 1) {
            return true;
        } else {
            nums.add(n);
            return happy(next, nums);
        }
    }

    public static int squareSum(int n) {
        int sum = 0;

        while (n > 0) {
            int bit = n % 10;
            sum += bit * bit;
            n = n / 10;
        }

        return sum;
    }
}
