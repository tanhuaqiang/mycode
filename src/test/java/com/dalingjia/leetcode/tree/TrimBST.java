package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

/**
 * @author tanhq
 * @Description  669 修剪二叉搜索树
 * @Date 2019/9/8 下午7:28
 * @Version 1.0
 **/
public class TrimBST {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }

        if (root.val >= L && root.val <= R) {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }

        if(root.val < L) {
            return trimBST(root.right, L, R);
        }

        //root.val > R
        return trimBST(root.left, L, R);

    }
}

 
    
    
    
    