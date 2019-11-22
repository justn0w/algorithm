package com.justnow.linkedlist.single;


public class ListOperate {

    /**
     * 使用头插法，插入节点
     * @param head
     * @param val
     */
    public void addListNode(ListNode head, int val) {
        if (head == null) {
            System.out.println("此头结点不存在");
            return ;
        }
        ListNode node = new ListNode(val);
        node.next = head.next;
        head.next = node;
    }

}
