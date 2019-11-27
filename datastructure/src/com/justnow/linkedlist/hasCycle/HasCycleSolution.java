package com.justnow.linkedlist.hasCycle;


import com.justnow.linkedlist.single.ListNode;

import java.util.HashSet;
import java.util.Set;

public class HasCycleSolution {
    public static void main(String[] args) {
        ListNode a = null;
        ListNode b = null;
        if (a == b) {
            System.out.println("两个null值可以判断相同");
        }
    }

    /**
     * 方法一：
     * 我们遍历所有结点并在哈希表中存储每个结点的引用（或内存地址）。
     * 如果当前结点为空结点 null（即已检测到链表尾部的下一个结点），那么我们已经遍历完整个链表，并且该链表不是环形链表。
     * 如果当前结点的引用已经存在于哈希表中，那么返回 true（即该链表为环形链表）。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>(); // 这里为什么要用hashset
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 方法二
     * https://blog.csdn.net/zhuguang_2016/article/details/89738602
     * @param head
     * @return
     */
    public boolean hasCycleTwo(ListNode head) {
/* 自己的解法存在的问题
        if (head == null) {
            return false;
        }
        ListNode cur = head;
        ListNode slow = cur;
        ListNode fast = cur;

        while(fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow != null && fast != null && slow == fast) {
                return true;
            }
        }
        return false;
*/
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast) {
            if (fast == null || fast.next ==null) {
                // 说明该链表存在尾节点
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;

    }


}
