package com.dalingjia.swordOffer.BinaryTree;

/* 重建二叉树
 * 问题描述：输入某二叉树的前序遍历和中序遍历结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不包含重复的数字。
 * 例如输入前序遍历序列:{1,2,4,7,3,5,6,8}和中序遍历{4,7,2,1,5,3,8,6},
 * 则重建出图中所示二叉树并且输出它的头结点。
 */
//定义二叉树节点
class BinaryTreeNode {
    public int value;
    public BinaryTreeNode leftNode;
    public BinaryTreeNode rightNode;

    // 无参构造函数
    public BinaryTreeNode() {}
    // 有参构造函数
    public BinaryTreeNode(int value) {
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }
}

public class ConstructBinaryTree {
    public static BinaryTreeNode construct(int preOrder[], int inOrder[],
            int length) throws Exception {
        if (preOrder == null || inOrder == null || length < 0) {
            return null;
        }
        return constructCore(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public static BinaryTreeNode constructCore(int preOrder[], int startPreIndex, int endPreIndex,
                    int inOrder[], int startInIndex, int endInIndex) throws InvalidPutException {
        // 头结点的值
        int rootValue = preOrder[startPreIndex];

        // 构建一个只有一个根节点的二叉树
        BinaryTreeNode root = new BinaryTreeNode(rootValue);
        // 只有一个元素的情况下：
        if (startPreIndex == endPreIndex) {
//            if (startInIndex == endInIndex
//                    && preOrder[startInIndex] == inOrder[endInIndex]) {
//                System.out.println("只有一个元素");
                return root;
//            } else {
//                throw new InvalidPutException();
//            }

        }
        // 最重要的一步：在中序遍历中找到根结点的索引
        int rootInIndex = startInIndex;
        while (rootInIndex <= endInIndex && inOrder[rootInIndex] != rootValue) {
            rootInIndex++;
        }
        /*if (rootInIndex == endInIndex && inOrder[rootInIndex] != rootInIndex) {
            throw new InvalidPutException();
        }*/
        // 根节点的左子树的长度
        int leftLength = rootInIndex - startInIndex;
        // 根节点的左子树的最右端的索引值（先序遍历获取左子树最右结点的索引，此处是结点7的索引值）
        int leftPreEndIndex = startPreIndex + leftLength;
        // 构建左子树
        if (leftLength > 0) {
            root.leftNode = constructCore(preOrder, startPreIndex + 1,
                    leftPreEndIndex, inOrder, startInIndex, rootInIndex - 1);
        }
        // 结点总个数（-1）大于左子树长度，说明根节点存在右子树 ： endPreIndex - startPreIndex ：并不是结点总个数，而是总个数-1个
        if (leftLength < endPreIndex - startPreIndex) {
            root.rightNode = constructCore(preOrder, leftPreEndIndex + 1,
                    endPreIndex, inOrder, rootInIndex + 1, endInIndex);
        }
        return root;
    }

    // 按照前序遍历打印二叉树的节点
    public static void printPreBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.value + "->");
        }
        if (root.leftNode != null) {
            printPreBinaryTree(root.leftNode);
        }
        if (root.rightNode != null) {
            printPreBinaryTree(root.rightNode);
        }
    }

    public static class InvalidPutException extends Exception {
        private static final long serialVersionUID = 1L;
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int preOrder[] = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int inOrder[] = { 4, 7, 2, 1, 5, 3, 8, 6 };
        printPreBinaryTree(ConstructBinaryTree.construct(preOrder, inOrder, preOrder.length));
    }

}