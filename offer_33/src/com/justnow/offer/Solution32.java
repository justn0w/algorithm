package com.justnow.offer;


public class Solution32 {

    public boolean isSysmmetric(BinaryTreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(BinaryTreeNode treeNode1, BinaryTreeNode treeNode2) {
        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }

        //两者中其中一个为null，因为上一个if语句已经判断了是否同时为null
        if (treeNode1 == null || treeNode2 == null) {
            return false;
        }

        return (treeNode1.data == treeNode2.data) && isMirror(treeNode1.leftChild, treeNode2.rightChild)
                && isMirror(treeNode1.rightChild, treeNode2.leftChild);
    }
}
