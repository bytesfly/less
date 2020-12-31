package com.github.itwild.less.leetcode.algorithm;

import java.util.LinkedHashSet;

/**
 * 题号：236. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {

    // 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    public static void main(String[] args) {

    }

    public TreeNode solution1(TreeNode root, TreeNode p, TreeNode q) {

        LinkedHashSet<TreeNode> pVisitedNodes = new LinkedHashSet<>();
        LinkedHashSet<TreeNode> qVisitedNodes = new LinkedHashSet<>();

        if (find(root, p, pVisitedNodes)) {
            pVisitedNodes.add(root);
        }

        if (find(root, q, qVisitedNodes)) {
            qVisitedNodes.add(root);
        }

        for (TreeNode node : pVisitedNodes) {
            if (qVisitedNodes.contains(node)) {
                return node;
            }
        }

        return null;
    }

    public static boolean find(TreeNode root, TreeNode node, LinkedHashSet<TreeNode> visitedNodes) {
        if (root == null) {
            return false;
        }
        if (root == node) {
            visitedNodes.add(root);
            return true;
        }

        if (root.left != null && find(root.left, node, visitedNodes)) {
            visitedNodes.add(root.left);
            return true;
        }

        if (root.right != null && find(root.right, node, visitedNodes)) {
            visitedNodes.add(root.right);
            return true;
        }
        return false;
    }

    public TreeNode solution2(TreeNode root, TreeNode p, TreeNode q) {

        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = solution2(root.left, p, q);
        TreeNode right = solution2(root.right, p, q);
        if (left != null && right == null) {
            //左子树上能找到，但是右子树上找不到，此时就应当直接返回左子树的查找结果
            return left;
        } else if (left == null) {
            //右子树上能找到，但是左子树上找不到，此时就应当直接返回右子树的查找结果
            return right;
        }
        //左右子树上均能找到，说明此时的p结点和q结点分居root结点两侧，此时就应当直接返回root结点
        return root;
    }
}
