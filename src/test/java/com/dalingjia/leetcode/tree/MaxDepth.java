package com.dalingjia.leetcode.tree;

import java.util.List;

/**
 * @author tanhq
 * @Description  559 N叉树的最大深度
 * @Date 2019/9/7 下午12:06
 * @Version 1.0
 **/
public class MaxDepth {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return nodeDept(root);
    }

    /**
     * 利用递归算法，以及深度优先遍历的思想，值得注意的是要用一个max来临时记录最大值
     * @param node
     * @return
     */
    private int nodeDept(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.children == null) {
            return 1;
        }
        int max = 0;
        for (Node n : node.children) {
            int d = nodeDept(n);
            max = Math.max(max, d);
        }
        return max + 1;
    }
}

 
    
    
    
    