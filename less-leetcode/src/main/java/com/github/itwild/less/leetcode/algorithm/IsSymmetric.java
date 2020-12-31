package com.github.itwild.less.leetcode.algorithm;

/**
 * 题号：101. 对称二叉树
 */
public class IsSymmetric {

    /*
    给定一个二叉树，检查它是否是镜像对称的。      

    例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

            1
            / \
            2   2
            / \ / \
            3  4 4  3
             

    但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

            1
            / \
            2   2
            \   \
            3    3
    进阶：

    你可以运用递归和迭代两种方法解决这个问题吗？
    */
    public static void main(String[] args) {

    }

    public static boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return visit(root.left, root.right);
    }

    public static boolean visit(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }

        return tree1.val == tree2.val && visit(tree1.left, tree2.right) && visit(tree1.right, tree2.left);
    }

}
