package com.github.itwild.less.leetcode.algorithm;

import java.util.Arrays;

/**
 * 题号：16. 最接近的三数之和
 */
public class ThreeSumClosest {
    /*
    给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。       

    示例：

    输入：nums = [-1,2,1,-4], target = 1
    输出：2
    解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
             
    提示：

            3 <= nums.length <= 10^3
            -10^3 <= nums[i] <= 10^3
            -10^4 <= target <= 10^4
     */
    public static void main(String[] args) {

    }

    public static int solution(int[] nums, int target) {

        int result = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(result - target);

        Arrays.sort(nums);

        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {

            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    return sum;
                }

                int tempDiff = Math.abs(sum - target);
                if (tempDiff < diff) {
                    diff = tempDiff;
                    result = sum;
                }

                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }
}
