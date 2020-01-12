package com.justnow.offer;


public class Solution31 {

    /**
     * 如果发现A中某一个节点值与和树B的头节点的值相同，则调用doseTree1HasTrees，进行第二步判断；否则返回false
     * @param A
     * @param B
     * @return
     */
    public boolean hasSubTree(BinaryTreeNode A, BinaryTreeNode B) {
        boolean result = false;//作为flag

        if (A != null && B != null) {
            if (A.data == B.data) {
                result = doseTree1HasTree2(A, B);
            }
            if (!result) {
                result = hasSubTree(A.leftChild, B);
            }
            if (!result) {
                result = hasSubTree(A.rightChild, B);
            }
        }
        return result;
    }

    /**
     * 递归进行判断以tree1为根节点的树和以tree2为节点的树是否有相同的结构
     * @param tree1
     * @param tree2
     * @return
     */
    public boolean doseTree1HasTree2(BinaryTreeNode tree1, BinaryTreeNode tree2) {
        // 当递归到tree1的叶子节点时，说明没有找到与tree2一致的子树，那么返回false
        if (tree1 == null) {
            return false;
        }
        // 当递归到tree2的叶子节点时，说明递归到该路径的分支是一致的。
        if (tree2 == null) {
            return true;
        }
        //如果两个节点的值不相等，直接返回false
        if (tree1.data != tree2.data) {
            return false;
        }
        //如果两个子树的当前节点一致，那么分别判断其左子树和右子树是否一致。
        return doseTree1HasTree2(tree1.leftChild, tree2.leftChild) && doseTree1HasTree2(tree1.rightChild, tree2.rightChild);
    }
}
