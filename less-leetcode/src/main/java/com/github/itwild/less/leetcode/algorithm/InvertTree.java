package com.github.itwild.less.leetcode.algorithm;

/**
 * 题号：226. 翻转二叉树
 */
public class InvertTree {

    /*
    翻转一棵二叉树。

    示例：

    输入：

            4
            /   \
            2     7
            / \   / \
            1   3 6   9
    输出：

            4
            /   \
            7     2
            / \   / \
            9   6 3   1
    备注:
    这个问题是受到 Max Howell 的 原问题 启发的 ：

    谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
    */
    public static void main(String[] args) {

    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = invertTree(left);
        root.left = invertTree(right);

        return root;
    }
}
