package com.justnow.offer;


public class Solution30 {

    /**
     * 合并两个有序单链表
     * @param head1
     * @param head2
     * @return
     */
    public ListNode combineLinkedList(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }

        ListNode first = head1;
        ListNode second = head2;
        ListNode comHead = new ListNode(); //当作头结点，内容为空
        ListNode combine = comHead;

        while (first != null && second != null) {
            if (first.val > second.val) {
                combine.next = second;
                second = second.next;
            } else {
                combine.next = first;
                first = first.next;
            }
            combine = combine.next;
        }

        if (first != null) {
            combine.next = first;
        }

        if (second != null) {
            combine.next = second;
        }

        return comHead.next;
    }
}
