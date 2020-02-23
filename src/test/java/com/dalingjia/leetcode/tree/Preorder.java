package com.dalingjia.leetcode.tree;

import java.util.*;

/**
 * @author tanhq
 * @Description  589 N叉树的前序遍历
 * @Date 2019/9/7 下午4:31
 * @Version 1.0
 **/
public class Preorder {

    List<Integer> list = new ArrayList<>();

    //N叉树的前序遍历
    public List<Integer> preorder(Node root) {

        if (root != null) {
            list.add(root.val);
            for (Node node : root.children) {
                preorder(node);
            }
        }
        return list;
    }
}

 
    
    
    
    