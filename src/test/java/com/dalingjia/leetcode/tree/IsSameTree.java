package com.dalingjia.leetcode.tree;


import com.dalingjia.leetcode.tree.binTree.TreeNode;

/**
 * 判断两棵树是否相同
 */
public class IsSameTree {


    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if(p.val != q.val){
                return false;
            }else {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }else {
            if(p == null && q == null){
                return true;
            }else {
                return false;
            }
        }

    }
}
