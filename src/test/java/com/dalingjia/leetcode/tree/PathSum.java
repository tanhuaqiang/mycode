package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

/**
 * @author tanhq
 * @Description  路径总和III
 * @Date 2019/8/23 上午10:04
 * @Version 1.0
 **/
public class PathSum {

    /**
     * 找出路径和等于给定数值的路径总数。
     * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     *
     * 思路：每个节点作为根节点，从上往下遍历一遍
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        //整个二叉树的根节点判断
        if(root == null){
            return 0;
        }
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    int dfs(TreeNode root, int sum) {
        int result = 0;
        //每个节点做判断
        if (root == null) {
            return result;
        }
        if(root.val == sum){
            result++;
        }
        result += dfs(root.left, sum - root.val);
        result += dfs(root.right, sum - root.val);
        return result;
    }
}

 
    
    
    
    