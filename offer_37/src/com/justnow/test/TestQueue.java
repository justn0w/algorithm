package com.justnow.test;

import com.justnow.offer.Solution37;
import com.justnow.offer.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
    Solution37 solution = new Solution37();

    @Test
    public void test() {
        Queue<Integer> queue = new LinkedList<>();
        //queue.remove();
        Integer poll = queue.poll();
        System.out.println(poll);
    }

    @Test
    public void testWay2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        ArrayList<Integer> arrayList = solution.PrintFromTopToBottom2(root);
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
    }

    @Test
    public void testWay2Null() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        ArrayList<Integer> arrayList = solution.PrintFromTopToBottom2(null);
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
    }

    @Test
    public void testByLevel() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        solution.PrintFromTopToBottomByLevel(root);
    }

}
