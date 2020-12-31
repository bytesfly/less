package com.github.itwild.less.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 题号：98. 验证二叉搜索树
 */
public class IsValidBST {


    /*给定一个二叉树，判断其是否是一个有效的二叉搜索树。

    假设一个二叉搜索树具有如下特征：

    节点的左子树只包含小于当前节点的数。
    节点的右子树只包含大于当前节点的数。
    所有左子树和右子树自身必须也是二叉搜索树。
    示例 1:

    输入:
             2
            / \
           1  3
    输出: true
    示例 2:

    输入:
             5
            / \
           1   4
              / \
             3  6
    输出: false
    解释: 输入为: [5,1,4,null,null,3,6]。
                 根节点的值为 5 ，但是其右子节点值为 4 。

    */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4, new TreeNode(3), new TreeNode(6));

        boolean isValid = solution2(root);
        System.out.println(isValid);
    }

    public static boolean solution1(TreeNode root) {
        List<Integer> data = new ArrayList<>();
        visit(root, data);

        int last = data.get(0);

        for (int i = 1; i < data.size(); i++) {
            int num = data.get(i);
            if (num <= last) {
                return false;
            }
            last = num;
        }
        return true;
    }

    public static void visit(TreeNode root, List<Integer> data) {
        if (root.left != null) {
            visit(root.left, data);
        }
        data.add(root.val);
        if (root.right != null) {
            visit(root.right, data);
        }
    }

    public static boolean solution2(TreeNode root) {
        return visit(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean visit(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        int value = root.val;

        if (value <= min || value >= max) {
            return false;
        }

        return visit(root.left, min, value) && visit(root.right, value, max);
    }
}
