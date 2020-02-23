package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

/**
 * @author tanhq
 * @Description  543 二叉树的直径
 * @Date 2019/9/6 下午11:17
 * @Version 1.0
 **/
public class DiameterOfBinaryTree {

    int maxLen =0;
    public int diameterOfBinaryTree(TreeNode root) {
        pathLen(root);
        return maxLen;
    }

    public int pathLen(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = pathLen(root.left);
        int right = pathLen(root.right);
        maxLen = Math.max(maxLen, left+right);
        return Math.max(left+1, right+1);
    }
}

 
    
    
    
    