package com.github.itwild.less.leetcode.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 题号：144. 二叉树的前序遍历
 */
public class PreorderTraversal {

    // 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
    public static void main(String[] args) {
        // 根 左 右
    }

    private List<Integer> result;

    public List<Integer> solution1(TreeNode root) {
        this.result = new ArrayList<>();
        if (root == null) {
            return this.result;
        }
        visit(root);
        return this.result;
    }

    public void visit(TreeNode node) {
        this.result.add(node.val);
        if (node.left != null) {
            visit(node.left);
        }
        if (node.right != null) {
            visit(node.right);
        }
    }

    public List<Integer> solution2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return res;
    }
}
