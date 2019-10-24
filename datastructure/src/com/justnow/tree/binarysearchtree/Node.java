package com.justnow.tree.binarysearchtree;

public class Node {
    public int data;    //节点数据
    public Node leftChild; //左子节点的引用
    public Node rightChild;//右子节点的引用
    boolean isDelete; //表示节点是否被删除

    public Node(int data) {
        this.data = data;
    }

    //打印节点内容

    @Override
    public String toString() {
        return "value: " + data;
    }
}
