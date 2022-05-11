package com.dalingjia.leetcode.ListNode;

/**
 * @author tanhq
 * @Description Leetcode 25  K个一组反转链表
 * @Date 2019/11/17 上午11:16 每k个元素反转一次链表
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

    /**
     * 第2中解法
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup2(ListNode head, int k) {
        // nextHead指向链表中除去k个节点之后的头节点
        // 初始指向节点head
        ListNode nextHead = head;
        // 链表中剩余节点个数
        int remainNum = 0;
        while (remainNum < k) {
            // 根据题意如果链表剩余节点个数不足k个
            // 则不需要反转，因此直接返回head
            if (nextHead == null) {
                return head;
            }
            remainNum++;
            nextHead = nextHead.next;
        }

        // 递归反转链表中除去前k个节点的后续节点
        ListNode subList = reverseKGroup2(nextHead, k);
        // 反转链表中前k个节点
        ListNode newHead = reverseTopN(head, k);
        // 前k个节点反转后，head指向的节点是反转后的链表中的最后一个节点
        // 因此head指向的节点的后继指针指向subList
        head.next = subList;
        return newHead;
    }

    private static ListNode reverseTopN(ListNode head, int n) {
        ListNode prev = null;
        // 当前考察的节点
        ListNode cur = head;
        // num小于n，则表示当前节点需要反转
        for (int num = 0; num < n; num++) {
            // 当前节点的下一个节点
            ListNode next = cur.next;
            // 当前节点的后继指针指向prev
            cur.next = prev;
            // prev指向当前节点
            // 表示其是next节点反转后的前一个节点
            prev = cur;
            // cur指向下一个节点
            // 表示下一个节点是待反转节点
            cur = next;
        }
        return prev;
    }

    /***
     * 第三种解法
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup3(ListNode head, int k) {
        ListNode dummy = new ListNode(0), prev = dummy, curr = head, next;
        dummy.next = head;
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        head = dummy.next;
        for(int i = 0; i < length / k; i++) {
            for(int j = 0; j < k - 1; j++) {
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = curr;
            curr = prev.next;
        }
        return dummy.next;
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
        ListNode res = reverseKGroup2(node1, 3);
        System.out.println(res);

    }
}

 
    
    
    
    