package com.github.itwild.less.leetcode.algorithm;

/**
 * 题号：19. 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd {

    /*给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

    示例：

    给定一个链表: 1->2->3->4->5, 和 n = 2.

    当删除了倒数第二个节点后，链表变为 1->2->3->5.
    说明：

    给定的 n 保证是有效的。

    进阶：

    你能尝试使用一趟扫描实现吗？
    */
    public static void main(String[] args) {

    }

    public static ListNode solution1(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
