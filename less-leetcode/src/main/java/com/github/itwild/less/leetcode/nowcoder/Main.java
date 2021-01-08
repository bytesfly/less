package com.github.itwild.less.leetcode.nowcoder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println(solution1(n));
        }
    }

    public static int solution1(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        int n1 = n / 3;
        int n2 = n % 3;

        return n1 + solution1(n1 + n2);
    }
}
