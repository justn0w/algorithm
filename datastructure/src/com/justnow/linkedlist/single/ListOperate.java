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

    /**
     * 创建一个单链表节点
     * @param value
     * @return
     */
    public ListNode createListNode(int value) {
        ListNode node = new ListNode();
        node.val = value;
        node.next = null;
        return node;
    }

    /**
     * 串联两个节点
     * @param currentNode
     * @param nextNode
     */
    public void connectListNodes(ListNode currentNode, ListNode nextNode) {
        if (currentNode == null) {
            System.out.println("error to connect two nodes");
        }

        currentNode.next = nextNode;
    }



}
