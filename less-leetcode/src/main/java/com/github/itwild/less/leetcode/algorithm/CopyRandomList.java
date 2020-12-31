package com.github.itwild.less.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 题号：138. 复制带随机指针的链表
 */
public class CopyRandomList {

    /*
    给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

    要求返回这个链表的 深拷贝。
    */
    public static void main(String[] args) {

    }

    public static Node solution(Node head) {
        if (head == null) {
            return null;
        }
        // key为复制前的Node，value为新复制的Node
        Map<Node, Node> map = new HashMap<>();

        Node newHead = new Node(head.val);
        map.put(head, newHead);

        Node oldCurrent = head.next;
        Node newCurrent = newHead;

        while (oldCurrent != null) {
            Node newNode = new Node(oldCurrent.val);
            newCurrent.next = newNode;

            map.put(oldCurrent, newNode);

            newCurrent = newNode;
            oldCurrent = oldCurrent.next;
        }

        oldCurrent = head;
        newCurrent = newHead;

        while (oldCurrent != null) {

            if (oldCurrent.random != null) {
                newCurrent.random = map.get(oldCurrent.random);
            }

            oldCurrent = oldCurrent.next;
            newCurrent = newCurrent.next;
        }

        return newHead;
    }

}
