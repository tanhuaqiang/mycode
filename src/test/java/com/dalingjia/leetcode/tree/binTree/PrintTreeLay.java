package com.dalingjia.leetcode.tree.binTree;

import com.google.common.collect.Lists;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class PrintTreeLay {

    /**
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行
     * @param root
     * @return
     */
    public static List<List<TreeNode>> printTree(TreeNode root) {
        //分层放所有数据
        List<List<TreeNode>> result = Lists.newArrayList();
        if(root == null){
            return result;
        }
        //队列，先进先出
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode current = root;
        //将头结点放入队列
        deque.offer(current);
        while (deque.size()>0) {
            List<TreeNode> layList = Lists.newArrayList();
            //弹出队列中的所有元素
            while (deque.size() > 0) {
                current = deque.poll();
                layList.add(current);
            }
            result.add(layList);
            for (TreeNode node : layList) {
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
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
        List<List<TreeNode>> list = printTree(nodeTree);
        list.stream().forEach(x -> System.out.println(x.toString() + "->"));
        System.out.println("********************************");
        //反转集合
        Collections.reverse(list);
        list.stream().forEach(x -> System.out.println(x.toString() + "->"));


    }
}
