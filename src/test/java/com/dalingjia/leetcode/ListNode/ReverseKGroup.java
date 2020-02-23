package com.dalingjia.leetcode.ListNode;

/**
 * @author tanhq
 * @Description Leetcode 25  K个一组反转链表
 * @Date 2019/11/17 上午11:16
 * @Version 1.0
 **/
public class ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode tmp = head;
        //1、计算链表长度
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        len /= k;
        //2、当没有要反转链表的时候直接返回
        if (len == 0) {
            return head;
        }
        ListNode cur = head;
        //尾结点
        ListNode tail = cur;
        for (int i = 0; i < len; i++) {
            //newlist表示分离出来的链表
            ListNode newlist = null;
            //newhead表示反转之前分离出来链表的头
            ListNode newhead = cur;
            int count = k;
            //反转分离出来的链表
            while (count > 0) {
                tmp = cur;
                cur = cur.next;
                tmp.next = newlist;
                newlist = tmp;
                count--;
            }
            if (i == 0) {
                head = newlist;
            } else {
                tail.next = newlist;
                tail = newhead;
            }
        }
        //链接链表剩余的部分
        if (cur != null) {
            tail.next = cur;
        }
        //返回头节点
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        ListNode res = reverseKGroup(node1, 3);
        System.out.println(res);

    }
}

 
    
    
    
    