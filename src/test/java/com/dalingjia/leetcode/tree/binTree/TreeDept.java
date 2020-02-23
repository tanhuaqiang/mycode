package com.dalingjia.leetcode.tree.binTree;

/**
 * 二叉树的深度
 */
public class TreeDept {

    /**
     * 最大深度
     * @param root
     * @return
     */
    public static int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = treeDepth(root.left);
        int rh = treeDepth(root.right);
        return lh > rh ? (lh + 1) : (rh + 1);
    }

    /**
     * 最小深度
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int left = 0;
        int right = 0 ;
        if(root.left != null){
            left = minDepth(root.left);
        }else {
            left = Integer.MAX_VALUE;
        }
        if(root.right != null){
            right = minDepth(root.right);
        }else {
            right = Integer.MAX_VALUE;
        }
        return Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        int[] array = {3, 2};
        //初始化一个二叉树
        TreeNode nodeTree = new TreeNode(array[0]);
        for (int i = 1; i < array.length; i++) {
            nodeTree.insert2(nodeTree, array[i]);
        }

        System.out.println("maxDepth = " + treeDepth(nodeTree));
        System.out.println("minDepth = " + minDepth(nodeTree));
    }
}
