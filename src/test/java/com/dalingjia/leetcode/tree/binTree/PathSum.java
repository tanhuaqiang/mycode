package com.dalingjia.leetcode.tree.binTree;

/**
 * 判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null && root.val == sum){
            return true;
        }
        //核心：计算剩下的值是否与当前叶子节点相同
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
