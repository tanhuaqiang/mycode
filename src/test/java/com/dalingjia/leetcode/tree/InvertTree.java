package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

/**
 * @author tanhq
 * @Description  leetcode 226 反转二叉树
 * @Date 2019/8/20 下午6:59
 * @Version 1.0
 **/
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        return root;
    }
}

 
    
    
    
    