package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

import java.util.*;

/**
 * @author tanhq
 * @Description 783 二叉搜索树结点最小距离
 * @Date 2019/9/17 下午2:42
 * @Version 1.0
 **/
public class MinDiffInBST {

    List<Integer> list = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {

        inOrderMinDiffInBst(root);
        int min = Math.abs(list.get(0)-list.get(1));
        for (int i = 1; i < list.size()-1; i++) {
            int abs = Math.abs(list.get(i) - list.get(i + 1));
            if ( abs < min) {
                min = abs;
            }
        }
        return min;
    }

    private void inOrderMinDiffInBst(TreeNode root) {
        if (root != null) {
            inOrderMinDiffInBst(root.left);
            list.add(root.val);
            inOrderMinDiffInBst(root.right);
        }


    }
}

 
    
    
    
    