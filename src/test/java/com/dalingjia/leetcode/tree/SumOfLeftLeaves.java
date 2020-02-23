package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

/**
 * @author tanhq
 * @Description 左叶子之和
 * @Date 2019/8/22 下午4:39
 * @Version 1.0
 **/
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null || root.right != null) {
            sum += sumOfLeftLeaves(root.left, true);
            sum += sumOfLeftLeaves(root.right, false);
        } else if (isLeft) {
            sum += root.val;
        }
        return sum;
    }
}

 
    
    
    
    