package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

/**
 * @author tanhq
 * @Description 606  根据二叉树创建字符串
 * @Date 2019/9/7 下午6:59
 * @Version 1.0
 **/
public class Tree2str {


    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        String res = "";
        res += t.val;
        if (t.left != null) {
            res += "(" + tree2str(t.left) + ")";
        } else if (t.right != null) {
            res += "()";
        }
        if (t.right != null) {
            res += "(" + tree2str(t.right) + ")";
        }
        return res;
    }

}

 
    
    
    
    