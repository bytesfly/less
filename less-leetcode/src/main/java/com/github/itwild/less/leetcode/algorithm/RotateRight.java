package com.github.itwild.less.leetcode.algorithm;

/**
 * 题号：61. 旋转链表
 */
public class RotateRight {

    /*
    给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

    示例 1:

    输入: 1->2->3->4->5->NULL, k = 2
    输出: 4->5->1->2->3->NULL
    解释:
    向右旋转 1 步: 5->1->2->3->4->NULL
    向右旋转 2 步: 4->5->1->2->3->NULL
    示例 2:

    输入: 0->1->2->NULL, k = 4
    输出: 2->0->1->NULL
    解释:
    向右旋转 1 步: 2->0->1->NULL
    向右旋转 2 步: 1->2->0->NULL
    向右旋转 3 步: 0->1->2->NULL
    向右旋转 4 步: 2->0->1->NULL

    */
    public static void main(String[] args) {

    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }
        // 实际需要移动多少步
        int step = k % len;

        if (step == 0) {
            return head;
        }

        int move = len - step;
        cur = head;
        for (int i = 1; i < move; i++) {
            cur = cur.next;
        }

        ListNode newHead = cur.next;
        cur.next = null;

        cur = newHead;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = head;

        return newHead;
    }
}
