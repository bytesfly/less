package com.github.itwild.less.leetcode.algorithm;

/**
 * 题号：21. 合并两个有序链表
 */
public class MergeTwoLists {

    /*
    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
    示例：

    输入：1->2->4, 1->3->4
    输出：1->1->2->3->4->4
    */
    public static void main(String[] args) {

    }

    public static ListNode solution1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = l1.val <= l2.val ? l1 : l2;

        ListNode cur = head;

        ListNode one = head.next;
        ListNode another = l1.val <= l2.val ? l2 : l1;

        while (one != null || another != null) {

            if (another == null
                    || (one != null && one.val <= another.val)) {
                cur.next = one;
                one = one.next;
            } else {
                cur.next = another;
                another = another.next;
            }
            cur = cur.next;
        }

        return head;
    }

    public static ListNode solution2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = solution2(l1.next, l2);
            return l1;
        } else {
            l2.next = solution2(l1, l2.next);
            return l2;
        }
    }
}
