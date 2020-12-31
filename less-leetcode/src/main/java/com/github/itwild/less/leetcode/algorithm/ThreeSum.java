package com.github.itwild.less.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题号：15. 三数之和
 */
public class ThreeSum {

    /*
    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

    注意：答案中不可以包含重复的三元组。

    示例：

    给定数组 nums = [-1, 0, 1, 2, -1, -4]，

    满足要求的三元组集合为：
            [
            [-1, 0, 1],
            [-1, -1, 2]
            ]
    */
    public static void main(String[] args) {

    }

    public List<List<Integer>> solution(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();

        int len = nums.length;

        if (len < 3) {
            return results;
        }

        Arrays.sort(nums);

        if (nums[0] > 0) {
            return results;
        }

        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                int n = nums[i] + nums[left] + nums[right];
                if (n == 0) {
                    List<Integer> result = new ArrayList<>(3);
                    result.add(nums[i]);
                    result.add(nums[left]);
                    result.add(nums[right]);

                    results.add(result);

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (n < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return results;
    }
}
