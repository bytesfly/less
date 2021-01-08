package com.github.itwild.less.leetcode.algorithm;

import java.util.Arrays;

/**
 * 题号：581. 最短无序连续子数组
 */
public class FindUnsortedSubarray {

    /*
    给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

     你找到的子数组应是最短的，请输出它的长度。

     示例 1:

     输入: [2, 6, 4, 8, 10, 9, 15]
     输出: 5
     解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     说明 :

     输入的数组长度范围在 [1, 10,000]。
     输入的数组可能包含重复元素 ，所以升序的意思是<=。
     */
    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(solution1(arr));
    }

    public static int solution1(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        int left = 0;
        int right = len - 1;

        for (int i = 0; i <= right; i++) {
            if (nums[i] != sortedNums[i]) {
                left = i;
                break;
            } else if (i == right) {
                return 0;
            }
        }

        for (int i = right; i > left; i--) {
            if (nums[i] != sortedNums[i]) {
                right = i;
                break;
            }
        }

        return right - left + 1;
    }
}
