package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

/**
 * @author tanhq
 * @Description 993 二叉树的堂兄弟节点
 * @Date 2019/9/19 下午3:22
 * @Version 1.0
 **/
public class IsCousins {

    int xDeep, yDeep, deep = 0, flag = 0;   //用 flag 记录是否为同一父节点

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y);
        return xDeep == yDeep && flag == 0;
    }

    private void dfs(TreeNode node, int x, int y) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.right != null) {
            if (node.left.val == x && node.right.val == y) {
                flag = 1;
            } else if (node.left.val == y && node.right.val == x) {
                flag = 1;
            }
        }

        deep++;
        if (node.val == x) {
            xDeep = deep;
        }
        if (node.val == y) {
            yDeep = deep;
        }
        dfs(node.left, x, y);
        dfs(node.right, x, y);
        deep--; //遍历完当前节点所在子树后让当前深度 - 1；//递归过程中对每个节点都要累加的注意是否需要 - 1
    }
}

 
    
    
    
    