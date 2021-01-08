package com.github.itwild.less.leetcode.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 */
public class InorderTraversal {

    // 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
    public static void main(String[] args) {
        // 左 根 右
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
        this.result.add(node.val);
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

        }

        return res;
    }
}
