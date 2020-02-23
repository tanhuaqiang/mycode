package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tanhq
 * @Description  965 单值二叉树
 * @Date 2019/9/18 下午10:48
 * @Version 1.0
 **/
public class IsUnivalTree {

    Set<Integer> set = new HashSet<>();

    public boolean isUnivalTree(TreeNode root) {

        inOrderIsUnivalTree(root);
        return set.size() == 1;
    }

    private void inOrderIsUnivalTree(TreeNode root) {
        if (root != null) {
            inOrderIsUnivalTree(root.left);
            set.add(root.val);
            inOrderIsUnivalTree(root.right);
        }
    }
}

 
    
    
    
    