package com.dalingjia.leetcode.ListNode;

/**
 * @author tanhq
 * @Description  leetcode 206 反转链表
 * @Date 2019/8/20 下午4:40
 * @Version 1.0
 **/
public class ReverseList {

    /**
     * 1,递归法反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;  //当前结点的下一个结点指向自己，即：反转指向
        head.next = null;       //清空之前的指向
        return node;
    }

    /**
     * 2,遍历法反转链表
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        ListNode newHead = null;
        ListNode current = head;
        while (current != null) {
            next = current.next;
            if (next == null) {
                newHead = current;
            }
            current.next = pre;
            pre = current;
            current = next;
        }
        return newHead;
    }
}

 
    
    
    
    