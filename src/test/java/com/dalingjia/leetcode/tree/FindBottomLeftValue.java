package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

/**
 * @author tanhq
 * @Description
 *          leetcode 513  找树左下角的值
 *          猿辅导笔试题：给定一棵二叉树，要求寻找其最下面一层的最左边叶子
 * @Date 2019/11/18 上午2:00
 * @Version 1.0
 **/
public class FindBottomLeftValue {

    int res = 0;
    int h = 0;

    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 1);
        return res;
    }

    public void findBottomLeftValue(TreeNode root, int depth) {
        if (h < depth) {
            res = root.val;
            h = depth;
        }
        if (root.left != null) {
            findBottomLeftValue(root.left, depth + 1);
        }
        if (root.right != null) {
            findBottomLeftValue(root.right, depth + 1);
        }
    }

}

 
    
    
    
    