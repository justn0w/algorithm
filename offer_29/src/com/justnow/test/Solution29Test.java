package com.justnow.test;

import com.justnow.offer.ListNode;
import com.justnow.offer.ListOperate;
import com.justnow.offer.Solution29;
import org.junit.Test;

public class Solution29Test {

    ListOperate listOperate = new ListOperate();
    ListNode head = new ListNode(1);

    @Test
    public void testNormal() {
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        listOperate.connectListNodes(head, node2);
        listOperate.connectListNodes(node2, node3);
        listOperate.connectListNodes(node3, node4);
        listOperate.connectListNodes(node4, node5);
        listOperate.showListNode(head);
        Solution29 solution29 = new Solution29();
        ListNode reverseListNode = solution29.reverseListNode(head);
        System.out.println("..................................");
        listOperate.showListNode(reverseListNode);
    }

    @Test
    public void testOnly() {
        Solution29 solution29 = new Solution29();
        ListNode reverseListNode = solution29.reverseListNode(head);
        System.out.println("..................................");
        listOperate.showListNode(reverseListNode);
    }

}
