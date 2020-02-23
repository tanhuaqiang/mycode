package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

import java.util.*;

/**
 * @author tanhq
 * @Description  653 两数这和 BST
 * @Date 2019/9/8 下午6:33
 * @Version 1.0
 **/
public class FindTarget {

    List<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {

        //中序遍历
        inOrderFindTarget(root);
        if (list == null || list.size() < 2) {
            return false;
        }
        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    private void inOrderFindTarget(TreeNode root) {
        if (root != null) {
            inOrderFindTarget(root.left);
            list.add(root.val);
            inOrderFindTarget(root.right);
        }
    }
}

 
    
    
    
    