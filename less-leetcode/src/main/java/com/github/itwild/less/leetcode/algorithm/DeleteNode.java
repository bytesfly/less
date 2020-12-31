package com.github.itwild.less.leetcode.algorithm;

/**
 * 题号：450. 删除二叉搜索树中的节点
 */
public class DeleteNode {

    /*给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

    一般来说，删除节点可分为两个步骤：

    首先找到需要删除的节点；
    如果找到了，删除它。
    说明： 要求算法时间复杂度为 O(h)，h 为树的高度。

    示例:

    root = [5,3,6,2,4,null,7]
    key = 3

            5
            / \
            3   6
            / \   \
            2   4   7

    给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。

    一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。

            5
            / \
            4   6
            /     \
            2       7

    另一个正确答案是 [5,2,6,null,4,null,7]。

            5
            / \
            2   6
            \   \
            4   7

    */

    public static void main(String[] args) {

    }

    public static TreeNode solution(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        int value = root.val;
        if (key < value) {
            root.left = solution(root.left, key);
            return root;
        }
        if (key > value) {
            root.right = solution(root.right, key);
            return root;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }

        // 找到前驱节点
        TreeNode maxNode = max(root.left);
        // 给前驱节点的左右节点赋值
        maxNode.left = removeMax(root.left);
        maxNode.right = root.right;

        return maxNode;
    }

    public static TreeNode max(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return max(root.right);
    }

    public static TreeNode removeMax(TreeNode root) {
        if (root.right == null) {
            return root.left;
        }
        root.right = removeMax(root.right);
        return root;
    }
}
