package com.justnow.tree.binarysearchtree;

public class BinaryTreeMain implements BinarySearchTree {

    // 表示根节点
    private Node root;

    // 查找节点
    @Override
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.data > key) {//当前节点值比查找值大，搜索左子树
                current = current.leftChild;
            } else if (current.data < key) {//当前节点值比查找值小，搜索右子树
                current = current.rightChild;
            } else {
                return current;
            }
        }
        return null; // 遍历完整个树每找到，返回null
    }

    // 插入节点
    @Override
    public boolean insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {//当前树为空树，没有任何节点
            root = newNode;
            return true;
        } else {
            Node current = root;
            Node parentNode = null;
            // 这里一直循环效果更好
            while (true) {
                parentNode = current;
                if (current.data > data) {// 当前值比插入值大，搜索左子节点
                    current = current.leftChild;
                    if (current == null) {// 左子节点为空，直接将新值插入到该节点
                        parentNode.leftChild = newNode;
                        return true;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {// 右子节点为空，直接将新值插入到该节点
                        parentNode.rightChild = newNode;
                        return true;
                    }
                }
            }
        }
    }

    // 前序遍历
    // 根节点 -> 左子树 -> 右子树
    @Override
    public void preOrder(Node current) {
        if (current != null) {
            System.out.println(current.data + " ");
            preOrder(current.leftChild);
            preOrder(current.rightChild);
        }
    }

    // 中序遍历
    // 左子树 -> 根节点 -> 右子树
    @Override
    public void inOrder(Node current) {
        if (current != null) {
            preOrder(current.leftChild);
            System.out.println(current.data + " ");
            preOrder(current.rightChild);
        }
    }

    // 后序遍历
    // 左子树 -> 右子树 -> 根节点
    @Override
    public void postOrder(Node current) {
        if (current != null) {
            postOrder(current.leftChild);
            postOrder(current.rightChild);
            System.out.println(current.data + " ");
        }
    }

    // 找最大值
    @Override
    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        while (current != null) {
            maxNode = current;
            current = current.rightChild;
        }
        return maxNode;
    }

    @Override
    public Node findMin() {
        Node current = root;
        Node minNode = current;
        while (current != null) {
            minNode = current;
            current = current.leftChild;
        }
        return minNode;
    }

    /**
     * 删除节点
     * @param data
     * @return
     */
    @Override
    public boolean delete(int data) {
        return false;
    }

    public static void main(String[] args) {
        BinaryTreeMain bt = new BinaryTreeMain();
        // 插入数据内容
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);
        bt.insert(30);
        bt.insert(60);
        bt.insert(90);
        bt.insert(25);
        bt.insert(85);
        bt.insert(100);

        System.out.println(bt.find(50));
        // 前序遍历
        bt.preOrder(bt.root);
        // 中序遍历
        bt.inOrder(bt.root);
        // 后序遍历
        bt.postOrder(bt.root);

        // 查找最大值和最小值
        System.out.println("**************\n最大值");
        System.out.println(bt.findMax());
        System.out.println("**************\n最小值");
        System.out.println(bt.findMin());


    }

}
