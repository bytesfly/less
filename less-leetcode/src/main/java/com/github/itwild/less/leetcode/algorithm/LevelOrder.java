package com.github.itwild.less.leetcode.algorithm;

import java.util.*;

/**
 * 题号：102. 二叉树的层序遍历
 */
public class LevelOrder {

    /*
    给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

    示例：
    二叉树：[3,9,20,null,null,15,7],

            3
            / \
            9  20
            /  \
            15   7
    返回其层序遍历结果：

            [
            [3],
            [9,20],
            [15,7]
            ]
    */
    public static void main(String[] args) {

    }

    private List<List<Integer>> result;

    public List<List<Integer>> solution1(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        this.result = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>(1);
        nodes.add(root);
        visit(nodes);
        return this.result;
    }

    public void visit(List<TreeNode> nodes) {
        List<Integer> items = new ArrayList<>();
        List<TreeNode> nextNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            items.add(node.val);
            if (node.left != null) {
                nextNodes.add(node.left);
            }
            if (node.right != null) {
                nextNodes.add(node.right);
            }
        }
        this.result.add(items);
        if (!nextNodes.isEmpty()) {
            visit(nextNodes);
        }
    }

    public List<List<Integer>> solution2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> res = new ArrayList<>();

        int size;
        while ((size = queue.size()) > 0) {
            List<Integer> items = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                items.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(items);
        }

        return res;
    }
}
