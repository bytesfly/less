package com.github.itwild.less.leetcode.algorithm;

/**
 * 题号：2. 两数相加
 */
public class AddTwoNumbers {

    /*
    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    示例：

    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807
    */
    public static void main(String[] args) {

    }

    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode mockHead = new ListNode();
        ListNode cur = mockHead;

        int temp = 0;

        ListNode node1 = l1;
        ListNode node2 = l2;

        while (node1 != null || node2 != null) {
            int v1 = node1 != null ? node1.val : 0;
            int v2 = node2 != null ? node2.val : 0;

            int sum = v1 + v2 + temp;
            temp = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }

        if (temp > 0) {
            cur.next = new ListNode(temp);
        }

        return mockHead.next;
    }
}
