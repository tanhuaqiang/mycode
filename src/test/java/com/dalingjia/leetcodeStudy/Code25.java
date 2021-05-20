package com.dalingjia.leetcodeStudy;

/**
 * K 个一组翻转链表
 */
public class Code25 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        //head为引用传递，值不会变
        ListNode newHead = reverse206(head, tail); //[ )
        head.next = reverseKGroup(tail, k);

        return newHead;
    }

    private static ListNode reverse206(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next = null;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode res = reverseKGroup(node1, 3);
        System.out.println(res);

    }


}
