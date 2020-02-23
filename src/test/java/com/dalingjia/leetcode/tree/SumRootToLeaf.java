package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

/**
 * @author tanhq
 * @Description 1022 从根到叶的二进制数之和
 * @Date 2019/9/19 下午6:54
 * @Version 1.0
 **/
public class SumRootToLeaf {

    public int sumRootToLeaf(TreeNode root) {
        return def(root, 0);
    }

    public int def(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = 2 * sum + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        int leftSum = root.left == null ? 0 : def(root.left, sum);
        int rightSum = root.right == null ? 0 : def(root.right, sum);
        return leftSum + rightSum;
    }
}

 
    
    

    