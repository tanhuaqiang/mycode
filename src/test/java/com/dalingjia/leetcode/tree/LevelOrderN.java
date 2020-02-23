package com.dalingjia.leetcode.tree;

import java.util.*;

/**
 * @author tanhq
 * @Description  LeetCode 429 N叉树的层序遍历
 * @Date 2019/8/22 下午9:31
 * @Version 1.0
 **/
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class LevelOrderN {

    /**
     * 递归法
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        addNode(ret, root, 0);
        return ret;
    }

    private void addNode(List<List<Integer>> ret, Node root, int i) {
        if(root == null){
            return;
        }
        //没往下一层，加一个list集合
        if(i >= ret.size()){
            ret.add(new ArrayList<Integer>());
        }
        //将第i层节点加入集合
        ret.get(i).add(root.val);
        for (Node node : root.children) {
            addNode(ret, node, i+1);
        }
    }

    /**
     * 队列实现
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(Node root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> ret = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque();
        queue.offer(root);
        while (queue.size() > 0) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();//取出
                queue.addAll(node.children);
                list.add(node.val);
            }
            ret.add(list);
        }
        return ret;
    }
}

 
    
    
    
    