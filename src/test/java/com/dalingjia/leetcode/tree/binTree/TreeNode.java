package com.dalingjia.leetcode.tree.binTree;

/**
 * 二叉查找树（又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树：
 *      若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 *      若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 *      它的左、右子树也分别为二叉排序树。
 */
public class TreeNode {

    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(Integer val) {
        this.val = val;
    }

    //插入数据
    public void insert(TreeNode node , int val){
        //插入的数比该节点小，放节点的左边
        if (val < node.getVal()){
            if(node.getLeft() == null){
                node.setLeft(new TreeNode(val));
            }else {
                insert(node.getLeft(),val);
            }
            //val比节点数大，放右边
        }else if(val > node.getVal()){
            if(node.getRight() == null){
                node.setRight(new TreeNode(val));
            }else{
                insert(node.getRight(),val);
            }
        }else{
            try {
                throw new Exception("二叉树不允许有重复的元素");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    public static void insert2(TreeNode node, int value){
        int val = node.val;
        if(value < val){
            if(node.left != null){
                insert2(node.left, value);
            }else {
                node.left = new TreeNode(value);
            }
        }else if(value > val){
            if(node.right != null){
                insert2(node.right, value);
            }else {
                node.right = new TreeNode(value);
            }
        }else {
            try {
                throw new Exception("二叉树不允许有重复元素");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建一个普通的二叉树
     * @param node
     * @param arr
     * @param i
     */
    public static void createTree(TreeNode node, int[] arr, int i){

    }

    @Override
    public String toString() {
        return "NodeTree{" +
                "val=" + val +
                '}';
    }
}
