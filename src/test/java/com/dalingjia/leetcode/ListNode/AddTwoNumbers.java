package com.dalingjia.leetcode.ListNode;

/**
 * @author tanhq
 * @Description LeetCode 445 两数相加II  （两个单链表求和）
 * @Date 2019/10/24 下午6:41
 * @Version 1.0
 **/
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rev1 = reverse(l1);
        ListNode rev2 = reverse(l2);
        ListNode root = null;
        ListNode current = null;
        int bits = 0;//进位位
        for (; rev1 != null && rev2 != null; rev1 = rev1.next, rev2 = rev2.next) {
            int sum = rev1.val + rev2.val + bits;
            bits = sum / 10;
            if (root == null) {
                root = new ListNode(sum % 10);
                current = root;
            } else {
                current.next = new ListNode(sum % 10);
                current = current.next;
            }
        }
        for (; rev1 != null; rev1 = rev1.next) {
            int sum = rev1.val + bits;
            bits = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        for (; rev2 != null; rev2 = rev2.next) {
            int sum = rev2.val + bits;
            bits = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        if (bits == 1) {
            current.next = new ListNode(1);
            current = current.next;
        }
        return reverse(root);
    }


    /**
     * 反转链表
     *
     * @param listNode
     * @return
     */
    public ListNode reverse(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode node = reverse(listNode.next);
        listNode.next.next = listNode;
        listNode.next = null;
        return node;
    }

}

 
    
    
    
    