package com.justnow.datastructure.Single.solution1;

public class SingleLinkedList {
    private int size;//链表结点的个数
    private Node head;//头结点

    public SingleLinkedList(){
        size = 0;
        head = null;
    }

    //链表中的每个节点类
    private class Node {
        private Object data; //节点数据
        private Node next; //每个结点指向下一个节点的指针

        public Node(Object data){
            this.data = data;
        }
        public String toString(){
            return "data:"+data;
        }
    }

    //在链表头插入新的元素
    public Object addHead(Object obj){
        Node newHead = new Node(obj);
        if(size == 0){
            head = newHead;
        }else{
            newHead.next = head;
            head = newHead;
        }
        size++;
        return obj;
    }

    //在链表头删除元素
    public Object deleteHead(){
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    //查找指定元素，知道后返回该节点，找不到返回null
    public Node find(Object obj){
        Node current = head;
        while(current != null){
            if(obj.equals(current.data)){
                return current;
            }else{
                current = current.next;
            }
        }

        return null;

    }

    //删除指定的元素，删除成功返回true

    public boolean delete(Object obj){
        if(size == 0){
            return false;
        }
        Node current = head;
        Node previous = head;

        while(current.data != obj){
            if(current.next == null){
                return false;
            }else{
                previous = current;
                current = current.next;
            }
        }

        //如果删除的节点是第一个节点
        if(current == head){
            head = current.next;
            size--;
        }else{//删除的节点不是第一个节点
            previous.next = current.next;
            size--;
        }

        return true;
    }

    //判读链表是否位空
    public boolean isEmpty(){
        if(size == 0)
            return true;
        else
            return false;
    }

    //显示节点信息
    public void display(){
        if(size >0){
            Node node = head;
            int tempSize = size;
            if(tempSize == 1){//当前链表只有一个节点
                System.out.println("["+node.data+"]");
                return;
            }
            while(tempSize>0){
                if(node.equals(head)){
                    System.out.print("["+node.data+"->");
                }else if(node.next == null){
                    System.out.print(node.data+"]");
                }else{
                    System.out.print(node.data+"->");
                }
                node = node.next;
                tempSize--;
            }
            System.out.println();
        }else{//如果链表一个节点都没有，直接打印[]
            System.out.println("[]");
        }

    }


}
