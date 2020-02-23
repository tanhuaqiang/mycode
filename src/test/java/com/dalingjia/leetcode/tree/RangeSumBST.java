package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

/**
 * @author tanhq
 * @Description 938 二叉
 * @Date 2019/9/18 下午6:29
 * @Version 1.0
 **/
public class RangeSumBST {

    int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {

        inOrderRangeSumBst(root, L, R);
        return sum;
    }

    private void inOrderRangeSumBst(TreeNode root, int l, int r) {
        if (root != null) {
            inOrderRangeSumBst(root.left, l, r);
            if (root.val >= l && root.val <= r) {
                sum += root.val;
            }
            inOrderRangeSumBst(root.right, l, r);
        }
    }


    public int rangeSumBST2(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }

        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }

        return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R);
    }
}

 
    
    
    
    