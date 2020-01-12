package com.justnow.offer;

import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution37 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current = root;
        while (current != null || !queue.isEmpty()) {
            arrayList.add(current.val);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
            current = queue.poll(); //删除队列头部的元素，并返回该节点
        }
        return arrayList;
    }

    public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
        if (root == null)
            return new ArrayList<>(); // 因为题目要求，当我们的结果为空时，应该返回一个[];
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            current = queue.poll(); //删除队列头部的元素，并返回该节点
            arrayList.add(current.val);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return arrayList;
    }

    /**
     * 从上到下打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行
     *
     * @param root
     */
    public void PrintFromTopToBottomByLevel(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current = root;
        int toBePrint = 1; // 表示当前层中还没有打印的节点数
        int nextLevel = 0; // 表示下一层节点的数目
        queue.add(root);
        while (!queue.isEmpty()) {
            current = queue.poll();
            System.out.print(current.val + " "); //
            --toBePrint;
            if (current.left != null) {
                queue.add(current.left);
                nextLevel++;

            }
            if (current.right != null) {
                queue.add(current.right);
                nextLevel++;
            }
            if (toBePrint == 0) { //
                System.out.println("");
                toBePrint = nextLevel;
                nextLevel = 0;
            }
        }
    }


    /**
     * 从上到下打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行
     *
     * @param pRoot
     */
    public ArrayList<ArrayList<Integer>> PrintFromTopToBottomByLevel2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> layerList = new ArrayList<>();
        TreeNode current = pRoot;
        int toBePrint = 1; // 表示当前层中还没有打印的节点数
        int nextLevel = 0; // 表示下一层节点的数目
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            current = queue.poll();
            layerList.add(current.val);
            --toBePrint;
            if (current.left != null) {
                queue.add(current.left);
                nextLevel++;

            }
            if (current.right != null) {
                queue.add(current.right);
                nextLevel++;
            }
            if (toBePrint == 0) { //
                list.add(layerList);
                layerList = new ArrayList<>();
                toBePrint = nextLevel;
                nextLevel = 0;
            }

        }
        return list;
    }

    /**
     * 从上到下打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行
     *
     * @param pRoot
     */
    public ArrayList<ArrayList<Integer>> PrintFromTopToBottomByLevel3(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> layerList = new ArrayList<>();
        TreeNode current = pRoot;
        int start = 0;
        int end = 1; // 表示每层的个数，初始值为第一个节点
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            current = queue.poll();
            layerList.add(current.val);
            start++;
            if (current.left != null) {
                queue.add(current.left);


            }
            if (current.right != null) {
                queue.add(current.right);

            }
            if (start == end) { // 当前层已经添加完毕
                start = 0;
                end = queue.size(); //下一层的个数
                list.add(layerList);
                layerList = new ArrayList<>();
            }

        }
        return list;
    }
    /**
     * 以之字形打印二叉树中的节点值
     *
     * @param root
     */
    public ArrayList<ArrayList<Integer>> PrintFromTopToBottomByZhi(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<TreeNode> stack1 = new Stack<>(); //保存奇数层节点
        Stack<TreeNode> stack2 = new Stack<>(); //保存偶数层节点

        int level = 1;
        stack1.push(root);

        while (!stack1.empty() || !stack2.empty()) {

            if (level % 2 != 0) { //为奇数层
                ArrayList<Integer> list1 = new ArrayList<>(); //用array来判断当前曾是否
                while (!stack1.empty()) {
                    TreeNode node = stack1.pop();

                    list1.add(node.val);
                    if (node.left != null)
                        stack2.push(node.left);
                    if (node.right != null)
                        stack2.push(node.right);
                }
                if (!list1.isEmpty()) {
                    // while循环结束说明当前层为已经输出完毕，开始进入下一层
                    list.add(list1);
                    level++;
                }

            } else {
                ArrayList<Integer> list2 = new ArrayList<>();
                while (!stack2.empty()) {
                    TreeNode node = stack2.pop();

                    list2.add(node.val);
                    if (node.right != null)
                        stack1.push(node.right);
                    if (node.left != null)
                        stack1.push(node.left);
                }
                if (!list2.isEmpty()) {
                    // while循环结束说明当前层为已经输出完毕，开始进入下一层。
                    list.add(list2);
                    level++;
                }
            }
        }
        return list;
    }
}
