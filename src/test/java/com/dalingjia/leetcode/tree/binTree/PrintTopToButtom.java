package com.dalingjia.leetcode.tree.binTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PrintTopToButtom {

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * 思路：扫描二叉树时，用一个队列来存二叉树的结点，然后从该队列取出结点放到一个List中
     * @param root
     */
    public static List<Integer> printTopToButtom(TreeNode root){
        //1,定义一个队列
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        //2,定义一个集合
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        TreeNode current = root;
        //将元素加入队列
        queue.offer(root);
        while (queue.size() > 0){
            //取出队列中的结点
            current = queue.poll();
            //将结点放入集合
            result.add(current.val);
            if(current.left != null){
                queue.offer(current.left);
            }
            if(current.right != null){
                queue.offer(current.right);
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
        List list = printTopToButtom(nodeTree);
        list.stream().forEach(x -> System.out.print(x + "->"));
    }

}
