package com.justnow.linkedlist.findmiddle;

import com.justnow.linkedlist.single.ListNode;


public class FindMiddleValue {

    /**
     * 1、我的方法，每次都是循环逻辑出问题，这个一定要克服
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        int mid = length / 2 + 1;
        ListNode middle = head;
        while (mid > 1) {
            mid--;
            head = head.next;
        }
        return head;
    }

    /**
     * 2、官方解法，用了快慢指针的方法
     * 快慢指针，慢指针slow遍历列表时，让另一个指针fast的速度是它的两倍
     * 当fast到达列表的末尾时，slow必然位于中间
     * 时间复杂度：O(N),其中N是给定列表的节点数目
     * 空间复杂度：O(1),slow和fast用去的空间
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
