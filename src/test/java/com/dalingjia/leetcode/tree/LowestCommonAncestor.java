package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

/**
 * @author tanhq
 * @Description  二叉搜索树最近公共祖先
 * @Date 2019/8/20 下午8:54
 * @Version 1.0
 **/
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null){
            return null;
        }
        /**
         * 1,两个节点最大值比根节点都小，那么公共祖先一定在根节点的左子树
         * 2,两个节点最小值比根节点都大，那么公共祖先一定在根节点的右子树
         * 3,两个节点在根节点的两边，则公共祖先为根节点
         */
        if(Math.max(p.val, q.val) < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(Math.min(p.val, q.val) > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }else {
            return root;
        }
    }
}

 
    
    
    
    