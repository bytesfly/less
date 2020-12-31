package com.github.itwild.less.leetcode.algorithm;

/**
 * 题号：26. 删除排序数组中的重复项
 */
public class RemoveDuplicates {

    /*
    给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

    不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

    示例 1:

    给定数组 nums = [1,1,2],

    函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

    你不需要考虑数组中超出新长度后面的元素。
    示例 2:

    给定 nums = [0,0,1,1,1,2,2,3,3,4],

    函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

    你不需要考虑数组中超出新长度后面的元素。
    */
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int len = solution(nums);

        System.out.println(len);

        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ", ");
        }
    }

    public static int solution(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        int j = 1;

        for (int i = 1; i < len; i++) {

            if (nums[i] > nums[j - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }
}
