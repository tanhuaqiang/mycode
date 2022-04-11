package com.dalingjia.leetcode.ListNode;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/11/24 下午3:34
 * @Version 1.0
 **/
public class Test {


    public static ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode reverse = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return reverse;

    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode res = reverse(node1);
        System.out.println(res);

    }
}

 
    
    
    
    