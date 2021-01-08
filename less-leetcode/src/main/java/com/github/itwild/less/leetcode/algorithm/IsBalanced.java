package com.github.itwild.less.leetcode.algorithm;

/**
 * 题号：110. 平衡二叉树
 */
public class IsBalanced {
    /*
    给定一个二叉树，判断它是否是高度平衡的二叉树。

    本题中，一棵高度平衡二叉树定义为：

    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
    */
    public static void main(String[] args) {

    }

    public boolean solution1(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1 && solution1(root.left) && solution1(root.right);
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(1 + height(node.left), 1 + height(node.right));
    }

    public boolean solution2(TreeNode root) {
        return depth(root) != -1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        if (left == -1) {
            return -1;
        }
        int right = depth(node.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }
}
