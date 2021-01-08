package com.github.itwild.less.leetcode.nowcoder;

import java.util.Scanner;
import java.util.TreeSet;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            TreeSet<Integer> set = new TreeSet<>();
            int n = sc.nextInt();
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    set.add(sc.nextInt());
                }
            }
            for (Integer i : set) {
                System.out.println(i);
            }
        }
    }
}
