package com.justnow.tree.binarysearchtree;

import java.util.Stack;

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

    /**
     * 递归查找节点
     * @param key
     * @return
     */
    @Override
    public Node findByRecursion(Node root, int key) {
        if (root == null)
            return null;
        if (root.data == key) {
            return root;
        } else if (root.data > key) { //当前节点值比查找值大，搜索左子树
            return findByRecursion(root.leftChild, key);
        } else if (root.data < key) { //当前节点值比查找值小，搜索右子树
            return findByRecursion(root.rightChild, key);
        }
        return null; //如果没有找到，就返回null
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

    /**
     * 非递归前序遍历
     * 根节点 -> 左子树 -> 右子树
     * @param root
     */
    @Override
    public void nonRecursivePreOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while ((current != null) || (!stack.isEmpty())) {
            if (current != null) {
                System.out.println(current.data);
                stack.push(current);
                current = current.leftChild;
            } else {
                current = stack.pop(); // 返回栈顶元素,
                current = current.rightChild;
            }
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

    /**
     * 非递归中序遍历
     * @param root
     */
    @Override
    public void nonRecursiveInOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while ((current != null) || (!stack.isEmpty())) {
            if (current != null ) {
                stack.push(current);
                current = current.leftChild;
            } else {
                current = stack.pop();
                System.out.println(current.data);
                current = current.rightChild;
            }
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

    /**
     * 非递归后序遍历
     * https://blog.csdn.net/superballball/article/details/83689248
     * https://blog.csdn.net/gatieme/article/details/51163010
     * @param root
     */
    @Override
    public void nonRecursivePostOrder(Node root) {
        /**
         * 对于任一结点P，将其入栈，然后沿其左子树一直往下搜索，直到搜索到没有左孩子的结点，此时该结点出现在栈顶，
         * 但是此时不能将其出栈并访问，因此其右孩子还为被访问。所以接下来按照相同的规则对其右子树进行相同的处理，
         * 当访问完其右孩子时，该结点又出现在栈顶，此时可以将其出栈并访问。这样就保证了正确的访问顺序。
         * 可以看出，在这个过程中，每个结点都两次出现在栈顶，只有在第二次出现在栈顶时，才能访问它。
         * 因此需要多设置一个变量标识该结点是否是第一次出现在栈顶。
         */
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while ((current != null) || (!stack.isEmpty())) {
            if (current != null) {
                current.isFirst = true; // 第一个访问该节点
                stack.push(current);
                current = current.leftChild; // 沿其左子树一直往下搜索，直到搜索到没有左孩子的节点。
            } else {
                current = stack.pop(); // 如果该节点为空，将其父节点弹出
                if (current.isFirst) { // 判断是否是第一次访问，如果是的话，还要将其再次入栈，然后将isFirst置为false，开始遍历其右子树
                    current.isFirst = false;
                    stack.push(current);
                    current = current.rightChild;
                } else {               // 如果该节点已经被访问了一次了，说明此时该节点为已经没有左右节点了或者其左右节点已经被打印完了，需要将其打印出来，并置为空
                    System.out.println(current.data);
                    current = null;
                }
            }
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


        //System.out.println(bt.find(50));
        //System.out.println(bt.findByRecursion(bt.root, 50));
        // 前序遍历
        //bt.preOrder(bt.root);
        //System.out.println("*********************************");
        //bt.nonRecursivePreOrder(bt.root);
        // 中序遍历
        //bt.inOrder(bt.root);
        // 后序遍历
        bt.postOrder(bt.root);
        bt.nonRecursivePostOrder(bt.root);
        // 查找最大值和最小值
        System.out.println("**************\n最大值");
        System.out.println(bt.findMax());
        System.out.println("**************\n最小值");
        System.out.println(bt.findMin());
    }

}
