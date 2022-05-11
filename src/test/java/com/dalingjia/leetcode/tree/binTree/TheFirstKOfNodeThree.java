package com.dalingjia.leetcode.tree.binTree;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 二叉搜索树的第k大节点
 */
public class TheFirstKOfNodeThree {

    private static List<Integer> list = Lists.newArrayList();

    /**
     * 给定一颗二叉搜索树，请找出其中的第k大的结点。
     * 例如，     5
     *          / \
     *         3  7
     *        /\  /\
     *       2 4  6 8
     * 按结点数值大小顺序第三个结点的值为4
     * @param node
     */
    public static void inOrder(TreeNode node){
        if(node != null){
            inOrder(node.left);
            list.add(node.val);
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        int[] array = {5,3,7,2,4,6,8};
        //初始化一个二叉树
        TreeNode nodeTree = new TreeNode(array[0]);
        for (int i = 1; i <array.length ; i++) {
            nodeTree.insert2(nodeTree, array[i]);
        }
        //中序遍历
        inOrder(nodeTree);
        for (int i = 0; i < list.size(); i++) {
            if((i+1) == 3){
                System.out.println(list.get(i));
            }
        }
    }

    static int index = 0;
    static int result = 0;
    public static int kthLargest(TreeNode node, int k) {
        find(node, k);
        return result;
    }

    private static void find(TreeNode node, int k) {
        if (node.right != null) {
            find(node.right, k);
        }
        index++;
        if (index == k) {
            result = node.val;
            return;
        }
        if (node.left != null) {
            find(node.left, k);
        }
    }
}
