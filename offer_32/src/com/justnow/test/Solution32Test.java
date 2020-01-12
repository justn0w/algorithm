package com.justnow.test;


import com.justnow.offer.BinaryTreeNode;
import com.justnow.offer.BinaryTreeOperate;
import com.justnow.offer.Solution32;
import org.junit.Test;

public class Solution32Test {

    /**
     * 正常测试用例
     */
    @Test
    public void testNormal() {
        BinaryTreeNode pNode8 = BinaryTreeOperate.createBinaryTreeNode(8);
        BinaryTreeNode pNode6= BinaryTreeOperate.createBinaryTreeNode(6);
        BinaryTreeNode pNode10 = BinaryTreeOperate.createBinaryTreeNode(10);
        BinaryTreeNode pNode5 = BinaryTreeOperate.createBinaryTreeNode(5);
        BinaryTreeNode pNode7 = BinaryTreeOperate.createBinaryTreeNode(7);
        BinaryTreeNode pNode9 = BinaryTreeOperate.createBinaryTreeNode(9);
        BinaryTreeNode pNode11 = BinaryTreeOperate.createBinaryTreeNode(11);

        BinaryTreeOperate.connectTreeNodes(pNode8, pNode6, pNode10);
        BinaryTreeOperate.connectTreeNodes(pNode6, pNode5, pNode7);
        BinaryTreeOperate.connectTreeNodes(pNode10, pNode9, pNode11);

        BinaryTreeOperate.printTree(pNode8);

        Solution32 solution = new Solution32();
        solution.mirrorRecursively(pNode8);
        System.out.println("........................");
        BinaryTreeOperate.printTree(pNode8);

    }

    @Test
    public void testOnlyLeftChild() {
        BinaryTreeNode pNode8 = BinaryTreeOperate.createBinaryTreeNode(8);
        BinaryTreeNode pNode6= BinaryTreeOperate.createBinaryTreeNode(6);
        BinaryTreeNode pNode10 = BinaryTreeOperate.createBinaryTreeNode(10);
        BinaryTreeNode pNode5 = BinaryTreeOperate.createBinaryTreeNode(5);
        BinaryTreeNode pNode7 = BinaryTreeOperate.createBinaryTreeNode(7);
        BinaryTreeNode pNode9 = BinaryTreeOperate.createBinaryTreeNode(9);
        BinaryTreeNode pNode11 = BinaryTreeOperate.createBinaryTreeNode(11);

        BinaryTreeOperate.connectTreeNodes(pNode8, pNode6, null);
        BinaryTreeOperate.connectTreeNodes(pNode6, pNode10, null);
        BinaryTreeOperate.connectTreeNodes(pNode10, pNode5, null);
        BinaryTreeOperate.connectTreeNodes(pNode5, pNode7, null);
        BinaryTreeOperate.connectTreeNodes(pNode7, pNode9, null);
        BinaryTreeOperate.connectTreeNodes(pNode9, pNode11, null);

        BinaryTreeOperate.printTree(pNode8);
        Solution32 solution = new Solution32();
        solution.mirrorRecursively(pNode8);
        System.out.println("........................");
        BinaryTreeOperate.printTree(pNode8);
    }





}
