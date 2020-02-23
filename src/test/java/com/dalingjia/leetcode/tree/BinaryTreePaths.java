package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

import java.util.*;
/**
 * @author tanhq
 * @Description 二叉树的所有路径
 * @Date 2019/8/21 上午9:56
 * @Version 1.0
 **/
public class BinaryTreePaths {

    /**
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        addList(root, list, "");
        return list;
    }

    private void addList(TreeNode root, List<String> list, String s) {
        if(root == null){
            return;
        }
        s += String.valueOf(root.val);
        if(root.left != null){
            addList(root.left, list, s + "->");
        }
        if(root.right != null){
            addList(root.right, list, s + "->");
        }
        if(root.left == null && root.right == null){
            list.add(s);
        }
    }

    public static void main(String[] args) {
        System.out.println("->".length());
    }
}

 
    
    
    
    