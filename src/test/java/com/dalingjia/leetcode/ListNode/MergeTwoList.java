package com.dalingjia.leetcode.ListNode;

/**
 * leetcode 21 合并两个有序列表
 */
public class MergeTwoList {

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode newHead = null;
        if(l1.val <= l2.val){
            newHead = l1;
            newHead.next = mergeTwoLists(l1.next, l2);
        }else {
            newHead = l2;
            newHead.next = mergeTwoLists(l1, l2.next);
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode min1 = new ListNode(1);
        ListNode min2 = new ListNode(4);
        ListNode min3 = new ListNode(7);
        min1.next = min2;
        min2.next = min3;

        ListNode max1 = new ListNode(2);
        ListNode max2 = new ListNode(6);
        ListNode max3 = new ListNode(8);
        max1.next = max2;
        max2.next = max3;

        ListNode node = mergeTwoLists(min1, max1);
        while (node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }
    }
}
