package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

import java.util.*;

/**
 * @author tanhq
 * @Description  637 二叉树的层平均值
 * @Date 2019/9/8 下午5:19
 * @Version 1.0
 **/
public class AverageOfLevels {

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        //定义一个队列
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            double num = 0;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                //取出队列中的元素
                TreeNode node = deque.poll();
                num += node.val;
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            result.add(num / size);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] array = {35,17,39,9,28};
        //初始化一个二叉树
        TreeNode nodeTree = new TreeNode(array[0]);
        for (int i = 1; i <array.length ; i++) {
            nodeTree.insert2(nodeTree, array[i]);
        }
        averageOfLevels(nodeTree);

    }
}

 
    
    
    
    