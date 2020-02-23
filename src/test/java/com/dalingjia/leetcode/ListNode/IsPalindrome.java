package com.dalingjia.leetcode.ListNode;

/**
 * @author tanhq
 * @Description 回文链表
 * @Date 2019/8/20 下午7:47
 * @Version 1.0
 **/
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        //1,判断空值和只有一个元素的情况
        if(head == null || head.next == null){
            return true;
        }
        //2,找到链表的中间元素
        ListNode mid = findMiddle(head);
        //3，将中间节点的下一个节点作为头结点，进行反转
        mid.next = invert(mid.next);
        //4，比较前半段链表和后半段链表元素
        ListNode a = head;
        ListNode b = mid.next;
        while (a != null && b != null && a.val == b.val) {
            a = a.next;
            b = b.next;
        }
        //如果是回文链表，b最终为空
        return b == null;
    }


    private ListNode invert(ListNode node) {
        if(node == null || node.next == null){
            return node;
        }
        ListNode headNode = invert(node.next);
        node.next.next = node;
        node.next = null;
        return headNode;
    }

    /**
     * 寻找中间结点
     * @param head
     * @return
     */
    private ListNode findMiddle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;//前面要判空，防止出现空指针
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

 
    
    
    
    