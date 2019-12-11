package com.justnow.linkedlist.looplaw;

import com.justnow.linkedlist.single.ListNode;
import com.justnow.linkedlist.single.ListOperate;

/**
 * @author JustNow
 * 早点休息吧
 */
public class LoopLaw {

    public static void main(String[] args) {
        ListOperate o = new ListOperate();
        ListNode head = new ListNode(1);
        o.addListNode(head, 6);
        o.addListNode(head, 5);
        o.addListNode(head, 4);
        o.addListNode(head, 3);
        o.addListNode(head, 2);
        o.showListNode(head);
        System.out.println("********************打印链表的长度********************");
        printLength(head);
        System.out.println("*******************打印指定节点的值*******************");
        getValue(head, 4);

    }

    /**
     * 打印链表的长度
     *
     * @param head
     */
    public static void printLength(ListNode head) {

        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        System.out.println(count);
    }

    /**
     * 根据location获取节点的值
     * @param head
     * @param location
     */
    public static void getValue(ListNode head, int location) {
        ListNode tail = new ListNode();
        tail.next = head;
        ListNode current = tail;
        for (int i = 0; i < location; i++){
            // 此时，如果for程序块中没有break，那么将会循环location次
            // 为了最终使current为第location个节点，那么第一次循环结束，current为第一个节点
            // 为了达到这个效果我们可以设置一个头结点，来实现
            current = current.next;
        }
        System.out.println("使用头结点\n" + "第" + location + "个节点的值为：" + current.val);
        ListNode currentTwo = head;
        for (int i = 0; i < location - 1; i++) {
            // 如果不使用头结点，也可以实现
            // 利用到链表的next指针特性，所以我们可以使用location-1次循环，然后使第一次循环结束后
            // current为第二个节点，第二次循环后，current为第三个节点，因为我们共进行了location-1次循环，那么最终current必定为
            // 第location个节点
            currentTwo = currentTwo.next;
        }
        System.out.println("不使用头结点\n" + "第" + location + "个节点的值为：" + currentTwo.val);

        int n = 0;
        while (n < location) {
            // while程序块，共循环了location次，还是和上述方法内容一致
            // 在此就不在赘述！
            n++;
        }
    }
}
