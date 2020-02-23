package com.dalingjia.leetcode.tree.binTree;

import org.junit.Test;

/**
 * 判断一棵树是否是平衡二叉树：
 *      一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        int abs = Math.abs(left - right);
        if(abs > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }


    private int treeDepth(TreeNode node) {
        if(node == null){
            return 0;
        }
        int lh = treeDepth(node.left);
        int rh = treeDepth(node.right);
        return lh > rh ? (lh + 1) : (rh + 1);
    }

    @Test
    public void test() {
        int[] array = {35,17,39,9,7,28,65,56,87,41};
        //初始化一个二叉树
        TreeNode nodeTree = new TreeNode(array[0]);
        for (int i = 1; i <array.length ; i++) {
            nodeTree.insert2(nodeTree, array[i]);
        }
        System.out.println(isBalanced(nodeTree));
    }
}
