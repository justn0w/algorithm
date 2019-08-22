package com.justnow.datastructure.Single.solution2;

public class SingleLinkedList {
    private int size;
    private Node head;//头结点

    //初始化
    public SingleLinkedList(){
        size = 0;
        head = new Node();
    }

    //在链表的头部插入元素
    public void addHead(int data){
        Node newHead = new Node(data);
        newHead.next = head.next;
        head.next = newHead;
        size++;
    }

    //插入整数
    public void insert(int data, int index){
        if(index >= size){
            return;
        }
        Node node = new Node(data);
        Node preNode = head;
        while(index>1){//找到该值的索引,在索引前插入元素
            preNode = preNode.next;
            index--;
        }
        node.next = preNode.next;
        preNode.next = node;
        size++;
    }

    public void display(){
        Node current = head.next;
        for(int i=0; i<size;i++){
            System.out.println(current.data);
            current = current.next;
        }
    }

}
