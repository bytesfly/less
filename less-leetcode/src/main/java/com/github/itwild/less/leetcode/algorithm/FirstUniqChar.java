package com.github.itwild.less.leetcode.algorithm;

import java.util.*;

/**
 * 题号：387. 字符串中的第一个唯一字符
 */
public class FirstUniqChar {

    /*
    给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

    示例：

    s = "leetcode"
    返回 0

    s = "loveleetcode"
    返回 2
             
    提示：你可以假定该字符串只包含小写字母。
    */
    public static void main(String[] args) {
        String s = "loveleetcode";

        System.out.println(solution2(s));
    }

    public static int solution1(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        // 存储唯一字符, key为字符，value为该字符所在数组的index
        Map<Character, Integer> uniqMap = new LinkedHashMap<>();
        // 记录非唯一字符
        Set<Character> repeatSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (repeatSet.contains(ch)) {
                continue;
            }
            if (uniqMap.containsKey(ch)) {
                // 从uniqSet中移除该元素
                uniqMap.remove(ch);
                // 记录非唯一字符
                repeatSet.add(ch);
            } else {
                uniqMap.put(ch, i);
            }
        }
        for (Map.Entry<Character, Integer> entry : uniqMap.entrySet()) {
            return entry.getValue();
        }
        return -1;
    }

    public static int solution2(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        Map<Character, Integer> countMap = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            if (countMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
