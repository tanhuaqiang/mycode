package com.dalingjia.leetcode.tree.binTree;

public class TwoForkedTree {

    /*
     * 先序遍历,中左右
     * 先遍历根节点，然后遍历左节点，最后遍历右节点
     */
    private static void preOrder(TreeNode nodeTree){
        if(nodeTree != null){
            System.out.print(nodeTree.getVal()+"-");
            preOrder(nodeTree.getLeft());
            preOrder(nodeTree.getRight());
        }
    }

    //中序遍历
    private static void inOrder(TreeNode nodeTree){
        if(nodeTree != null){
            inOrder(nodeTree.getLeft());
            System.out.print(nodeTree.getVal()+"-");
            inOrder(nodeTree.getRight());
        }
    }

    //后序遍历
    private static void postOrder(TreeNode nodeTree){
         if(nodeTree != null){
            postOrder(nodeTree.getLeft());
            postOrder(nodeTree.getRight());
            System.out.print(nodeTree.getVal()+"-");
        }
    }

    public static void main(String[] args) {
        int[] array = {35,17,39,9,28,65,56,87,41};
        //初始化一个二叉查找树
        TreeNode nodeTree = new TreeNode(array[0]);
        for (int i = 1; i <array.length ; i++) {
            nodeTree.insert2(nodeTree, array[i]);
        }
        System.out.println("先序遍历：");
        preOrder(nodeTree);
        System.out.println();
        System.out.println("中序遍历：");
        inOrder(nodeTree);
        System.out.println();
        System.out.println("后序遍历：");
        postOrder(nodeTree);

    }

}
