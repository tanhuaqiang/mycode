package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

import java.util.*;

/**
 * @author tanhq
 * @Description  501 二叉搜索树中的众数
 * @Date 2019/9/5 下午6:53
 * @Version 1.0
 **/
public class FindMode {

    Map<Integer, Integer> map = new HashMap<>();
    //众数的个数
    int max = 0;
    List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        //中序遍历的结果恰好是所有结点的递增序列
        inOrder(root);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == max) {
                result.add(entry.getKey());
            }
        }
        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints;
    }

    private void inOrder(TreeNode root) {
        if(root != null){
            inOrder(root.left);
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            max = Math.max(max, map.get(root.val));
            inOrder(root.right);
        }
    }

}

 
    
    
    
    