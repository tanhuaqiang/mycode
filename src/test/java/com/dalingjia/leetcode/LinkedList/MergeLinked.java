package com.dalingjia.leetcode.LinkedList;

public class MergeLinked {

    public static Node mergeLinked(Node head1, Node head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        Node mergeNode = null;
        if(head1.data < head2.data){
            mergeNode = head1;
            mergeNode.next = mergeLinked(head1.next, head2);
        }else {
            mergeNode = head2;
            mergeNode.next = mergeLinked(head1, head2.next);
        }
        return mergeNode;

    }

    public static void print(Node node){
        if(node == null){
            return;
        }
        while (node != null){
            System.out.print(node.data + "->");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        node1.next = node2;
        node2.next = node3;

        Node node5 = new Node(2);
        Node node6 = new Node(5);
        Node node7 = new Node(7);
        node5.next = node6;
        node6.next = node7;

        Node mergeNode = mergeLinked(node1, node5);
        print(mergeNode);
    }
}
