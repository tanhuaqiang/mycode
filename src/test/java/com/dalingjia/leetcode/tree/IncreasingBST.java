package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

import java.util.*;

/**
 * @author tanhq
 * @Description  897 递增顺序查找树
 * @Date 2019/9/18 下午12:02
 * @Version 1.0
 **/
public class IncreasingBST {

    List<Integer> list = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {

        inOrderIncreasingBst(root);
        TreeNode node = new TreeNode(list.get(0));
        //定义一个指针
        TreeNode p = node;
        for (int i = 1; i < list.size(); i++) {
            p.right = new TreeNode(list.get(i));
            p = p.right;
        }
        return node;
    }

    private void inOrderIncreasingBst(TreeNode root) {
        if (root != null) {
            inOrderIncreasingBst(root.left);
            list.add(root.val);
            inOrderIncreasingBst(root.right);
        }
    }

}

 
    
    
    
    