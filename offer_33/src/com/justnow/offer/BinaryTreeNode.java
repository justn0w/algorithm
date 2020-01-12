package com.justnow.offer;

public class BinaryTreeNode {
    public int data;    //节点数据
    public BinaryTreeNode leftChild; //左子节点的引用
    public BinaryTreeNode rightChild;//右子节点的引用

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public BinaryTreeNode() {

    }
    //打印节点内容
    @Override
    public String toString() {
        return "value: " + data;
    }
}
