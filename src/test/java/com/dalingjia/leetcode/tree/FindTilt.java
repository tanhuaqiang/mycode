package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

/**
 * @author tanhq
 * @Description  563 二叉树的坡度
 * @Date 2019/9/7 下午3:37
 * @Version 1.0
 **/
public class FindTilt {

    int res = 0;
    public int findTilt(TreeNode root) {
        postOrder(root);
        return res;
    }
    public int postOrder(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        res += Math.abs(left - right);
        return left + right + root.val;
    }
}

 
    
    
    
    