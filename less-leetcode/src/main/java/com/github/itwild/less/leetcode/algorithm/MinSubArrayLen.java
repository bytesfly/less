package com.github.itwild.less.leetcode.algorithm;

/**
 * 题号：209. 长度最小的子数组
 */
public class MinSubArrayLen {

    /*
    给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。

    示例：

    输入：s = 7, nums = [2,3,1,2,4,3]
    输出：2
    解释：子数组 [4,3] 是该条件下的长度最小的子数组。
             

    进阶：

    如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。

    */
    public static void main(String[] args) {
        int len = solution1(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(len);
    }

    public static int solution1(int s, int[] nums) {
        int len = nums.length;

        int sum = 0;

        int min = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        while (true) {
            if (i == len && j == len) {
                break;
            }

            if (sum == s) {
                min = Math.min(min, i - j);

                if (i < len) {
                    sum += nums[i];
                    i++;
                } else {
                    sum -= nums[j];
                    j++;
                }
            } else if (sum < s) {
                if (i == len) {
                    break;
                }
                sum += nums[i];
                i++;
            } else {
                min = Math.min(min, i - j);

                sum -= nums[j];
                j++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static int solution2(int s, int[] nums) {
        int len = nums.length;

        int j = 0;
        int sum = 0;

        int min = 0;

        for (int i = 0; i < len; i++) {
            sum += nums[i];

            while (sum >= s) {
                int temp = i - j + 1;
                min = min == 0 ? temp : Math.min(min, temp);
                sum -= nums[j++];
            }
        }
        return min;
    }
}
