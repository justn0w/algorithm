package com.justnow.linkedlist.combine;


import com.justnow.linkedlist.single.ListNode;

public class CombineSortedList {

    /**
     * 方法一：我的方法，不需要多余的内容，下方展示的更加边界
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode head = new ListNode(-1);
        ListNode preNode = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val >= cur2.val) {
                preNode.next = new ListNode(cur2.val);
                preNode = preNode.next;
                cur2 = cur2.next;
            } else {
                preNode.next = new ListNode(cur1.val);
                preNode = preNode.next;
                cur1 = cur1.next;
            }
        }

        if (cur1 != null) {
            preNode.next = cur1;
        }
        if (cur2 !=null) {
            preNode.next = cur2;
        }
        return head.next;
    }

    /**
     * 官方的方法，总结两者存在的问题
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }



}
