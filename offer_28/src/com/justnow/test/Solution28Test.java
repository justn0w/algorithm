package com.justnow.test;

import com.justnow.offer.ListNode;
import com.justnow.offer.ListOperate;
import com.justnow.offer.Solution28;
import org.junit.Test;

public class Solution28Test {
    ListOperate listOperate = new ListOperate();
    ListNode head = new ListNode(1);

    @Test
    public void normalListNode() {
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        listOperate.connectListNodes(head, node2);
        listOperate.connectListNodes(node2, node3);
        listOperate.connectListNodes(node3, node4);
        listOperate.connectListNodes(node4, node5);
        listOperate.connectListNodes(node5, node6);
        listOperate.connectListNodes(node6, node4);
        Solution28 solution28 = new Solution28();
        //ListNode listNode = solution28.hasCycle2(head);
        ListNode listNode1 = solution28.EntryNodeOfLoop(head);

        System.out.println(listNode1.val);
    }

    /**
     * 测试只有一个节点的情况
     */
    @Test
    public void onlyOneNode() {
        Solution28 solution28 = new Solution28();
        ListNode listNode = solution28.EntryNodeOfLoop(head);
        System.out.println(listNode);
    }

    @Test
    public void nullNode() {
        Solution28 solution28 = new Solution28();
        ListNode listNode = solution28.EntryNodeOfLoop(null);
        System.out.println(listNode);
    }
}
