package com.github.itwild.less.leetcode.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 题号：73. 矩阵置零
 */
public class SetZeroes {

    /*
    给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

    示例 1:

    输入:
            [
            [1,1,1],
            [1,0,1],
            [1,1,1]
            ]
    输出:
            [
            [1,0,1],
            [0,0,0],
            [1,0,1]
            ]
    示例 2:

    输入:
            [
            [0,1,2,0],
            [3,4,5,2],
            [1,3,1,5]
            ]
    输出:
            [
            [0,0,0,0],
            [0,4,5,0],
            [0,3,1,0]
            ]
    进阶:

    一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
    一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
    你能想出一个常数空间的解决方案吗？*/
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        //solution1(matrix);
        solution2(matrix);

        System.out.println();
    }

    public static void solution1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        for (Integer row : zeroRows) {
            for (int j = 0; j < cols; j++) {
                matrix[row][j] = 0;
            }
        }

        for (Integer col : zeroCols) {
            for (int i = 0; i < rows; i++) {
                matrix[i][col] = 0;
            }
        }
    }

    // 利用数组的首行和首列来记录 0 值
    public static void solution2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 第一行是否要置0
        boolean rowFlag = false;
        // 第一列是否要置0
        boolean colFlag = false;

        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                rowFlag = true;
                break;
            }
        }

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    // 标记在第一列
                    matrix[i][0] = 0;
                    // 标记在第一行
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < cols; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 处理第一行
        if (rowFlag) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // 处理第一列
        if (colFlag) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
