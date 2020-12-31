package com.github.itwild.less.leetcode.algorithm;

/**
 * 题号：121. 买卖股票的最佳时机
 */
public class MaxProfit {

    /*
    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

    如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

    注意：你不能在买入股票前卖出股票。
    */
    public static void main(String[] args) {

    }

    public static int solution1(int[] prices) {
        int len = prices.length;
        int result = 0;

        for (int i = 0; i < len; i++) {

            for (int j = i + 1; j < len; j++) {
                int temp = prices[j] - prices[i];
                if (temp > result) {
                    result = temp;
                }
            }

        }
        return result;
    }

    public static int solution2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            int temp = prices[i] - min;
            if (temp > result) {
                result = temp;
            }
        }
        return result;
    }
}
