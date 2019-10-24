package com.justnow.tree.binarysearchtree;

public interface BinarySearchTree {
    // 查找节点
    public Node find(int key);
    // 插入新结点
    public boolean insert(int data);
    // 先序遍历
    public void preOrder(Node node);
    // 中序遍历
    public void inOrder(Node node);
    // 后序遍历
    public void postOrder(Node node);

    // 查找最大值
    public Node findMax();
    // 查找最小值
    public Node findMin();

    // 删除节点
    public boolean delete(int key);
}
