package com.github.itwild.less.leetcode.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 题号：141. 环形链表
 */
public class HasCycle {

    /*
    给定一个链表，判断链表中是否有环。

    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

    如果链表中存在环，则返回 true 。 否则，返回 false 。

    进阶：

    你能用 O(1)（即，常量）内存解决此问题吗？
    */
    public static void main(String[] args) {

    }

    public static boolean solution1(ListNode head) {

        ListNode custom = new ListNode(0);

        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur;
            cur = cur.next;
            if (cur == custom) {
                return true;
            }
            temp.next = custom;
        }

        return false;
    }

    public static boolean solution2(ListNode head) {

        Set<ListNode> nodes = new HashSet<>();

        ListNode cur = head;
        while (cur != null) {
            if (nodes.contains(cur)) {
                return true;
            } else {
                nodes.add(cur);
            }
            cur = cur.next;
        }
        return false;
    }

    public static boolean solution3(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
