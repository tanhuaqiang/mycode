package com.dalingjia.leetcode.ListNode;

/**
 * @author tanhq
 * @Description  876 链表的中间结点
 * @Date 2019/9/17 下午10:51
 * @Version 1.0
 **/
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        //定义快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

 
    
    
    
    