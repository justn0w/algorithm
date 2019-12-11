package com.justnow.linkedlist.deletebackwards;

import com.justnow.linkedlist.single.ListNode;
import com.justnow.linkedlist.single.ListOperate;

public class DelelteBackwardsSolution {

    /**
     * 1、我的版本
     * 循环得到删除节点的位置，然后再次循环到节点处，开始删除
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 考虑到节点null和只有一个节点的情况
        if (head == null) {
            return null;
        }
        if (head.next == null && n==1){
            return null;
        }

        // 考虑到要删除的节点是头结点
        // 遍历链表获得长度
        ListNode pred = head;
        ListNode current = pred;
        int count = 0;
        while(current != null) {
            count++;
            current = current.next;
        }

        // 考虑到删除的节点是头结点的情况
        if (count == n) {
            head = head.next;
            return head;
        }
        current = pred;

        // 循环到要删除的节点
        for (int i=0; i<count-n; i++) {
            ListNode next = current.next;
            pred = current;
            current = current.next;
        }

        pred.next = current.next;
        return head;
    }

    /**
     * 2.1 官方版本两次循环
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }

        length -= n;
        first = dummy;
        while(length > 0) {
            length--;
            first = first.next;
        }

        first.next = first.next.next;
        return dummy.next;
    }

    /**
     * 2.2 官方版本遍历一次就ok
     * 刷题存在的问题时每次，都在数字索引上犯错误
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode target = dummy, tail = dummy;
        dummy.next = head;
        while (n >= 0 && tail != null) {
            tail = tail.next;
            n--;
        }

        while (tail != null) {
            tail = tail.next;
            target = target.next;
        }

        target.next = target.next.next;

        return dummy.next;
    }


    public static void main(String[] args) {
//        ListNode head = new ListNode(5);
//        ListOperate op = new ListOperate();
//        op.addListNode(head, 1);
//        op.addListNode(head, 2);
//        op.addListNode(head, 3);
//        op.addListNode(head, 4);
        ListNode head = new ListNode(1);
        ListOperate op = new ListOperate();
        op.addListNode(head, 2);
        op.showListNode(head);
        removeNthFromEnd(head, 1);
        System.out.println("...........");
        op.showListNode(head);

    }
}
