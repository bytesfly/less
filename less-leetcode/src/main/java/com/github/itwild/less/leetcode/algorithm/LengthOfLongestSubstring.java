package com.github.itwild.less.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 题号：3. 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    /*
    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

    示例 1:

    输入: s = "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    示例 2:

    输入: s = "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    示例 3:

    输入: s = "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
                 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    示例 4:

    输入: s = ""
    输出: 0
    */
    public static void main(String[] args) {

        System.out.println(solution1("bbtablud"));
    }

    public static int solution1(String s) {

        if (s == null) {
            return 0;
        }
        int len = s.length();

        if (len < 2) {
            return len;
        }

        int start = 0;
        int end = 1;

        int max = end - start;
        String temp = s.substring(start, end);

        while (start <= end && end < len) {
            int index = temp.indexOf(s.charAt(end));
            if (index == -1) {
                max = Math.max(max, end - start + 1);
            } else {
                start += index + 1;
            }
            end++;
            temp = s.substring(start, end);
        }

        return max;
    }

    public static int solution2(String s) {

        int len = s.length();

        int start = 0;
        int end = 0;

        int max = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (end < len) {

            char ch = s.charAt(end);
            Integer idx = map.get(ch);
            map.put(ch, end);

            if (idx != null && idx >= start) {
                start = idx + 1;
            }

            max = Math.max(max, end - start + 1);

            end++;
        }

        return max;
    }
}
