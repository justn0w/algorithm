package com.justnow.offer;


import java.util.List;

public class Solution27 {

    public int kthEleFromTheBottom(ListNode head, int k) {
        if (head == null || k < 0) {
            return -1;
        }
        ListNode target = head;
        ListNode tail = head;
/*
        while (k > 1) {
            tail = tail.next;
            if (tail == null) {
                // 说明k-1>链表的长度
                return -1;
            }
            k--;
        }
*/

        //我的版本,使用for循环
/*
        for (int i = 0; i < k- 1; i++) {
            tail = tail.next;
            if (tail == null) {
                return -1;
            }

        }
*/
        // 书上的版本
        for (int i = 0; i < k- 1; i++) {
            // 将例外情况写到else分支，if下为主要的业务逻辑
            if (tail.next != null) {
                tail = tail.next;
            } else {
                return -1;
            }
        }

        //System.out.println(tail.val);

        while (tail.next != null) {
            tail =  tail.next;
            target = target.next;
        }
        return target.val;
    }
}
