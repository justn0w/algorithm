package com.justnow.test;

import com.justnow.offer.ListNode;
import com.justnow.offer.ListOperate;
import com.justnow.offer.Solution30;
import org.junit.Test;

public class Solution30Test {
    ListOperate listOperate = new ListOperate();


    /**
     * 正常测试
     */
    @Test
    public void testNormal() {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        ListNode node11 = new ListNode(11);
        listOperate.connectListNodes(head1, node3);
        listOperate.connectListNodes(node3, node5);
        listOperate.connectListNodes(node5, node7);
        listOperate.connectListNodes(node7, node9);
        listOperate.showListNode(head1);
        System.out.println("...............................");
        listOperate.connectListNodes(head2, node4);
        listOperate.connectListNodes(node4, node6);
        listOperate.connectListNodes(node6, node8);
        listOperate.connectListNodes(node8, node10);
        listOperate.connectListNodes(node10, node11);
        listOperate.showListNode(head2);
        System.out.println("...............................");
        Solution30 solution30 = new Solution30();
        ListNode listNode = solution30.combineLinkedList(head1, head2);
        listOperate.showListNode(listNode);
    }

    /**
     * 其中一个链表为null
     */
    @Test
    public void testOneNull() {
        ListNode head1 = new ListNode(1);
        ListNode head2 = null;
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node7 = new ListNode(7);
        ListNode node9 = new ListNode(9);
        listOperate.connectListNodes(head1, node3);
        listOperate.connectListNodes(node3, node5);
        listOperate.connectListNodes(node5, node7);
        listOperate.connectListNodes(node7, node9);
        Solution30 solution30 = new Solution30();
        ListNode listNode = solution30.combineLinkedList(head1, head2);
        listOperate.showListNode(listNode);

    }

    /**
     * 两个链表都为null
     */
    @Test
    public void testTwoNull() {
        ListNode head1 = null;
        ListNode head2 = null;
        Solution30 solution30 = new Solution30();
        ListNode listNode = solution30.combineLinkedList(head1, head2);
        listOperate.showListNode(listNode);
    }



}
