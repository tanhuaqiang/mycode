package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

/**
 * @author tanhq
 * @Description 700 二叉搜索树中的搜索
 * @Date 2019/9/15 下午6:30
 * @Version 1.0
 **/
public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        }
        return root;
    }


}

 
    
    
    
    