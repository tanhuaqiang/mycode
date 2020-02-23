package com.dalingjia.leetcode.tree.binTree;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树
 */
public class SortArrayToBST {

    public static TreeNode sortedArrayToBST(int[] arr) {
        if(arr == null){
            return null;
        }
        return createTreeNode(arr, 0, arr.length - 1);
    }

    private static TreeNode createTreeNode(int[] arr, int l, int r) {
        if(l <= r){
            int mid = (l + r)/2;
            TreeNode treeNode = new TreeNode(arr[mid]);
            treeNode.left = createTreeNode(arr, l, mid - 1);
            treeNode.right = createTreeNode(arr, mid + 1, r);
            return treeNode;
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        int[] arr = {-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(arr);
        System.out.println(treeNode);
    }
}
