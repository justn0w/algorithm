package com.justnow.test;

import com.justnow.offer.Node;
import com.justnow.offer.SingleLinkedList;
import org.junit.Test;

public class Test21 {


    //1、从中间删除一个节点
    @Test
    public void testMiddleDeleted() {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addHead(100);
        linkedList.addHead(5);
        linkedList.addHead(3);
        linkedList.addHead(20);
        linkedList.addHead(17);
        linkedList.addHead(11);
        linkedList.display();
        // 测试删除的节点为第三个节点
        Node toBeDeleted = linkedList.head.next.next.next;
        System.out.println("待删除的节点是:" + toBeDeleted.value);
        linkedList.deleteNode2(linkedList.head, toBeDeleted);
        System.out.println("删除后的内容为:");
        linkedList.display();
    }

    //2、删除第一个节点
    @Test
    public void testHeadDeleted() {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addHead(100);
        linkedList.addHead(5);
        linkedList.addHead(3);
        linkedList.addHead(20);
        linkedList.addHead(17);
        linkedList.addHead(11);
        linkedList.display();
        // 测试删除的节点为第三个节点
        Node toBeDeleted = linkedList.head;
        System.out.println("待删除的节点是:" + toBeDeleted.value);
        linkedList.deleteNode2(linkedList.head, toBeDeleted);
        System.out.println("删除后的内容为:");
        linkedList.display();
    }

    //3、删除尾部节点
    @Test
    public void testTailDeleted() {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addHead(100);
        linkedList.addHead(5);
        linkedList.addHead(3);
        linkedList.addHead(20);
        linkedList.addHead(17);
        linkedList.addHead(11);
        linkedList.display();
        // 测试删除的节点为第三个节点
        Node toBeDeleted = linkedList.head.next.next.next.next.next.next;
        System.out.println("待删除的节点是:" + toBeDeleted.value);
        linkedList.deleteNode2(linkedList.head, toBeDeleted);
        System.out.println("删除后的内容为:");
        linkedList.display();
    }

}
