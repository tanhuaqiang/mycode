package com.dalingjia.leetcode.LinkedList;

import com.dalingjia.leetcode.ListNode.ListNode;

/**
 * @author tanhq
 * @Description 链表中环的入口节点
 * @Date 2022/5/19 下午12:30
 * @Version 1.0
 **/
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}

 
    
    
    
    