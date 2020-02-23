package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

import java.util.*;

/**
 * @author tanhq
 * @Description  530 二叉搜索树的最小绝对差
 * @Date 2019/9/5 下午9:56
 * @Version 1.0
 **/
public class GetMinimumDifference {

    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        int min = Math.abs(list.get(0) - list.get(1));
        for (int i = 0; i < list.size()-1; i++) {
            int abs = Math.abs(list.get(i) - list.get(i + 1));
            min = Math.min(min, abs);
        }
        return min;
    }

    public void inOrder(TreeNode node){
        if(node != null){
            inOrder(node.left);
            list.add(node.val);
            inOrder(node.right);
        }
    }

}

 
    
    
    
    