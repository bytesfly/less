package com.github.itwild.less.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 题号：54. 螺旋矩阵
 */
public class SpiralOrder {

    // 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

    /*
    输入:
            [
            [1, 2, 3, 4],
            [5, 6, 7, 8],
            [9,10,11,12]
            ]
    输出: [1,2,3,4,8,12,11,10,9,5,6,7]
    */
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> list = solution(matrix);

        for (Integer i : list) {
            System.out.print(i + ",");
        }
    }

    public static List<Integer> solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Integer> list = new ArrayList<>(rows * cols);

        int left = 0;
        int right = cols - 1;
        int up = 0;
        int down = rows - 1;

        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            up++;
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && up <= down; i--) {
                list.add(matrix[down][i]);
            }
            down--;
            for (int i = down; i >= up && left <= right; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }

        return list;
    }
}
