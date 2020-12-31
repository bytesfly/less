package com.github.itwild.less.leetcode.algorithm;

/**
 * 题号：11. 盛最多水的容器
 */
public class MaxArea {
    /*
     给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

     说明：你不能倾斜容器。

    */
    public static void main(String[] args) {
        int result1 = solution(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        int result2 = solution(new int[]{4, 3, 2, 1, 4});
        int result3 = solution(new int[]{1, 2, 1});

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    public static int solution(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int result = 0;

        while (left < right) {
            int temp = Math.min(height[left], height[right]) * (right - left);
            if (temp > result) {
                result = temp;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
