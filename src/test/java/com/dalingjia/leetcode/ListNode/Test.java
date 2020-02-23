package com.dalingjia.leetcode.ListNode;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/11/24 下午3:34
 * @Version 1.0
 **/
public class Test {

    public ListNode reverseKGroup(ListNode head, int k) {
        //链表总长度
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        len /= k;
        if (len <= 0) {
            return head;
        }
        ListNode cur = head;
        ListNode tail = cur;
        for (int i = 0; i < len; i++) {
            ListNode newHead = cur;
            ListNode newList = null;
            int count = k;
            while (count > 0) {
                tmp = cur;
                cur = cur.next;
                tmp.next = newList;
                newList = tmp;
                count--;
            }
            if (i == 0) {
                head = newList;
            }else {
                tail.next = newList;
                tail = newHead;
            }
        }
        if (cur != null) {
            tail.next = cur;
        }
        return head;
    }
}

 
    
    
    
    