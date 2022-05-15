package com.dalingjia.test;

import com.dalingjia.leetcode.tree.binTree.TreeNode;
import java.util.*;
/**
 * @author tanhq
 * @Description TODO
 * @Date 2022/5/11 下午5:39
 * @Version 1.0
 **/
public class DidiTest {

    //层次遍历
    List<List<Integer>> list = new ArrayList();
    public void method(TreeNode node) {
        List<Integer> aList = new ArrayList<>();
        while (node != null) {
            List<Integer> bList = new ArrayList<>();
            aList.add(node.val);
            if (node.left != null) {
                bList.add(node.left.val);
            }
            if (node.right != null) {
                bList.add(node.right.val);
            }
            list.add(bList);
        }
    }

}

 
    
    
    
    