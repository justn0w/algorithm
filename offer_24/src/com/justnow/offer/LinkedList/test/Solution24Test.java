package com.justnow.offer.LinkedList.test;

import com.justnow.offer.LinkedList.InitList;
import com.justnow.offer.LinkedList.ListNode;
import com.justnow.offer.Solution24;
import org.junit.Test;

public class Solution24Test {


    @Test
    public void normal() {
        InitList init = new InitList();
        Solution24 so = new Solution24();
        ListNode head = new ListNode();
        ListNode listNode1 = init.createListNode(1);
        ListNode listNode2 = init.createListNode(2);
        ListNode listNode3 = init.createListNode(3);
        ListNode listNode4 = init.createListNode(2);
        ListNode listNode5 = init.createListNode(1);
        init.connectListNodes(head, listNode1);
        init.connectListNodes(listNode1, listNode2);
        init.connectListNodes(listNode2, listNode3);
        init.connectListNodes(listNode3, listNode4);
        init.connectListNodes(listNode4, listNode5);

        boolean result = so.charge(head);
        System.out.println(result);
    }

    @Test
    public void normal2() {
        InitList init = new InitList();
        Solution24 so = new Solution24();
        ListNode head = new ListNode();
        ListNode listNode1 = init.createListNode(1);
        ListNode listNode2 = init.createListNode(2);
        ListNode listNode3 = init.createListNode(3);
        ListNode listNode4 = init.createListNode(2);
        ListNode listNode5 = init.createListNode(1);
        ListNode listNode6 = init.createListNode(1);
        ListNode listNode7 = init.createListNode(7);
        init.connectListNodes(head, listNode1);
        init.connectListNodes(listNode1, listNode2);
        init.connectListNodes(listNode2, listNode3);
        init.connectListNodes(listNode3, listNode4);
        init.connectListNodes(listNode4, listNode5);
        init.connectListNodes(listNode5, listNode6);
        init.connectListNodes(listNode6, listNode7);
        ListNode reverse = so.reverse(head);
        boolean charge = so.charge(head);
        init.printList(reverse);
        System.out.println(charge);
    }
}
