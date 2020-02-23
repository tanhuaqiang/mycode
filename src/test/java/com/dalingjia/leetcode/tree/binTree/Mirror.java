package com.dalingjia.leetcode.tree.binTree;

public class Mirror {

    public static void mirror(TreeNode nodeTree) {
        if(nodeTree == null){
            return;
        }
        //交换当前结点的左右子节点就好
        TreeNode temp = nodeTree.left;
        nodeTree.left = nodeTree.right;
        nodeTree.right = temp;

        mirror(nodeTree.left);
        mirror(nodeTree.right);
    }

    public static void main(String[] args) {
        int[] array = {8,6,10,5,7,9,11};
        //初始化一个二叉树
        TreeNode nodeTree = new TreeNode(array[0]);
        for (int i = 1; i <array.length ; i++) {
            nodeTree.insert2(nodeTree, array[i]);
        }
        mirror(nodeTree);
    }
}
