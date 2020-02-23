package com.dalingjia.leetcode.tree.binTree;

public class CheckBalanceBinTree {

    /**
     * 判断树的深度
     * @param node
     * @return
     */
    public static int treeDept(TreeNode node){
        if(node == null){
            return 0;
        }
        int lh = treeDept(node.left);
        int rh = treeDept(node.right);
        return lh > rh ? (lh + 1) : (rh + 1);
    }

    /**
     * 判断一棵树是否是平衡二叉树：左右子树的高度差不超过1
     * @param node
     * @return
     */
    public static boolean checkBalance(TreeNode node){
        if(node == null){
            return true;
        }
        //判断左右子树的高度
        int lh = treeDept(node.left);
        int rh = treeDept(node.right);
        int diff = lh - rh;
        if(diff>1 || diff<-1){
            return false;
        }
        return checkBalance(node.left) && checkBalance(node.right);
    }


    public static void main(String[] args) {
        int[] array = {35,17,39,9,7,28,65,56,87,41};
        //初始化一个二叉树
        TreeNode nodeTree = new TreeNode(array[0]);
        for (int i = 1; i <array.length ; i++) {
            nodeTree.insert2(nodeTree, array[i]);
        }
        System.out.println(checkBalance(nodeTree));
    }

}
