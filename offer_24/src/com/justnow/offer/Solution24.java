package com.justnow.offer;

import com.justnow.offer.LinkedList.ListNode;

public class Solution24 {

    /**
     * 返回一个专置的链表的头结点
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {

        ListNode reverseHead = new ListNode();
        ListNode currentNode = head.next;
        ListNode temp;
        while(currentNode != null) {
            // 创建新的节点，并将其使用头插法，实现插入节点
            temp = new ListNode(currentNode.val);
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            currentNode = currentNode.next;
        }
        return reverseHead;
    }

    /**
     * 判断是否是回文字符串，其中节点的头节点为空节点，即其中没有数据
     * @param head
     * @return
     */
    public boolean charge(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode reverse = reverse(head);
        reverse = reverse.next;
        ListNode currentNode = head.next;
        while(currentNode != null) {
            if (currentNode.val != reverse.val) {
                return false;
            }
            currentNode = currentNode.next;
            reverse = reverse.next;
        }
        return true;
    }
}
