package com.justnow.linkedlist.reverse;

import com.justnow.linkedlist.single.ListNode;


/**
 * 单链表的初始化
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *
 *     public ListNode(int val) {
 *         this.val = val;
 *     }
 *
 *     public ListNode() {
 *     }
 *
 *
 * }
 */
public class ReverseList {


    /**
     * 方法一：
     * 申请一个新的头结点，使用头插法插入数据
     * 时间：0 ms	内存消耗：37.1 MB
     * @param head
     * @return
     */
    public ListNode reverseList01(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode reverse = new ListNode(-1);//将其视为头结点
        ListNode current = head;// 使用这一步，可以确保head永远指向第一个结点
        ListNode temp;
        while (current != null) {
            temp = new ListNode(current.val);
            temp.next = reverse.next;
            reverse.next = temp;
            current = current.next;
        }
        return reverse.next;
    }

    /**
     * 方法二：
     * https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
     * 假如有一下链表：
     * 1->2->3->4->null
     * 链表反转后：
     * null<-1<-2<-3<-4
     * 这种解法秒就秒在，将后一个结点的next指向前一个。涉及到三个结点，是挺难的！
     * @param head
     * @return
     */
    public ListNode reverserList02(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
