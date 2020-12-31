package com.github.itwild.less.leetcode.algorithm;

/**
 * 题号：701. 二叉搜索树中的插入操作
 */
public class InsertIntoBST {

    public static void main(String[] args) {

    }

    public static TreeNode solution(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = solution(root.left, val);
        }

        if (val > root.val) {
            root.right = solution(root.right, val);
        }

        return root;
    }
}
