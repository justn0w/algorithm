package com.justnow.offer;

public class Solution28 {


    /**
     * 判断是否有环，有的话返回快慢节点相遇的节点,存在问题
     * @param head
     * @return
     */
    public ListNode hasCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head.next;
        while (fast != slow) {
            if (fast == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * 书中的方法总结
     * @param head
     * @return
     */
    public ListNode hasCycle2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = slow.next;
        // 判断只有一个节点的情况
        if (fast == null) {
            return null;
        }
        while (fast != null && slow != null) {

            if (fast == slow) {
                return fast;
            }

            slow = slow.next;
            fast = fast.next;

            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }

    public ListNode EntryNodeOfLoop(ListNode head) {
        //ListNode meetNode = hasCycle(head);
        ListNode meetNode = hasCycle2(head);
        if (meetNode == null) {
            return null;
        }
        int count = 1; //计算出来的是循环中链表中环的长度
        ListNode calNode = meetNode;
        ListNode last = head, prev = head;
        while (calNode.next != meetNode) {
            calNode = calNode.next;
            count++;
        }
        for (int i = 0; i < count; i++) {
            prev = prev.next;
        }

        System.out.println("循环节点个数：" + count);
        while (last != prev) {
            prev = prev.next;
            last = last.next;
        }
        return last;
    }
}
