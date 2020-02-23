package com.dalingjia.leetcode.ListNode;

/**
 * 循环链表
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        if(head.next == null){
           return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != null && fast != null) {
            if(fast == slow){
                return true;
            }
            slow = slow.next;
            if(fast.next == null){
                return false;
            }else {
                fast = fast.next.next;
            }
        }
        return false;
    }

}
