package com.dalingjia.leetcode.tree;

import com.dalingjia.leetcode.tree.binTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanhq
 * @Description  538 把二叉搜索树转换为累加数
 * @Date 2019/9/6 下午10:20
 * @Version 1.0
 **/
public class ConvertBST {

    List<Integer> list = new ArrayList<>();
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        //中序遍历
        inOrder(root);
        for (Integer i : list) {
            sum += i;
        }
        inOrder2(root);
        return root;
    }
    private void inOrder2(TreeNode node) {
        if (node != null) {
            inOrder2(node.left);
            int temp = node.val;
            node.val = sum;
            sum -= temp;
            inOrder2(node.right);
        }
    }
    private void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            list.add(node.val);
            inOrder(node.right);
        }
    }


    /**
     * 解法二：按照又中左的遍历顺序，效率最高
     */
    int result = 0;

    public TreeNode convertBST2(TreeNode root) {
        convert(root);
        return root;
    }

    public void convert(TreeNode cur) {
        if (cur == null){
            return;
        }
        convert(cur.right);
        cur.val += result;
        result = cur.val;
        convert(cur.left);
    }
}

 
    
    
    
    