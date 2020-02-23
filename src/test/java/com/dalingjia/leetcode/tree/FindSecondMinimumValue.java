package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

import java.util.*;

/**
 * @author tanhq
 * @Description 671 二叉树中第二小的结点
 * @Date 2019/9/8 下午9:20
 * @Version 1.0
 **/
public class FindSecondMinimumValue {

    Set<Integer> set = new HashSet<>();

    public int findSecondMinimumValue(TreeNode root) {

        inOrderFindSecond(root);

        if (set == null || set.size() < 2) {
            return -1;
        }
        int[] ints = new int[set.size()];
        int index = 0;
        for (Integer i : set) {
            ints[index++] = i;
        }
        Arrays.sort(ints);
        return ints[1];
    }

    private void inOrderFindSecond(TreeNode root) {
        if (root != null) {
            inOrderFindSecond(root.left);
            set.add(root.val);
            inOrderFindSecond(root.right);
        }
    }



    public int findSecondMinimumValue2(TreeNode root) {
        if(root == null || root.left == null && root.right == null) {
            return -1;
        }
        int left = root.left.val;
        int right = root.right.val;

        if(root.left.val == root.val)
            left = findSecondMinimumValue2(root.left);
        if(root.right.val == root.val)
            right = findSecondMinimumValue2(root.right);
        if (left != -1 && right != -1)
            return Math.min(left, right);
        else if (left != -1)
            return left;
        else
            return right;
    }
}

 
    
    
    
    