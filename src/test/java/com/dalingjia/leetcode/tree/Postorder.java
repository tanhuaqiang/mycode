package com.dalingjia.leetcode.tree;

import java.util.*;

/**
 * @author tanhq
 * @Description  590 N叉树的后续遍历
 * @Date 2019/9/7 下午4:37
 * @Version 1.0
 **/
public class Postorder {

    List<Integer> list = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root != null) {
            for (Node node : root.children) {
                postorder(node);
            }
            list.add(root.val);
        }
        return list;
    }

}

 
    
    
    
    