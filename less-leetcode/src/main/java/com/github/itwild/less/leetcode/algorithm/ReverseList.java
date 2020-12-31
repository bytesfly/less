package com.github.itwild.less.leetcode.algorithm;

/**
 * 题号：206. 反转链表
 */
public class ReverseList {

    /*
    反转一个单链表。

    示例:

    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL
    进阶:
    你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
    */
    public static void main(String[] args) {

    }

    public static ListNode solution1(ListNode head) {
        ListNode first = null;

        while (head != null) {
            ListNode next = head.next;

            ListNode tmp = first;
            first = head;
            first.next = tmp;

            head = next;
        }
        return first;
    }

    public static ListNode solution2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = solution2(head.next);
        head.next.next = head;
        head.next = null;
        return first;
    }
}
