package com.justnow.offer;

/**
 * 操作二叉树的内容
 */
public class BinaryTreeOperate {

    /**
     * 创建二叉树节点
     * @param value
     * @return
     */
    public static BinaryTreeNode createBinaryTreeNode(int value) {
        BinaryTreeNode pNode = new BinaryTreeNode();
        pNode.data = value;
        pNode.leftChild = null;
        pNode.rightChild = null;
        return pNode;
    }

    /**
     * 按照父节点，左子节点，右子节点的顺序连接二叉树
     * @param pNode
     * @param pLeft
     * @param pRight
     */
    public static void connectTreeNodes(BinaryTreeNode pNode, BinaryTreeNode pLeft, BinaryTreeNode pRight) {
        if (pNode != null) {
            pNode.leftChild = pLeft;
            pNode.rightChild = pRight;
        }
    }

    /**
     * 打印当前节点和其左子节点和右子节点
     * @param pNode
     */
    public static void printTreeNode(BinaryTreeNode pNode) {
        if (pNode != null) {
            System.out.println("value of this node is: " + pNode.data);

            if (pNode.leftChild != null) {
                System.out.println("value of its left child is: " + pNode.leftChild.data);
            } else {
                System.out.println("left child is null");
            }
            if (pNode.rightChild != null) {
                System.out.println("value of its right child is: " + pNode.rightChild.data);
            } else {
                System.out.println("right child is null");
            }
        } else {
            System.out.println("this node is null");
        }
    }

    /**
     * 打印树
     * @param pNode
     */
    public static void printTree(BinaryTreeNode pNode) {
        printTreeNode(pNode);
        if (pNode != null) {
            if (pNode.leftChild != null)
                printTreeNode(pNode.leftChild);
            if (pNode.rightChild != null)
                printTreeNode(pNode.rightChild);
        }
    }



}
