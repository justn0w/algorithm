package com.justnow.test;


import com.justnow.offer.ListNode;
import com.justnow.offer.ListOperate;
import com.justnow.offer.Solution27;
import org.junit.Test;

public class Solution27Test {
    ListOperate listOperate = new ListOperate();
    ListNode head = new ListNode(1);

    Solution27 solution27 = new Solution27();
    public Solution27Test() {
        listOperate.addListNode(head, 6);
        listOperate.addListNode(head, 5);
        listOperate.addListNode(head, 4);
        listOperate.addListNode(head, 3);
        listOperate.addListNode(head, 2);
        listOperate.showListNode(head);
    }
    @Test
    public void testMyWay() {
        int i = solution27.kthEleFromTheBottom(head, 6);
        System.out.println("//////");
        System.out.println(i);
    }

    /**
     * k大于链表长度时会出现什么情况
     */
    @Test
    public void testUnnormal() {
        int i = solution27.kthEleFromTheBottom(head, 7);
        System.out.println("//////");
        System.out.println(i);
    }
}
