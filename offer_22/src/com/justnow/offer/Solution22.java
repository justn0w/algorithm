package com.justnow.offer;


import com.justnow.LinkedList.ListNode;

public class Solution22 {

    public ListNode deleteDuplication(ListNode headNode) {
        if (headNode == null) {
            return headNode;
        }

        ListNode head = new ListNode(); //创建一个空节点，防止第1个节点和之后的节点相同
        head.next = headNode;
        ListNode pre = head;
        ListNode last = pre.next;

        while (last != null) {
            if (last.next != null && last.val == last.next.val) {
                // 找到最后一个相同的节点
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            } else {
                pre = pre.next;
                last = last.next;
            }
        }
        return head.next;
    }
}
