package com.justnow.offer;


public class SingleLinkedList {

    private int size;

    public Node head;//头节点，默认头节点中不存在value，只有一个指向第一个节点的指针

    //初始化
    public SingleLinkedList(){
        size = 0;
        head = new Node();
    }

    //在链表的头部插入元素
    public Node addHead(int data){
        Node newHead = new Node(data);
        newHead.next = head.next;
        head.next = newHead;
        size++;
        return newHead;
    }

    /**
     * 删除node节点
     * @param linkedList
     * @param node
     */
    public void deleteNode(SingleLinkedList linkedList, Node node) {
        Node currentNode = linkedList.head;
        boolean flag = false;
        for (int i = 0; i < linkedList.size; i++) {
            if (currentNode.value == node.value) {
                System.out.println("I find the Node in this linkedList");
                break;
            }
            currentNode = currentNode.next;
        }
    }

    public void deleteNode2(Node head, Node toBeDeleted) {
        // 考虑边界条件：如果链表为空，或者要删除的内容为空
        if (head == null || toBeDeleted == null) {
            return;
        }

        // 待删除的节点不是尾节点
        if (toBeDeleted.next != null) {
            Node pNext = toBeDeleted.next;
            toBeDeleted.value = pNext.value;
            toBeDeleted.next = pNext.next;
            pNext = null;
        }
        // 链表只有一个节点，删除头节点（也是尾节点）
        else if (head.next == toBeDeleted) {
            toBeDeleted = null;
            head = null;
        }
        // 待删除的节点是尾节点
        else {
            Node pNode = head;
            while (pNode.next != toBeDeleted) {
                pNode = pNode.next;
            }
            pNode.next = null;
        }
    }

    public void display(){
        Node current = head.next;
        while(current != null) {
            System.out.println(current.value);
            current = current.next;
        }

    }
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addHead(10);
        singleLinkedList.addHead(20);
        singleLinkedList.addHead(5);
        singleLinkedList.addHead(18);
        //Node node = new Node(5);
        //singleLinkedList.deleteNode(singleLinkedList, node);
        singleLinkedList.display();
        System.out.println("------------------------------");
        Node node2 = singleLinkedList.head.next.next;
        singleLinkedList.deleteNode2(singleLinkedList.head, node2);
        singleLinkedList.display();
    }

}
