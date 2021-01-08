package com.github.itwild.less.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 题号：78. 子集
 */
public class Subsets {

    /*
    给你一个整数数组 nums ，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。

    示例 1：
    输入：nums = [1,2,3]
    输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    示例 2：

    输入：nums = [0]
    输出：[[],[0]]

    提示：
            1 <= nums.length <= 10
            -10 <= nums[i] <= 10
    */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = new Subsets().solution1(nums);
        System.out.println();
    }

    public List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        if (nums == null || nums.length == 0) {
            return list;
        }
        for (int num : nums) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subList = list.get(i);
                List<Integer> tempSubList = new ArrayList<>(subList);
                tempSubList.add(num);

                list.add(tempSubList);
            }
        }
        return list;
    }
}
