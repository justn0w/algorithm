package com.justnow.offer.test;

import com.justnow.LinkedList.InitList;
import com.justnow.LinkedList.ListNode;
import com.justnow.offer.Solution22;
import org.junit.Test;

public class Test22 {


    @Test
    public void testNormal() {
        InitList init = new InitList();
        Solution22 so = new Solution22();
        ListNode listNode1 = init.createListNode(1);
        ListNode listNode2 = init.createListNode(2);
        ListNode listNode3 = init.createListNode(3);
        ListNode listNode4 = init.createListNode(3);
        ListNode listNode5 = init.createListNode(3);
        ListNode listNode6 = init.createListNode(7);
        ListNode listNode7 = init.createListNode(10);

        init.connectListNodes(listNode1, listNode2);
        init.connectListNodes(listNode2, listNode3);
        init.connectListNodes(listNode3, listNode4);
        init.connectListNodes(listNode4, listNode5);
        init.connectListNodes(listNode5, listNode6);
        init.connectListNodes(listNode6, listNode7);

        init.printList(listNode1);
        ListNode newlistNode1 = so.deleteDuplication(listNode1);
        init.printList(newlistNode1);


    }
}
