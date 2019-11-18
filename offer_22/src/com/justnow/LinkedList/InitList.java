package com.justnow.LinkedList;

public class InitList {
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

    /**
     * 从头开始打印链表
     * @param headNode
     */
    public void printList(ListNode headNode) {
        ListNode currentNode = headNode;
        while(currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }

    }

    /**
     * 打印该节点的val值
     * @param node
     */
    public void printListNode(ListNode node) {
        if (node == null) {
            System.out.println("The node is null");
        } else {
            System.out.println("The key in node is " + node.val);
        }
    }
}
