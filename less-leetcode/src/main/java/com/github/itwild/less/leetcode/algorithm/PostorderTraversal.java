package com.github.itwild.less.leetcode.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 题号：145. 二叉树的后序遍历
 */
public class PostorderTraversal {

    // 给定一个二叉树，返回它的 后序 遍历。
    public static void main(String[] args) {
        // 左 右 根
        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(2));

        List<Integer> list = new PostorderTraversal().solution2(root);
        System.out.println();
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
        if (node.left != null) {
            visit(node.left);
        }
        if (node.right != null) {
            visit(node.right);
        }
        this.result.add(node.val);
    }

    public List<Integer> solution2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        LinkedList<TreeNode> visitedStack = new LinkedList<>();

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            visitedStack.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        while (!visitedStack.isEmpty()) {
            res.add(visitedStack.pop().val);
        }

        return res;
    }

    public List<Integer> solution3(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return res;
    }
}
