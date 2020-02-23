package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

import java.util.*;

/**
 * @author tanhq
 * @Description  LeetCode 107 二叉树的层序遍历  （变种）
 * @Date 2019/10/24 下午10:00
 * @Version 1.0
 **/
public class LevelOrder {

    /**
     * 分层从上往下遍历二叉树
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderTop(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //定义一个先进先出的队列
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
                //返回每层的最左值
//                if (i == 0) {
//                    list.add(node.val);
//                }
                list.add(node.val);
            }
            result.add(list);
        }

        return result;
    }

    /**
     * 分层从下往上遍历二叉树
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = levelOrderTop(root);
        Collections.reverse(result);
        return result;
    }

    /**
     * 深度优先搜索算法（Depth First Search）
     * DFS 遍历二叉树 先压栈右子树 然后左子树
     */
    public static List<Integer> DfsTree(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] array = {35,17,39,9,28,65,56,87};
        //初始化一个二叉树
        TreeNode nodeTree = new TreeNode(array[0]);
        for (int i = 1; i <array.length ; i++) {
            nodeTree.insert2(nodeTree, array[i]);
        }

        List<List<Integer>> list = levelOrderTop(nodeTree);
        list.stream().forEach(x -> System.out.println(x.toString() + "->"));
    }

}

 
    
    
    
    