package com.justnow.offer;

public class Solution32 {

    /**
     * 方法一
     * 递归实现
     * @param pNode
     */
    public void mirrorRecursively(BinaryTreeNode pNode) {
        if (pNode == null) {
            return;
        }

        /**
         * 说明为叶子节点，不用再反转了
         */
        if (pNode.leftChild == null && pNode.rightChild == null) {
            return;
        }

        BinaryTreeNode temp = pNode.leftChild;
        pNode.leftChild = pNode.rightChild;
        pNode.rightChild = temp;

        if (pNode.leftChild != null) {
            mirrorRecursively(pNode.leftChild);
        }

        if (pNode.rightChild != null) {
            mirrorRecursively(pNode.rightChild);
        }
    }


    /**
     * 方法二
     * 非递归，用循环的方式实现
     * @param pNode
     */
    public void mirrorIteratively(BinaryTreeOperate pNode) {

    }
}
