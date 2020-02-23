package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

/**
 * @author tanhq
 * @Description 687 最长同值路径
 * @Date 2019/9/9 下午5:02
 * @Version 1.0
 **/
public class LongestUnivaluePath {

    int maxLen;

    public int longestUnivaluePath(TreeNode root) {

        if (root == null) {
            return 0;
        }
        getMaxLen(root, root.val);
        return maxLen;
    }

    public int getMaxLen(TreeNode root, int val) {

        if (root == null) {
            return 0;
        }
        int left = getMaxLen(root.left, root.val);
        int right = getMaxLen(root.right, root.val);
        maxLen = Math.max(maxLen, left + right);
        if (root.val == val) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }

}

 
    
    
    
    